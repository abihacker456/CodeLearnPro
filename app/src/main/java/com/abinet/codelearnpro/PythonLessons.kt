package com.abinet.codelearnpro

val pythonLessons = listOf(
    // --- ORIGINAL 5 LESSONS ---
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
    ),

    // --- NEW 10 LESSONS ---
    Lesson(
        id = "python_06",
        languageId = 1,
        title = "Lists and Tuples",
        description = "Store multiple items in a single variable",
        content = """
            A list is an ordered, changeable collection of items. You create one with square brackets:
                fruits = ["apple", "banana", "cherry"]

            Access items by index (starting at 0):
                print(fruits[0])  # apple

            Change items:
                fruits[1] = "orange"

            A tuple is like a list, but immutable (cannot be changed). Create one with parentheses:
                coordinates = (10.0, 20.0)

            Use a list when the data will change. Use a tuple when the data is fixed and should not be modified.
        """.trimIndent(),
        codeExample = """
            fruits = ["apple", "banana", "cherry"]
            print(fruits[0])

            fruits.append("orange")
            print(fruits)

            coordinates = (10.0, 20.0)
            print("X:", coordinates[0])
        """.trimIndent(),
        exercise = "Create a list of 3 cities. Add a 4th city, remove the 2nd city, and print the final list.",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 6
    ),
    Lesson(
        id = "python_07",
        languageId = 1,
        title = "Dictionaries",
        description = "Store key-value pairs for fast lookups",
        content = """
            A dictionary stores data in key-value pairs. It is perfect when you want to associate values with unique keys.

            Create one with curly braces:
                student = {
                    "name": "Abinet",
                    "age": 20,
                    "grade": "A"
                }

            Access a value using its key:
                print(student["name"])

            Add or change a value:
                student["age"] = 21
                student["university"] = "MWU"

            Use the .get() method to avoid errors if the key does not exist:
                print(student.get("email", "Not provided"))
        """.trimIndent(),
        codeExample = """
            car = {"brand": "Toyota", "model": "Corolla"}

            print(car["brand"])

            car["year"] = 2022
            print(car)

            print(car.get("color", "Unknown"))
        """.trimIndent(),
        exercise = "Create a dictionary for a book with title, author, and year. Print the author's name, then add a price and print the whole dictionary.",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 7
    ),
    Lesson(
        id = "python_08",
        languageId = 1,
        title = "Error Handling",
        description = "Prevent crashes using try and except",
        content = """
            Errors happen. If you try to divide by zero or convert text to a number incorrectly, Python will crash.

            You can catch these errors using try and except:
                try:
                    result = 10 / 0
                except ZeroDivisionError:
                    print("You cannot divide by zero!")

            You can catch multiple errors:
                try:
                    number = int("abc")
                except ValueError:
                    print("That is not a number.")

            Use finally for code that should run whether an error happened or not:
                finally:
                    print("Done processing.")
        """.trimIndent(),
        codeExample = """
            try:
                num = int(input("Enter a number: "))
                print(10 / num)
            except ValueError:
                print("Error: Please enter a valid number.")
            except ZeroDivisionError:
                print("Error: Cannot divide by zero.")
        """.trimIndent(),
        exercise = "Write a try/except block that attempts to convert a variable containing 'hello' into an integer. Catch the ValueError and print a custom message.",
        difficulty = "Intermediate",
        estimatedTime = 30,
        order = 8
    ),
    Lesson(
        id = "python_09",
        languageId = 1,
        title = "Classes and Objects",
        description = "Introduction to object-oriented programming",
        content = """
            Python is an object-oriented language. A class is a blueprint for creating objects (a particular data structure).

            Define a class using the class keyword:
                class Student:
                    def __init__(self, name, age):
                        self.name = name
                        self.age = age

                    def greet(self):
                        print("Hello, I am", self.name)

            The __init__ method is the constructor. It runs when you create a new object.

            Create an object from the class:
                s1 = Student("Abinet", 20)
                s1.greet()
        """.trimIndent(),
        codeExample = """
            class Dog:
                def __init__(self, name, breed):
                    self.name = name
                    self.breed = breed

                def bark(self):
                    print(self.name, "says Woof!")

            my_dog = Dog("Buddy", "Golden Retriever")
            my_dog.bark()
        """.trimIndent(),
        exercise = "Create a class called Car with brand and color attributes. Add a method called drive that prints 'The [color] [brand] is driving'. Create one object and call drive.",
        difficulty = "Intermediate",
        estimatedTime = 35,
        order = 9
    ),
    Lesson(
        id = "python_10",
        languageId = 1,
        title = "Modules and Imports",
        description = "Use Python's built-in libraries",
        content = """
            Python comes with a huge standard library. You can use code from other files or built-in modules using import.

            Import an entire module:
                import math
                print(math.sqrt(16))

            Import specific functions:
                from math import pi
                print(pi)

            You can also give a module a shorter name:
                import random as rnd
                print(rnd.randint(1, 10))
        """.trimIndent(),
        codeExample = """
            import math
            import datetime

            print(math.pi)
            print(math.ceil(4.2))

            now = datetime.datetime.now()
            print("Current year:", now.year)
        """.trimIndent(),
        exercise = "Import the math module. Create a variable with the number 81 and use math.sqrt() to print its square root.",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 10
    ),
    Lesson(
        id = "python_11",
        languageId = 1,
        title = "List Comprehensions",
        description = "Create lists in a single line of code",
        content = """
            List comprehensions provide a short and elegant way to create a new list based on an existing one.

            Traditional way:
                numbers = [1, 2, 3, 4]
                doubled = []
                for n in numbers:
                    doubled.append(n * 2)

            List comprehension way:
                numbers = [1, 2, 3, 4]
                doubled = [n * 2 for n in numbers]

            You can also add a condition:
                evens = [n for n in numbers if n % 2 == 0]
        """.trimIndent(),
        codeExample = """
            numbers = [1, 2, 3, 4, 5, 6]

            squares = [x**2 for x in numbers]
            print(squares)

            even_numbers = [x for x in numbers if x % 2 == 0]
            print(even_numbers)
        """.trimIndent(),
        exercise = "Given the list `words = ['hello', 'world', 'python']`, use a list comprehension to create a new list containing only the words that are longer than 5 letters.",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 11
    ),
    Lesson(
        id = "python_12",
        languageId = 1,
        title = "File Handling",
        description = "Read and write text files",
        content = """
            Python makes it easy to work with files.

            To write to a file, use the "w" mode:
                with open("data.txt", "w") as file:
                    file.write("Hello, file!")

            To read a file, use the "r" mode:
                with open("data.txt", "r") as file:
                    content = file.read()
                    print(content)

            Using the with keyword ensures the file is closed automatically, even if an error occurs.
        """.trimIndent(),
        codeExample = """
            # Note: Judge0 may not allow writing to disk.
            # This is how you would do it in a real app.
            with open("test.txt", "w") as f:
                f.write("Python is great!")

            with open("test.txt", "r") as f:
                print(f.read())
        """.trimIndent(),
        exercise = "Write code that opens a file named 'notes.txt' in write mode, writes the text 'My first file', and then prints a success message.",
        difficulty = "Intermediate",
        estimatedTime = 30,
        order = 12
    ),
    Lesson(
        id = "python_13",
        languageId = 1,
        title = "Lambda Functions",
        description = "Write small, anonymous functions",
        content = """
            A lambda function is a small anonymous function. It can take any number of arguments, but can only have one expression.

            Syntax:
                lambda arguments : expression

            Example:
                add = lambda a, b: a + b
                print(add(5, 3))

            Lambdas are often used when passing a function as an argument to another function, like in sorting:
                data = [(1, "b"), (3, "a"), (2, "c")]
                data.sort(key=lambda x: x[1])
        """.trimIndent(),
        codeExample = """
            square = lambda x: x * x
            print(square(5))

            # Using lambda with map()
            numbers = [1, 2, 3, 4]
            doubled = list(map(lambda x: x * 2, numbers))
            print(doubled)
        """.trimIndent(),
        exercise = "Create a lambda function called `multiply` that takes two numbers and returns their product. Print the result of multiply(4, 5).",
        difficulty = "Intermediate",
        estimatedTime = 20,
        order = 13
    ),
    Lesson(
        id = "python_14",
        languageId = 1,
        title = "Working with JSON",
        description = "Parse and create JSON data",
        content = """
            JSON (JavaScript Object Notation) is a popular format for data exchange.

            Python has a built-in json module to work with it.

            Convert a Python dictionary to a JSON string (dumps):
                import json
                data = {"name": "Abinet", "age": 20}
                json_string = json.dumps(data)

            Convert a JSON string back to a Python dictionary (loads):
                json_string = '{"name": "Abinet", "age": 20}'
                parsed_data = json.loads(json_string)
        """.trimIndent(),
        codeExample = """
            import json

            user = {
                "name": "Abinet",
                "skills": ["Python", "Java"],
                "active": True
            }

            # Encode to JSON
            json_str = json.dumps(user, indent=2)
            print(json_str)
        """.trimIndent(),
        exercise = "Create a dictionary representing a student with name, age, and grade. Use the json module to convert it to a string and print it.",
        difficulty = "Intermediate",
        estimatedTime = 30,
        order = 14
    ),
    Lesson(
        id = "python_15",
        languageId = 1,
        title = "Final Project: Calculator",
        description = "Build a simple calculator using functions",
        content = """
            Let's combine what you've learned! We will build a simple calculator.

            We need:
            1. Functions for add, subtract, multiply, divide.
            2. A way to take user input.
            3. A loop to keep calculating until the user quits.

            This project will test your understanding of functions, conditionals, and loops.
        """.trimIndent(),
        codeExample = """
            def add(x, y):
                return x + y

            def subtract(x, y):
                return x - y

            print("Select operation:")
            print("1. Add")
            print("2. Subtract")

            choice = input("Enter choice (1/2): ")

            num1 = float(input("Enter first number: "))
            num2 = float(input("Enter second number: "))

            if choice == '1':
                print(num1, "+", num2, "=", add(num1, num2))
            elif choice == '2':
                print(num1, "-", num2, "=", subtract(num1, num2))
            else:
                print("Invalid Input")
        """.trimIndent(),
        exercise = "Extend the calculator above by writing the `multiply` and `divide` functions, and adding options '3' and '4' to the if/elif block.",
        difficulty = "Intermediate",
        estimatedTime = 45,
        order = 15
    )
)
