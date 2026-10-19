package com.abinet.codelearnpro

val kotlinLessons = listOf(
    // --- ORIGINAL 5 LESSONS ---
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
    ),

    // --- NEW 10 LESSONS ---
    Lesson(
        id = "kotlin_06",
        languageId = 3,
        title = "Null Safety",
        description = "Kotlin's way to prevent null pointer exceptions",
        content = """
            In Java, if you access a variable that is null, the app crashes. Kotlin prevents this at compile time.

            To allow a variable to be null, add a ? to the type:
                var name: String? = "Abinet"
                name = null // Allowed

            To safely access a null variable, use ?. (safe call):
                println(name?.length) // Prints null, doesn't crash

            The Elvis operator ?: provides a default value:
                val length = name?.length ?: 0

            The !! operator forces a non-null value (crashes if null). Avoid using it!
        """.trimIndent(),
        codeExample = """
            fun main() {
                var nickname: String? = "Abi"

                // Safe call
                println(nickname?.uppercase())

                // Set to null
                nickname = null
                println(nickname?.uppercase())

                // Elvis operator
                val displayName = nickname ?: "Guest"
                println(displayName)
            }
        """.trimIndent(),
        exercise = "Create a nullable String variable called `email` and set it to null. Use the Elvis operator `?:` to print 'No email provided' if it is null.",
        difficulty = "Intermediate",
        estimatedTime = 20,
        order = 6
    ),
    Lesson(
        id = "kotlin_07",
        languageId = 3,
        title = "Data Classes",
        description = "Classes built just to hold data",
        content = """
            A data class is a class whose main purpose is to hold data. Kotlin automatically generates useful methods like `toString()`, `equals()`, and `copy()` for you.

            Define one using the `data` keyword:
                data class User(val name: String, val age: Int)

            Usage:
                val user1 = User("Abinet", 20)
                println(user1) // User(name=Abinet, age=20)

            Copying with modifications:
                val user2 = user1.copy(age = 21)
        """.trimIndent(),
        codeExample = """
            data class Book(val title: String, val author: String, val year: Int)

            fun main() {
                val b1 = Book("Kotlin Basics", "Abinet", 2024)
                println(b1)

                val b2 = b1.copy(year = 2025)
                println(b2)
            }
        """.trimIndent(),
        exercise = "Create a data class called `Movie` with properties `title` (String) and `rating` (Double). Create an instance of it and print it.",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 7
    ),
    Lesson(
        id = "kotlin_08",
        languageId = 3,
        title = "Sets and Maps",
        description = "Unordered collections and key-value pairs",
        content = """
            Sets are collections of unique items. Duplicates are ignored:
                val numbers = setOf(1, 2, 3, 3, 3)
                println(numbers) // [1, 2, 3]

            Maps hold key-value pairs:
                val user = mapOf("name" to "Abinet", "age" to 20)

            Access map values using the key:
                println(user["name"])

            Use `mutableSetOf()` and `mutableMapOf()` to create versions you can change.
        """.trimIndent(),
        codeExample = """
            fun main() {
                val uniqueFruits = setOf("Apple", "Banana", "Apple")
                println(uniqueFruits) // [Apple, Banana]

                val capitalCities = mapOf(
                    "Ethiopia" to "Addis Ababa",
                    "Kenya" to "Nairobi"
                )

                println(capitalCities["Ethiopia"])
            }
        """.trimIndent(),
        exercise = "Create a Map called `student` with keys 'name' and 'grade'. Add your name and an 'A' grade. Print the whole map.",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 8
    ),
    Lesson(
        id = "kotlin_09",
        languageId = 3,
        title = "Ranges and Loops",
        description = "Iterate over numbers using ranges",
        content = """
            Kotlin makes looping over numbers very easy using ranges.

            The `..` operator creates an inclusive range:
                for (i in 1..5) {
                    println(i) // Prints 1, 2, 3, 4, 5
                }

            Use `until` for exclusive ranges:
                for (i in 1 until 5) {
                    println(i) // Prints 1, 2, 3, 4
                }

            Use `downTo` to count backwards:
                for (i in 5 downTo 1) { ... }

            Use `step` to skip numbers:
                for (i in 1..10 step 2) { ... }
        """.trimIndent(),
        codeExample = """
            fun main() {
                println("1 to 3:")
                for (i in 1..3) {
                    println(i)
                }

                println("Countdown:")
                for (i in 3 downTo 1) {
                    println(i)
                }
            }
        """.trimIndent(),
        exercise = "Use a for loop with a range to print only the even numbers from 2 to 10 (Hint: use `step 2`).",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 9
    ),
    Lesson(
        id = "kotlin_10",
        languageId = 3,
        title = "Classes and Objects",
        description = "Create blueprints for your data",
        content = """
            A class defines the structure and behavior of an object.

            class Dog(val name: String, var age: Int) {
                fun bark() {
                    println("${'$'}name says Woof!")
                }
            }

            The parameters in the class header are the constructor. If you use `val` or `var`, they become properties automatically.

            Create an object using the constructor:
                val myDog = Dog("Buddy", 3)
                myDog.bark()
        """.trimIndent(),
        codeExample = """
            class Smartphone(val brand: String, val storage: Int) {
                fun showSpecs() {
                    println("${'$'}brand with ${'$'}storage GB")
                }
            }

            fun main() {
                val phone = Smartphone("Samsung", 128)
                phone.showSpecs()
            }
        """.trimIndent(),
        exercise = "Create a class called `Student` with `name` and `grade`. Add a method that prints 'Student [name] got grade [grade]'. Create an object and call it.",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 10
    ),
    Lesson(
        id = "kotlin_11",
        languageId = 3,
        title = "Inheritance",
        description = "Build new classes from existing ones",
        content = """
            Inheritance lets a class (child) adopt the properties of another class (parent).

            To allow a class to be inherited, mark it as `open`:
                open class Animal(val name: String) {
                    fun eat() { println("${'$'}name is eating") }
                }

            The child class uses `:` and calls the parent constructor:
                class Dog(name: String) : Animal(name) {
                    fun bark() { println("Woof") }
                }
        """.trimIndent(),
        codeExample = """
            open class Vehicle(val brand: String) {
                fun start() {
                    println("${'$'}brand engine started")
                }
            }

            class Car(brand: String) : Vehicle(brand) {
                fun drive() {
                    println("Driving the car")
                }
            }

            fun main() {
                val myCar = Car("Toyota")
                myCar.start()
                myCar.drive()
            }
        """.trimIndent(),
        exercise = "Create an `open class` called `Shape` with a method `describe()`. Create a child class `Circle` that inherits from Shape.",
        difficulty = "Advanced",
        estimatedTime = 30,
        order = 11
    ),
    Lesson(
        id = "kotlin_12",
        languageId = 3,
        title = "Interfaces",
        description = "Define a contract for your classes",
        content = """
            An interface defines what a class *must* do, but not how it does it.

            interface Flyable {
                fun fly()
            }

            A class uses the `:` symbol to implement an interface, and MUST provide the method:
                class Bird : Flyable {
                    override fun fly() {
                        println("Flapping wings")
                    }
                }

            The `override` keyword is required.
        """.trimIndent(),
        codeExample = """
            interface Playable {
                fun play()
            }

            class Guitar : Playable {
                override fun play() {
                    println("Strumming strings")
                }
            }

            class Piano : Playable {
                override fun play() {
                    println("Pressing keys")
                }
            }

            fun main() {
                val g = Guitar()
                val p = Piano()
                g.play()
                p.play()
            }
        """.trimIndent(),
        exercise = "Create an interface called `Animal` with a method `sound()`. Create a class `Cow` that implements it and prints 'Moo'.",
        difficulty = "Advanced",
        estimatedTime = 30,
        order = 12
    ),
    Lesson(
        id = "kotlin_13",
        languageId = 3,
        title = "Exception Handling",
        description = "Prevent crashes with try-catch",
        content = """
            When an error happens, Kotlin throws an Exception, which crashes the app if not handled.

            Use `try` to attempt risky code, and `catch` to handle the error:
                try {
                    val result = 10 / 0
                } catch (e: ArithmeticException) {
                    println("Cannot divide by zero!")
                }

            You can use `finally` for code that must run no matter what:
                finally {
                    println("Done trying")
                }
        """.trimIndent(),
        codeExample = """
            fun main() {
                val input = "abc"

                try {
                    val number = input.toInt()
                    println("Number is ${'$'}number")
                } catch (e: NumberFormatException) {
                    println("That was not a valid number.")
                }
            }
        """.trimIndent(),
        exercise = "Write a try/catch block that tries to convert the string 'hello' to an Int. Catch the exception and print 'Failed to convert'.",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 13
    ),
    Lesson(
        id = "kotlin_14",
        languageId = 3,
        title = "Higher-Order Functions",
        description = "Pass functions as parameters",
        content = """
            Kotlin treats functions as first-class citizens. You can pass them as arguments to other functions.

            A function that takes another function:
                fun applyTwice(action: (String) -> Unit) {
                    action("Hello")
                    action("Hello")
                }

            The syntax `(String) -> Unit` means "a function that takes a String and returns nothing".

            Call it using a lambda:
                applyTwice { text ->
                    println(text)
                }
        """.trimIndent(),
        codeExample = """
            fun mathOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
                return operation(a, b)
            }

            fun main() {
                val sum = mathOperation(5, 3) { x, y -> x + y }
                println(sum) // 8

                val multiply = mathOperation(5, 3) { x, y -> x * y }
                println(multiply) // 15
            }
        """.trimIndent(),
        exercise = "Pass a lambda to `mathOperation` that subtracts the second number from the first (e.g., x - y) and prints the result.",
        difficulty = "Advanced",
        estimatedTime = 35,
        order = 14
    ),
    Lesson(
        id = "kotlin_15",
        languageId = 3,
        title = "Final Project: Task Manager",
        description = "Build a simple console app to manage tasks",
        content = """
            Let's combine what you've learned!

            We will build a Task Manager.
            1. A data class `Task`.
            2. A mutable list to hold tasks.
            3. Functions to add a task and print all tasks.
        """.trimIndent(),
        codeExample = """
            data class Task(val title: String, var isCompleted: Boolean = false)

            class TaskManager {
                private val tasks = mutableListOf<Task>()

                fun addTask(title: String) {
                    tasks.add(Task(title))
                    println("Added: ${'$'}title")
                }

                fun printTasks() {
                    for (task in tasks) {
                        val status = if (task.isCompleted) "✓" else "✗"
                        println("${'$'}status ${'$'}{task.title}")
                    }
                }
            }

            fun main() {
                val manager = TaskManager()
                manager.addTask("Learn Kotlin")
                manager.addTask("Build an App")
                manager.printTasks()
            }
        """.trimIndent(),
        exercise = "Add a method to `TaskManager` called `completeTask(title: String)` that finds a task by its title and sets its `isCompleted` to true.",
        difficulty = "Advanced",
        estimatedTime = 45,
        order = 15
    )
)
