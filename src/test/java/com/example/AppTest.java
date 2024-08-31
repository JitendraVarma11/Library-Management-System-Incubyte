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

    // **********Test Cases for adding book***********
    @Test
    public void testValidISBN() {
        Book validBook10 = new Book("1234567890", "Valid Book 10", "Author", 2021);
        Book validBook13 = new Book("9781234567890", "Valid Book 13", "Author", 2021);

        // Creating a book with spaces in the ISBN
        Book invalidBook= new Book("978 1 234 567 ABC", "Invalid Book With Spaces", "Author", 2021);

        // Test for valid 10-digit ISBN 
        assertTrue(validBook10.isValidISBN("1234567890"));
        
        // Test for valid 13-digit ISBN
        assertTrue(validBook13.isValidISBN("9781234567890"));

        // Test for ISBN with spaces (should be invalid) & character
        assertFalse(invalidBook.isValidISBN("978 1 234 567 ABC"));

    }
    @Test
    public void testAddBookWithDuplicateISBN() {
        Book book1 = new Book("1234567890", "Effective Java", "Joshua Bloch", 2018);
        Book book2 = new Book("1234567890", "Clean Code", "Robert C. Martin", 2008);

        library.addBook(book1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(book2);
        });

        assertEquals("Book with this ISBN already exists.", exception.getMessage());
    }

    @Test
    public void testAddBookWithNullValues() {
        //If Book is null
        Exception exception = assertThrows(NullPointerException.class, () -> {
            library.addBook(null);
        });
        assertEquals("Book cannot be null.", exception.getMessage());

        //If Title is null
        Book book1 = new Book("1234567890", null, "Joshua Bloch", 2018);
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(book1);
        });
        assertEquals("Title cannot be empty/null.", exception1.getMessage());

        //If Author is null
        Book book2 = new Book("1234567890", "Title", null, 2018);
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(book2);
        });
        assertEquals("Author cannot be empty/null.", exception2.getMessage());

    }

    @Test
    public void testAddBookWithEmptyValue() {
        // Test for empty title
        Book bookWithEmptyTitle = new Book("1234568789", "", "Robert Martin", 2018);
        Exception exceptionTitle = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(bookWithEmptyTitle);
        });
        assertEquals("Title cannot be empty/null.", exceptionTitle.getMessage());

        // Test for empty author
        Book bookWithEmptyAuthor = new Book("7890123455", "Clean Code", "", 2008);
        Exception exceptionAuthor = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(bookWithEmptyAuthor);
        });
        assertEquals("Author cannot be empty/null.", exceptionAuthor.getMessage());
    }

    @Test
    public void testAddBookWithPublicationYear() {
        //If year is greater than 2024
        Book Book = new Book("9999999999", "Future Tech", "John Doe", 3000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(Book);
        });
        assertEquals("Invalid Publication Year.", exception.getMessage());

        //If year is negative
        Book Book2 = new Book("9999999999", "Future Tech", "John Doe", -2000);

        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(Book2);
        });

        //If year is null
        assertEquals("Invalid Publication Year.", e.getMessage());
        Book Book3 = new Book("9999999999", "Future Tech", "John Doe", null);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(Book3);
        });
        assertEquals("Publication year cannot be null.", ex.getMessage());        
    }
}
