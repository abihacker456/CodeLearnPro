package com.abinet.codelearnpro

import android.util.Base64
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.util.concurrent.TimeUnit

object CodeExecutionService {

    private const val JUDGE0_URL = "https://ce.judge0.com/submissions?base64_encoded=true&wait=true"

    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()

    private val jsonMediaType = "application/json; charset=utf-8".toMediaType()

    suspend fun executeCodeReal(code: String, language: String): ExecutionResult {
        val trimmed = code.trim()
        if (trimmed.isEmpty()) {
            return ExecutionResult(
                output = "",
                success = false,
                error = "Please write some code before running."
            )
        }

        return withContext(Dispatchers.IO) {
            try {
                val languageId = mapLanguage(language)
                    ?: return@withContext ExecutionResult(
                        output = "",
                        success = false,
                        error = "Language '$language' is not supported for execution."
                    )

                val encodedCode = Base64.encodeToString(trimmed.toByteArray(), Base64.NO_WRAP)

                val payload = JSONObject().apply {
                    put("source_code", encodedCode)
                    put("language_id", languageId)
                }.toString()

                val request = Request.Builder()
                    .url(JUDGE0_URL)
                    .post(payload.toRequestBody(jsonMediaType))
                    .addHeader("Content-Type", "application/json")
                    .build()

                client.newCall(request).execute().use { response ->
                    val body = response.body?.string().orEmpty()

                    if (!response.isSuccessful) {
                        return@withContext ExecutionResult(
                            output = "",
                            success = false,
                            error = "Execution service error (HTTP ${response.code}). Try again in a moment."
                        )
                    }

                    val json = JSONObject(body)

                    val status = json.optJSONObject("status")
                    val statusId = status?.optInt("id", 0) ?: 0

                    if (statusId == 0) {
                        return@withContext ExecutionResult(
                            output = "",
                            success = false,
                            error = "Unexpected response from execution service."
                        )
                    }

                    val stdout = decodeBase64(json.optString("stdout", ""))
                    val stderr = decodeBase64(json.optString("stderr", ""))
                    val compileOutput = decodeBase64(json.optString("compile_output", ""))
                    val message = decodeBase64(json.optString("message", ""))

                    val combined = buildString {
                        if (stdout.isNotEmpty()) append(stdout)
                        if (stderr.isNotEmpty()) {
                            if (isNotEmpty()) append('\n')
                            append(stderr)
                        }
                        if (compileOutput.isNotEmpty()) {
                            if (isNotEmpty()) append('\n')
                            append(compileOutput)
                        }
                        if (message.isNotEmpty()) {
                            if (isNotEmpty()) append('\n')
                            append(message)
                        }
                    }.trimEnd()

                    val success = statusId == 3
                    ExecutionResult(
                        output = combined.ifEmpty { "Program finished with no output." },
                        success = success,
                        error = if (!success) stderr.ifEmpty { compileOutput.ifEmpty { "Status: ${status?.optString("description") ?: "Unknown error"}" } } else null
                    )
                }
            } catch (e: Exception) {
                ExecutionResult(
                    output = "",
                    success = false,
                    error = "Could not reach the execution service. Check your internet connection.\n\nDetails: ${e.message}"
                )
            }
        }
    }

    private fun decodeBase64(input: String): String {
        if (input.isBlank()) return ""
        return try {
            String(Base64.decode(input, Base64.DEFAULT)).trimEnd()
        } catch (e: Exception) {
            input
        }
    }

    private fun mapLanguage(input: String): Int? = when (input.lowercase()) {
        "python" -> 71
        "java" -> 62
        "c++", "cpp" -> 54
        "kotlin" -> 78
        "javascript", "js" -> 63
        else -> null
    }
}

data class ExecutionResult(
    val output: String,
    val success: Boolean,
    val error: String? = null
)