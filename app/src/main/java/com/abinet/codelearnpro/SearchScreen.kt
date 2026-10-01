package com.abinet.codelearnpro

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchScreen(
    onBackClick: () -> Unit,
    onLessonClick: (Lesson) -> Unit,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var searchResults by remember { mutableStateOf<List<Lesson>>(emptyList()) }
    var isSearching by remember { mutableStateOf(false) }
    var showHistory by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header with back button
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }

            Text(
                text = "Search Lessons",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.width(48.dp)) // For balance
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Search bar
        SearchBar(
            query = searchQuery,
            onQueryChange = { query ->
                searchQuery = query
                if (query.isNotEmpty()) {
                    searchResults = SearchRepository.searchLessons(query)
                    isSearching = true
                    showHistory = false
                } else {
                    searchResults = emptyList()
                    isSearching = false
                    showHistory = true
                }
            },
            onSearch = {
                if (searchQuery.isNotEmpty()) {
                    searchResults = SearchRepository.searchLessons(searchQuery)
                    isSearching = true
                    showHistory = false
                }
            },
            onClear = {
                searchQuery = ""
                searchResults = emptyList()
                isSearching = false
                showHistory = true
            },
            placeholder = "Search across all lessons..."
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (isSearching) {
            // Show search results
            SearchResultsSection(
                searchQuery = searchQuery,
                searchResults = searchResults,
                onLessonClick = onLessonClick
            )
        } else if (showHistory && SearchRepository.getSearchHistory().isNotEmpty()) {
            // Show search history
            SearchHistorySection(
                onSearchClick = { query ->
                    searchQuery = query
                    searchResults = SearchRepository.searchLessons(query)
                    isSearching = true
                    showHistory = false
                },
                onClearHistory = {
                    SearchRepository.clearSearchHistory()
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Show search suggestions below history
            SearchSuggestionsSection(
                onSearchClick = { query ->
                    searchQuery = query
                    searchResults = SearchRepository.searchLessons(query)
                    isSearching = true
                    showHistory = false
                }
            )
        } else {
            // Show only search suggestions
            SearchSuggestionsSection(
                onSearchClick = { query ->
                    searchQuery = query
                    searchResults = SearchRepository.searchLessons(query)
                    isSearching = true
                    showHistory = false
                }
            )
        }
    }
}

@Composable
fun SearchResultsSection(
    searchQuery: String,
    searchResults: List<Lesson>,
    onLessonClick: (Lesson) -> Unit
) {
    if (searchResults.isEmpty()) {
        // No results found
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "No results",
                    modifier = Modifier.size(64.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "No lessons found for \"$searchQuery\"",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Try different keywords",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    } else {
        // Show search results
        Column {
            Text(
                text = "${searchResults.size} result${if (searchResults.size != 1) "s" else ""} found",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(searchResults) { lesson ->
                    SearchResultItem(
                        lesson = lesson,
                        onClick = { onLessonClick(lesson) }
                    )
                }
            }
        }
    }
}

@Composable
fun SearchHistorySection(
    onSearchClick: (String) -> Unit,
    onClearHistory: () -> Unit
) {
    val searchHistory = SearchRepository.getSearchHistory()

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Recent Searches",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            if (searchHistory.isNotEmpty()) {
                Text(
                    text = "Clear all",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable { onClearHistory() }
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(searchHistory) { historyItem ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSearchClick(historyItem) },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.History,
                                contentDescription = "Search history",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.padding(end = 12.dp)
                            )
                            Text(
                                text = historyItem,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }

                        IconButton(
                            onClick = {
                                SearchRepository.removeFromHistory(historyItem)
                            },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Remove from history",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SearchSuggestionsSection(
    onSearchClick: (String) -> Unit
) {
    val suggestions = SearchRepository.getSearchSuggestions()

    Column {
        Text(
            text = "Suggestions",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(suggestions) { suggestion ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSearchClick(suggestion) },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(end = 12.dp)
                        )
                        Text(
                            text = suggestion,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SearchResultItem(
    lesson: Lesson,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val language = languages.find { it.id == lesson.languageId } ?: languages[0]

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Language icon
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color(language.color).copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = language.name.take(2),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(language.color)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Lesson info
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = lesson.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = language.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Text(
                    text = lesson.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            // Difficulty badge
            Text(
                text = lesson.difficulty,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .background(
                        Color(language.color).copy(alpha = 0.1f),
                        shape = CircleShape
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }
}