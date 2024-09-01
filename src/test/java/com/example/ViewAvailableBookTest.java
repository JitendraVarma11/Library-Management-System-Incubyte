package com.example;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ViewAvailableBookTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testGetAvailableBooks_EmptyLibrary() {
        assertTrue(library.getAvailableBooks().isEmpty());
    }

    @Test
    public void testGetAvailableBooks_AllBooksAvailable() {
        library.addBook(new Book("1234567890", "Clean Code", "Robert Martin", 2008));
        library.addBook(new Book("0987654321", "The Pragmatic Programmer", "Andy Hunt", 1999));

        Map<String, Book> availableBooks = library.getAvailableBooks();
        assertEquals(2, availableBooks.size());
    }

    @Test
    public void testGetAvailableBooks_SomeBooksBorrowed() {
        Book book1 = new Book("1234567890", "Clean Code", "Robert Martin", 2008);
        Book book2 = new Book("0987654321", "The Pragmatic Programmer", "Andy Hunt", 1999);
        library.addBook(book1);
        library.addBook(book2);

        library.borrowBook("1234567890");

        Map<String, Book> availableBooks = library.getAvailableBooks();
        assertEquals(1, availableBooks.size());
        assertTrue(availableBooks.containsKey("0987654321"));
    }

    @Test
    public void testGetAvailableBooks_AllBooksBorrowed() {
        Book book1 = new Book("1234567890", "Clean Code", "Robert Martin", 2008);
        Book book2 = new Book("0987654321", "The Pragmatic Programmer", "Andy Hunt", 1999);
        library.addBook(book1);
        library.addBook(book2);

        library.borrowBook("1234567890");
        library.borrowBook("0987654321");

        Map<String, Book> availableBooks = library.getAvailableBooks();
        assertTrue(availableBooks.isEmpty());
    }
}
