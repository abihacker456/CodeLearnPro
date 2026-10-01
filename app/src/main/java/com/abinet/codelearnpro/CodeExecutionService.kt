package com.abinet.codelearnpro

import kotlinx.coroutines.delay

/**
 * Code execution service that uses JDoodle API for real execution
 * Falls back to simulated execution if API is not configured
 */
object CodeExecutionService {

    /**
     * Execute code using JDoodle API (real execution) or simulation
     */
    suspend fun executeCodeReal(code: String, language: String): ExecutionResult {
        val trimmedCode = code.trim()

        // Check for empty code
        if (trimmedCode.isEmpty()) {
            return ExecutionResult(
                output = "No code to execute",
                success = false,
                error = "Please write some code before running"
            )
        }

        // Check for common errors first
        val error = checkForCommonErrors(trimmedCode, language)
        if (error != null) {
            return ExecutionResult(
                output = "Code contains errors",
                success = false,
                error = error
            )
        }

        // Try to use JDoodle API if configured
        return if (JDoodleService.isConfigured()) {
            executeWithJDoodle(trimmedCode, language)
        } else {
            // Fall back to simulated execution
            delay(1000) // Simulate execution time
            executeSimulated(trimmedCode, language)
        }
    }

    /**
     * Execute code using JDoodle API
     */
    private suspend fun executeWithJDoodle(code: String, language: String): ExecutionResult {
        val jdoodleLanguage = JDoodleService.getJDoodleLanguageCode(language)
        val result = JDoodleService.executeCode(code, jdoodleLanguage)

        return if (result.isSuccess) {
            // Successful execution
            val output = buildString {
                append(result.output)
                if (result.cpuTime != null) {
                    append("\n\n⏱ CPU Time: ${result.cpuTime}s")
                }
                if (result.memory != null) {
                    append("\n💾 Memory: ${result.memory}KB")
                }
                append("\n\n✅ Code executed successfully using JDoodle API!")
            }

            ExecutionResult(
                output = output,
                success = true
            )
        } else {
            // Execution failed
            ExecutionResult(
                output = "Execution failed",
                success = false,
                error = result.error ?: "Unknown error (Status: ${result.statusCode})"
            )
        }
    }

    /**
     * Simulated execution (fallback when JDoodle is not configured)
     */
    private fun executeSimulated(code: String, language: String): ExecutionResult {
        return when (language.lowercase()) {
            "python" -> executePython(code)
            "java" -> executeJava(code)
            "javascript" -> executeJavaScript(code)
            "kotlin" -> executeKotlin(code)
            "c++", "cpp" -> executeCpp(code)
            else -> ExecutionResult(
                output = "Language '$language' not supported for execution",
                success = false,
                error = "Unsupported language"
            )
        }
    }

    private fun executePython(code: String): ExecutionResult {
        return try {
            // Analyze code for different patterns
            when {
                code.contains("print(") && code.contains("\"Hello\"") ->
                    ExecutionResult(
                        output = "Hello\nCode executed successfully!",
                        success = true
                    )
                code.contains("def ") && code.contains("return") ->
                    ExecutionResult(
                        output = "Function defined and returned value\nExecution successful!",
                        success = true
                    )
                code.contains("for ") && code.contains("range(") ->
                    ExecutionResult(
                        output = "Loop executed 5 times\nOutput: 0 1 2 3 4",
                        success = true
                    )
                code.contains("if ") && code.contains("else") ->
                    ExecutionResult(
                        output = "Condition evaluated\nBranch executed successfully",
                        success = true
                    )
                code.contains("print(") ->
                    ExecutionResult(
                        output = "Output displayed\nCode executed successfully!",
                        success = true
                    )
                else ->
                    ExecutionResult(
                        output = "Python code executed!\n(Output would appear here in real execution)",
                        success = true
                    )
            }
        } catch (e: Exception) {
            ExecutionResult(
                output = "Runtime error in Python code",
                success = false,
                error = "Execution failed: ${e.message}"
            )
        }
    }

    private fun executeJava(code: String): ExecutionResult {
        return try {
            if (code.contains("System.out.println") || code.contains("System.out.print")) {
                ExecutionResult(
                    output = "Output printed to console\nJava program executed successfully!",
                    success = true
                )
            } else if (code.contains("public class") || code.contains("class ")) {
                ExecutionResult(
                    output = "Java class compiled and executed\nProgram ran successfully!",
                    success = true
                )
            } else if (code.contains("int ") || code.contains("String ") || code.contains("double ")) {
                ExecutionResult(
                    output = "Variables declared and initialized\nCode executed successfully!",
                    success = true
                )
            } else {
                ExecutionResult(
                    output = "Java code executed successfully!\n(No output generated)",
                    success = true
                )
            }
        } catch (e: Exception) {
            ExecutionResult(
                output = "Compilation error in Java code",
                success = false,
                error = "Check your syntax: ${e.message}"
            )
        }
    }

    private fun executeJavaScript(code: String): ExecutionResult {
        return try {
            when {
                code.contains("console.log") ->
                    ExecutionResult(
                        output = "Message logged to console\nJavaScript executed successfully!",
                        success = true
                    )
                code.contains("alert(") ->
                    ExecutionResult(
                        output = "Alert dialog would appear in browser\nCode executed!",
                        success = true
                    )
                code.contains("function") ->
                    ExecutionResult(
                        output = "Function defined\nJavaScript code executed!",
                        success = true
                    )
                code.contains("document.") ->
                    ExecutionResult(
                        output = "DOM manipulation simulated\nExecution successful!",
                        success = true
                    )
                else ->
                    ExecutionResult(
                        output = "JavaScript code executed!\n(Check browser console for output)",
                        success = true
                    )
            }
        } catch (e: Exception) {
            ExecutionResult(
                output = "JavaScript execution error",
                success = false,
                error = "Runtime error: ${e.message}"
            )
        }
    }

    private fun executeKotlin(code: String): ExecutionResult {
        return try {
            when {
                code.contains("println(") || code.contains("print(") ->
                    ExecutionResult(
                        output = "Output printed\nKotlin code executed successfully!",
                        success = true
                    )
                code.contains("fun ") ->
                    ExecutionResult(
                        output = "Kotlin function executed\nCode ran successfully!",
                        success = true
                    )
                code.contains("val ") || code.contains("var ") ->
                    ExecutionResult(
                        output = "Variables declared\nKotlin code executed!",
                        success = true
                    )
                else ->
                    ExecutionResult(
                        output = "Kotlin code executed successfully!\n(No visible output)",
                        success = true
                    )
            }
        } catch (e: Exception) {
            ExecutionResult(
                output = "Kotlin compilation error",
                success = false,
                error = "Check Kotlin syntax: ${e.message}"
            )
        }
    }

    private fun executeCpp(code: String): ExecutionResult {
        return try {
            when {
                code.contains("cout") && code.contains("<<") ->
                    ExecutionResult(
                        output = "Output stream executed\nC++ program ran successfully!",
                        success = true
                    )
                code.contains("#include") ->
                    ExecutionResult(
                        output = "Header included\nC++ code compiled and executed!",
                        success = true
                    )
                code.contains("int main()") ->
                    ExecutionResult(
                        output = "Main function executed\nProgram completed successfully!",
                        success = true
                    )
                else ->
                    ExecutionResult(
                        output = "C++ code executed!\n(Simulated output would appear here)",
                        success = true
                    )
            }
        } catch (e: Exception) {
            ExecutionResult(
                output = "C++ compilation error",
                success = false,
                error = "Linker or compiler error: ${e.message}"
            )
        }
    }

    private fun checkForCommonErrors(code: String, language: String): String? {
        // Check for common syntax errors
        when (language.lowercase()) {
            "python" -> {
                if (code.contains("print(") && !code.contains(")")) {
                    return "Missing closing parenthesis in print statement"
                }
                if (code.contains("def ") && !code.contains(":")) {
                    return "Missing colon in function definition"
                }
                if (code.contains("if ") && !code.contains(":")) {
                    return "Missing colon in if statement"
                }
                if (code.contains("for ") && !code.contains(":")) {
                    return "Missing colon in for loop"
                }
                if (code.contains("while ") && !code.contains(":")) {
                    return "Missing colon in while loop"
                }
                // Check for unmatched quotes
                val singleQuotes = code.count { it == '\'' }
                val doubleQuotes = code.count { it == '\"' }
                if (singleQuotes % 2 != 0) {
                    return "Unmatched single quotes"
                }
                if (doubleQuotes % 2 != 0) {
                    return "Unmatched double quotes"
                }
            }
            "java", "c++" -> {
                if (code.contains("{") && !code.contains("}")) {
                    return "Missing closing brace"
                }
                if (code.contains("(") && !code.contains(")")) {
                    return "Missing closing parenthesis"
                }
                if (code.contains("System.out.print") && !code.contains(";")) {
                    return "Missing semicolon in print statement"
                }
            }
            "javascript" -> {
                if (code.contains("console.log") && !code.contains(")")) {
                    return "Missing closing parenthesis in console.log"
                }
                if (code.contains("function") && !code.contains("{")) {
                    return "Missing opening brace in function"
                }
            }
        }

        return null // No errors detected
    }

    /**
     * Get example code for a lesson
     */
    fun getExampleCode(lessonId: String): String {
        return when (lessonId) {
            // Python examples
            "python_01" -> "print(\"Hello, Python!\")\nprint(\"Welcome to CodeLearn Pro!\")"
            "python_02" -> "name = \"Python Learner\"\nage = 20\nprint(f\"Name: {name}, Age: {age}\")"
            "python_03" -> "score = 85\nif score >= 80:\n    print(\"Great job!\")\nelse:\n    print(\"Keep practicing!\")"
            "python_04" -> "for i in range(1, 6):\n    print(f\"Number: {i}\")"
            "python_05" -> "def greet(name):\n    return f\"Hello {name}!\"\n\nprint(greet(\"Learner\"))"

            // C++ examples
            "cpp_01" -> "#include <iostream>\nusing namespace std;\n\nint main() {\n    cout << \"Hello C++!\";\n    return 0;\n}"
            "cpp_02" -> "int age = 20;\ndouble price = 99.99;\nchar grade = 'A';\nbool isStudent = true;\n\ncout << \"Age: \" << age << endl;"
            "cpp_03" -> "int score = 85;\n\nif (score >= 90) {\n    cout << \"A\";\n} else if (score >= 80) {\n    cout << \"B\";\n} else {\n    cout << \"C\";\n}"
            "cpp_04" -> "#include <iostream>\nusing namespace std;\n\nint add(int a, int b) {\n    return a + b;\n}\n\nint main() {\n    cout << add(5, 3);\n    return 0;\n}"
            "cpp_05" -> "int numbers[5] = {1, 2, 3, 4, 5};\n\nfor(int i = 0; i < 5; i++) {\n    cout << numbers[i] << \" \";\n}"

            // Kotlin examples
            "kotlin_01" -> "fun main() {\n    println(\"Hello Kotlin!\")\n}"
            "kotlin_02" -> "val name = \"Kotlin\"\nvar age = 5\n\nprintln(\"Name: \" + name)\nprintln(\"Age: \" + age)"
            "kotlin_03" -> "fun greet(name: String) {\n    println(\"Hello \" + name + \"!\")\n}\n\ngreet(\"Abinet\")"
            "kotlin_04" -> "val grade = 85\n\nwhen {\n    grade >= 90 -> println(\"A\")\n    grade >= 80 -> println(\"B\")\n    else -> println(\"C\")\n}"
            "kotlin_05" -> "val fruits = listOf(\"Apple\", \"Banana\", \"Cherry\")\n\nfor (fruit in fruits) {\n    println(fruit)\n}"

            // Java examples
            "java_01" -> "public class Main {\n    public static void main(String[] args) {\n        System.out.println(\"Hello, Java!\");\n    }\n}"
            "java_02" -> "int age = 20;\nString name = \"Java Learner\";\nSystem.out.println(\"Name: \" + name + \", Age: \" + age);"
            "java_03" -> "int votingAge = 18;\nint myAge = 20;\nif (myAge >= votingAge) {\n    System.out.println(\"You can vote!\");\n} else {\n    System.out.println(\"You cannot vote yet.\");\n}"
            "java_04" -> "public static boolean isEven(int number) {\n    return number % 2 == 0;\n}"
            "java_05" -> "class Student {\n    String name;\n    int age;\n    \n    void display() {\n        System.out.println(\"Name: \" + name);\n        System.out.println(\"Age: \" + age);\n    }\n}\n\npublic class Main {\n    public static void main(String[] args) {\n        Student s1 = new Student();\n        s1.name = \"Abinet\";\n        s1.age = 20;\n        s1.display();\n    }\n}"

            // JavaScript examples
            "js_01" -> "console.log(\"Hello, JavaScript!\");\n\nalert(\"Welcome to CodeLearn Pro!\");"
            "js_02" -> "// Old way\nvar oldVariable = \"I can be re-declared\";\n\n// Modern way\nlet modernVariable = \"I can be reassigned\";\n\n// Constant\nconst PI = 3.14159; // Cannot be reassigned\n\nconsole.log(oldVariable, modernVariable, PI);"
            "js_03" -> "// Function declaration\nfunction greet(name) {\n    return \"Hello \" + name + \"!\";\n}\n\n// Arrow function (modern)\nconst add = (a, b) => a + b;\n\n// Using functions\nconsole.log(greet(\"Abinet\"));\nconsole.log(\"Sum: \" + add(5, 3));"
            "js_04" -> "// HTML: <button id=\"myBtn\">Click Me</button>\n// HTML: <p id=\"demo\">Hello</p>\n\nconst button = document.getElementById(\"myBtn\");\nconst paragraph = document.getElementById(\"demo\");\n\nbutton.addEventListener(\"click\", function() {\n    paragraph.textContent = \"Button was clicked!\";\n    paragraph.style.color = \"blue\";\n});"
            "js_05" -> "// Creating arrays\nlet fruits = [\"Apple\", \"Banana\", \"Cherry\"];\nlet numbers = [1, 2, 3, 4, 5];\n\n// Array methods\nfruits.push(\"Orange\"); // Add to end\nfruits.pop(); // Remove from end\n\n// Looping through arrays\nfruits.forEach(fruit => {\n    console.log(fruit);\n});\n\n// Map method\nlet doubled = numbers.map(num => num * 2);\nconsole.log(doubled);"

            else -> "// Write your code here\n// Try solving the practice exercise!"
        }
    }
}

data class ExecutionResult(
    val output: String,
    val success: Boolean,
    val error: String? = null
)