# Exercise: Library Management System

## Scenario
You need to design a library management system where users can borrow books, return books, and check the status of books. The system should be flexible and extensible, allowing for new types of users and books without changing existing code.

## Requirements

### Users
- Users can be either `RegularUser` or `PremiumUser`.
- `RegularUser` has a limit on the number of books they can borrow.
- `PremiumUser` can borrow an unlimited number of books.

### Books
- Books can be either `PrintedBook` or `Ebook`.
- `PrintedBook` has a physical location.
- `Ebook` has a digital format and can be downloaded.

### Library Operations
- Users can borrow and return books.
- The system should keep track of which books are currently borrowed by which users.
- The system should check the availability of books and the borrowing limit for users.

## Task

### Design the Classes and Interfaces
- Define interfaces and classes for Users and Books.
- Implement the borrowing and returning logic.
- Ensure the design adheres to SOLID principles.

### Implementation Details

- **Single Responsibility Principle (SRP):** Ensure that each class has a single responsibility. For instance, the `User` class should not handle book borrowing logic.

- **Open/Closed Principle (OCP):** Design the system so that new types of users or books can be added without modifying existing code. Use interfaces and abstract classes to achieve this.

- **Liskov Substitution Principle (LSP):** Ensure that subclasses (e.g., `RegularUser`, `PremiumUser`) can be used interchangeably with their base classes without altering the correctness of the system.

- **Interface Segregation Principle (ISP):** Avoid forcing classes to implement methods they do not use. Create specific interfaces for different functionalities.

- **Dependency Inversion Principle (DIP):** Depend on abstractions rather than concrete implementations. For example, high-level modules should depend on abstractions for book and user management.

## Questions

### Single Responsibility Principle (SRP)
- **How would you refactor the code if the `User` class also had to handle book reservation logic?**

### Open/Closed Principle (OCP)
- **How would you add support for new types of books (e.g., `Audiobook`) without modifying existing classes?**

### Liskov Substitution Principle (LSP)
- **Can you ensure that replacing a `RegularUser` with a `PremiumUser` will not break the borrowing functionality?**

### Interface Segregation Principle (ISP)
- **How would you split the interfaces if additional functionalities were required, such as managing reservations or fines?**

### Dependency Inversion Principle (DIP)
- **How would you ensure that high-level modules, like the borrowing logic, do not depend on specific implementations of books and users?**
