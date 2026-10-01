package com.abinet.codelearnpro

val languages = listOf(
    ProgrammingLanguage(
        id = 1,
        name = "Python",
        icon = android.R.drawable.ic_dialog_info, // Temporary icon
        description = "Easy to learn, great for beginners, used in AI/ML, web development, and automation.",
        difficulty = "Beginner Friendly",
        color = 0xFF4CAF50
    ),
    ProgrammingLanguage(
        id = 2,
        name = "C++",
        icon = android.R.drawable.ic_dialog_info,
        description = "High-performance language for game development, systems programming, and competitive programming.",
        difficulty = "Intermediate",
        color = 0xFF2196F3
    ),
    ProgrammingLanguage(
        id = 3,
        name = "Kotlin",
        icon = android.R.drawable.ic_dialog_info,
        description = "Modern language for Android development, concise syntax, 100% interoperable with Java.",
        difficulty = "Beginner to Advanced",
        color = 0xFF9C27B0
    ),
    // NEW: Add Java
    ProgrammingLanguage(
        id = 4,
        name = "Java",
        icon = android.R.drawable.ic_dialog_info,
        description = "Object-oriented language for enterprise applications, Android apps (legacy), and web development.",
        difficulty = "Intermediate",
        color = 0xFFF44336
    ),
    // NEW: Add JavaScript
    ProgrammingLanguage(
        id = 5,
        name = "JavaScript",
        icon = android.R.drawable.ic_dialog_info,
        description = "The language of the web. Used for frontend development, backend (Node.js), and mobile apps.",
        difficulty = "Beginner to Advanced",
        color = 0xFFFFC107
    )
)