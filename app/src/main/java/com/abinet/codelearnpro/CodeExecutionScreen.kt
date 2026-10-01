package com.abinet.codelearnpro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CodeExecutionScreen(
    lessonId: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val lesson = remember { LessonDataProvider.getLessonById(lessonId) }
    val language = remember { languages.find { it.id == lesson.languageId } ?: languages[0] }
    val exampleCode = remember { CodeExecutionService.getExampleCode(lessonId) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Practice: ${lesson.title}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Instructions
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "💡 Practice Exercise",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    val exercise = when (lesson.id) {
                        // Python exercises
                        "python_01" -> "Create a program that prints your name, age, and university."
                        "python_02" -> "Create variables for your favorite book, its price, and whether you've read it. Print them."
                        "python_03" -> "Write a program that checks if a number is positive, negative, or zero."
                        "python_04" -> "Print all even numbers from 1 to 20 using a loop."
                        "python_05" -> "Create a function that calculates the area of a rectangle."

                        // C++ exercises
                        "cpp_01" -> "Write a C++ program that prints your name and university."
                        "cpp_02" -> "Create variables for student information (name, age, GPA) and display them."
                        "cpp_03" -> "Write a program that determines if a student passed or failed (score >= 60)."
                        "cpp_04" -> "Create a function that calculates the average of three numbers."
                        "cpp_05" -> "Create an array of 5 numbers and find the largest number."

                        // Kotlin exercises
                        "kotlin_01" -> "Write a Kotlin program that greets the user with their name."
                        "kotlin_02" -> "Create val and var variables for your favorite programming language and version."
                        "kotlin_03" -> "Create a function that takes two numbers and returns their sum."
                        "kotlin_04" -> "Use when expression to convert numeric grade to letter grade (A, B, C, D, F)."
                        "kotlin_05" -> "Create a list of your favorite movies and print each one."

                        // Java exercises
                        "java_01" -> "Create a Java program that prints 'Hello, Java!' and your name."
                        "java_02" -> "Declare variables for a student's information and display them using System.out.println()."
                        "java_03" -> "Write a program that checks voting eligibility (age >= 18)."
                        "java_04" -> "Create a method that checks if a number is even or odd."
                        "java_05" -> "Create a Student class with name and age, then create an object and display its information."

                        // JavaScript exercises
                        "js_01" -> "Create a simple HTML page with JavaScript that shows an alert with your name."
                        "js_02" -> "Use let, const, and var to declare different types of variables and log them to console."
                        "js_03" -> "Create a function that converts Celsius to Fahrenheit."
                        "js_04" -> "Create a button that changes the text color when clicked (simulate DOM manipulation)."
                        "js_05" -> "Create an array of fruits and use forEach to print each fruit to console."

                        else -> "Modify the code example to solve a similar problem."
                    }

                    Text(
                        text = exercise,
                        style = MaterialTheme.typography.bodyLarge,
                        lineHeight = 24.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "💡 Tip: Use the code editor below to write and test your solution.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // REAL Code editor (fixed)
            CodeEditor(
                initialCode = exampleCode,
                language = language.name.lowercase(),
                onExecute = { code, lang ->
                    // This will be handled internally by CodeEditor now
                    println("Executing $lang code: ${code.take(50)}...")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Help section
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "🆘 Need Help?",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "• Check the lesson content for syntax examples\n" +
                                "• Start with the provided example code\n" +
                                "• Test small parts of your code before writing the full solution\n" +
                                "• Use print statements to debug your code\n" +
                                "• If using JDoodle API, you get 200 free executions per day",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 20.sp
                    )
                }
            }
        }
    }
}