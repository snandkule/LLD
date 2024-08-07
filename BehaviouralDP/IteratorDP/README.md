# Iterator Design Pattern

The Iterator design pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation. It falls under the category of behavioral design patterns.

## Key Concepts

- **Iterator**: The interface or abstract class that defines methods for accessing and traversing elements.
- **Concrete Iterator**: Implements the Iterator interface and is responsible for the actual traversal of the aggregate object.
- **Aggregate (or Collection)**: The interface or abstract class that defines methods to create an iterator.
- **Concrete Aggregate**: Implements the Aggregate interface and returns an instance of the Concrete Iterator.

## Example

Let's consider an example where we have a collection of `Book` objects and we want to traverse this collection.

### UML Diagram
```plaintext
+---------------------+              +--------------------------+
|     <<Interface>>   |              |      <<Interface>>       |
|       Iterator      |              |         Aggregate        |
|---------------------|              |--------------------------|
| + hasNext(): boolean|              | + createIterator():      |
| + next(): Object    |<------------>|       Iterator           |
+---------------------+              +--------------------------+
           ^                                      ^
           |                                      |
           |                                      |
           |                                      |
+---------------------+              +--------------------------+
|   ConcreteIterator  |              |     ConcreteAggregate    |
|---------------------|              |--------------------------|
| - collection: Book[]|              | - books: Book[]          |
| - index: int        |              | - last: int              |
|---------------------|              |--------------------------|
| + hasNext(): boolean|              | + getBookAt(index: int): |
| + next(): Object    |              |       Book               |
+---------------------+              | + appendBook(book: Book):|
                                     |       void               |
                                     | + getLength(): int       |
                                     | + createIterator():      |
                                     |       Iterator           |
                                     +--------------------------+
                                                    |
                                                    |
                                            +----------------+
                                            |     Book       |
                                            +----------------+
                                            | - name: String |
                                            +----------------+
                                            | + getName():   |
                                            |       String   |
                                            +----------------+
```
### Step 1: Create the Iterator Interface

```java
public interface Iterator {
    boolean hasNext();
    Object next();
}
```

### Step 2: Create the Concrete Iterator Class

```java
public class BookIterator implements Iterator {
private BookCollection bookCollection;
private int index;

    public BookIterator(BookCollection bookCollection) {
        this.bookCollection = bookCollection;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookCollection.getLength();
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return bookCollection.getBookAt(index++);
        }
        return null;
    }
}
```

### Step 3: Create the Aggregate Interface
```java
public interface Aggregate {
Iterator createIterator();
}
```

### Step 4: Create the Concrete Aggregate Class
```java
public class BookCollection implements Aggregate {
private Book[] books;
private int last = 0;

    public BookCollection(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator createIterator() {
        return new BookIterator(this);
    }
}
```
### Step 5: Create the Book Class
```java
public class Book {
private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```
### Step 6: Use the Iterator in the Client Code
``` java
public class IteratorPatternDemo {
public static void main(String[] args) {
BookCollection bookCollection = new BookCollection(4);
bookCollection.appendBook(new Book("Design Patterns"));
bookCollection.appendBook(new Book("Clean Code"));
bookCollection.appendBook(new Book("Refactoring"));
bookCollection.appendBook(new Book("The Pragmatic Programmer"));

        Iterator iterator = bookCollection.createIterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println("Book: " + book.getName());
        }
    }
}
```

## Explanation

- **Iterator Interface**: Defines the methods `hasNext()` and `next()`. Any class implementing this interface can be used to traverse elements.

- **Concrete Iterator**: Implements the Iterator interface. It maintains a reference to the collection and the current position in the traversal.

- **Aggregate Interface**: Defines a method `createIterator()` which returns an instance of `Iterator`.

- **Concrete Aggregate**: Implements the Aggregate interface. It contains a collection of `Book` objects and provides a method to create an iterator for this collection.

- **Book Class**: Represents the objects being stored in the collection.

- **Client Code**: Demonstrates how to use the iterator to traverse the `BookCollection` without exposing its internal structure.

## Benefits

- **Encapsulation**: The internal representation of the collection is hidden.

- **Single Responsibility**: The collection class focuses on managing its elements, while the iterator handles traversal.

- **Flexibility**: The traversal algorithm can be changed without changing the collection's interface.

## Summary

The Iterator design pattern provides a uniform way to access elements of a collection, making the client code easier to write and maintain. By using this pattern, you can keep your collection classes focused on storing and managing data while offloading the traversal logic to separate iterator classes.
