package com.abinet.codelearnpro

data class Lesson(
    val id: String,
    val languageId: Int,
    val title: String,
    val description: String,
    val content: String,
    val codeExample: String,
    val difficulty: String, // "Beginner", "Intermediate", "Advanced"
    val estimatedTime: Int, // in minutes
    val order: Int // for sorting lessons in order
)