package com.abinet.codelearnpro

val javaScriptLessons = listOf(
    Lesson(
        id = "js_01",
        languageId = 5,
        title = "Introduction to JavaScript",
        description = "JavaScript basics and the console",
        content = """
            JavaScript is the language of the web. Every browser runs it. It is also used on servers through Node.js and in mobile apps through React Native.

            The simplest way to see output is console.log(), which prints to the developer console:
                console.log("Hello, JavaScript!");

            Other basic ideas:
            - Statements usually end with a semicolon (optional but recommended)
            - // starts a single-line comment
            - /* ... */ wraps a multi-line comment
            - Case matters: log and Log are different

            In this course we run JavaScript through a code execution service, so output appears as text — no browser needed.
        """.trimIndent(),
        codeExample = """
            // My first JavaScript program
            console.log("Hello, JavaScript!");
            console.log("JavaScript runs in every browser");
        """.trimIndent(),
        exercise = "Write JavaScript that logs your name, your age, and your university using three console.log calls.",
        difficulty = "Beginner",
        estimatedTime = 10,
        order = 1
    ),
    Lesson(
        id = "js_02",
        languageId = 5,
        title = "Variables: let and const",
        description = "Two modern ways to declare variables",
        content = """
            JavaScript has three ways to declare a variable: var, let, and const.

            - var is the old way. It has confusing scope rules. Avoid it in modern code.
            - let declares a variable that can be reassigned.
            - const declares a variable that cannot be reassigned.

            Examples:
                let count = 0;
                count = 1;                // allowed

                const PI = 3.14159;
                // PI = 3; would throw an error

            Use const by default. Switch to let only when you need to change the value.

            JavaScript is dynamically typed — you do not declare the type:
                let name = "Abinet";      // string
                let age = 20;             // number
                let isStudent = true;     // boolean
        """.trimIndent(),
        codeExample = """
            let count = 0;
            console.log(count);

            count = count + 1;
            console.log(count);

            const name = "Abinet";
            console.log(name);
        """.trimIndent(),
        exercise = "Declare a let called score with value 10, then reassign it to 20 and log both values.",
        difficulty = "Beginner",
        estimatedTime = 15,
        order = 2
    ),
    Lesson(
        id = "js_03",
        languageId = 5,
        title = "Functions",
        description = "Two ways to write JavaScript functions",
        content = """
            A function groups code that performs a task.

            Classic declaration:
                function greet(name) {
                    return "Hello, " + name;
                }

            Arrow function (modern, shorter):
                const greet = (name) => "Hello, " + name;

            Both do the same thing. Arrow functions are common in modern JavaScript, especially when passing functions to other functions.

            Calling a function:
                console.log(greet("Abinet"));

            If a function has no return statement, it returns undefined.

            Parameters are the names in the function definition. Arguments are the values you pass when calling it.
        """.trimIndent(),
        codeExample = """
            function add(a, b) {
                return a + b;
            }

            const multiply = (a, b) => a * b;

            console.log(add(3, 4));
            console.log(multiply(3, 4));
        """.trimIndent(),
        exercise = "Write an arrow function called square that takes a number and returns its square. Print the square of 7.",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 3
    ),
    Lesson(
        id = "js_04",
        languageId = 5,
        title = "Arrays",
        description = "Work with ordered lists of values",
        content = """
            An array holds an ordered list of values:
                const fruits = ["Apple", "Banana", "Cherry"];

            Access by index (starting at 0):
                fruits[0]   // "Apple"

            Common operations:
                fruits.length              // 3
                fruits.push("Date")        // add to end
                fruits.pop()               // remove from end
                fruits.includes("Apple")   // true

            Iterate with a loop:
                for (let i = 0; i < fruits.length; i++) {
                    console.log(fruits[i]);
                }

            Or use forEach:
                fruits.forEach(f => console.log(f));

            Arrays can hold mixed types, but keeping them consistent avoids bugs.
        """.trimIndent(),
        codeExample = """
            const fruits = ["Apple", "Banana", "Cherry"];

            console.log(fruits.length);
            fruits.push("Date");
            console.log(fruits);

            for (const fruit of fruits) {
                console.log(fruit);
            }
        """.trimIndent(),
        exercise = "Create an array of 5 numbers and use a for loop to print each number and finally their sum.",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 4
    ),
    Lesson(
        id = "js_05",
        languageId = 5,
        title = "Objects",
        description = "Group related values into a single object",
        content = """
            An object stores named values:
                const student = {
                    name: "Abinet",
                    age: 20,
                    isStudent: true
                };

            Access a value with dot notation:
                student.name       // "Abinet"

            Or with bracket notation:
                student["name"]    // "Abinet"

            Add or change fields:
                student.grade = "A";
                student.age = 21;

            Objects often contain functions, called methods:
                const counter = {
                    count: 0,
                    increment() {
                        this.count = this.count + 1;
                    }
                };

                counter.increment();
                console.log(counter.count);   // 1

            Inside a method, this refers to the object.
        """.trimIndent(),
        codeExample = """
            const student = {
                name: "Abinet",
                age: 20,
                isStudent: true
            };

            console.log(student.name);
            console.log(student["age"]);

            student.grade = "A";
            console.log(student);
        """.trimIndent(),
        exercise = "Create an object called book with title, author, and year fields. Print each field on its own line.",
        difficulty = "Intermediate",
        estimatedTime = 30,
        order = 5
    )
)