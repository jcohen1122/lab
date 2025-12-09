# Java Notes
## Core Concepts
**Encapsulation:** Process of hiding internal state of an object and only exposing a controlled interface.

**Inheritance:** Allows a class to acquire fields and methods from another class. Describes an "is-a" relationship. For example if Bird extends Animal, Bird IS an animal.

**Polymorphism:** The ability of an object to take on many forms. Achieved in Java through **method overriding** and **method overloading**.

**Method Overriding:** When a subclass provides a specific implementation of a method already defined in its superclass.
```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

**Method Overloading:** Occurs when multiple methods in the same class have the same name but different parameters.

**JVM, JRE, JDK:** 
- Java Virtual Machine is a part of JRE and makes sure programs are executes in a platform-independent manner.
- Java Runtime Environment provides the libraries and JVM required to run Java apps.
- Java Development Kit provides JRE and tools for developing and running Java.

**Memory Management:** Objects are stored in the heap and are considered unreachable if there are no references pointing to it. The Garbage Collector finds these unreachable objects and reclaims their memory.

**Final Keyword:** The value of a final variable can't be changed once initialized. A final method cannot be overridden by subclasses. A final class cannot be extended.

**Static Keyword:** A static variable is shared across all instances of the class. A static method can be called without creating an object of the class. 

**Checked Exception:** Checked at compile-time.

**Unchecked Exception:** Occur at runtime.

**equals() vs ==:** equals() compares content, can be overridden. == compares values directly for primitives or memory references for objects.

**Implicit Casting:** happens automatically when needed for smaller to larger data
```java
int num = 10;
double doub = num;
```

**Explicit Casting:** must be done when converting larger data to smaller data
```java
double doub = 10.5;
int num = (int) doub;
```

## Data Structures and Collections
**Collections Framework:** provides classes & interfaces to store and manipulate objects. Part of ```java.util```
- Root Interfaces: ```Collection```, ```Map```
- Collection Subinterfaces: ```List```, ```Set```, ```Queue```

**List Interface:** ordered collection w/ dupes. ```ArrayList```, ```LinkedList```, ```Vector```

**Set Interface:** unordered collection w/ no dupes. ```HashSet```, ```LinkedHashSet```, ```TreeSet```

**Map Interface:** key-val pairs. ```HashMap```, ```LinkedHashMap```, ```TreeMap```, ```Hashtable```

## Multithreading and Concurrency
**Thread Creation:** A thread is a single path of execution within a program. Using multiple threads is known as multithreading, allowing multiple tasks to be performed simultaneously.
```java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); // Starts the thread
    }
}
```
or can use lambda expressions
```java
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Thread is running..."));
        thread.start(); // Starts the thread
    }
}
```

## Coding Snippets
### Compiling & Running Java
```bash
javac ProjectFolder/Project.java
java Project.ClassName
```

### Taking User Input
```java
import java.util.Scanner;
public class PhoneNumber {
    public String phoneNumber() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter phone number:" );
        String phoneNum = in.nextLine();
    }
}
```

###  String vs StringBuilder vs StringBuffer

String
```java
String s = "Hello";
s = s + " World"; // Creates new String object
```
StringBuilder (not thread safe)
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World"); // Modifies existing object
```
StringBuffer (thread safe)
```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World"); // Modifies existing object
```