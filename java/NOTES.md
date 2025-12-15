# Java Notes
## Advantages of Object Oriented Programming
1. Modularity: code is organized into classes and objects, making it easy to manage.
2. Reusability: Classes and methods can be reused in different programs.
3. Encapsulation: access to data is restricted, improving security.
4. Inheritance: reduces code duplication.

## Core Concepts
**Java always uses pass by value, never pass by reference**

**Encapsulation:** Process of hiding internal state of an object and only exposing a controlled interface.

**Inheritance:** Allows a class to acquire fields and methods from another class. Describes an "is-a" relationship. For example if Bird extends Animal, Bird IS an animal.

**Polymorphism:** The ability of an object to take on many forms. Occurs in Java when we have many objects related by inheritance.

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

**Process vs Thread:** A process is a program in execution. A thread is a subset of a process.

## Generics
**Type Parameterization:** Generics allow a placeholder for a type when defining a class or method.
```java
class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

public class Main {
    public static void main(String args[]) {
        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello");
        System.out.println(stringBox.getItem());
    }
}
```
Can use a **wildcard (?)** when you don't know the exact type.
```java
public void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}

public void printNumbers(List<? extends Number> list) {
    for (Number num : list) {
        System.out.println(num);
    }
}
```

## Interfaces
Defines a blueprint for a class. Only contains method signatures and constants.
```java
interface Animal {
    void eat(); // abstract method
}

class Dog implements Animal {
    public void eat() {
        System.out.println("Dog is eating");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.eat();
    }
}
```

## Abstract Classes
Can have both abstract methods and concrete methods.
```java
abstract class Animal {
    abstract void eat(); // Abstract method
}

class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("Dog is eating");
    }
}

public class AbstractClassExample {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.eat();
    }
}
```

## Streams
Used to process a collection of objects. Methods can be chained together.
Input -> [intermediate operations 1, 2, ... n] -> Terminal Operation -> Output

### Intermediate Operations
- **map()** returns the results of applying the given function to the stream
- **filter()** returns the results of applying the given condition to the stream
- **sorted()** sorts the stream
- **flatMap()** flatten the stream into a single stream of elements
- **distinct()** removes duplicate elements
- **peek()** performs an action on each element without modifying the stream

### Terminal Operations
- **collect()** returns the results of intermediate operations performed on a stream
- **forEach()** iterate through every element of the stream
- **reduce()** reduce the stream to a single value
- **count()** returns the count of the element stream
- **findFirst()** returns first element of the stream
- **allMatch()** checks if all elements match the given predicate
- **anyMatch()** checks if any elements match the given predicate

### Example
```java
List<List<String>> listOfLists = Arrays.asList(
            Arrays.asList("Reflection", "Collection", "Stream"),
            Arrays.asList("Structure", "State", "Flow"),
            Arrays.asList("Sorting", "Mapping", "Reduction", "Stream")
        );

// Create a set to hold intermediate results
Set<String> intermediateResults = new HashSet<>();

// Stream pipeline demonstrating various intermediate operations
List<String> result = listOfLists.stream()
    .flatMap(List::stream)              
    .filter(s -> s.startsWith("S"))      
    .map(String::toUpperCase)          
    .distinct()                          
    .sorted()                            
    .peek(s -> intermediateResults.add(s))
    .collect(Collectors.toList());
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

### Making Custom Exceptions
```java
class NullParameterException extends Exception {
    public NullParameterException(String message) {
        super(message);
    }
}

class FooClass {
    public void fooMethod(String param) throws NullParameterException {
        if (param == null) {
            throw new NullParameterException("Param must not be null");
        }
        System.out.println("Param is valid");
    }
}
```

### Sorting a Stream
```java
List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
List<String> sortedList = myList.stream()
    .sorted()
    .collect(Collectors.toList());
```

### String to Integer
```java
String str = "123";
int num = Integer.parseInt(str);
```

### Find Index of String in a String
```java
public int strStr(String haystack, String needle) {
    return haystack.indexOf(needle);
}
```