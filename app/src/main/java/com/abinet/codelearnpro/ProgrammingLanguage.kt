package com.abinet.codelearnpro

data class ProgrammingLanguage(
    val id: Int,
    val name: String,
    val icon: Int, // Will reference drawable resource
    val description: String,
    val difficulty: String,
    val color: Long // Color in 0xFFFF0000 format
)