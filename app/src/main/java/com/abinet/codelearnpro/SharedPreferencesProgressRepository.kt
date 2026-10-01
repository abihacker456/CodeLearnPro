package com.abinet.codelearnpro

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SharedPreferencesProgressRepository(private val context: Context) {
    private val sharedPrefs: SharedPreferences = context.getSharedPreferences("progress_store", Context.MODE_PRIVATE)
    private val _completedLessons = MutableStateFlow<Set<String>>(emptySet())
    val completedLessons: Flow<Set<String>> = _completedLessons.asStateFlow()

    init {
        // Load saved progress when repository is created
        loadCompletedLessons()
    }

    private fun loadCompletedLessons() {
        val saved = sharedPrefs.getStringSet("completed_lessons", emptySet()) ?: emptySet()
        _completedLessons.value = saved
    }

    // Add a single lesson to completed
    suspend fun addCompletedLesson(lessonId: String) {
        val current = _completedLessons.value.toMutableSet()
        current.add(lessonId)
        _completedLessons.value = current
        saveToPreferences(current)
    }

    // Remove a lesson from completed
    suspend fun removeCompletedLesson(lessonId: String) {
        val current = _completedLessons.value.toMutableSet()
        current.remove(lessonId)
        _completedLessons.value = current
        saveToPreferences(current)
    }

    // Clear all progress
    suspend fun clearAllProgress() {
        _completedLessons.value = emptySet()
        sharedPrefs.edit().remove("completed_lessons").apply()
    }

    private fun saveToPreferences(lessons: Set<String>) {
        sharedPrefs.edit()
            .putStringSet("completed_lessons", lessons)
            .apply()
    }
}