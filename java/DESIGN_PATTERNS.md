# Design Patterns in Java

## Table of Contents
1. [SOLID Design Principles](#solid-design-principles)
    - [Overview](#overview)
    - [Single Responsibility Principle](#single-responsibility-principle-srp)
    - [Open Closed Principle](#open-closed-principle-ocp)
    - [Liskov Substitution Principle](#liskov-substitution-principle-lsp)
    - [Interface Segregation Principle](#interface-segregation-principle-isp)
    - [Dependency Inversion Principle](#dependency-inversion-principle-dip)
2. [Creational Design Patterns]()
3. [Structural Design Patterns]()
4. [Behavioral Design Patterns]()

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