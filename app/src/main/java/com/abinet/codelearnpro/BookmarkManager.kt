package com.abinet.codelearnpro

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class BookmarkManager(private val context: Context) {
    private val sharedPrefs: SharedPreferences = context.getSharedPreferences("bookmarks", Context.MODE_PRIVATE)
    private val _bookmarkedLessons = MutableStateFlow<Set<String>>(emptySet())
    val bookmarkedLessons: StateFlow<Set<String>> = _bookmarkedLessons.asStateFlow()

    init {
        loadBookmarks()
    }

    private fun loadBookmarks() {
        val bookmarks = sharedPrefs.getStringSet("bookmarked_lessons", emptySet()) ?: emptySet()
        _bookmarkedLessons.value = bookmarks
    }

    /**
     * Check if a lesson is bookmarked
     */
    fun isBookmarked(lessonId: String): Boolean {
        return _bookmarkedLessons.value.contains(lessonId)
    }

    /**
     * Toggle bookmark status for a lesson
     */
    fun toggleBookmark(lessonId: String) {
        val current = _bookmarkedLessons.value.toMutableSet()
        if (current.contains(lessonId)) {
            current.remove(lessonId)
        } else {
            current.add(lessonId)
        }
        _bookmarkedLessons.value = current
        saveToPreferences()
    }

    /**
     * Add a lesson to bookmarks
     */
    fun addBookmark(lessonId: String) {
        val current = _bookmarkedLessons.value.toMutableSet()
        current.add(lessonId)
        _bookmarkedLessons.value = current
        saveToPreferences()
    }

    /**
     * Remove a lesson from bookmarks
     */
    fun removeBookmark(lessonId: String) {
        val current = _bookmarkedLessons.value.toMutableSet()
        current.remove(lessonId)
        _bookmarkedLessons.value = current
        saveToPreferences()
    }

    /**
     * Get all bookmarked lessons
     */
    fun getBookmarkedLessons(): List<Lesson> {
        val allLessons = LessonDataProvider.getAllLessons()
        return allLessons.filter { lesson ->
            _bookmarkedLessons.value.contains(lesson.id)
        }
    }

    /**
     * Get bookmarked lessons count
     */
    fun getBookmarkCount(): Int {
        return _bookmarkedLessons.value.size
    }

    /**
     * Clear all bookmarks
     */
    fun clearAllBookmarks() {
        _bookmarkedLessons.value = emptySet()
        sharedPrefs.edit().remove("bookmarked_lessons").apply()
    }

    private fun saveToPreferences() {
        sharedPrefs.edit()
            .putStringSet("bookmarked_lessons", _bookmarkedLessons.value)
            .apply()
    }
}