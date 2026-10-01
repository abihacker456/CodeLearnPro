package com.abinet.codelearnpro

val allLessons = listOf(
    // === PYTHON LESSONS (5 lessons) ===
    Lesson(
        id = "python_01",
        languageId = 1,
        title = "Introduction to Python",
        description = "Learn what Python is and why it's so popular",
        content = "Python is a high-level, interpreted programming language known for its simplicity and readability.",
        codeExample = "print(\"Hello, World!\")\nprint(\"Welcome to Python!\")",
        difficulty = "Beginner",
        estimatedTime = 15,
        order = 1
    ),
    Lesson(
        id = "python_02",
        languageId = 1,
        title = "Variables and Data Types",
        description = "Learn how to store and manipulate data",
        content = "Variables store data values. Python has dynamic typing.",
        codeExample = "name = \"Python\"\nage = 20\nprice = 99.99\nis_student = True",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 2
    ),
    Lesson(
        id = "python_03",
        languageId = 1,
        title = "Conditional Statements",
        description = "Learn if, elif, else statements",
        content = "Make decisions in your code with conditions.",
        codeExample = "age = 18\n\nif age >= 18:\n    print(\"Adult\")\nelse:\n    print(\"Minor\")",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 3
    ),
    Lesson(
        id = "python_04",
        languageId = 1,
        title = "Loops in Python",
        description = "Learn for and while loops",
        content = "Repeat actions with loops.",
        codeExample = "for i in range(5):\n    print(i)\n\ncount = 0\nwhile count < 5:\n    print(count)\n    count += 1",
        difficulty = "Beginner",
        estimatedTime = 30,
        order = 4
    ),
    Lesson(
        id = "python_05",
        languageId = 1,
        title = "Functions in Python",
        description = "Learn to create reusable code",
        content = "Functions help organize code.",
        codeExample = "def greet(name):\n    print(\"Hello \" + name + \"!\")\n\ngreet(\"Abinet\")",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 5
    ),

    // === C++ LESSONS (5 lessons) ===
    Lesson(
        id = "cpp_01",
        languageId = 2,
        title = "Introduction to C++",
        description = "Learn C++ programming basics",
        content = "C++ is powerful for system programming.",
        codeExample = "#include <iostream>\nusing namespace std;\n\nint main() {\n    cout << \"Hello C++!\";\n    return 0;\n}",
        difficulty = "Intermediate",
        estimatedTime = 20,
        order = 1
    ),
    Lesson(
        id = "cpp_02",
        languageId = 2,
        title = "C++ Variables and Types",
        description = "Learn C++ data types",
        content = "C++ has strict typing system.",
        codeExample = "int age = 20;\ndouble price = 99.99;\nchar grade = 'A';\nbool isStudent = true;",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 2
    ),
    Lesson(
        id = "cpp_03",
        languageId = 2,
        title = "C++ Control Flow",
        description = "Learn if-else and loops",
        content = "Control program flow in C++.",
        codeExample = "int score = 85;\n\nif (score >= 90) {\n    cout << \"A\";\n} else if (score >= 80) {\n    cout << \"B\";\n}",
        difficulty = "Intermediate",
        estimatedTime = 30,
        order = 3
    ),
    Lesson(
        id = "cpp_04",
        languageId = 2,
        title = "C++ Functions",
        description = "Learn to create functions",
        content = "Functions in C++ have return types.",
        codeExample = "#include <iostream>\nusing namespace std;\n\nint add(int a, int b) {\n    return a + b;\n}\n\nint main() {\n    cout << add(5, 3);\n    return 0;\n}",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 4
    ),
    Lesson(
        id = "cpp_05",
        languageId = 2,
        title = "C++ Arrays",
        description = "Learn about arrays",
        content = "Arrays store multiple values.",
        codeExample = "int numbers[5] = {1, 2, 3, 4, 5};\n\nfor(int i = 0; i < 5; i++) {\n    cout << numbers[i] << \" \";\n}",
        difficulty = "Intermediate",
        estimatedTime = 30,
        order = 5
    ),

    // === KOTLIN LESSONS (5 lessons) ===
    Lesson(
        id = "kotlin_01",
        languageId = 3,
        title = "Introduction to Kotlin",
        description = "Learn Kotlin for Android",
        content = "Kotlin is modern and concise.",
        codeExample = "fun main() {\n    println(\"Hello Kotlin!\")\n}",
        difficulty = "Beginner",
        estimatedTime = 15,
        order = 1
    ),
    Lesson(
        id = "kotlin_02",
        languageId = 3,
        title = "Kotlin Variables",
        description = "Learn val and var",
        content = "Kotlin has val (immutable) and var (mutable).",
        codeExample = "val name = \"Kotlin\"\nvar age = 5\n\nprintln(\"Name: \" + name)\nprintln(\"Age: \" + age)",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 2
    ),
    Lesson(
        id = "kotlin_03",
        languageId = 3,
        title = "Kotlin Functions",
        description = "Learn to create functions",
        content = "Functions in Kotlin use fun keyword.",
        codeExample = "fun greet(name: String) {\n    println(\"Hello \" + name + \"!\")\n}\n\ngreet(\"Abinet\")",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 3
    ),
    Lesson(
        id = "kotlin_04",
        languageId = 3,
        title = "Kotlin Conditionals",
        description = "Learn if-else and when",
        content = "Kotlin has when statement (like switch).",
        codeExample = "val grade = 85\n\nwhen {\n    grade >= 90 -> println(\"A\")\n    grade >= 80 -> println(\"B\")\n    else -> println(\"C\")\n}",
        difficulty = "Beginner",
        estimatedTime = 30,
        order = 4
    ),
    Lesson(
        id = "kotlin_05",
        languageId = 3,
        title = "Kotlin Lists",
        description = "Learn collections in Kotlin",
        content = "Kotlin has List, MutableList, etc.",
        codeExample = "val fruits = listOf(\"Apple\", \"Banana\", \"Cherry\")\n\nfor (fruit in fruits) {\n    println(fruit)\n}",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 5
    ),

    // === JAVA LESSONS (5 lessons) ===
    Lesson(
        id = "java_01",
        languageId = 4,
        title = "Introduction to Java",
        description = "Learn Java programming fundamentals",
        content = "Java is an object-oriented, class-based programming language designed to have as few implementation dependencies as possible.",
        codeExample = "public class Main {\n    public static void main(String[] args) {\n        System.out.println(\"Hello, World!\");\n    }\n}",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 1
    ),
    Lesson(
        id = "java_02",
        languageId = 4,
        title = "Java Variables and Types",
        description = "Learn Java data types and variables",
        content = "Java is statically typed, meaning variables must be declared before use.",
        codeExample = "int age = 20;\ndouble price = 99.99;\nchar grade = 'A';\nString name = \"Java\";\nboolean isStudent = true;",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 2
    ),
    Lesson(
        id = "java_03",
        languageId = 4,
        title = "Java Control Statements",
        description = "Learn if-else and loops in Java",
        content = "Java supports standard control flow statements.",
        codeExample = "int score = 85;\n\nif (score >= 90) {\n    System.out.println(\"Grade: A\");\n} else if (score >= 80) {\n    System.out.println(\"Grade: B\");\n} else {\n    System.out.println(\"Grade: C\");\n}",
        difficulty = "Beginner",
        estimatedTime = 30,
        order = 3
    ),
    Lesson(
        id = "java_04",
        languageId = 4,
        title = "Java Methods",
        description = "Learn to create methods in Java",
        content = "Methods in Java are similar to functions in other languages.",
        codeExample = "public class Calculator {\n    public static int add(int a, int b) {\n        return a + b;\n    }\n    \n    public static void main(String[] args) {\n        System.out.println(\"Sum: \" + add(5, 3));\n    }\n}",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 4
    ),
    Lesson(
        id = "java_05",
        languageId = 4,
        title = "Java Classes and Objects",
        description = "Learn object-oriented programming in Java",
        content = "Java is object-oriented. Everything in Java is associated with classes and objects.",
        codeExample = "class Student {\n    String name;\n    int age;\n    \n    void display() {\n        System.out.println(\"Name: \" + name);\n        System.out.println(\"Age: \" + age);\n    }\n}\n\npublic class Main {\n    public static void main(String[] args) {\n        Student s1 = new Student();\n        s1.name = \"Abinet\";\n        s1.age = 20;\n        s1.display();\n    }\n}",
        difficulty = "Intermediate",
        estimatedTime = 35,
        order = 5
    ),

    // === JAVASCRIPT LESSONS (5 lessons) ===
    Lesson(
        id = "js_01",
        languageId = 5,
        title = "Introduction to JavaScript",
        description = "Learn JavaScript for web development",
        content = "JavaScript is the programming language of the Web. It's lightweight and commonly used for web pages.",
        codeExample = "console.log(\"Hello, JavaScript!\");\n\nalert(\"Welcome to CodeLearn Pro!\");",
        difficulty = "Beginner",
        estimatedTime = 15,
        order = 1
    ),
    Lesson(
        id = "js_02",
        languageId = 5,
        title = "JavaScript Variables",
        description = "Learn var, let, and const in JavaScript",
        content = "JavaScript has three ways to declare variables: var, let, and const.",
        codeExample = "// Old way\nvar oldVariable = \"I can be re-declared\";\n\n// Modern way\nlet modernVariable = \"I can be reassigned\";\n\n// Constant\nconst PI = 3.14159; // Cannot be reassigned\n\nconsole.log(oldVariable, modernVariable, PI);",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 2
    ),
    Lesson(
        id = "js_03",
        languageId = 5,
        title = "JavaScript Functions",
        description = "Learn functions in JavaScript",
        content = "JavaScript functions are blocks of code designed to perform a particular task.",
        codeExample = "// Function declaration\nfunction greet(name) {\n    return \"Hello \" + name + \"!\";\n}\n\n// Arrow function (modern)\nconst add = (a, b) => a + b;\n\n// Using functions\nconsole.log(greet(\"Abinet\"));\nconsole.log(\"Sum: \" + add(5, 3));",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 3
    ),
    Lesson(
        id = "js_04",
        languageId = 5,
        title = "DOM Manipulation",
        description = "Learn to manipulate web pages with JavaScript",
        content = "The Document Object Model (DOM) is a programming interface for web documents.",
        codeExample = "// HTML: <button id=\"myBtn\">Click Me</button>\n// HTML: <p id=\"demo\">Hello</p>\n\nconst button = document.getElementById(\"myBtn\");\nconst paragraph = document.getElementById(\"demo\");\n\nbutton.addEventListener(\"click\", function() {\n    paragraph.textContent = \"Button was clicked!\";\n    paragraph.style.color = \"blue\";\n});",
        difficulty = "Intermediate",
        estimatedTime = 30,
        order = 4
    ),
    Lesson(
        id = "js_05",
        languageId = 5,
        title = "JavaScript Arrays",
        description = "Learn arrays and array methods in JavaScript",
        content = "Arrays are used to store multiple values in a single variable.",
        codeExample = "// Creating arrays\nlet fruits = [\"Apple\", \"Banana\", \"Cherry\"];\nlet numbers = [1, 2, 3, 4, 5];\n\n// Array methods\nfruits.push(\"Orange\"); // Add to end\nfruits.pop(); // Remove from end\n\n// Looping through arrays\nfruits.forEach(fruit => {\n    console.log(fruit);\n});\n\n// Map method\nlet doubled = numbers.map(num => num * 2);\nconsole.log(doubled);",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 5
    )
)