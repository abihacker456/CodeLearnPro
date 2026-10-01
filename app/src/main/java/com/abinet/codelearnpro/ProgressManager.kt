package com.abinet.codelearnpro

import android.app.Application
import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

// Data class to track progress for a language
data class LanguageProgress(
    val languageId: Int,
    val completedLessons: Set<String> = emptySet(),
    val totalLessons: Int = 0
) {
    val progressPercentage: Float
        get() = if (totalLessons > 0) {
            (completedLessons.size.toFloat() / totalLessons) * 100
        } else {
            0f
        }

    val progressText: String
        get() = "${completedLessons.size}/$totalLessons lessons"
}

// ViewModel to manage progress WITH persistent storage
class ProgressViewModel(application: Application) : ViewModel() {
    private val repository = SharedPreferencesProgressRepository(application.applicationContext)
    private val _completedLessons = mutableStateOf<Set<String>>(emptySet())
    val completedLessons: State<Set<String>> = _completedLessons

    init {
        // Load saved progress when ViewModel is created
        loadCompletedLessons()
    }

    private fun loadCompletedLessons() {
        viewModelScope.launch {
            repository.completedLessons.collect { lessons ->
                _completedLessons.value = lessons
            }
        }
    }

    // Check if a lesson is completed
    fun isLessonCompleted(lessonId: String): Boolean {
        return _completedLessons.value.contains(lessonId)
    }

    // Mark lesson as completed
    fun markLessonCompleted(lessonId: String) {
        viewModelScope.launch {
            repository.addCompletedLesson(lessonId)
            // The flow will update _completedLessons automatically
        }
    }

    // Mark lesson as not completed
    fun markLessonNotCompleted(lessonId: String) {
        viewModelScope.launch {
            repository.removeCompletedLesson(lessonId)
            // The flow will update _completedLessons automatically
        }
    }

    // Get progress for a specific language
    fun getLanguageProgress(languageId: Int): LanguageProgress {
        val allLessons = LessonDataProvider.getAllLessons()
        val languageLessons = allLessons.filter { it.languageId == languageId }
        val completed = _completedLessons.value.filter { lessonId ->
            languageLessons.any { it.id == lessonId }
        }

        return LanguageProgress(
            languageId = languageId,
            completedLessons = completed.toSet(),
            totalLessons = languageLessons.size
        )
    }

    // Get overall progress
    fun getOverallProgress(): Float {
        val totalLessons = LessonDataProvider.getAllLessons().size
        if (totalLessons == 0) return 0f
        return (_completedLessons.value.size.toFloat() / totalLessons) * 100
    }

    // Get completed lessons count
    fun getCompletedCount(): Int {
        return _completedLessons.value.size
    }

    // Get total lessons count
    fun getTotalLessonsCount(): Int {
        return LessonDataProvider.getAllLessons().size
    }

    // Clear all progress
    fun clearAllProgress() {
        viewModelScope.launch {
            repository.clearAllProgress()
        }
    }
}