package com.abinet.codelearnpro

val javaLessons = listOf(
    Lesson(
        id = "java_01",
        languageId = 4,
        title = "Introduction to Java",
        description = "Structure of a Java program",
        content = """
            Java is a compiled, object-oriented language created by Sun Microsystems in 1995. It runs on the Java Virtual Machine (JVM), which makes Java programs portable across platforms.

            Every Java application starts in a class containing a main method:
                public class Main {
                    public static void main(String[] args) {
                        System.out.println("Hello");
                    }
                }

            Breaking that down:
            - public class Main — the class definition
            - public static void main(String[] args) — the entry point
            - System.out.println() — prints a line to the console

            Java is case-sensitive. Main and main are different. The file name must match the public class name: Main.java.
        """.trimIndent(),
        codeExample = """
            public class Main {
                public static void main(String[] args) {
                    System.out.println("Hello, Java!");
                    System.out.println("I am learning Java");
                }
            }
        """.trimIndent(),
        exercise = "Write a Java program that prints 'Hello, Java!' and your name on two lines.",
        difficulty = "Beginner",
        estimatedTime = 15,
        order = 1
    ),
    Lesson(
        id = "java_02",
        languageId = 4,
        title = "Variables and Data Types",
        description = "Java's typed variable system",
        content = """
            Java is statically typed — every variable needs a declared type.

            Primitive types:
            - int: whole numbers
            - double: decimals
            - char: single characters like 'A'
            - boolean: true / false

            Reference type:
            - String: text in double quotes

            Declaring:
                int age = 20;
                double price = 99.99;
                char grade = 'A';
                String name = "Abinet";
                boolean isStudent = true;

            Important rules:
            - Statements end with a semicolon
            - String uses double quotes, char uses single quotes
            - Names are case-sensitive
        """.trimIndent(),
        codeExample = """
            public class Main {
                public static void main(String[] args) {
                    int age = 20;
                    double gpa = 3.75;
                    char grade = 'A';
                    String name = "Abinet";
                    boolean isStudent = true;

                    System.out.println(name);
                    System.out.println(age);
                    System.out.println(gpa);
                    System.out.println(grade);
                    System.out.println(isStudent);
                }
            }
        """.trimIndent(),
        exercise = "Declare variables for a student's name, age, and GPA, and print them all using System.out.println.",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 2
    ),
    Lesson(
        id = "java_03",
        languageId = 4,
        title = "Conditional Statements",
        description = "Control flow with if, else if, and else",
        content = """
            Java supports the standard if / else if / else structure.

            if (condition) {
                // runs when true
            } else if (otherCondition) {
                // runs when the first is false and this is true
            } else {
                // runs when nothing else matched
            }

            Comparison operators: ==, !=, >, <, >=, <=.
            Logical operators: && (and), || (or), ! (not).

            The condition inside if(...) must be a boolean — Java does not treat numbers as truthy like C does.

            Use braces for the body, even when it is a single line. It prevents bugs later.
        """.trimIndent(),
        codeExample = """
            public class Main {
                public static void main(String[] args) {
                    int age = 20;
                    int votingAge = 18;

                    if (age >= votingAge) {
                        System.out.println("You can vote");
                    } else {
                        System.out.println("You cannot vote yet");
                    }
                }
            }
        """.trimIndent(),
        exercise = "Write a program that checks whether a number is positive, negative, or zero and prints the result.",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 3
    ),
    Lesson(
        id = "java_04",
        languageId = 4,
        title = "Methods",
        description = "Group code into reusable methods",
        content = """
            A method in Java is a block of code with a name, parameters, and a return type.

            Shape:
                public static int add(int a, int b) {
                    return a + b;
                }

            - public static are modifiers
            - int is the return type (use void if the method returns nothing)
            - add is the name
            - (int a, int b) are the parameters

            Calling a method from main:
                int result = add(3, 4);

            Methods must be declared inside a class. static means the method belongs to the class itself, not to an instance — that lets main call it directly.
        """.trimIndent(),
        codeExample = """
            public class Main {
                public static int add(int a, int b) {
                    return a + b;
                }

                public static boolean isEven(int n) {
                    return n % 2 == 0;
                }

                public static void main(String[] args) {
                    System.out.println(add(5, 3));
                    System.out.println(isEven(4));
                }
            }
        """.trimIndent(),
        exercise = "Write a method called max that takes two integers and returns the larger one. Print the result of calling it with 12 and 7.",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 4
    ),
    Lesson(
        id = "java_05",
        languageId = 4,
        title = "Classes and Objects",
        description = "Introduction to object-oriented programming in Java",
        content = """
            Java is object-oriented — programs are built from classes that describe objects.

            A class defines fields (data) and methods (behavior):
                class Student {
                    String name;
                    int age;

                    void introduce() {
                        System.out.println("I am " + name);
                    }
                }

            To use a class, create an object with new:
                Student s = new Student();
                s.name = "Abinet";
                s.age = 20;
                s.introduce();

            The constructor runs when you create an object. If you do not write one, Java provides an empty default.

                class Student {
                    String name;
                    Student(String n) {
                        name = n;
                    }
                }

            Use classes to model things in your program: users, orders, lessons, and so on.
        """.trimIndent(),
        codeExample = """
            class Student {
                String name;
                int age;

                void introduce() {
                    System.out.println("I am " + name + ", age " + age);
                }
            }

            public class Main {
                public static void main(String[] args) {
                    Student s = new Student();
                    s.name = "Abinet";
                    s.age = 20;
                    s.introduce();
                }
            }
        """.trimIndent(),
        exercise = "Create a class called Book with a title and an author. Add a method describe that prints both. Create one Book object in main and call describe.",
        difficulty = "Intermediate",
        estimatedTime = 30,
        order = 5
    )
)