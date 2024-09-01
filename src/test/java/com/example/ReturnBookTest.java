package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ReturnBookTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testReturnBookSuccessfully() {
        Book book = new Book("1234567999", "Test Book", "Author", 2023);
        library.addBook(book);

        library.borrowBook("1234567999");

        library.returnBook("1234567999");

        assertTrue(book.isAvailable());
    }

    @Test
    public void testReturnBookAlreadyAvailable() {
        library.addBook(new Book("1234567890", "Effective Java", "Joshua Bloch", 2018));

        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook("1234567890");
        });
        assertEquals("Book is already available.", exception.getMessage());
    }

    @Test
    public void testReturnNonExistentBook() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook("0000000000");
        });
        assertEquals("Book not found.", exception.getMessage());
    }

    @Test
    public void testReturnBookWithNullISBN() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook(null);
        });
        assertEquals("ISBN cannot be null.", exception.getMessage());
    }
    @Test
    public void testReturnBookWithEmptyISBN() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook("");
        });
        assertEquals("ISBN cannot be empty.", exception.getMessage());
    }

    @Test
    public void testReturnBookWithInvalidISBNFormat() {
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook("12345X7890");
        });
        assertEquals("Invalid ISBN: ISBN must be 10 or 13 numeric characters long.", exception.getMessage());
    }
}
