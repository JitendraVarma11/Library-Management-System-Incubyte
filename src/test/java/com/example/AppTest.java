package com.example;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AppTest {

    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBookWithDuplicateISBN() {
        Book book1 = new Book("123456", "Effective Java", "Joshua Bloch", 2018);
        Book book2 = new Book("123456", "Clean Code", "Robert C. Martin", 2008);

        library.addBook(book1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(book2);
        });

        assertEquals("Book with this ISBN already exists.", exception.getMessage());
    }

    @Test
    public void testAddBookWithInvalidISBN() {
        Book book = new Book("", "Invalid Book", "Unknown Author", 2024);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(book);
        });

        assertEquals("ISBN cannot be empty.", exception.getMessage());
    }

    @Test
    public void testAddBookWithNullValues() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            library.addBook(null);
        });

        assertEquals("Book cannot be null.", exception.getMessage());
    }

    @Test
    public void testAddBookWithEmptyValue() {
        // Create a book with an empty title
        Book bookWithEmptyTitle = new Book("123456", "", "Robert Martin", 2018);

        Exception exceptionTitle = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(bookWithEmptyTitle);
        });
        assertEquals("Title cannot be empty.", exceptionTitle.getMessage());

        // Create a book with an empty author
        Book bookWithEmptyAuthor = new Book("789012", "Clean Code", "", 2008);

        Exception exceptionAuthor = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(bookWithEmptyAuthor);
        });
        assertEquals("Author cannot be empty.", exceptionAuthor.getMessage());
    }

    @Test
    public void testAddBookWithFuturePublicationYear() {
        Book futureBook = new Book("999999", "Future Tech", "John Doe", 3000);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(futureBook);
        });

        assertEquals("Publication year cannot be in the future.", exception.getMessage());
    }
}
