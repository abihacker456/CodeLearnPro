package com.abinet.codelearnpro

val cppLessons = listOf(
    // --- ORIGINAL 5 LESSONS ---
    Lesson(
        id = "cpp_01",
        languageId = 2,
        title = "Introduction to C++",
        description = "Write and run your first C++ program",
        content = """
            C++ is a compiled, high-performance language created by Bjarne Stroustrup. It is used for games, operating systems, embedded devices, and competitive programming.

            Every C++ program starts running from the main function. Before that, you include the libraries you need.

            #include <iostream> brings in input and output tools.
            using namespace std; lets you write cout instead of std::cout.

            The cout object prints text to the screen. The << operator sends data to it, and endl moves to a new line.

            Every statement ends with a semicolon.
        """.trimIndent(),
        codeExample = """
            #include <iostream>
            using namespace std;

            int main() {
                cout << "Hello, C++!" << endl;
                cout << "I am learning C++" << endl;
                return 0;
            }
        """.trimIndent(),
        exercise = "Write a C++ program that prints your name and your university on two separate lines.",
        difficulty = "Beginner",
        estimatedTime = 15,
        order = 1
    ),
    Lesson(
        id = "cpp_02",
        languageId = 2,
        title = "Variables and Data Types",
        description = "Declare variables and choose the right type",
        content = """
            C++ is statically typed — every variable needs a type. The compiler checks types before the program runs.

            Common types:
            - int: whole numbers (5, -12)
            - double: decimal numbers (3.14)
            - char: a single character ('A')
            - bool: true or false
            - string: text, requires #include <string>

            Variables are declared with a type and a name:
                int age = 20;

            You can also declare without initializing:
                int score;
                score = 100;

            Always give variables meaningful names. Use camelCase: studentName, totalScore.
        """.trimIndent(),
        codeExample = """
            #include <iostream>
            #include <string>
            using namespace std;

            int main() {
                string name = "Abinet";
                int age = 20;
                double gpa = 3.75;
                char grade = 'A';
                bool isStudent = true;

                cout << name << endl;
                cout << age << endl;
                cout << gpa << endl;
                return 0;
            }
        """.trimIndent(),
        exercise = "Create variables for a student's name, age, and GPA, and print each one on a separate line.",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 2
    ),
    Lesson(
        id = "cpp_03",
        languageId = 2,
        title = "Conditional Statements",
        description = "Use if, else if, and else in C++",
        content = """
            Conditions control the flow of your program. C++ uses if, else if, and else.

            Comparison operators work the same as in Python: ==, !=, >, <, >=, <=.

            Logical operators:
            - && and
            - || or
            - ! not

            Braces { } mark the block of code that belongs to each condition. Indentation is for humans — braces are for the compiler.

            An if can stand alone. else if and else must follow an if.
        """.trimIndent(),
        codeExample = """
            #include <iostream>
            using namespace std;

            int main() {
                int score = 85;

                if (score >= 90) {
                    cout << "Grade A" << endl;
                } else if (score >= 80) {
                    cout << "Grade B" << endl;
                } else if (score >= 70) {
                    cout << "Grade C" << endl;
                } else {
                    cout << "Keep practicing" << endl;
                }
                return 0;
            }
        """.trimIndent(),
        exercise = "Write a program that checks whether a student passed (score >= 60) or failed, and prints the result.",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 3
    ),
    Lesson(
        id = "cpp_04",
        languageId = 2,
        title = "Functions",
        description = "Break programs into reusable functions",
        content = """
            A function groups code that performs one task. C++ requires you to declare the return type.

            Basic shape:
                int add(int a, int b) {
                    return a + b;
                }

            - int is the return type
            - add is the function name
            - (int a, int b) are the parameters
            - return sends the result back to the caller

            If a function returns nothing, use void as the return type:
                void greet() {
                    cout << "Hello" << endl;
                }

            Functions must be declared before they are used, or you can put a prototype above main.
        """.trimIndent(),
        codeExample = """
            #include <iostream>
            using namespace std;

            int add(int a, int b) {
                return a + b;
            }

            void greet(string name) {
                cout << "Hello, " << name << endl;
            }

            int main() {
                greet("Abinet");
                cout << add(5, 3) << endl;
                return 0;
            }
        """.trimIndent(),
        exercise = "Write a function called average that takes three integers and returns their average as a double.",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 4
    ),
    Lesson(
        id = "cpp_05",
        languageId = 2,
        title = "Arrays",
        description = "Store many values of the same type together",
        content = """
            An array holds a fixed number of values of the same type.

            Declare an array:
                int numbers[5] = {10, 20, 30, 40, 50};

            Access elements using an index, starting at 0:
                numbers[0] is 10
                numbers[4] is 50

            Loop through an array:
                for (int i = 0; i < 5; i++) {
                    cout << numbers[i] << endl;
                }

            Be careful: C++ does not stop you from reading past the end of an array. Always keep the index inside the valid range 0 to size-1.
        """.trimIndent(),
        codeExample = """
            #include <iostream>
            using namespace std;

            int main() {
                int numbers[5] = {10, 20, 30, 40, 50};
                int total = 0;

                for (int i = 0; i < 5; i++) {
                    total = total + numbers[i];
                }

                cout << "Total: " << total << endl;
                return 0;
            }
        """.trimIndent(),
        exercise = "Create an array of 5 numbers and print the largest one.",
        difficulty = "Intermediate",
        estimatedTime = 30,
        order = 5
    ),

    // --- NEW 10 LESSONS ---
    Lesson(
        id = "cpp_06",
        languageId = 2,
        title = "Vectors",
        description = "Dynamic arrays that can grow in size",
        content = """
            Standard arrays in C++ have a fixed size. If you need an array that can grow or shrink, use a vector.
            To use vectors, you must include the <vector> library.

            Create a vector:
                vector<int> numbers = {10, 20, 30};

            Add elements:
                numbers.push_back(40);

            Get the size:
                numbers.size();

            Vectors are much safer and more flexible than raw arrays.
        """.trimIndent(),
        codeExample = """
            #include <iostream>
            #include <vector>
            using namespace std;

            int main() {
                vector<string> fruits = {"Apple", "Banana"};

                fruits.push_back("Cherry");

                for (int i = 0; i < fruits.size(); i++) {
                    cout << fruits[i] << endl;
                }
                return 0;
            }
        """.trimIndent(),
        exercise = "Create a vector of integers, add 3 numbers to it using push_back, and print the size of the vector.",
        difficulty = "Intermediate",
        estimatedTime = 20,
        order = 6
    ),
    Lesson(
        id = "cpp_07",
        languageId = 2,
        title = "Pointers",
        description = "Variables that store memory addresses",
        content = """
            A pointer is a variable that stores the memory address of another variable.

            Declare a pointer using the * symbol:
                int age = 20;
                int* ptr = &age;
                // & gets the address of age

            To get the value the pointer is pointing to, use * (dereference):
                cout << *ptr; // prints 20

            Pointers are powerful but dangerous. If you point to invalid memory, the program will crash.
        """.trimIndent(),
        codeExample = """
            #include <iostream>
            using namespace std;

            int main() {
                int score = 100;
                int* p = &score;

                cout << "Value: " << score << endl;
                cout << "Address: " << p << endl;
                cout << "Value via pointer: " << *p << endl;

                return 0;
            }
        """.trimIndent(),
        exercise = "Create a double variable named price with a value of 99.99. Create a pointer to it, and use the pointer to print the value.",
        difficulty = "Advanced",
        estimatedTime = 35,
        order = 7
    ),
    Lesson(
        id = "cpp_08",
        languageId = 2,
        title = "References",
        description = "An alias for an existing variable",
        content = """
            A reference is another name for an existing variable. It is created using the & symbol.

            int a = 10;
            int& ref = a; // ref is now another name for a

            If you change ref, you change a.
                ref = 20;
                cout << a; // prints 20

            References are often used in function parameters to avoid copying large amounts of data.
                void updateValue(int& x) {
                    x = 100;
                }
        """.trimIndent(),
        codeExample = """
            #include <iostream>
            using namespace std;

            void doubleValue(int& num) {
                num = num * 2;
            }

            int main() {
                int myNum = 5;
                doubleValue(myNum);
                cout << myNum << endl; // prints 10
                return 0;
            }
        """.trimIndent(),
        exercise = "Write a function called `triple` that takes an integer reference and multiplies the original variable by 3.",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 8
    ),
    Lesson(
        id = "cpp_09",
        languageId = 2,
        title = "Classes and Objects",
        description = "Introduction to Object-Oriented Programming in C++",
        content = """
            C++ is an object-oriented language. A class is a blueprint for creating objects.

            class Car {
            public:
                string brand;
                int year;

                void honk() {
                    cout << "Beep!" << endl;
                }
            };

            The `public:` keyword means these members can be accessed from outside the class.

            Create an object:
                Car myCar;
                myCar.brand = "Toyota";
                myCar.honk();
        """.trimIndent(),
        codeExample = """
            #include <iostream>
            using namespace std;

            class Dog {
            public:
                string name;

                void bark() {
                    cout << name << " says Woof!" << endl;
                }
            };

            int main() {
                Dog d1;
                d1.name = "Buddy";
                d1.bark();
                return 0;
            }
        """.trimIndent(),
        exercise = "Create a class called `Book` with a string `title` and an integer `pages`. Create one object, set the values, and print them.",
        difficulty = "Intermediate",
        estimatedTime = 30,
        order = 9
    ),
    Lesson(
        id = "cpp_10",
        languageId = 2,
        title = "Constructors",
        description = "Special methods that run when an object is created",
        content = """
            A constructor is a special method that is automatically called when you create a new object.

            It has the same name as the class and no return type.

            class Student {
            public:
                string name;

                // Constructor
                Student(string n) {
                    name = n;
                }
            };

            Now, you must provide the name when creating the object:
                Student s1("Abinet");
        """.trimIndent(),
        codeExample = """
            #include <iostream>
            using namespace std;

            class Player {
            public:
                string username;
                int level;

                Player(string u, int l) {
                    username = u;
                    level = l;
                }
            };

            int main() {
                Player p1("AbiPro", 10);
                cout << p1.username << " is level " << p1.level << endl;
                return 0;
            }
        """.trimIndent(),
        exercise = "Add a constructor to a class named `Rectangle` that takes width and height as integers and assigns them to the object's variables.",
        difficulty = "Intermediate",
        estimatedTime = 30,
        order = 10
    ),
    Lesson(
        id = "cpp_11",
        languageId = 2,
        title = "Inheritance",
        description = "Create classes based on other classes",
        content = """
            Inheritance allows a new class (child) to inherit properties and methods from an existing class (parent).

            class Animal {
            public:
                void eat() { cout << "Eating..." << endl; }
            };

            class Dog : public Animal {
            public:
                void bark() { cout << "Woof!" << endl; }
            };

            The Dog class now has both `eat()` and `bark()`.
        """.trimIndent(),
        codeExample = """
            #include <iostream>
            using namespace std;

            class Vehicle {
            public:
                void start() {
                    cout << "Engine started." << endl;
                }
            };

            class Car : public Vehicle {
            public:
                void drive() {
                    cout << "Car is driving." << endl;
                }
            };

            int main() {
                Car myCar;
                myCar.start();
                myCar.drive();
                return 0;
            }
        """.trimIndent(),
        exercise = "Create a base class `Shape` with a method `describe()` that prints 'I am a shape'. Create a child class `Circle` that inherits from Shape and adds a method `area()`.",
        difficulty = "Advanced",
        estimatedTime = 35,
        order = 11
    ),
    Lesson(
        id = "cpp_12",
        languageId = 2,
        title = "Structs",
        description = "A simpler way to group related data",
        content = """
            A struct is similar to a class, but its members are public by default.

            They are often used for simple data structures that don't need complex methods.

            struct Point {
                int x;
                int y;
            };

            Usage:
                Point p1;
                p1.x = 10;
                p1.y = 20;
        """.trimIndent(),
        codeExample = """
            #include <iostream>
            using namespace std;

            struct Student {
                string name;
                int age;
                double gpa;
            };

            int main() {
                Student s1 = {"Abinet", 20, 3.75};
                cout << s1.name << " has a GPA of " << s1.gpa << endl;
                return 0;
            }
        """.trimIndent(),
        exercise = "Create a struct named `Book` with a string `title` and a double `price`. Create an instance of it, set the values, and print them.",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 12
    ),
    Lesson(
        id = "cpp_13",
        languageId = 2,
        title = "String Manipulation",
        description = "Working with text in C++",
        content = """
            In C++, `string` is a class that provides many useful methods.

            #include <string>

            string text = "Hello";

            - text.length() -> returns 5
            - text.append(" World") -> "Hello World"
            - text[0] -> 'H'
            - text.substr(0, 5) -> "Hello"

            Strings are incredibly useful for processing user input and displaying dynamic text.
        """.trimIndent(),
        codeExample = """
            #include <iostream>
            #include <string>
            using namespace std;

            int main() {
                string name = "CodeLearn";

                cout << name.length() << endl;
                cout << name[0] << endl;

                name += " Pro";
                cout << name << endl;

                return 0;
            }
        """.trimIndent(),
        exercise = "Create a string with the value 'Programming'. Print the length of the string, and then print the first and last characters.",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 13
    ),
    Lesson(
        id = "cpp_14",
        languageId = 2,
        title = "Exception Handling",
        description = "Catch errors before they crash your program",
        content = """
            Exception handling lets you deal with runtime errors gracefully.

            Use `try` to wrap code that might fail, and `catch` to handle the error.

            try {
                int age = -5;
                if (age < 0) {
                    throw runtime_error("Age cannot be negative");
                }
            } catch (const exception& e) {
                cout << "Error: " << e.what() << endl;
            }

            `throw` is used to trigger an error.
        """.trimIndent(),
        codeExample = """
            #include <iostream>
            #include <stdexcept>
            using namespace std;

            int main() {
                try {
                    int divisor = 0;
                    if (divisor == 0) {
                        throw runtime_error("Cannot divide by zero!");
                    }
                    cout << 10 / divisor << endl;
                } catch (const exception& e) {
                    cout << "Caught an error: " << e.what() << endl;
                }
                return 0;
            }
        """.trimIndent(),
        exercise = "Write a try/catch block. Inside the try block, use `throw` to throw a `runtime_error` with the message 'Something went wrong'. Catch it and print the message.",
        difficulty = "Advanced",
        estimatedTime = 30,
        order = 14
    ),
    Lesson(
        id = "cpp_15",
        languageId = 2,
        title = "Final Project: Bank Account",
        description = "Combine classes and functions into a full program",
        content = """
            Let's build a simple Bank Account program.

            We need:
            1. A class called BankAccount.
            2. It should have a balance and a constructor.
            3. A method `deposit()` to add money.
            4. A method `withdraw()` to take money out (if balance is enough).
            5. A method `getBalance()`.

            This tests your knowledge of classes, variables, and conditionals.
        """.trimIndent(),
        codeExample = """
            #include <iostream>
            using namespace std;

            class BankAccount {
            private:
                double balance;

            public:
                BankAccount(double initial) {
                    balance = initial;
                }

                void deposit(double amount) {
                    balance += amount;
                }

                void withdraw(double amount) {
                    if (amount <= balance) {
                        balance -= amount;
                    } else {
                        cout << "Insufficient funds!" << endl;
                    }
                }

                double getBalance() { return balance; }
            };

            int main() {
                BankAccount myAccount(100.0);
                myAccount.deposit(50.0);
                myAccount.withdraw(20.0);
                cout << "Balance: " << myAccount.getBalance() << endl;
                return 0;
            }
        """.trimIndent(),
        exercise = "In the BankAccount class above, add a check inside `deposit()` to make sure the amount is greater than 0. If it is, print 'Invalid deposit amount'.",
        difficulty = "Advanced",
        estimatedTime = 45,
        order = 15
    )
)
