package com.abinet.codelearnpro

val javaLessons = listOf(
    // --- ORIGINAL 5 LESSONS ---
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
    ),

    // --- NEW 10 LESSONS ---
    Lesson(
        id = "java_06",
        languageId = 4,
        title = "Constructors",
        description = "Initialize objects when they are created",
        content = """
            A constructor is a special method that runs when an object is created using `new`. It has the same name as the class and no return type.

            class Car {
                String model;

                // Constructor
                public Car(String m) {
                    model = m;
                }
            }

            Usage:
                Car myCar = new Car("Toyota");
        """.trimIndent(),
        codeExample = """
            class Person {
                String name;
                int age;

                public Person(String n, int a) {
                    name = n;
                    age = a;
                }
            }

            public class Main {
                public static void main(String[] args) {
                    Person p1 = new Person("Abinet", 20);
                    System.out.println(p1.name + " is " + p1.age);
                }
            }
        """.trimIndent(),
        exercise = "Create a class `Phone` with a `brand` and `price`. Add a constructor to initialize both values. Create an object and print its details.",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 6
    ),
    Lesson(
        id = "java_07",
        languageId = 4,
        title = "Inheritance",
        description = "Create classes based on other classes",
        content = """
            Inheritance allows a class (subclass) to acquire the properties and methods of another class (superclass).

            Use the `extends` keyword:
                class Animal {
                    void eat() { System.out.println("Eating..."); }
                }

                class Dog extends Animal {
                    void bark() { System.out.println("Woof!"); }
                }

            The `Dog` class now has both `eat()` and `bark()`.
        """.trimIndent(),
        codeExample = """
            class Vehicle {
                void start() {
                    System.out.println("Engine started");
                }
            }

            class Car extends Vehicle {
                void drive() {
                    System.out.println("Driving...");
                }
            }

            public class Main {
                public static void main(String[] args) {
                    Car myCar = new Car();
                    myCar.start();
                    myCar.drive();
                }
            }
        """.trimIndent(),
        exercise = "Create a superclass `Shape` with a method `draw()`. Create a subclass `Circle` that extends Shape and adds a method `radius()`.",
        difficulty = "Intermediate",
        estimatedTime = 30,
        order = 7
    ),
    Lesson(
        id = "java_08",
        languageId = 4,
        title = "Interfaces",
        description = "Define a contract for your classes",
        content = """
            An interface is a completely abstract class used to group related methods with empty bodies.

            interface Animal {
                void makeSound();
            }

            A class implements an interface using the `implements` keyword and must provide the method body:
                class Dog implements Animal {
                    public void makeSound() {
                        System.out.println("Woof");
                    }
                }
        """.trimIndent(),
        codeExample = """
            interface Playable {
                void play();
            }

            class Guitar implements Playable {
                public void play() {
                    System.out.println("Strumming strings");
                }
            }

            public class Main {
                public static void main(String[] args) {
                    Guitar g = new Guitar();
                    g.play();
                }
            }
        """.trimIndent(),
        exercise = "Create an interface `Shape` with a method `area()`. Create a class `Square` that implements it and prints the area (assume side length 5).",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 8
    ),
    Lesson(
        id = "java_09",
        languageId = 4,
        title = "Exception Handling",
        description = "Catch errors before they crash your app",
        content = """
            Exceptions are runtime errors. If not handled, they crash the program.

            Use `try` to wrap risky code and `catch` to handle the error:
                try {
                    int result = 10 / 0;
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }

            `finally` runs regardless of whether an exception occurred.
        """.trimIndent(),
        codeExample = """
            public class Main {
                public static void main(String[] args) {
                    try {
                        String text = "abc";
                        int num = Integer.parseInt(text);
                        System.out.println(num);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format!");
                    }
                }
            }
        """.trimIndent(),
        exercise = "Write a try/catch block that accesses an array out of bounds (e.g., `int[] arr = new int[2]; arr[5] = 10;`) and catches the `ArrayIndexOutOfBoundsException`.",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 9
    ),
    Lesson(
        id = "java_10",
        languageId = 4,
        title = "ArrayList",
        description = "Dynamic arrays that can grow",
        content = """
            Standard arrays in Java have a fixed size. `ArrayList` is a resizable array found in `java.util`.

            Import it first:
                import java.util.ArrayList;

            Create one:
                ArrayList<String> names = new ArrayList<>();

            Add elements:
                names.add("Abinet");

            Get size:
                names.size();

            Access by index:
                names.get(0);
        """.trimIndent(),
        codeExample = """
            import java.util.ArrayList;

            public class Main {
                public static void main(String[] args) {
                    ArrayList<String> fruits = new ArrayList<>();
                    fruits.add("Apple");
                    fruits.add("Banana");
                    fruits.add("Cherry");

                    System.out.println(fruits);
                    System.out.println(fruits.get(1));
                }
            }
        """.trimIndent(),
        exercise = "Create an ArrayList of integers. Add 3 numbers to it, then use a loop to print each number.",
        difficulty = "Beginner",
        estimatedTime = 25,
        order = 10
    ),
    Lesson(
        id = "java_11",
        languageId = 4,
        title = "HashMap",
        description = "Store key-value pairs",
        content = """
            A `HashMap` stores items in key/value pairs. You can access them by an index of another type (e.g., a String).

            Import:
                import java.util.HashMap;

            Create:
                HashMap<String, Integer> ages = new HashMap<>();

            Add items:
                ages.put("Abinet", 20);
                ages.put("Sara", 22);

            Access:
                ages.get("Abinet");

            Remove:
                ages.remove("Sara");
        """.trimIndent(),
        codeExample = """
            import java.util.HashMap;

            public class Main {
                public static void main(String[] args) {
                    HashMap<String, String> capitals = new HashMap<>();
                    capitals.put("Ethiopia", "Addis Ababa");
                    capitals.put("Kenya", "Nairobi");

                    System.out.println(capitals.get("Ethiopia"));
                }
            }
        """.trimIndent(),
        exercise = "Create a HashMap to store student names and their grades (String keys, Double values). Add two students, then print one of the grades.",
        difficulty = "Intermediate",
        estimatedTime = 30,
        order = 11
    ),
    Lesson(
        id = "java_12",
        languageId = 4,
        title = "String Methods",
        description = "Manipulate text in Java",
        content = """
            The `String` class has many built-in methods.

            String text = "Hello";

            - length(): returns 5
            - toUpperCase(): "HELLO"
            - toLowerCase(): "hello"
            - charAt(0): 'H'
            - equals("Hello"): true
            - substring(1, 3): "el"
            - contains("ell"): true

            Remember, Strings in Java are immutable. Methods always return a new String.
        """.trimIndent(),
        codeExample = """
            public class Main {
                public static void main(String[] args) {
                    String name = "CodeLearn";

                    System.out.println(name.length());
                    System.out.println(name.toUpperCase());
                    System.out.println(name.substring(4));
                    System.out.println(name.charAt(0));
                }
            }
        """.trimIndent(),
        exercise = "Create a String variable with your full name. Print it in all uppercase, and print the first and last character.",
        difficulty = "Beginner",
        estimatedTime = 20,
        order = 12
    ),
    Lesson(
        id = "java_13",
        languageId = 4,
        title = "Encapsulation",
        description = "Protect your data using private and getters/setters",
        content = """
            Encapsulation restricts direct access to important data. You make fields `private` and provide `public` getter and setter methods.

            class Student {
                private String name;

                // Getter
                public String getName() {
                    return name;
                }

                // Setter
                public void setName(String newName) {
                    name = newName;
                }
            }

            This lets you control how data is accessed and modified (e.g., adding validation rules in the setter).
        """.trimIndent(),
        codeExample = """
            class BankAccount {
                private double balance = 100.0;

                public double getBalance() {
                    return balance;
                }

                public void deposit(double amount) {
                    if (amount > 0) {
                        balance += amount;
                    }
                }
            }

            public class Main {
                public static void main(String[] args) {
                    BankAccount acc = new BankAccount();
                    acc.deposit(50);
                    System.out.println(acc.getBalance());
                }
            }
        """.trimIndent(),
        exercise = "Create a class `Person` with a private integer `age`. Add a getter and a setter. In the setter, only set the age if it is greater than 0.",
        difficulty = "Advanced",
        estimatedTime = 35,
        order = 13
    ),
    Lesson(
        id = "java_14",
        languageId = 4,
        title = "The static Keyword",
        description = "Methods and variables that belong to the class, not the object",
        content = """
            The `static` keyword means a member belongs to the class itself, rather than to instances (objects).

            - Static variables share the same value across all objects.
            - Static methods can be called without creating an object.

            class MathUtils {
                static int square(int n) {
                    return n * n;
                }
            }

            Usage:
                int result = MathUtils.square(5); // No 'new' needed
        """.trimIndent(),
        codeExample = """
            class Counter {
                static int count = 0;

                public Counter() {
                    count++;
                }
            }

            public class Main {
                public static void main(String[] args) {
                    Counter c1 = new Counter();
                    Counter c2 = new Counter();

                    System.out.println(Counter.count); // Prints 2
                }
            }
        """.trimIndent(),
        exercise = "Create a static method called `cube` in a class named `Calculator` that takes an integer and returns its cube. Call it from main and print the result.",
        difficulty = "Intermediate",
        estimatedTime = 25,
        order = 14
    ),
    Lesson(
        id = "java_15",
        languageId = 4,
        title = "Final Project: Student Manager",
        description = "Combine arrays, classes, and loops",
        content = """
            Let's build a simple Student Management program.

            Requirements:
            1. A `Student` class with name and grade.
            2. An `ArrayList` to store multiple students.
            3. A loop to print all student records.

            This is a typical task in enterprise applications.
        """.trimIndent(),
        codeExample = """
            import java.util.ArrayList;

            class Student {
                String name;
                int grade;

                Student(String n, int g) {
                    name = n;
                    grade = g;
                }
            }

            public class Main {
                public static void main(String[] args) {
                    ArrayList<Student> students = new ArrayList<>();
                    students.add(new Student("Abinet", 90));
                    students.add(new Student("Sara", 85));

                    for (Student s : students) {
                        System.out.println(s.name + ": " + s.grade);
                    }
                }
            }
        """.trimIndent(),
        exercise = "Extend the program by adding a method to the `Student` class called `isPassing()` that returns true if the grade is 50 or above.",
        difficulty = "Advanced",
        estimatedTime = 45,
        order = 15
    )
)
