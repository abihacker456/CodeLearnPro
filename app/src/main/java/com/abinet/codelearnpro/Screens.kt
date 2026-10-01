package com.abinet.codelearnpro

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object LanguageDetail : Screen("language/{languageId}") {
        fun createRoute(languageId: Int) = "language/$languageId"
    }
    object Lessons : Screen("lessons/{languageId}") {
        fun createRoute(languageId: Int) = "lessons/$languageId"
    }
    object LessonDetail : Screen("lesson/{lessonId}") {
        fun createRoute(lessonId: String) = "lesson/$lessonId"
    }
    object AboutDeveloper : Screen("about")
    object Contact : Screen("contact")
    object Search : Screen("search")
    object Bookmarks : Screen("bookmarks")
    object CodeExecution : Screen("code/{lessonId}") {
        fun createRoute(lessonId: String) = "code/$lessonId"
    }
}

enum class LanguageType(val id: Int) {
    PYTHON(1),
    CPP(2),
    KOTLIN(3),
    JAVA(4),
    JAVASCRIPT(5)
}