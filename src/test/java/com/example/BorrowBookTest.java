package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BorrowBookTest {
    private Library library;
    
    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testBorrowBookSuccessfully() {
        Book book = new Book("1234567999", "Test Book", "Author", 2023);
        library.addBook(book);
    
        library.borrowBook("1234567999");
    
        assertFalse("The book should be marked as borrowed.", book.isAvailable());
    }
    
    @Test
    public void testBorrowAlreadyBorrowedBook() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("1234567999");
        });
        assertEquals("Book is already borrowed.", exception.getMessage());
    }
    
    @Test
    public void testBorrowNonExistentBook() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("0000000000");
        });
        assertEquals("Book not found.", exception.getMessage());
    }
    
    @Test
    public void testBorrowBookWithNullISBN() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook(null);
        });
        assertEquals("ISBN cannot be null.", exception.getMessage());
    }
    
    @Test
    public void testBorrowBookWithEmptyISBN() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("");
        });
        assertEquals("ISBN cannot be empty.", exception.getMessage());
    }
    
    @Test
    public void testBorrowBookWithInvalidISBNFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("12345X7890");
        });
        assertEquals("Invalid ISBN: ISBN must be 10 or 13 numeric characters long.", exception.getMessage());
    }
}
