package com.abinet.codelearnpro

object ComprehensiveLessonGenerator {

    // Core topics that apply to all languages (25 topics)
    private val coreTopics = listOf(
        // Beginner Level (1-8)
        "Introduction and Setup",
        "Variables and Data Types",
        "Operators and Expressions",
        "Conditional Statements",
        "Loops and Iteration",
        "Functions and Methods",
        "Basic Input/Output",
        "Comments and Documentation",

        // Intermediate Level (9-16)
        "Arrays and Lists",
        "Strings and Text Processing",
        "File Handling",
        "Error and Exception Handling",
        "Object-Oriented Programming Basics",
        "Classes and Objects",
        "Inheritance",
        "Polymorphism and Interfaces",

        // Advanced Level (17-25)
        "Working with Libraries and Packages",
        "Database Connectivity",
        "Networking Basics",
        "Multithreading and Concurrency",
        "GUI Programming Introduction",
        "Web Development Basics",
        "API Integration and REST",
        "Testing and Debugging",
        "Performance Optimization",
        "Security Best Practices",
        "Deployment and Distribution",
        "Final Project: Complete Application",
        "Career Preparation and Best Practices"
    )

    fun generateAllLessons(): List<Lesson> {
        val lessons = mutableListOf<Lesson>()

        // Generate for Python (25 lessons)
        lessons.addAll(generateLanguageLessons(1, "Python", "python"))

        // Generate for C++ (25 lessons)
        lessons.addAll(generateLanguageLessons(2, "C++", "cpp"))

        // Generate for Kotlin (25 lessons)
        lessons.addAll(generateLanguageLessons(3, "Kotlin", "kotlin"))

        // Generate for Java (25 lessons)
        lessons.addAll(generateLanguageLessons(4, "Java", "java"))

        // Generate for JavaScript (25 lessons)
        lessons.addAll(generateLanguageLessons(5, "JavaScript", "js"))

        println("✅ Generated ${lessons.size} lessons total")
        return lessons
    }

    fun generateLanguageLessons(
        languageId: Int,
        languageName: String,
        languageCode: String
    ): List<Lesson> {
        return coreTopics.mapIndexed { index, topic ->
            Lesson(
                id = "${languageCode}_${index + 1}",
                languageId = languageId,
                title = "${getTopicTitle(topic, languageName)}",
                description = "Learn ${topic.lowercase()} in $languageName",
                content = generateContent(languageName, topic, index),
                codeExample = generateExample(languageCode, topic, index),
                difficulty = getDifficultyLevel(index),
                estimatedTime = getEstimatedTime(index),
                order = index + 1
            )
        }
    }

    private fun getTopicTitle(topic: String, languageName: String): String {
        return when (topic) {
            "Introduction and Setup" -> "Getting Started with $languageName"
            "Final Project: Complete Application" -> "Build a Complete $languageName Application"
            else -> "$topic in $languageName"
        }
    }

    private fun getDifficultyLevel(index: Int): String {
        return when {
            index < 8 -> "Beginner"
            index < 16 -> "Intermediate"
            else -> "Advanced"
        }
    }

    private fun getEstimatedTime(index: Int): Int {
        return when {
            index < 8 -> 15 + (index * 2)
            index < 16 -> 30 + (index * 2)
            else -> 45 + (index * 2)
        }.coerceAtMost(90) // Max 90 minutes
    }

    private fun generateContent(languageName: String, topic: String, index: Int): String {
        return """
            **${topic} in ${languageName}**
            
            This comprehensive lesson teaches you ${topic.lowercase()} using the ${languageName} programming language.
            
            **Learning Objectives:**
            • Understand the core concepts of ${topic.lowercase()}
            • Write practical ${languageName} code examples
            • Apply knowledge to solve real-world problems
            • Prepare for more advanced ${languageName} topics
            
            **Key Concepts Covered:**
            1. Fundamental principles
            2. Syntax and best practices
            3. Common use cases
            4. Error handling and debugging
            
            **Prerequisites:**
            ${if (index > 0) "• Completion of previous lessons" else "• Basic computer literacy"}
            
            **Next Steps:**
            After this lesson, you'll be ready for ${if (index < 24) "the next topic" else "real-world ${languageName} projects"}.
        """.trimIndent()
    }

    private fun generateExample(languageCode: String, topic: String, index: Int): String {
        return when (languageCode) {
            "python" -> generatePythonExample(index)
            "java" -> generateJavaExample(index)
            "cpp" -> generateCppExample(index)
            "kotlin" -> generateKotlinExample(index)
            "js" -> generateJavaScriptExample(index)
            else -> "// ${languageCode.uppercase()} example for: $topic"
        }
    }

    private fun generatePythonExample(index: Int): String {
        return when (index) {
            0 -> """
                # Hello World in Python
                print("Hello, Python World!")
                
                # Simple calculation
                print(f"5 + 3 = {5 + 3}")
            """.trimIndent()

            1 -> """
                # Variables and Data Types
                name = "Python"
                age = 30
                price = 99.99
                is_awesome = True
                
                print(f"Name: {name}")
                print(f"Age: {age}")
                print(f"Price: {price}")
                print(f"Awesome: {is_awesome}")
            """.trimIndent()

            2 -> """
                # Arithmetic Operators
                a = 10
                b = 3
                
                print(f"{a} + {b} = {a + b}")
                print(f"{a} - {b} = {a - b}")
                print(f"{a} * {b} = {a * b}")
                print(f"{a} / {b} = {a / b:.2f}")
                print(f"{a} % {b} = {a % b}")
            """.trimIndent()

            3 -> """
                # Conditional Statements
                score = 85
                
                if score >= 90:
                    grade = "A"
                elif score >= 80:
                    grade = "B"
                elif score >= 70:
                    grade = "C"
                else:
                    grade = "F"
                
                print(f"Score: {score}, Grade: {grade}")
            """.trimIndent()

            4 -> """
                # Loops
                print("For loop:")
                for i in range(1, 6):
                    print(f"  Number {i}")
                
                print("\\nWhile loop:")
                count = 5
                while count > 0:
                    print(f"  Countdown: {count}")
                    count -= 1
            """.trimIndent()

            5 -> """
                # Functions
                def greet(name):
                    return f"Hello, {name}!"
                
                def add(a, b):
                    return a + b
                
                print(greet("Learner"))
                print(f"Sum: {add(5, 3)}")
            """.trimIndent()

            6 -> """
                # Input/Output
                name = input("Enter your name: ")
                print(f"Hello, {name}!")
                
                # Reading numbers
                age = int(input("Enter your age: "))
                print(f"Next year you'll be {age + 1}")
            """.trimIndent()

            7 -> """
                # Comments and Docstrings
                \"\"\"
                This is a module-level docstring.
                It describes what this module does.
                \"\"\"
                
                def calculate_area(length, width):
                    \"\"\"Calculate area of rectangle.\"\"\"
                    return length * width
                
                # Single line comment
                area = calculate_area(5, 3)
                print(f"Area: {area}")
            """.trimIndent()

            else -> """
                # Python example for topic ${index + 1}
                # Implement the concept here
                print("Python code example")
            """.trimIndent()
        }
    }

    private fun generateJavaExample(index: Int): String {
        return when (index) {
            0 -> """
                public class HelloWorld {
                    public static void main(String[] args) {
                        System.out.println("Hello, Java World!");
                        System.out.println("5 + 3 = " + (5 + 3));
                    }
                }
            """.trimIndent()

            1 -> """
                public class Variables {
                    public static void main(String[] args) {
                        String name = "Java";
                        int age = 30;
                        double price = 99.99;
                        boolean isAwesome = true;
                        
                        System.out.println("Name: " + name);
                        System.out.println("Age: " + age);
                        System.out.println("Price: " + price);
                        System.out.println("Awesome: " + isAwesome);
                    }
                }
            """.trimIndent()

            2 -> """
                public class Operators {
                    public static void main(String[] args) {
                        int a = 10;
                        int b = 3;
                        
                        System.out.println(a + " + " + b + " = " + (a + b));
                        System.out.println(a + " - " + b + " = " + (a - b));
                        System.out.println(a + " * " + b + " = " + (a * b));
                        System.out.println(a + " / " + b + " = " + (a / b));
                        System.out.println(a + " % " + b + " = " + (a % b));
                    }
                }
            """.trimIndent()

            else -> """
                // Java example for topic ${index + 1}
                // Implement the concept here
                public class Example {
                    public static void main(String[] args) {
                        System.out.println("Java code example");
                    }
                }
            """.trimIndent()
        }
    }

    private fun generateCppExample(index: Int): String {
        return when (index) {
            0 -> """
                #include <iostream>
                using namespace std;
                
                int main() {
                    cout << "Hello, C++ World!" << endl;
                    cout << "5 + 3 = " << 5 + 3 << endl;
                    return 0;
                }
            """.trimIndent()

            1 -> """
                #include <iostream>
                #include <string>
                using namespace std;
                
                int main() {
                    string name = "C++";
                    int age = 30;
                    double price = 99.99;
                    bool isAwesome = true;
                    
                    cout << "Name: " << name << endl;
                    cout << "Age: " << age << endl;
                    cout << "Price: " << price << endl;
                    cout << "Awesome: " << boolalpha << isAwesome << endl;
                    
                    return 0;
                }
            """.trimIndent()

            else -> """
                // C++ example for topic ${index + 1}
                // Implement the concept here
                #include <iostream>
                using namespace std;
                
                int main() {
                    cout << "C++ code example" << endl;
                    return 0;
                }
            """.trimIndent()
        }
    }

    private fun generateKotlinExample(index: Int): String {
        return when (index) {
            0 -> """
                fun main() {
                    println("Hello, Kotlin World!")
                    println("5 + 3 = ${5 + 3}")
                }
            """.trimIndent()

            1 -> """
                fun main() {
                    val name = "Kotlin"
                    var age = 30
                    val price = 99.99
                    val isAwesome = true
                    
                    println("Name: name")
                    println("Age: age")
                    println("Price: price")
                    println("Awesome: isAwesome")
                }
            """.trimIndent()

            else -> """
                // Kotlin example for topic ${index + 1}
                // Implement the concept here
                fun main() {
                    println("Kotlin code example")
                }
            """.trimIndent()
        }
    }

    private fun generateJavaScriptExample(index: Int): String {
        return when (index) {
            0 -> """
                console.log("Hello, JavaScript World!");
                console.log(`5 + 3 = ${5 + 3}`);
            """.trimIndent()

            1 -> """
                // Variables in JavaScript
                let name = "JavaScript";
                const age = 30;
                let price = 99.99;
                const isAwesome = true;
                
                console.log(`Name: {name}`);
                console.log(`Age: {age}`);
                console.log(`Price: {price}`);
                console.log(`Awesome: {isAwesome}`);
            """.trimIndent()

            else -> """
                // JavaScript example for topic ${index + 1}
                // Implement the concept here
                console.log("JavaScript code example");
            """.trimIndent()
        }
    }
}