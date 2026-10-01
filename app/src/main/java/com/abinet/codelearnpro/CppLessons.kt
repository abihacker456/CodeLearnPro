package com.abinet.codelearnpro

val cppLessons = listOf(
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
    )
)