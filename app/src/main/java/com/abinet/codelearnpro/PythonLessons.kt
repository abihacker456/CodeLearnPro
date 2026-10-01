package com.abinet.codelearnpro

val pythonLessons = listOf(
    Lesson(
        id = "python_01",
        languageId = 1,
        title = "Introduction to Python",
        description = "What Python is and why it is great for beginners",
        content = """
            Python is a high-level, interpreted programming language created by Guido van Rossum in 1991. It is famous for being easy to read and write, which makes it a great first language.

            Python runs on Windows, macOS, Linux, and even small devices. Companies like Google, Instagram, and Netflix use it every day.

            In this lesson you will write your first Python program using the print() function, which displays text on the screen.

            Key ideas:
            - Python files end with .py
            - Python ignores blank lines and text after a #
            - print() is the standard way to show output
        """.trimIndent(),
        codeExample = """
            # My first Python program
            print("Hello, World!")
            print("I am learning Python")
            print("Python is fun")
        """.trimIndent(),
        exercise = "Write a Python program that prints your name, your age, and your university on three separate lines.",
        difficulty = "Beginner",
        estimatedTime = 10,
        order = 1
    ),
    Lesson(
        id = "python_02",
        languageId = 1,
        title = "Variables and Data Types",
        description = "Store and manage data using Python variables",
        content = """
            A variable is a named container that holds a value. In Python, you do not need to declare the type of a variable — Python figures it out from the value you assign.

            The most common Python data types are:
            - int: whole numbers like 5 or -12
            - float: decimal numbers like 3.14
            - str: text in quotes like "hello"
            - bool: True or False

            Variable names must start with a letter or underscore, cannot contain spaces, and are case-sensitive. Use snake_case for readability: student_name, total_score.

            You can change a variable's value at any time by assigning a new one.
        """.trimIndent(),
        codeExample = """
            name = "Abinet"
            age = 20
            price = 99.99
            is_student = True

            print(name)
            print(age)
            print(price)
            print(is_student)
        """.trimIndent(),
        exercise = "Create variables for your favorite book title, its price, and whether you have read it. Print all three.",
        difficulty = "Beginner",
        estimatedTime = 15,
        order = 2
    ),
    Lesson(
        id = "python_03",
        languageId = 1,
        title = "Conditional Statements",
        description = "Make decisions in your code with if, elif, and else",
        content = """
            Conditions let your program take different paths depending on the data. Python uses if, elif (else-if), and else.

            Comparison operators:
            - == equal
            - != not equal
            - > greater than
            - < less than
            - >= greater or equal
            - <= less or equal

            Logical operators combine conditions:
            - and: both must be True
            - or: at least one must be True
            - not: reverses the condition

            Indentation matters in Python. Everything inside an if block must be indented by 4 spaces.
        """.trimIndent(),
        codeExample = """
            score = 85

            if score >= 90:
                print("Grade A")
            elif score >= 80:
                print("Grade B")
            elif score >= 70:
                print("Grade C")
            else:
                print("Keep practicing")
        """.trimIndent(),
        exercise = "Write a program that reads a number stored in a variable and prints whether it is positive, negative, or zero.",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 3
    ),
    Lesson(
        id = "python_04",
        languageId = 1,
        title = "Loops",
        description = "Repeat actions with for and while loops",
        content = """
            Loops run a block of code multiple times. Python has two common loops.

            for loop — used when you know what to iterate over:
                for i in range(5):
                    print(i)

            while loop — repeats while a condition is True:
                count = 0
                while count < 5:
                    count += 1

            Useful tools:
            - range(start, stop, step) generates numbers
            - break exits the loop early
            - continue skips to the next iteration

            Be careful with while loops — if the condition never becomes False, the loop runs forever.
        """.trimIndent(),
        codeExample = """
            for i in range(1, 6):
                print("Number:", i)

            count = 3
            while count > 0:
                print("Countdown:", count)
                count = count - 1
        """.trimIndent(),
        exercise = "Use a for loop to print all even numbers from 2 to 20.",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 4
    ),
    Lesson(
        id = "python_05",
        languageId = 1,
        title = "Functions",
        description = "Write reusable blocks of code with functions",
        content = """
            A function is a named block of code you can call whenever you need it. Functions make programs shorter and easier to fix.

            Define a function with def:
                def greet(name):
                    print("Hello", name)

            Call it by name:
                greet("Abinet")

            Functions can take parameters (inputs) and can return a value using the return keyword:
                def add(a, b):
                    return a + b

                result = add(3, 4)

            Every function should do one thing well. If a function is long or does several jobs, split it into smaller functions.
        """.trimIndent(),
        codeExample = """
            def greet(name):
                print("Hello,", name)

            def add(a, b):
                return a + b

            greet("Abinet")
            print(add(3, 4))
        """.trimIndent(),
        exercise = "Write a function called area that takes length and width and returns the area of a rectangle. Print the result of calling it with 5 and 3.",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 5
    )
)