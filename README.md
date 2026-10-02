# CodeLearn Pro

A free Android app for learning programming. Built with Kotlin and Jetpack Compose.

## What it does

- 25 structured lessons across five languages: Python, C++, Kotlin, Java, and JavaScript
- Built-in code editor with real code execution
- Practice exercise after every lesson
- Progress tracking, bookmarks, search
- Light and dark theme

## Tech stack

- Kotlin 2.0
- Jetpack Compose (Material 3)
- Navigation Compose
- Kotlin Coroutines
- OkHttp for HTTP
- DataStore for preferences
- Judge0 CE API for code execution

## Requirements

- Android Studio Hedgehog (2023.1.1) or newer
- JDK 17
- Android SDK 36
- Minimum device: Android 7.0 (API 24)

## Build

1. Clone the repo:
   git clone https://github.com/abihacker456/CodeLearnPro.git

2. Open the project in Android Studio.

3. Create `keystore.properties` in the project root (required for signed release builds):
   storeFile=your-keystore.jks
storePassword=your_password
keyAlias=your_alias
keyPassword=your_key_password

4. Build:
   ./gradlew assembleDebug # debug APK
./gradlew bundleRelease # release AAB

## License

All rights reserved. Personal project by Abinet Endale.

