# --- Kotlin ---
-dontwarn kotlin.**
-keepclassmembers class kotlin.Metadata { public <methods>; }

# --- Kotlinx Coroutines ---
-dontwarn kotlinx.coroutines.**
-keepclassmembers class kotlinx.coroutines.** { volatile <fields>; }

# --- OkHttp ---
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

# --- JSON (Android built-in) ---
-keep class org.json.** { *; }

# --- Compose ---
-keep class androidx.compose.** { *; }
-dontwarn androidx.compose.**

# --- App model classes (safe for reflection) ---
-keep class com.abinet.codelearnpro.Lesson { *; }
-keep class com.abinet.codelearnpro.ProgrammingLanguage { *; }
-keep class com.abinet.codelearnpro.ExecutionResult { *; }
-keep class com.abinet.codelearnpro.JDoodleResult { *; }

# --- Keep line numbers for crash reports ---
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile