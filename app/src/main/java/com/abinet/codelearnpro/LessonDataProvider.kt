package com.abinet.codelearnpro

object LessonDataProvider {
    private val lessons: List<Lesson> by lazy {
        pythonLessons + cppLessons + kotlinLessons + javaLessons + javaScriptLessons
    }

    fun getAllLessons(): List<Lesson> = lessons

    fun getLessonById(lessonId: String): Lesson =
        lessons.firstOrNull { it.id == lessonId } ?: lessons.first()

    fun getLessonsByLanguage(languageId: Int): List<Lesson> =
        lessons.filter { it.languageId == languageId }.sortedBy { it.order }

    fun getNextLesson(currentLessonId: String): Lesson? {
        val current = getLessonById(currentLessonId)
        val sameLanguage = getLessonsByLanguage(current.languageId)
        val index = sameLanguage.indexOfFirst { it.id == currentLessonId }
        return if (index >= 0 && index < sameLanguage.size - 1) sameLanguage[index + 1] else null
    }
}