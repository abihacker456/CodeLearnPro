# CodeLearn Pro

A free Android app for learning programming. Built with Kotlin and Jetpack Compose.

[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.09.00-4285F4?logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Min SDK](https://img.shields.io/badge/minSdk-24-3DDC84?logo=android&logoColor=white)](https://developer.android.com)
[![Target SDK](https://img.shields.io/badge/targetSdk-36-3DDC84?logo=android&logoColor=white)](https://developer.android.com)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

## About

CodeLearn Pro is a beginner-friendly Android app for learning five programming languages through short, structured lessons and hands-on practice.

Every lesson teaches one concept. You read a short explanation, study a working code example, then try it yourself in the built-in code editor. Tap **Run Code** and see the real output in seconds.

## Features

- **25 structured lessons** across five languages: Python, C++, Kotlin, Java, and JavaScript
- **Built-in code editor** with real code execution
- **Practice exercises** after every lesson
- **Progress tracking** so you can see how far you've come
- **Bookmarks** to save lessons for later
- **Search** across all lessons
- **Light and dark theme**
- **Offline-first** — only code execution requires internet

## Screenshots

> _Coming soon — add screenshots to `docs/screenshots/` and update this section._

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Kotlin 2.0.21 |
| UI | Jetpack Compose (Material 3) |
| Navigation | Navigation Compose |
| Async | Kotlin Coroutines |
| HTTP | OkHttp |
| Persistence | SharedPreferences + DataStore |
| Code execution | [Judge0 CE](https://ce.judge0.com) (public API) |
| Build | Gradle 8.14.3 + AGP 8.13.2 |

## Requirements

- **Android Studio** Hedgehog (2023.1.1) or newer
- **JDK** 17
- **Android SDK** 36
- **Minimum device:** Android 7.0 (API 24)

## Build

### 1. Clone the repository

```bash
git clone https://github.com/abihacker456/CodeLearnPro.git
cd CodeLearnPro