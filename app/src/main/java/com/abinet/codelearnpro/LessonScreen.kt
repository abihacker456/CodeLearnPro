package com.abinet.codelearnpro

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun LessonScreen(
    languageId: Int,
    progressViewModel: ProgressViewModel,
    onBackClick: () -> Unit,
    onLessonClick: (Lesson) -> Unit,
    modifier: Modifier = Modifier
) {
    val language = languages.find { it.id == languageId } ?: languages[0]
    val filteredLessons = LessonDataProvider.getLessonsByLanguage(languageId)
    val languageProgress = progressViewModel.getLanguageProgress(languageId)

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .statusBarsPadding()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Back button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "← Back",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .clickable { onBackClick() }
                    .padding(vertical = 8.dp)
            )
        }

        // Language header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 8.dp)
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

            Column {
                Text(
                    text = "${language.name} Lessons",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${filteredLessons.size} lessons • ${language.difficulty}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Progress Card
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "📊 Your Progress",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${"%.0f".format(languageProgress.progressPercentage)}%",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(end = 16.dp)
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = if (languageProgress.completedLessons.isEmpty()) {
                                "Start your learning journey!"
                            } else if (languageProgress.completedLessons.size == languageProgress.totalLessons) {
                                "🎉 All lessons completed!"
                            } else {
                                "Keep going! You're doing great!"
                            },
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = languageProgress.progressText,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        // Progress bar
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .background(
                                    MaterialTheme.colorScheme.surfaceVariant,
                                    shape = CircleShape
                                )
                                .padding(1.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(languageProgress.progressPercentage / 100f)
                                    .height(6.dp)
                                    .background(
                                        Color(language.color),
                                        shape = CircleShape
                                    )
                            )
                        }
                    }
                }
            }
        }

        // Lessons List Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Lessons",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = language.difficulty,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 6.dp)
                    .background(
                        Color(language.color).copy(alpha = 0.1f),
                        shape = CircleShape
                    )
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            )
        }

        // Lessons List
        filteredLessons.sortedBy { it.order }.forEachIndexed { index, lesson ->
            val isCompleted = progressViewModel.isLessonCompleted(lesson.id)
            LessonCard(
                lesson = lesson,
                languageColor = language.color,
                isCompleted = isCompleted,
                onClick = { onLessonClick(lesson) },
                index = index + 1
            )
        }

        // Coming Soon Card
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "🚀 More Coming Soon!",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "We're constantly adding new lessons and projects. Next topics:",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                val upcomingTopics = when (languageId) {
                    1 -> listOf("File Handling", "Object-Oriented Programming", "Error Handling", "Working with APIs", "Data Analysis with Pandas")
                    2 -> listOf("Pointers", "Classes and Objects", "File I/O", "Data Structures", "Game Development")
                    3 -> listOf("Room Database", "Retrofit API", "MVVM Architecture", "Firebase", "Publishing Apps")
                    4 -> listOf("Java Collections Framework", "Exception Handling", "Multithreading", "Java I/O", "Swing GUI Programming") // NEW
                    5 -> listOf("ES6+ Features", "Promises and Async/Await", "Fetch API", "Node.js Basics", "React Introduction") // NEW
                    else -> emptyList()
                }

                upcomingTopics.forEach { topic ->
                    Text(
                        text = "• $topic",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(vertical = 2.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonCard(
    lesson: Lesson,
    languageColor: Long,
    isCompleted: Boolean,
    onClick: () -> Unit,
    index: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = if (isCompleted) {
                Color(languageColor).copy(alpha = 0.15f)
            } else {
                Color(languageColor).copy(alpha = 0.05f)
            }
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(
                            if (isCompleted) {
                                Color(languageColor).copy(alpha = 0.4f)
                            } else {
                                Color(languageColor).copy(alpha = 0.2f)
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (isCompleted) {
                        Text(
                            text = "✓",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    } else {
                        Text(
                            text = index.toString(),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(languageColor)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = lesson.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = if (isCompleted) {
                                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                            } else {
                                MaterialTheme.colorScheme.onSurface
                            }
                        )

                        if (isCompleted) {
                            Text(
                                text = "✓ Completed",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier
                                    .background(
                                        Color(languageColor).copy(alpha = 0.2f),
                                        shape = CircleShape
                                    )
                                    .padding(horizontal = 8.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Text(
                        text = lesson.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = if (isCompleted) {
                            MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        },
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Bookmark button
                BookmarkIcon(
                    lessonId = lesson.id,
                    showAsButton = false,
                    size = 20,
                    modifier = Modifier.padding(start = 8.dp)
                )

                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Open ${lesson.title}",
                    tint = if (isCompleted) {
                        MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    }
                )
            }

            // ... rest of the existing code remains the same ...

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = lesson.difficulty,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .background(
                            Color(languageColor).copy(alpha = 0.1f),
                            shape = CircleShape
                        )
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                )

                Text(
                    text = "${lesson.estimatedTime} min",
                    style = MaterialTheme.typography.labelMedium,
                    color = if (isCompleted) {
                        MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    }
                )
            }
        }
    }
}