package com.abinet.codelearnpro

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchHistoryManager(private val context: Context) {
    private val sharedPrefs: SharedPreferences = context.getSharedPreferences("search_history", Context.MODE_PRIVATE)
    private val _searchHistory = MutableStateFlow<List<String>>(emptyList())
    val searchHistory: StateFlow<List<String>> = _searchHistory.asStateFlow()

    init {
        loadSearchHistory()
    }

    private fun loadSearchHistory() {
        val history = sharedPrefs.getStringSet("history", emptySet())?.toList() ?: emptyList()
        _searchHistory.value = history
    }

    /**
     * Add a search query to history
     * @param query The search query to add
     * @param maxItems Maximum number of items to keep in history (default: 10)
     */
    fun addToHistory(query: String, maxItems: Int = 10) {
        val trimmedQuery = query.trim()
        if (trimmedQuery.isEmpty()) return

        val current = _searchHistory.value.toMutableList()

        // Remove if already exists (to move to front)
        current.remove(trimmedQuery)

        // Add to beginning
        current.add(0, trimmedQuery)

        // Limit size
        if (current.size > maxItems) {
            _searchHistory.value = current.take(maxItems)
        } else {
            _searchHistory.value = current
        }

        saveToPreferences()
    }

    /**
     * Clear all search history
     */
    fun clearHistory() {
        _searchHistory.value = emptyList()
        sharedPrefs.edit().remove("history").apply()
    }

    /**
     * Remove a specific item from history
     */
    fun removeFromHistory(query: String) {
        val current = _searchHistory.value.toMutableList()
        current.remove(query)
        _searchHistory.value = current
        saveToPreferences()
    }

    private fun saveToPreferences() {
        sharedPrefs.edit()
            .putStringSet("history", _searchHistory.value.toSet())
            .apply()
    }

    /**
     * Get recent searches (limited count)
     */
    fun getRecentSearches(count: Int = 5): List<String> {
        return _searchHistory.value.take(count)
    }
}