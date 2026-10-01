package com.abinet.codelearnpro

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.util.concurrent.TimeUnit

object JDoodleService {
    private var clientId: String = ""
    private var clientSecret: String = ""

    fun initializeCredentials(id: String, secret: String) {
        clientId = id
        clientSecret = secret
        println("✅ JDoodle credentials initialized: ${id.take(5)}...")
    }

    fun loadSavedCredentials(context: Context) {
        val prefs = context.getSharedPreferences("api_config", Context.MODE_PRIVATE)
        val savedClientId = prefs.getString("jdoodle_client_id", "") ?: ""
        val savedClientSecret = prefs.getString("jdoodle_client_secret", "") ?: ""

        if (savedClientId.isNotEmpty() && savedClientSecret.isNotEmpty()) {
            clientId = savedClientId
            clientSecret = savedClientSecret
            println("✅ Loaded saved API credentials")
        } else {
            println("⚠️ No saved API credentials found")
            // Set empty credentials so isConfigured() returns false
            clientId = ""
            clientSecret = ""
        }
    }

    fun isConfigured(): Boolean {
        return clientId.isNotEmpty() &&
                clientSecret.isNotEmpty() &&
                clientId != "YOUR_CLIENT_ID" &&
                clientSecret != "YOUR_CLIENT_SECRET"
    }

    private val client = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .build()

    private val jsonMediaType = "application/json; charset=utf-8".toMediaType()

    suspend fun executeCode(
        code: String,
        language: String,
        versionIndex: String = "0"
    ): JDoodleResult {
        return withContext(Dispatchers.IO) {
            try {
                // Validate credentials
                if (!isConfigured()) {
                    return@withContext JDoodleResult(
                        output = "API credentials not configured. Please set up JDoodle API in Settings.\n\nGo to: Home → Settings → API Configuration",
                        statusCode = "400",
                        memory = null,
                        cpuTime = null,
                        error = "Missing API credentials"
                    )
                }

                // Prepare request body
                val requestBody = JSONObject().apply {
                    put("clientId", clientId)
                    put("clientSecret", clientSecret)
                    put("script", code)
                    put("language", language)
                    put("versionIndex", versionIndex)
                }.toString()

                println("🔧 Sending request to JDoodle API...")
                println("🔧 Language: $language")
                println("🔧 Client ID: ${clientId.take(5)}...")

                // Create request
                val request = Request.Builder()
                    .url("https://api.jdoodle.com/v1/execute")
                    .post(requestBody.toRequestBody(jsonMediaType))
                    .addHeader("Content-Type", "application/json")
                    .build()

                // Execute request
                val response = client.newCall(request).execute()
                val responseBody = response.body?.string() ?: "{}"

                println("🔧 Response code: ${response.code}")
                println("🔧 Response: $responseBody")

                // Parse response
                val jsonResponse = JSONObject(responseBody)
                val output = jsonResponse.optString("output", "").trim()
                val statusCode = jsonResponse.optString("statusCode", "")
                val error = jsonResponse.optString("error", null)

                // Debug: Check what JDoodle is returning
                if (response.code != 200) {
                    println("❌ HTTP Error: ${response.code}")
                    return@withContext JDoodleResult(
                        output = "HTTP Error ${response.code}: ${response.message}",
                        statusCode = response.code.toString(),
                        memory = null,
                        cpuTime = null,
                        error = "HTTP ${response.code}"
                    )
                }

                // If statusCode is not 200, it's an error
                if (statusCode != "200") {
                    println("❌ JDoodle Error: statusCode=$statusCode, error=$error")
                    val errorMessage = when (statusCode) {
                        "400" -> "Bad request - check your code syntax"
                        "401" -> "Unauthorized - invalid API credentials"
                        "429" -> "Too many requests - daily limit exceeded"
                        else -> "JDoodle API error (Status: $statusCode)"
                    }

                    return@withContext JDoodleResult(
                        output = errorMessage,
                        statusCode = statusCode,
                        memory = null,
                        cpuTime = null,
                        error = error ?: errorMessage
                    )
                }

                // Success!
                JDoodleResult(
                    output = if (output.isEmpty()) "Code executed successfully (no output)" else output,
                    statusCode = statusCode,
                    memory = jsonResponse.optString("memory", null),
                    cpuTime = jsonResponse.optString("cpuTime", null),
                    error = null
                )
            } catch (e: Exception) {
                println("❌ JDoodle API exception: ${e.message}")
                JDoodleResult(
                    output = "Exception: ${e.message}\n\nPlease check:\n1. Internet connection\n2. API credentials\n3. Code syntax",
                    statusCode = "500",
                    memory = null,
                    cpuTime = null,
                    error = e.message
                )
            }
        }
    }

    fun getJDoodleLanguageCode(languageName: String): String {
        return when (languageName.lowercase()) {
            "python" -> "python3"
            "java" -> "java"
            "c++", "cpp" -> "cpp17"
            "kotlin" -> "kotlin"
            "javascript", "js" -> "nodejs"
            else -> "python3"
        }
    }

    fun getConfigurationStatus(): String {
        return if (isConfigured()) {
            "✅ JDoodle API configured (Ready for real execution)"
        } else {
            "⚠️ JDoodle API not configured. Using simulated execution."
        }
    }

    // Helper function to get credentials status for debugging
    fun getCredentialsStatus(): String {
        return if (isConfigured()) {
            "Configured (ID: ${clientId.take(5)}...)"
        } else {
            "Not configured"
        }
    }
}

data class JDoodleResult(
    val output: String,
    val statusCode: String,
    val memory: String?,
    val cpuTime: String?,
    val error: String?
) {
    val isSuccess: Boolean
        get() = statusCode == "200" && error == null

    val hasOutput: Boolean
        get() = output.isNotEmpty()
}