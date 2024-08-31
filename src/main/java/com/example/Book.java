package com.example;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private Integer publicationYear;
    private boolean isAvailable;

    //Book constructor
    public Book(String isbn, String title, String author, Integer publicationYear) {
        this.isbn = isbn.replaceAll("\\s", "");
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
    }

    // Getters and setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if(isValidISBN(isbn)){
        this.isbn = isbn;
        }else{
            throw new IllegalArgumentException("Invalid ISBN: ISBN must be 10 or 13 characters long.");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    } 
    public boolean isValidISBN(String isbn) {
        // Remove spaces
        isbn = isbn.trim().replaceAll("\\s", "");
    
        // Check if ISBN length is either 10 or 13
        if (isbn.length() != 10 && isbn.length() != 13) {
            return false;
        }
    
        // Check if ISBN contains only numeric characters
        return isbn.matches("\\d+");
    }
    
    
    @Override
    public String toString() {
        return String.format("Book[ISBN=%s | Title=%s | Author=%s | Year=%d]",isbn, title, author, publicationYear);
    }
}
