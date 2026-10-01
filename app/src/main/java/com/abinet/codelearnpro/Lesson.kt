package com.abinet.codelearnpro

data class Lesson(
    val id: String,
    val languageId: Int,
    val title: String,
    val description: String,
    val content: String,
    val codeExample: String,
    val exercise: String,
    val difficulty: String,
    val estimatedTime: Int,
    val order: Int
)