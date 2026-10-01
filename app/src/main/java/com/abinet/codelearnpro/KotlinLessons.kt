package com.abinet.codelearnpro

val kotlinLessons = listOf(
    Lesson(
        id = "kotlin_01",
        languageId = 3,
        title = "Introduction to Kotlin",
        description = "Meet Kotlin and write your first program",
        content = """
            Kotlin is a modern language created by JetBrains in 2011. Google made it the preferred language for Android development in 2019.

            Kotlin is concise, safe, and interoperates with Java — you can use Java libraries from Kotlin and vice versa.

            Every Kotlin program starts with a main function:
                fun main() {
                    println("Hello")
                }

            println() prints text followed by a new line. print() prints without moving to a new line.

            You do not need semicolons at the end of each line, though they are allowed.
        """.trimIndent(),
        codeExample = """
            fun main() {
                println("Hello, Kotlin!")
                println("I am learning Kotlin")
            }
        """.trimIndent(),
        exercise = "Write a Kotlin program that prints your name and your favorite programming language on separate lines.",
        difficulty = "Beginner",
        estimatedTime = 10,
        order = 1
    ),
    Lesson(
        id = "kotlin_02",
        languageId = 3,
        title = "val, var, and Data Types",
        description = "Understand the two ways to declare a variable",
        content = """
            Kotlin has two keywords for variables:

            val — a value that cannot change (immutable). Use this by default.
            var — a variable that can be reassigned.

            Examples:
                val name = "Kotlin"
                var score = 10
                score = 20   // allowed
                // name = "X" would NOT compile

            Kotlin infers the type from the value. You can also state it:
                val age: Int = 20

            Common types:
            - Int, Long: whole numbers
            - Double: decimals
            - String: text
            - Boolean: true / false

            Rule of thumb: use val unless you truly need to change the value.
        """.trimIndent(),
        codeExample = """
            fun main() {
                val language = "Kotlin"
                var year = 2011

                println(language)
                println(year)

                year = 2024
                println(year)
            }
        """.trimIndent(),
        exercise = "Create a val for your name and a var for your age. Print both, then change age and print it again.",
        difficulty = "Beginner",
        estimatedTime = 15,
        order = 2
    ),
    Lesson(
        id = "kotlin_03",
        languageId = 3,
        title = "Functions",
        description = "Define and call functions in Kotlin",
        content = """
            Functions in Kotlin use the fun keyword.

            Basic shape:
                fun greet(name: String) {
                    println("Hello, " + name)
                }

            - fun is the keyword
            - greet is the name
            - (name: String) is the parameter list — Kotlin always states the type
            - The block prints a greeting

            Functions with a return value:
                fun add(a: Int, b: Int): Int {
                    return a + b
                }

            Short form using an expression body:
                fun add(a: Int, b: Int) = a + b

            Call a function by name: greet("Abinet")
        """.trimIndent(),
        codeExample = """
            fun greet(name: String) {
                println("Hello, " + name)
            }

            fun add(a: Int, b: Int): Int {
                return a + b
            }

            fun main() {
                greet("Abinet")
                println(add(5, 3))
            }
        """.trimIndent(),
        exercise = "Write a Kotlin function called multiply that takes two Int parameters and returns their product. Call it from main and print the result.",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 3
    ),
    Lesson(
        id = "kotlin_04",
        languageId = 3,
        title = "when Expression",
        description = "Kotlin's powerful replacement for switch",
        content = """
            Kotlin's when expression replaces Java's switch. It is cleaner and safer.

            Form 1 — match a value:
                when (grade) {
                    "A" -> println("Excellent")
                    "B" -> println("Good")
                    else -> println("Keep going")
                }

            Form 2 — check conditions:
                when {
                    score >= 90 -> println("A")
                    score >= 80 -> println("B")
                    else -> println("C")
                }

            Every branch starts with -> and returns a value if the whole expression is assigned.

            You can capture the result:
                val label = when (score) {
                    in 90..100 -> "A"
                    in 80..89 -> "B"
                    else -> "C"
                }
        """.trimIndent(),
        codeExample = """
            fun main() {
                val score = 85

                when {
                    score >= 90 -> println("Grade A")
                    score >= 80 -> println("Grade B")
                    score >= 70 -> println("Grade C")
                    else -> println("Keep practicing")
                }
            }
        """.trimIndent(),
        exercise = "Use when to print the name of the day for a number 1 to 7 (1 = Monday, 7 = Sunday). Handle numbers outside that range.",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 4
    ),
    Lesson(
        id = "kotlin_05",
        languageId = 3,
        title = "Lists",
        description = "Store ordered collections of values",
        content = """
            Kotlin has two list types:

            val fruits = listOf("Apple", "Banana", "Cherry")   // read-only
            val numbers = mutableListOf(1, 2, 3)               // changeable

            Access by index (starting at 0):
                fruits[0]   // "Apple"

            Loop over a list:
                for (fruit in fruits) {
                    println(fruit)
                }

            Useful methods:
            - fruits.size returns the number of items
            - fruits.contains("Apple") checks membership
            - numbers.add(4) adds to a mutable list
            - numbers.removeAt(0) removes by index

            Read-only lists are safer by default. Switch to mutableListOf only when you need to change the list.
        """.trimIndent(),
        codeExample = """
            fun main() {
                val fruits = listOf("Apple", "Banana", "Cherry")

                for (fruit in fruits) {
                    println(fruit)
                }

                println("Total: " + fruits.size)

                val numbers = mutableListOf(1, 2, 3)
                numbers.add(4)
                println(numbers)
            }
        """.trimIndent(),
        exercise = "Create a list of your five favorite movies and print each one, then print the total count.",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 5
    )
)