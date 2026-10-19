package com.abinet.codelearnpro

val javaScriptLessons = listOf(
    // --- ORIGINAL 5 LESSONS ---
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

            Objects often contain functions, called methods.
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
    ),

    // --- NEW 10 LESSONS ---
    Lesson(
        id = "js_06",
        languageId = 5,
        title = "Loops",
        description = "Repeat actions using for and while",
        content = """
            Loops execute a block of code multiple times.

            `for` loop — used when you know how many times to loop:
                for (let i = 0; i < 3; i++) {
                    console.log(i);
                }

            `while` loop — repeats as long as a condition is true:
                let count = 0;
                while (count < 3) {
                    console.log(count);
                    count++;
                }

            Be careful with while loops — if the condition never becomes false, it will run forever and crash your app.
        """.trimIndent(),
        codeExample = """
            // For loop
            for (let i = 1; i <= 3; i++) {
                console.log("Count: " + i);
            }

            // While loop
            let num = 3;
            while (num > 0) {
                console.log("Num: " + num);
                num--;
            }
        """.trimIndent(),
        exercise = "Use a for loop to print all even numbers from 2 to 10.",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 6
    ),
    Lesson(
        id = "js_07",
        languageId = 5,
        title = "Array Methods",
        description = "Transform and filter arrays easily",
        content = """
            JavaScript arrays have powerful built-in methods that take a function (callback) as an argument.

            `map()` creates a new array by applying a function to every item:
                const nums = [1, 2, 3];
                const doubled = nums.map(n => n * 2);
                // [2, 4, 6]

            `filter()` creates a new array with items that pass a test:
                const evens = nums.filter(n => n % 2 === 0);
                // [2]

            `forEach()` executes a function for each item (returns nothing):
                nums.forEach(n => console.log(n));
        """.trimIndent(),
        codeExample = """
            const prices = [10, 25, 5, 50];

            const doubledPrices = prices.map(p => p * 2);
            console.log(doubledPrices);

            const expensive = prices.filter(p => p > 10);
            console.log(expensive);
        """.trimIndent(),
        exercise = "Given the array `const ages = [12, 18, 25, 14, 30]`, use `filter()` to create an array of ages that are 18 or older and print it.",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 7
    ),
    Lesson(
        id = "js_08",
        languageId = 5,
        title = "String Methods",
        description = "Manipulate and search text",
        content = """
            Strings in JavaScript have many useful methods.

            const text = "Hello World";

            - text.length -> 11
            - text.toUpperCase() -> "HELLO WORLD"
            - text.toLowerCase() -> "hello world"
            - text.includes("World") -> true
            - text.indexOf("World") -> 6
            - text.slice(0, 5) -> "Hello"
            - text.split(" ") -> ["Hello", "World"]

            Remember, strings are immutable. These methods return new strings, they do not change the original.
        """.trimIndent(),
        codeExample = """
            const sentence = "JavaScript is fun";

            console.log(sentence.length);
            console.log(sentence.toUpperCase());
            console.log(sentence.includes("fun"));
            console.log(sentence.split(" "));
        """.trimIndent(),
        exercise = "Create a string variable with the text ' Programming '. Use `.trim()` to remove the spaces, and print the trimmed length.",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 8
    ),
    Lesson(
        id = "js_09",
        languageId = 5,
        title = "Error Handling",
        description = "Catch errors and prevent crashes",
        content = """
            Errors happen. If you try to access a property of null, your program will crash.

            Use `try` and `catch` to handle errors gracefully:
                try {
                    // risky code
                    let result = myFunction();
                } catch (error) {
                    // handle the error
                    console.log("An error occurred: " + error.message);
                }

            You can also throw your own errors:
                throw new Error("Something went wrong");
        """.trimIndent(),
        codeExample = """
            try {
                const user = null;
                console.log(user.name); // This will cause an error
            } catch (error) {
                console.log("Caught an error!");
            }
        """.trimIndent(),
        exercise = "Write a try/catch block. Inside the try block, use `throw new Error('Test error')`. Catch it and print 'Handled'.",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 9
    ),
    Lesson(
        id = "js_10",
        languageId = 5,
        title = "Classes",
        description = "Blueprints for creating objects",
        content = """
            ES6 introduced the `class` syntax, which makes object-oriented programming easier.

            class Car {
                constructor(brand) {
                    this.brand = brand;
                }

                drive() {
                    console.log(this.brand + " is driving");
                }
            }

            Create an instance using `new`:
                const myCar = new Car("Toyota");
                myCar.drive();
        """.trimIndent(),
        codeExample = """
            class Student {
                constructor(name, grade) {
                    this.name = name;
                    this.grade = grade;
                }

                introduce() {
                    console.log("I am " + this.name + " and my grade is " + this.grade);
                }
            }

            const s1 = new Student("Abinet", "A");
            s1.introduce();
        """.trimIndent(),
        exercise = "Create a class called `Book` with a constructor that takes `title` and `author`. Add a method `describe` that prints both.",
        difficulty = "Intermediate",
        estimatedTime = 30,
        order = 10
    ),
    Lesson(
        id = "js_11",
        languageId = 5,
        title = "Destructuring and Spread",
        description = "Extract values from arrays and objects",
        content = """
            Destructuring lets you unpack values from arrays or objects into distinct variables.

            Array destructuring:
                const colors = ["red", "green"];
                const [first, second] = colors;
                console.log(first); // "red"

            Object destructuring:
                const user = { name: "Abinet", age: 20 };
                const { name, age } = user;
                console.log(name); // "Abinet"

            The spread operator `...` expands elements:
                const arr1 = [1, 2];
                const arr2 = [...arr1, 3, 4]; // [1, 2, 3, 4]
        """.trimIndent(),
        codeExample = """
            const numbers = [10, 20, 30];
            const [a, b] = numbers;
            console.log(a);
            console.log(b);

            const user = { name: "Abi", role: "Dev" };
            const { name } = user;
            console.log(name);
        """.trimIndent(),
        exercise = "Create an object `movie` with `title` and `year`. Destructure them into variables and print the title.",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 11
    ),
    Lesson(
        id = "js_12",
        languageId = 5,
        title = "Promises and Async/Await",
        description = "Handle asynchronous operations",
        content = """
            JavaScript is asynchronous. Promises represent a value that will be available later.

            An `async` function automatically returns a Promise.
            `await` pauses the function until the Promise resolves.

            async function fetchData() {
                try {
                    const response = await fetch("https://api.example.com");
                    const data = await response.json();
                    console.log(data);
                } catch (error) {
                    console.log("Failed to fetch");
                }
            }

            (Note: `fetch` might not work in the sandbox environment, so we use a simulated example).
        """.trimIndent(),
        codeExample = """
            async function getMessage() {
                // Simulate a network request delay
                return new Promise(resolve => {
                    setTimeout(() => resolve("Data loaded!"), 1000);
                });
            }

            async function start() {
                console.log("Loading...");
                const result = await getMessage();
                console.log(result);
            }

            start();
        """.trimIndent(),
        exercise = "Write an async function called `hello` that returns the string 'Hello World' after a 1-second delay using a Promise. Call it and log the result.",
        difficulty = "Advanced",
        estimatedTime = 35,
        order = 12
    ),
    Lesson(
        id = "js_13",
        languageId = 5,
        title = "Working with JSON",
        description = "Convert objects to strings and back",
        content = """
            JSON (JavaScript Object Notation) is the standard format for sending data across the web.

            Convert an object to a JSON string using `JSON.stringify()`:
                const user = { name: "Abinet", age: 20 };
                const jsonString = JSON.stringify(user);
                // '{"name":"Abinet","age":20}'

            Convert a JSON string back to an object using `JSON.parse()`:
                const parsed = JSON.parse(jsonString);
                console.log(parsed.name); // "Abinet"
        """.trimIndent(),
        codeExample = """
            const car = {
                brand: "Toyota",
                model: "Corolla",
                year: 2022
            };

            const jsonText = JSON.stringify(car);
            console.log(jsonText);

            const backToObject = JSON.parse(jsonText);
            console.log(backToObject.brand);
        """.trimIndent(),
        exercise = "Create an object `student` with `name` and `grade`. Use `JSON.stringify()` to convert it to a string and print it.",
        difficulty = "Intermediate",
        estimatedTime = 20,
        order = 13
    ),
    Lesson(
        id = "js_14",
        languageId = 5,
        title = "Math and Date",
        description = "Built-in objects for numbers and time",
        content = """
            The `Math` object provides mathematical constants and functions.
                Math.PI
                Math.max(10, 20) // 20
                Math.floor(4.9)  // 4
                Math.random()    // Random number between 0 and 1

            The `Date` object works with dates and times.
                const now = new Date();
                now.getFullYear();
                now.getMonth(); // 0 = January
        """.trimIndent(),
        codeExample = """
            console.log(Math.max(5, 10, 2));
            console.log(Math.floor(Math.random() * 10) + 1);

            const today = new Date();
            console.log(today.getFullYear());
        """.trimIndent(),
        exercise = "Use `Math.random()` and `Math.floor()` to generate a random integer between 1 and 100, and print it.",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 14
    ),
    Lesson(
        id = "js_15",
        languageId = 5,
        title = "Final Project: To-Do List",
        description = "Build a console-based task manager",
        content = """
            Let's combine what you've learned!

            We will build a simple To-Do List:
            1. A class `Task` with `title` and `completed` status.
            2. A class `TodoList` with an array of tasks.
            3. Methods to add, complete, and display tasks.
        """.trimIndent(),
        codeExample = """
            class Task {
                constructor(title) {
                    this.title = title;
                    this.completed = false;
                }
            }

            class TodoList {
                constructor() {
                    this.tasks = [];
                }

                addTask(title) {
                    this.tasks.push(new Task(title));
                    console.log("Added: " + title);
                }

                showTasks() {
                    this.tasks.forEach(t => {
                        const status = t.completed ? "[x]" : "[ ]";
                        console.log(status + " " + t.title);
                    });
                }
            }

            const myList = new TodoList();
            myList.addTask("Learn JavaScript");
            myList.addTask("Build an app");
            myList.showTasks();
        """.trimIndent(),
        exercise = "Add a method to the `TodoList` class called `completeTask(title)` that finds a task by its title and sets `completed` to true.",
        difficulty = "Advanced",
        estimatedTime = 45,
        order = 15
    )
)
