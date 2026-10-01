package com.abinet.codelearnpro

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSelectionScreen(
    themeViewModel: ThemeViewModel,
    progressViewModel: ProgressViewModel,
    onLanguageClick: (Int) -> Unit,
    onAboutClick: () -> Unit,
    onContactClick: () -> Unit,
    onSearchClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    onApiConfigClick: () -> Unit, // API Configuration button
    modifier: Modifier = Modifier
) {
    val isDarkTheme = themeViewModel.isDarkTheme.value
    val allLessons = LessonDataProvider.getAllLessons()
    val overallProgress = progressViewModel.getOverallProgress()
    val completedCount = progressViewModel.getCompletedCount()
    val totalCount = progressViewModel.getTotalLessonsCount()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "CodeLearn Pro",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    // Progress indicator in top bar
                    Box(
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .background(
                                MaterialTheme.colorScheme.primaryContainer,
                                shape = CircleShape
                            )
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "$completedCount/$totalCount",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    // Bookmarks button (with count badge)
                    Box(
                        modifier = Modifier.padding(end = 4.dp)
                    ) {
                        val bookmarkCount = BookmarkRepository.getBookmarkCount()
                        IconButton(
                            onClick = onBookmarksClick
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Bookmark,
                                contentDescription = "Bookmarks",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        // Show count badge if there are bookmarks
                        if (bookmarkCount > 0) {
                            Box(
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .size(16.dp)
                                    .background(
                                        MaterialTheme.colorScheme.primary,
                                        shape = CircleShape
                                    )
                            ) {
                                Text(
                                    text = if (bookmarkCount > 9) "9+" else bookmarkCount.toString(),
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                        }
                    }

                    // Search button
                    IconButton(
                        onClick = onSearchClick
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search lessons",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    // API Configuration button - Using Settings icon instead of Api
                    IconButton(
                        onClick = onApiConfigClick
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "API Configuration",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    // Theme toggle button
                    IconButton(
                        onClick = { themeViewModel.toggleTheme() }
                    ) {
                        if (isDarkTheme) {
                            Icon(
                                imageVector = Icons.Filled.LightMode,
                                contentDescription = "Switch to light theme",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Filled.DarkMode,
                                contentDescription = "Switch to dark theme",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Overall Progress Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "📊 Your Learning Progress",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        // Progress bar
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(12.dp)
                                .background(
                                    MaterialTheme.colorScheme.surfaceVariant,
                                    shape = CircleShape
                                )
                                .padding(1.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(overallProgress / 100f)
                                    .height(10.dp)
                                    .background(
                                        MaterialTheme.colorScheme.primary,
                                        shape = CircleShape
                                    )
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${"%.1f".format(overallProgress)}%",
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )

                            Text(
                                text = "$completedCount/$totalCount lessons completed",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        if (completedCount == 0) {
                            Text(
                                text = "Start learning to track your progress!",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }

                Text(
                    text = "Learn to Code",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Choose a language to start learning",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                // Show our language cards with progress
                languages.forEach { language ->
                    val languageProgress = progressViewModel.getLanguageProgress(language.id)
                    LanguageCard(
                        language = language,
                        languageProgress = languageProgress,
                        onClick = { onLanguageClick(language.id) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // About and Contact buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "About Developer",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable { onAboutClick() }
                    )

                    Text(
                        text = "Contact",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable { onContactClick() }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "More languages coming soon!",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageCard(
    language: ProgrammingLanguage,
    languageProgress: LanguageProgress,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp),
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = Color(language.color).copy(alpha = 0.1f)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(Color(language.color).copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = language.name.take(2),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(language.color)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = language.name,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold
                        )

                        // Progress indicator
                        Text(
                            text = languageProgress.progressText,
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

                    Text(
                        text = language.difficulty,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    Text(
                        text = language.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    // Progress bar for each language
                    if (languageProgress.totalLessons > 0) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(6.dp)
                                .background(
                                    MaterialTheme.colorScheme.surfaceVariant,
                                    shape = CircleShape
                                )
                                .padding(1.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(languageProgress.progressPercentage / 100f)
                                    .height(4.dp)
                                    .background(
                                        Color(language.color),
                                        shape = CircleShape
                                    )
                            )
                        }
                    }
                }

                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Select ${language.name}",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}