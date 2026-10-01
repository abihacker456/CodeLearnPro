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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LessonDetailScreen(
    lesson: Lesson,
    progressViewModel: ProgressViewModel,
    onBackClick: () -> Unit,
    onTryCodeClick: (String) -> Unit,
    onNextLessonClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val language = languages.find { it.id == lesson.languageId } ?: languages[0]
    val isCompleted = progressViewModel.isLessonCompleted(lesson.id)

    // Get all lessons in this language
    val languageLessons = remember(lesson.languageId) {
        LessonDataProvider.getLessonsByLanguage(lesson.languageId)
            .sortedBy { it.order }
    }

    // Find current lesson index and next lesson
    val currentIndex = remember(lesson.id, languageLessons) {
        languageLessons.indexOfFirst { it.id == lesson.id }
    }

    val hasNextLesson = remember(currentIndex, languageLessons.size) {
        currentIndex >= 0 && currentIndex < languageLessons.size - 1
    }

    val nextLesson = remember(currentIndex, languageLessons) {
        if (hasNextLesson) languageLessons[currentIndex + 1] else null
    }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .statusBarsPadding()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Back button and bookmark button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "← Back",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .clickable { onBackClick() }
                    .padding(vertical = 8.dp)
            )

            // Bookmark button
            BookmarkIcon(
                lessonId = lesson.id,
                modifier = Modifier.size(24.dp)
            )
        }

        // Lesson header
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = lesson.title,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 32.sp,
                    modifier = Modifier.weight(1f)
                )

                // Completion status badge
                if (isCompleted) {
                    Text(
                        text = "✓ Completed",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .background(
                                Color(language.color).copy(alpha = 0.2f),
                                shape = CircleShape
                            )
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Color(language.color).copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = language.name.take(1),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(language.color)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = language.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = lesson.difficulty,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .background(
                            Color(language.color).copy(alpha = 0.1f),
                            shape = CircleShape
                        )
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "⏱ ${lesson.estimatedTime} min",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Description card
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "📖 Description",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                Text(
                    text = lesson.description,
                    style = MaterialTheme.typography.bodyLarge,
                    lineHeight = 24.sp
                )
            }
        }

        // Content card
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "📚 Lesson Content",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // Split content by lines and display with formatting
                val contentLines = lesson.content.split("\n")
                contentLines.forEach { line ->
                    if (line.startsWith("**") && line.endsWith("**")) {
                        // Bold text
                        Text(
                            text = line.removeSurrounding("**"),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    } else if (line.startsWith("•") || line.startsWith("✓")) {
                        // List item
                        Row(
                            modifier = Modifier.padding(vertical = 4.dp)
                        ) {
                            Text(
                                text = "• ",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = line.substring(1).trim(),
                                style = MaterialTheme.typography.bodyLarge,
                                lineHeight = 24.sp
                            )
                        }
                    } else if (line.trim().isNotEmpty()) {
                        // Regular paragraph
                        Text(
                            text = line,
                            style = MaterialTheme.typography.bodyLarge,
                            lineHeight = 24.sp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    } else {
                        // Empty line (spacing)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }

        // Code example card
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "💻 Code Example",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // Code block with monospace font
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                            shape = MaterialTheme.shapes.medium
                        )
                        .padding(16.dp)
                ) {
                    Text(
                        text = lesson.codeExample,
                        style = MaterialTheme.typography.bodyMedium,
                        fontFamily = FontFamily.Monospace,
                        lineHeight = 20.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "💡 Tip: Try running this code in the 'Try It Yourself' section below",
                    style = MaterialTheme.typography.bodySmall,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Practice card
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "🎯 Practice Exercise",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                val exercise = lesson.exercise

                Text(
                    text = exercise,
                    style = MaterialTheme.typography.bodyLarge,
                    lineHeight = 24.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Button(
                    onClick = { onTryCodeClick(lesson.id) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(language.color)
                    )
                ) {
                    Text("Try It Yourself")
                }
            }
        }

        // Next lesson navigation - FIXED VERSION
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = if (isCompleted) "🎉 Lesson Completed!" else "➡️ What's Next?",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = if (isCompleted) {
                        "Great job completing this lesson! ${if (hasNextLesson) "Move to the next lesson to continue learning." else "You've completed all lessons in this language!"}"
                    } else {
                        "Complete this lesson and practice the exercise before moving to the next topic."
                    },
                    style = MaterialTheme.typography.bodyLarge,
                    lineHeight = 24.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    if (isCompleted) {
                        Button(
                            onClick = {
                                progressViewModel.markLessonNotCompleted(lesson.id)
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                                contentColor = MaterialTheme.colorScheme.onSurfaceVariant
                            ),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Mark as Incomplete")
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        // Next Lesson button - ONLY SHOW IF THERE IS A NEXT LESSON
                        if (hasNextLesson && nextLesson != null) {
                            Button(
                                onClick = {
                                    onNextLessonClick(nextLesson.id)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(language.color)
                                ),
                                modifier = Modifier.weight(1f),
                                enabled = true
                            ) {
                                Text("Next Lesson")
                            }
                        } else {
                            // No more lessons
                            Button(
                                onClick = { onBackClick() },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                                    contentColor = MaterialTheme.colorScheme.onSurfaceVariant
                                ),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Back to Lessons")
                            }
                        }
                    } else {
                        Button(
                            onClick = {
                                progressViewModel.markLessonCompleted(lesson.id)
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            ),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Mark Complete")
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Button(
                            onClick = { onTryCodeClick(lesson.id) },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(language.color)
                            ),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Practice")
                        }
                    }
                }

                // Show next lesson preview
                if (hasNextLesson && nextLesson != null) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onNextLessonClick(nextLesson.id) },
                        colors = CardDefaults.cardColors(
                            containerColor = Color(language.color).copy(alpha = 0.1f)
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp)
                        ) {
                            Text(
                                text = "📚 Next: ${nextLesson.title}",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            Text(
                                text = nextLesson.description,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}