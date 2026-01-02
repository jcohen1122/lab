# Design Patterns in Java

## Table of Contents
1. [SOLID Design Principles](#solid-design-principles)
    - [Overview](#overview)
    - [Single Responsibility Principle](#single-responsibility-principle-srp)
    - [Open Closed Principle](#open-closed-principle-ocp)
    - [Liskov Substitution Principle](#liskov-substitution-principle-lsp)
    - [Interface Segregation Principle](#interface-segregation-principle-isp)
    - [Dependency Inversion Principle](#dependency-inversion-principle-dip)
2. [Creational Design Patterns](#creational-design-patterns)
    - [Builder](#builder)
    - [Factories](#factories)
    - [Prototype](#prototype)
    - [Singleton](#singleton)
3. [Structural Design Patterns](#structural-design-patterns)
    - [Adapter](#adapter)
    - [Bridge](#bridge)
    - [Composite](#composite)
    - [Decorator](#decorator)
    - [Facade](#facade)
    - [Flyweight](#flyweight)
    - [Proxy](#proxy)
4. [Behavioral Design Patterns](#behavioral-design-patterns)
    - [Chain of Responsibility](#chain-of-responsibility)
    - [Command](#command)
    - [Interpreter](#interpreter)
    - [Iterator](#iterator)
    - [Mediator](#mediator)
    - [Memento](#memento)
    - [Null Object](#null-object)
    - [Observer](#observer)
    - [State](#state)
    - [Strategy](#strategy)
    - [Template Method](#template-method)
    - [Visitor](#visitor)

## SOLID Design Principles
### Overview
1. A class should have one primary responsiblity.
2. A class should be open for extension, but closed for modification.
3. Any object of a base class should be replaceable by an object of its subclass without causing errors.
4. Large, bloated interfaces should be split into smaller, more specific ones (role interfaces).
5. High-level modules should depend on abstractions (abstract class / interface).

### Single Responsibility Principle (SRP)
A class should have just one primary responsibility instead of many. 

Adding more responsibilities ends up with something unmanagable and hard to modify later on.

**Example:** ```DesignExamples/SRP.java```

### Open-Closed Principle (OCP)
A class should be open for extension, but closed for modification.

Modification of code that has already been written and tested is not good. Interfaces make this easier to follow.

**Example:** ```DesignExamples/OCP.java```

### Liskov Substitution Principle (LSP)
Any object of a base class should be replaceable by an object of its subclass without causing errors.

**Example:** ```DesignExamples/LSP.java```

### Interface Segregation Principle (ISP)
Large, bloated interfaces should be split into smaller, more specific ones (role interfaces).

YAGNI = You Ain't Going to Need It -> Don't implement features that won't be used

**Example:** ```DesignExamples/ISP.java```

### Dependency Inversion Principle (DIP)
A. High-level modules should not depend on low-level modules. Both should depend on abstractions.

B. Abstractions should not depend on details.
Details should depend on abstractions.

This makes systems that are easier to test and extend.

**Example:** ```DesignExamples/DIP.java```

## Creational Design Patterns
**Deals with the creation (construction) of objects**

Explicit (constructor) vs implicit (dependency injection, reflection, etc)

Wholesale (single statement) vs piecewise (step by step)

### Builder
Provides an API to allow objects to be constructed piece by piece. Use when a constructor has more than 4 or 5 parameters.

A great example is ```StringBuilder```, which is built into Java. This is an example of a **fluent builder**, which allows chaining builder commands together.

A **faceted builder** breaks down the building process into multiple specialized sub-builders (facets). This is used for highly complex objects.

```java
/*
    Fluent Builder
*/
public class User {
    private final String name; // Required
    private final int age;    // Optional
    private final String email; // Optional

    private User(Builder b) { 
        this.name = b.name; 
        this.age = b.age; 
        this.email = b.email;
    }

    public static class Builder {
        private String name;
        private int age;
        private String email;

        public Builder(String name) { this.name = name; }

        public Builder setAge(int val) { this.age = val; return this; }

        public Builder setEmail(String email) { this.email = email; return this; }

        public User build() { return new User(this); }
    }
}

// Usage
User user = new User.Builder("Alice")
    .setAge(30)
    .setEmail("email@test.com")
    .build();
```

**Examples:** ```DesignExamples/Builder.java```, ```DesignExamples/FluentBuilder.java```, ```DesignExamples/FacetedBuilder.java```

### Factories
Motivation
- Object creation logic becomes too complex
- Constructor is not descriptive
- Wholesale object creation (not piecewise, unlike Builder)
- Object creation can be outsourced to a Factory Method that may exist in a separate Factory class

**Factory:** A component who is only responsible for the wholesale creation of objects.

**Abstract Factory:** provides an interface for creating families of related objects without specifying their concrete class.

**Examples:** ```DesignExamples/Factory.java```, ```DesignExamples/AbstractFactory.java```

### Prototype
Motivation
- When it's easier to copy an existing object than to fully initialize a new one
- We rescursively deep copy the prototype and customize it

**Prototype**: an object that you clone to make use of.

**Deep Copy:** copy all nested objects and structures to avoid sharing references.

**Shallow Copy:** simply copying the references. Changing one object affects the other object.

*Don't just use cloneable because it will give a shallow copy*

We can use copy constructors, we can override cloneable, or we can use serialization..

**Examples:** ```DesignExamples/PrototypeCloneable```, ```DesignExamples/PrototypeCopyConstructor```, ```DesignExamples/PrototypeSerialization```

### Singleton
Motivation
- For some components, it only makes sense to have one instance. For example a database.
- The constructor call is expensive
- Want to prevent anyone from creating additional copies

**Singleton:** a component which is instantiated only once.

**Multiton:** there are a finite set of instances.

```java
// Test if an object is a singleton instance
import java.util.function.Supplier;

class SingletonTester
{
  public static boolean isSingleton(Supplier<Object> func)
  {
     Object instanceA = func.get();
     Object instanceB = func.get();
     
     return instanceA == instanceB;
  }
}
```

**Examples:** ```DesignExamples/SingletonBasic.java```, ```DesignExamples/SingletonEnum.java```, ```DesignExamples/Multiton.java```

## Structural Design Patterns
**Concerned with the structure (i.e. class members)**

Many patterns are wrappers that mimic underlying interface

Stress the importance of good API design

### Adapter
Motivation
- A similar concept to physical power adapters.
- Taking an interface you have to get an interface that you want.
- Use caching when regenerating the same temporary objects each time.

**Adapter:** a construct which adapts an existing interface X to conform to the required interface Y.

**Examples:** ```DesignExamples/AdapterVector```, ```DesignExamples/AdapterCaching```

### Bridge
Motivation
- Connecting components together through abstractions
- Prevents a "Cartesian product" complexity explosion

**Bridge:** a mechanism that decouples an interface from an implementation.

**Examples:** ```DesignExamples/Bridge.java```

### Composite
Motivation
- Treating individual and aggregate objects uniformly.
- Composition lets us make compound objects

**Composite:** a mechanism for treating individual objects and compositions of objects in a uniform manner.

**Examples:** ```DesignExamples/GeometricShapes.java```, ```DesignExamples/NeuralNetworks.java```

### Decorator
Motivation
- Want to add functionality to an object
- Want to keep new functionality separate
- Usually keeps the reference to the original object

**Decorator:** allows the addition of functionality to objects without inheriting from them.

**Examples:** ```DesignExamples/StringDecorator.java```, ```DesignExamples/DynamicDecorator.java```, ```DesignExamples/StaticDecorator.java```

### Facade
Motivation
- Simplifying a complex subsystem by providing a unified interface
- Balancing complexity and usability

**Facade:** a simplified interface to a complex subsystem.

```java
// Example Facade
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        cpu.freeze();
        memory.load(0, hardDrive.read(0, 1024));
        cpu.execute();
    }
}
```

### Flyweight
Motivation
- Reducing memory usage by sharing common parts of objects
- Space optimization
- Avoid redundancy when storing data

**Flyweight:** lets us use less memory by externally storing data that is common to multiple objects.

**Examples:** ```DesignExamples/Users.java```

### Proxy
Motivation
- Controlling access to an object
- Lazy loading
- Logging or access control

**Proxy:** an interface for accessing a particular resource.

Proxy vs Decorator
- Proxy provides an identical interface to the original object, while Decorator adds new functionality.
- Decorator has a reference to what it is decorating, Proxy may not.

```java
// Example Proxy
class Person
{
  private int age;

  public Person(int age)
  {
    this.age = age;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public String drink() { return "drinking"; }
  public String drive() { return "driving"; }
  public String drinkAndDrive() { return "driving while drunk"; }
}

class ResponsiblePerson extends Person
{
  private Person person;

  public ResponsiblePerson(Person person)
  {
    super(person.getAge());
  }
  
  public String drink() {
      String msg = person.getAge() < 18 ? "too young" : "drinking";
      return msg;
  }
  
  public String drive() {
      String msg = person.getAge() < 16 ? "too young" : "driving";
      return msg;
  }
  
  public String drinkAndDrive() {
      return "dead";
  }
}
```

**Examples:** ```DesignExamples/ProtectionProxy.java```

## Behavioral Design Patterns
**They are all different; no central theme**

### Chain of Responsibility
Motivation
- Passing a request along a chain of handlers
- Each handler decides either to process the request or to pass it to the next handler in the chain

**Chain of Responsibility:** a way of passing a request between a chain of handlers.

Command Query Separation (CQS)
- Command = asking for an action to be performed
- Query = asking for data without side effects
- Having separate means of sending commands and queries

**Examples:** ```DesignExamples/BrokerChain.java```

### Command
Motivation
- Encapsulating a request as an object
- Decoupling the sender of a request from its receiver

**Command:** an object that represents a command to be executed.

```java
// Example Command
interface Command
{
    void call();
}
class BankAccountCommand implements Command
{
    private BankAccount account;
    
    public enum Action
    {
        DEPOSIT, WITHDRAW
    }

    private Action action;
    private int amount;

    public BankAccountCommand(BankAccount account, Action action, int amount)
    {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }

    @Override
    public void call()
    {
        switch (action)
        {
            case DEPOSIT:
                account.deposit(amount);
                break;
            case WITHDRAW:
                account.withdraw(amount);
                break;
        }
    }
}
```

### Interpreter
Motivation
- Evaluating sentences in a language
- Representing grammar rules as classes

**Interpreter:** a way to evaluate sentences in a language. Uses lexical tokens and parsing.

Lexing
- Breaking input into tokens
- Example: "3 + 5" -> [3, +, 5]

Parsing
- Analyzing token sequence according to grammar rules
- Example: [3, +, 5] -> Expression Tree

**ANTLR:** Another Tool For Language Recognition
- A powerful parser generator for reading, processing, executing, or translating structured text or binary files.

### Iterator
Motivation
- Providing a way to access elements of a collection sequentially without exposing its underlying representation

**Iterator:** an object that enables a programmer to traverse a container, particularly lists.

```java
// Example Iterator
import java.util.Iterator;
import java.util.NoSuchElementException;
class EvenNumberIterator implements Iterator<Integer>
{
    private int current;
    private final int max;

    public EvenNumberIterator(int max)
    {
        this.current = 0;
        this.max = max;
    }

    @Override
    public boolean hasNext()
    {
        return current <= max;
    }

    @Override
    public Integer next()
    {
        if (!hasNext())
            throw new NoSuchElementException();

        int toReturn = current;
        current += 2;
        return toReturn;
    }
}
```

**Examples:** ```DesignExamples/TreeTraversal.java```

### Mediator
Motivation
- Components may go in and out of a system at any time
- Have all components refer to a central component to handle communication (mediator)
- Facilitates communication between components

**Mediator:** a component that facilitates communication between other components.

**Examples:** ```DesignExamples/ChatRoom.java```, ```DesignExamples/RxEventBroker.java```

### Memento
Motivation
- An object goes through changes
- Capturing and restoring an object's internal state without violating encapsulation

**Memento:** a way to capture and restore an object's internal state without violating encapsulation.

```java
// Example Memento
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Token
{
  public int value = 0;

  public Token(int value)
  {
    this.value = value;
  }
}

class Memento
{
  public List<Token> tokens = new ArrayList<>();
  
  public Memento(List<Token> tokens) {
      this.tokens = new ArrayList<>(tokens);
  }
}

class TokenMachine
{
  public List<Token> tokens = new ArrayList<>();

  public Memento addToken(int value)
  {
    tokens.add(new Token(value));
    return new Memento(tokens);
  }

  public Memento addToken(Token token)
  {
    tokens.add(new Token(token.value));
    return new Memento(tokens);
  }

  public void revert(Memento m)
  {
    this.tokens = m.tokens;
  }
}
```

**Examples:** ```DesignExamples/Memento.java```

### Null Object
Motivation
- When component A uses component B, it typically assumes that B is not null

**Null Object:** a no-op (do nothing) object that conforms to the required interface, satisfying a dependency requirement of some other object.

**Examples:** ```DesignExamples/NullObject.java```

### Observer
Motivation
- A way for an object (subject) to notify other objects (observers) about changes
- Java now has functional objects (lambdas) that can be used for this purpose

**Observer:** a way for an object (subject) to notify other objects (observers) about changes.

**Examples:** ```DesignExamples/ObservableAndObserver.java```, ```DesignExamples/HandmadeEvents.java```

### State
Motivation
- An object can change its behavior when its internal state changes

**State:** a pattern where the object's behavior is determined by its state.
- Every single state has its own class.

**Examples:** ```DesignExamples/SpringStatemachine.java```

### Strategy
Motivation
- Many algorithms can be decomposed into higher and lower level parts
- The higher level algorithm can be reused for other tasks, while lower level are specific

**Strategy:** enables the exact behavior of a system to be selected either at runtime (dynamic) or compile-time (static).

**Examples:** ```DesignExamples/StaticStrategy.java```

### Template Method
Motivation
- A way to define the skeleton of an algorithm in a method, deferring some steps to subclasses
- Allows subclasses to redefine certain steps of an algorithm without changing the algorithm's structure

**Template Method:** a behavioral design pattern that defines the skeleton of an algorithm in a method, deferring some steps to subclasses.

```java
// Example Template Method
abstract class Game {
    protected int currentPlayer;
    protected final int numberOfPlayers;

    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    // Skeleton Algorithm
    public void run() {
        start();
        while (!haveWinner()) {
            takeTurn();
        }
        System.out.println("Player " + getWinner() + " wins.");
    }

    // Inherit from this game class and implement these methods
    protected abstract void start();
    protected abstract void takeTurn();
    protected abstract boolean haveWinner();
    protected abstract int getWinner();
}

class Chess extends Game {
    /// Implement methods
}
```

### Visitor
Motivation
- Allows adding extra behaviors to entire hierarchies of classes
- Need to define a new operation on an entire class hierarchy
- Create an external component, avoid type checks

**Visitor:** a component (visitor) that is allowed to traverse the entire hierarchy. Implemented by propagating a single visit() method throughout entire hierarchy,

**Examples:** ```DesignExamples/IntrusiveVisitor.java``` (violates open-close principle and sole-responsibility principle), ```DesignExamples/ReflectiveVisitor.java``` (recursive), ```DesignExamples/ClassicVisitor.java``` (double-dispatch).