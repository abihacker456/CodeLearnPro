package com.abinet.codelearnpro

import android.content.Context
import androidx.lifecycle.viewmodel.compose.viewModel

object SearchRepository {

    // Search history manager (will be initialized in MainActivity)
    private var searchHistoryManager: SearchHistoryManager? = null

    fun initialize(context: Context) {
        searchHistoryManager = SearchHistoryManager(context)
    }

    /**
     * Search across all lessons for matching text
     * @param query The search text
     * @param saveToHistory Whether to save this search to history (default: true)
     * @return List of lessons matching the search query
     */
    fun searchLessons(query: String, saveToHistory: Boolean = true): List<Lesson> {
        if (query.isEmpty()) return emptyList()

        val allLessons = LessonDataProvider.getAllLessons()
        val searchQuery = query.trim().lowercase()

        // Save to history if requested
        if (saveToHistory) {
            searchHistoryManager?.addToHistory(query)
        }

        return allLessons.filter { lesson ->
            // Search in title
            lesson.title.lowercase().contains(searchQuery) ||
                    // Search in description
                    lesson.description.lowercase().contains(searchQuery) ||
                    // Search in content
                    lesson.content.lowercase().contains(searchQuery) ||
                    // Search in language name
                    getLanguageName(lesson.languageId).lowercase().contains(searchQuery)
        }
    }

    /**
     * Search lessons within a specific language
     * @param query The search text
     * @param languageId The language to search within
     * @param saveToHistory Whether to save this search to history (default: true)
     * @return List of lessons matching the search query in the specified language
     */
    fun searchLessonsInLanguage(query: String, languageId: Int, saveToHistory: Boolean = true): List<Lesson> {
        if (query.isEmpty()) return emptyList()

        val languageLessons = LessonDataProvider.getLessonsByLanguage(languageId)
        val searchQuery = query.trim().lowercase()

        // Save to history if requested
        if (saveToHistory) {
            searchHistoryManager?.addToHistory("$query (${getLanguageName(languageId)})")
        }

        return languageLessons.filter { lesson ->
            lesson.title.lowercase().contains(searchQuery) ||
                    lesson.description.lowercase().contains(searchQuery) ||
                    lesson.content.lowercase().contains(searchQuery)
        }
    }

    /**
     * Get search history
     */
    fun getSearchHistory(): List<String> {
        return searchHistoryManager?.searchHistory?.value ?: emptyList()
    }

    /**
     * Get recent searches
     */
    fun getRecentSearches(count: Int = 5): List<String> {
        return searchHistoryManager?.getRecentSearches(count) ?: emptyList()
    }

    /**
     * Clear search history
     */
    fun clearSearchHistory() {
        searchHistoryManager?.clearHistory()
    }

    /**
     * Remove item from search history
     */
    fun removeFromHistory(query: String) {
        searchHistoryManager?.removeFromHistory(query)
    }

    /**
     * Get trending/search suggestions based on common programming terms
     */
    fun getSearchSuggestions(): List<String> {
        val suggestions = mutableListOf<String>()

        // Add recent searches first
        suggestions.addAll(getRecentSearches(3))

        // Add trending searches if we need more
        val trending = listOf(
            "variables",
            "functions",
            "loops",
            "arrays",
            "objects",
            "classes",
            "if else",
            "python",
            "java",
            "javascript",
            "kotlin",
            "c++",
            "beginner",
            "intermediate"
        )

        // Add trending if we don't have enough recent searches
        if (suggestions.size < 5) {
            trending.forEach {
                if (!suggestions.contains(it) && suggestions.size < 10) {
                    suggestions.add(it)
                }
            }
        }

        return suggestions.distinct().take(10)
    }

    private fun getLanguageName(languageId: Int): String {
        return languages.find { it.id == languageId }?.name ?: "Unknown"
    }
}