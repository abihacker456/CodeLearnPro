package com.abinet.codelearnpro

val pythonLessons = listOf(
    Lesson(
        id = "python_01",
        languageId = 1,
        title = "Introduction to Python",
        description = "Learn what Python is and why it's so popular",
        content = "Python is a high-level, interpreted programming language known for its simplicity and readability. It was created by Guido van Rossum and first released in 1991.\n\n" +
                "**Why Python is Great for Beginners:**\n" +
                "• Easy to read and write syntax\n" +
                "• Large community and extensive libraries\n" +
                "• Used in web development, data science, AI, and more\n" +
                "• Great for automation and scripting\n\n" +
                "**Python's Philosophy (The Zen of Python):**\n" +
                "Beautiful is better than ugly.\n" +
                "Simple is better than complex.\n" +
                "Readability counts.",
        codeExample = "# This is a comment in Python\nprint(\"Hello, World!\")\n\n# Variables don't need type declaration\nname = \"Abinet\"\nage = 20\n\nprint(f\"My name is {name} and I'm {age} years old\")",
        difficulty = "Beginner",
        estimatedTime = 15,
        order = 1
    ),
    Lesson(
        id = "python_02",
        languageId = 1,
        title = "Variables and Data Types",
        description = "Learn how to store and manipulate data in Python",
        content = "Variables are containers for storing data values. In Python, you don't need to declare the type of variable - Python figures it out automatically.\n\n" +
                "**Basic Data Types:**\n" +
                "1. **Integers**: Whole numbers (1, 2, 3, -10)\n" +
                "2. **Floats**: Decimal numbers (3.14, 2.5, -0.5)\n" +
                "3. **Strings**: Text data (\"hello\", 'Python')\n" +
                "4. **Booleans**: True or False values\n" +
                "5. **Lists**: Ordered, changeable collections\n" +
                "6. **Dictionaries**: Key-value pairs\n\n" +
                "**Naming Rules for Variables:**\n" +
                "• Must start with a letter or underscore\n" +
                "• Can contain letters, numbers, underscores\n" +
                "• Case-sensitive (age ≠ Age)\n" +
                "• Cannot use Python keywords (if, for, while, etc.)",
        codeExample = "# Integer\nage = 20\n\n# Float\nprice = 99.99\n\n# String\nname = \"Python Learner\"\nmessage = 'Hello there!'\n\n# Boolean\nis_student = True\nhas_graduated = False\n\n# List of numbers\nnumbers = [1, 2, 3, 4, 5]\n\n# Dictionary\nstudent = {\n    \"name\": \"Abinet\",\n    \"age\": 20,\n    \"university\": \"Madda Walabu\"\n}\n\n# Printing variables\nprint(f\"Name: {student['name']}\")\nprint(f\"Age: {age}\")\nprint(f\"Price: {price}\")",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 2
    ),
    Lesson(
        id = "python_03",
        languageId = 1,
        title = "Conditional Statements",
        description = "Learn how to make decisions in your code",
        content = "Conditional statements allow your program to make decisions and execute different code blocks based on conditions.\n\n" +
                "**If Statement:**\n" +
                "Executes code if condition is True\n\n" +
                "**If-Else Statement:**\n" +
                "Executes one block if True, another if False\n\n" +
                "**If-Elif-Else Statement:**\n" +
                "Handles multiple conditions\n\n" +
                "**Comparison Operators:**\n" +
                "• == Equal to\n" +
                "• != Not equal to\n" +
                "• > Greater than\n" +
                "• < Less than\n" +
                "• >= Greater than or equal to\n" +
                "• <= Less than or equal to\n\n" +
                "**Logical Operators:**\n" +
                "• and - Both conditions must be True\n" +
                "• or - At least one condition must be True\n" +
                "• not - Reverses the condition",
        codeExample = "# Simple if statement\nage = 18\n\nif age >= 18:\n    print(\"You are an adult\")\nelse:\n    print(\"You are a minor\")\n\n# If-elif-else example\ngrade = 85\n\nif grade >= 90:\n    print(\"Grade: A\")\nelif grade >= 80:\n    print(\"Grade: B\")\nelif grade >= 70:\n    print(\"Grade: C\")\nelif grade >= 60:\n    print(\"Grade: D\")\nelse:\n    print(\"Grade: F\")\n\n# Multiple conditions with logical operators\ntemperature = 25\nis_sunny = True\n\nif temperature > 20 and is_sunny:\n    print(\"Perfect weather for coding!\")\nelif temperature > 20 or is_sunny:\n    print(\"Good weather\")\nelse:\n    print(\"Stay indoors and code\")",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 3
    ),
    Lesson(
        id = "python_04",
        languageId = 1,
        title = "Loops in Python",
        description = "Learn how to repeat actions in your code",
        content = "Loops allow you to execute a block of code multiple times. Python has two main types of loops:\n\n" +
                "**For Loop:**\n" +
                "Used for iterating over a sequence (list, tuple, string, etc.) or a range of numbers.\n\n" +
                "**While Loop:**\n" +
                "Repeats as long as a condition is True.\n\n" +
                "**Loop Control Statements:**\n" +
                "• **break**: Exits the loop immediately\n" +
                "• **continue**: Skips the rest of current iteration\n" +
                "• **pass**: Does nothing (placeholder)\n\n" +
                "**Common Loop Patterns:**\n" +
                "• Iterating through lists\n" +
                "• Counting with range()\n" +
                "• Reading files line by line\n" +
                "• User input validation",
        codeExample = "# For loop with range\nprint(\"Counting from 1 to 5:\")\nfor i in range(1, 6):\n    print(f\"Number: {i}\")\n\n# For loop with list\nfruits = [\"apple\", \"banana\", \"cherry\"]\nprint(\"\\nMy favorite fruits:\")\nfor fruit in fruits:\n    print(f\"- {fruit}\")\n\n# While loop example\ncounter = 0\nprint(\"\\nWhile loop countdown:\")\nwhile counter < 5:\n    print(f\"Count: {counter}\")\n    counter += 1  # Important: increment counter\n\n# Nested loops (multiplication table)\nprint(\"\\nMultiplication Table (1-3):\")\nfor i in range(1, 4):\n    for j in range(1, 4):\n        print(f\"{i} x {j} = {i * j}\")\n    print()  # Empty line\n\n# Loop with break and continue\nprint(\"\\nBreak and Continue Example:\")\nfor num in range(1, 11):\n    if num == 3:\n        continue  # Skip number 3\n    if num == 8:\n        break     # Stop at number 8\n    print(num)",
        difficulty = "Beginner",
        estimatedTime = 30,
        order = 4
    ),
    Lesson(
        id = "python_05",
        languageId = 1,
        title = "Functions in Python",
        description = "Learn how to create reusable code blocks",
        content = "Functions are blocks of reusable code that perform a specific task. They help organize code, avoid repetition, and make programs easier to understand.\n\n" +
                "**Function Components:**\n" +
                "1. **def keyword**: Defines a function\n" +
                "2. **Function name**: Should be descriptive\n" +
                "3. **Parameters**: Input values (optional)\n" +
                "4. **Return value**: Output (optional)\n" +
                "5. **Docstring**: Documentation string\n\n" +
                "**Types of Functions:**\n" +
                "• Built-in functions (print(), len(), etc.)\n" +
                "• User-defined functions\n" +
                "• Lambda functions (anonymous)\n\n" +
                "**Function Benefits:**\n" +
                "• Code reusability\n" +
                "• Better organization\n" +
                "• Easier debugging\n" +
                "• Modular programming",
        codeExample = "# Simple function\ndef greet():\n    \"\"\"This function greets the user\"\"\"\n    print(\"Hello from CodeLearn Pro!\")\n\n# Call the function\ngreet()\n\n# Function with parameters\ndef greet_person(name, university):\n    \"\"\"Greets a person with their university\"\"\"\n    print(f\"Hello {name} from {university}!\")\n\n# Call with arguments\ngreet_person(\"Abinet\", \"Madda Walabu University\")\n\n# Function with return value\ndef add_numbers(a, b):\n    \"\"\"Returns the sum of two numbers\"\"\"\n    return a + b\n\nresult = add_numbers(10, 5)\nprint(f\"Sum: {result}\")\n\n# Function with default parameter\ndef calculate_area(length, width=1):\n    \"\"\"Calculates area (width defaults to 1 for squares)\"\"\"\n    return length * width\n\nprint(f\"Rectangle area: {calculate_area(5, 3)}\")\nprint(f\"Square area: {calculate_area(4)}\")  # Uses default width\n\n# Lambda function (anonymous)\nmultiply = lambda x, y: x * y\nprint(f\"Lambda result: {multiply(6, 7)}\")",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 5
    )
)