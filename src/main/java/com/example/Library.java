package com.example;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;

    public Library() {
        books = new HashMap<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        if (book == null) {
            throw new NullPointerException("Book cannot be null.");
        }
        if (!book.isValidISBN(book.getIsbn())) {
            throw new IllegalArgumentException("Invalid ISBN: ISBN must be 10 or 13 numeric characters long.");
        }
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty/null.");
        }
        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty/null.");
        }
        if (book.getPublicationYear() == null) {
            throw new IllegalArgumentException("Publication year cannot be null.");
        }
        if (book.getPublicationYear() < 0 || book.getPublicationYear() > 2024) {
            throw new IllegalArgumentException("Invalid Publication Year.");
        }

        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Book with this ISBN already exists.");
        }
        books.put(book.getIsbn(), book);
    }

    //Borrow a book
    public void borrowBook(String isbn) {
        // Check if the book with the given ISBN exists in the library
        Book book = books.get(isbn);
    
        // If the book doesn't exist, throw an exception
        if (book == null) {
            throw new IllegalArgumentException("Book not found.");
        }
    
        // If the book is already borrowed, throw an exception
        if (!book.isAvailable()) {
            throw new IllegalArgumentException("Book is already borrowed.");
        }
    
        // Mark the book as borrowed by setting its availability to false
        book.setAvailable(false);
    }
    
}
