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
4. [Behavioral Design Patterns](#behavioral-design-patterns)

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

## Behavioral Design Patterns
**They are all different; no central theme**