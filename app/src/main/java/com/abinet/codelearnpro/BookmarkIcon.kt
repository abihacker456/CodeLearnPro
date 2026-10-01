package com.abinet.codelearnpro

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BookmarkIcon(
    lessonId: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    showAsButton: Boolean = true,
    size: Int = 24
) {
    var isBookmarked by remember { mutableStateOf(BookmarkRepository.isBookmarked(lessonId)) }

    if (showAsButton) {
        IconButton(
            onClick = {
                BookmarkRepository.toggleBookmark(lessonId)
                isBookmarked = !isBookmarked
                onClick()
            },
            modifier = modifier
        ) {
            if (isBookmarked) {
                Icon(
                    imageVector = Icons.Filled.Bookmark,
                    contentDescription = "Remove bookmark",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(size.dp)
                )
            } else {
                Icon(
                    imageVector = Icons.Filled.BookmarkBorder,
                    contentDescription = "Add bookmark",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(size.dp)
                )
            }
        }
    } else {
        // For non-button version (like in LessonCard), use clickable modifier
        if (isBookmarked) {
            Icon(
                imageVector = Icons.Filled.Bookmark,
                contentDescription = "Remove bookmark",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(size.dp)
                    .clickable {
                        BookmarkRepository.toggleBookmark(lessonId)
                        isBookmarked = !isBookmarked
                        onClick()
                    }
                    .then(modifier)
            )
        } else {
            Icon(
                imageVector = Icons.Filled.BookmarkBorder,
                contentDescription = "Add bookmark",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .size(size.dp)
                    .clickable {
                        BookmarkRepository.toggleBookmark(lessonId)
                        isBookmarked = !isBookmarked
                        onClick()
                    }
                    .then(modifier)
            )
        }
    }
}