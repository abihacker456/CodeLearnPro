package com.abinet.codelearnpro

import android.content.Context // ADD THIS IMPORT

object BookmarkRepository {
    private var bookmarkManager: BookmarkManager? = null

    fun initialize(context: Context) {
        bookmarkManager = BookmarkManager(context)
    }

    fun isBookmarked(lessonId: String): Boolean {
        return bookmarkManager?.isBookmarked(lessonId) ?: false
    }

    fun toggleBookmark(lessonId: String) {
        bookmarkManager?.toggleBookmark(lessonId)
    }

    fun addBookmark(lessonId: String) {
        bookmarkManager?.addBookmark(lessonId)
    }

    fun removeBookmark(lessonId: String) {
        bookmarkManager?.removeBookmark(lessonId)
    }

    fun getBookmarkedLessons(): List<Lesson> {
        return bookmarkManager?.getBookmarkedLessons() ?: emptyList()
    }

    fun getBookmarkCount(): Int {
        return bookmarkManager?.getBookmarkCount() ?: 0
    }

    fun clearAllBookmarks() {
        bookmarkManager?.clearAllBookmarks()
    }

    fun getBookmarkedLessonsByLanguage(languageId: Int): List<Lesson> {
        return getBookmarkedLessons().filter { it.languageId == languageId }
    }
}