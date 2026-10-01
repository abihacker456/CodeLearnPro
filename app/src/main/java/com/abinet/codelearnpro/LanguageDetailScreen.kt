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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LanguageDetailScreen(
    languageId: Int,
    onBackClick: () -> Unit,
    onStartLearning: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val language = languages.find { it.id == languageId } ?: languages[0]

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .statusBarsPadding()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Back button at top
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

        // Language header with color
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Color(language.color).copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = language.name.take(2),
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(language.color)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = language.name,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = language.difficulty,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Description
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "About ${language.name}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = language.description,
                    style = MaterialTheme.typography.bodyLarge,
                    lineHeight = 24.sp
                )
            }
        }

        // What you'll learn
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "What You'll Learn",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                val learningPoints = when (language.id) {
                    1 -> listOf( // Python
                        "✓ Basic syntax and data types",
                        "✓ Functions and modules",
                        "✓ Object-oriented programming",
                        "✓ File handling and APIs",
                        "✓ Real-world projects"
                    )
                    2 -> listOf( // C++
                        "✓ Memory management",
                        "✓ Pointers and references",
                        "✓ Object-oriented programming",
                        "✓ Data structures and algorithms",
                        "✓ Game development basics"
                    )
                    3 -> listOf( // Kotlin
                        "✓ Android development fundamentals",
                        "✓ Jetpack Compose UI",
                        "✓ Coroutines and flows",
                        "✓ Room database",
                        "✓ Publish your own apps"
                    )
                    4 -> listOf( // Java - NEWLY ADDED
                        "✓ Object-oriented programming concepts",
                        "✓ Java syntax and core libraries",
                        "✓ Exception handling and debugging",
                        "✓ Collections framework",
                        "✓ Building console applications"
                    )
                    5 -> listOf( // JavaScript - NEWLY ADDED
                        "✓ JavaScript fundamentals and syntax",
                        "✓ DOM manipulation and events",
                        "✓ Asynchronous programming",
                        "✓ Modern ES6+ features",
                        "✓ Building interactive web pages"
                    )
                    else -> emptyList()
                }

                learningPoints.forEach { point ->
                    Text(
                        text = point,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Start Learning Button
        Button(
            onClick = { onStartLearning(languageId) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(language.color)
            )
        ) {
            Text(
                text = "Start Learning ${language.name}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}