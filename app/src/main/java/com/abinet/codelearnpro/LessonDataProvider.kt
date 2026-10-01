package com.abinet.codelearnpro

object LessonDataProvider {
    private var allLessons: List<Lesson>? = null

    fun getAllLessons(): List<Lesson> {
        if (allLessons == null) {
            allLessons = buildAllLessons()
        }
        return allLessons!!
    }

    private fun buildAllLessons(): List<Lesson> {
        val lessons = mutableListOf<Lesson>()

        // Generate 25 lessons for each of the 5 languages = 125 total
        for (languageId in 1..5) {
            val language = getLanguageForId(languageId)
            lessons.addAll(
                ComprehensiveLessonGenerator.generateLanguageLessons(
                    languageId,
                    language.name,
                    getLanguageCode(language.name)
                )
            )
        }

        println("✅ Generated ${lessons.size} total lessons")
        println("✅ Python lessons: ${lessons.count { it.languageId == 1 }}")
        println("✅ C++ lessons: ${lessons.count { it.languageId == 2 }}")
        println("✅ Kotlin lessons: ${lessons.count { it.languageId == 3 }}")
        println("✅ Java lessons: ${lessons.count { it.languageId == 4 }}")
        println("✅ JavaScript lessons: ${lessons.count { it.languageId == 5 }}")

        return lessons
    }

    private fun getLanguageForId(languageId: Int): ProgrammingLanguage {
        return languages.find { it.id == languageId } ?: languages[0]
    }

    private fun getLanguageCode(languageName: String): String {
        return when (languageName.lowercase()) {
            "python" -> "python"
            "c++" -> "cpp"
            "kotlin" -> "kotlin"
            "java" -> "java"
            "javascript" -> "js"
            else -> "python"
        }
    }

    fun getLessonById(lessonId: String): Lesson {
        return getAllLessons().find { it.id == lessonId } ?: getAllLessons()[0]
    }

    fun getLessonsByLanguage(languageId: Int): List<Lesson> {
        return getAllLessons()
            .filter { it.languageId == languageId }
            .sortedBy { it.order }
    }

    fun getNextLesson(currentLessonId: String): Lesson? {
        val currentLesson = getLessonById(currentLessonId)
        val languageLessons = getLessonsByLanguage(currentLesson.languageId)

        val currentIndex = languageLessons.indexOfFirst { it.id == currentLessonId }
        return if (currentIndex < languageLessons.size - 1) {
            languageLessons[currentIndex + 1]
        } else {
            null
        }
    }
}