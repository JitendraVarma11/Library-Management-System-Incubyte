package com.example;

import java.util.Scanner;
import com.example.Library;
import com.example.Book;

public class App {

    //libary instance
    private static Library library = new Library();

    //scanner instance
    private static Scanner scanner = new Scanner(System.in);

    //Main method
    public static void main(String[] args) {
        // Pre-populate the library with some books
        initializeLibrary();

        // Start the interactive menu
        runMenu();
    }

    //initial available books
    private static void initializeLibrary() {
        try {
            library.addBook(new Book("1234567890", "3 Laws of TDD", "Robert Martin", 2018));
            library.addBook(new Book("7890121334", "Unit Testing", "Robert C. Martin", 2008));
            library.addBook(new Book("6776873213323", "Design Patterns", "Erich Gamma", 1994));
            library.addBook(new Book("1111113213", "Introduction to Algorithms", "Thomas H. Cormen", 1990));
            library.addBook(new Book("3333337677676", "Modern C++ in Action", "Nicolai Josuttis", 2015));
        } catch (Exception e) {
            System.err.println("\nError initializing library: " + e.getMessage());
        }
    }

    //Start menu
    private static void runMenu() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            executeChoice(choice);
            if (choice == 5) {
                break;
            }
        }
    }

    //To display menu
    private static void displayMenu() {
        System.out.println("\n******* Library Management System *******");
        System.out.println("1. Add Book");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. View Available Books");
        System.out.println("5. Exit");
        System.out.print("Please select an option (1-5): ");
    }

    //To get user choice
    private static int getUserChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                return getUserChoice();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return getUserChoice();
        }
        return choice;
    }

    //To execute choice
    private static void executeChoice(int choice) {
        switch (choice) {
            case 1:
                addBookOption();
                break;
            case 2:
                borrowBookOption();
                break;
            case 3:
                // returnBookOption();
                break;
            case 4:
                // viewAvailableBooksOption();
                break;
            case 5:
                System.out.println("Exiting the system. Goodbye!");
                break;
            default:
                System.out.println("Unknown option. Please try again.");
        }
    }

    //Add book
    private static void addBookOption() {
        System.out.println("\n******* Add a New Book *******");
        try {
            System.out.print("Enter ISBN: ");
            String isbn = scanner.nextLine().trim();
            System.out.print("Enter Title: ");
            String title = scanner.nextLine().trim();
            System.out.print("Enter Author: ");
            String author = scanner.nextLine().trim();
            System.out.print("Enter Publication Year: ");
            String y=scanner.nextLine().trim();
            Integer year;
            if(y.isEmpty()){
                throw new IllegalArgumentException("Publication year cannot be empty");
            }else{
                year= Integer.parseInt(y);
            }
            
            Book newBook = new Book(isbn, title, author, year);
            library.addBook(newBook);
            System.out.println("Book added successfully!");
        } catch (Exception e) {
            System.err.println("Error adding book: " + e.getMessage());
        }
    }

    private static void borrowBookOption() {
        System.out.println("\n******* Borrow a Book *******");
        try {
            System.out.print("Enter ISBN of the book to borrow: ");
            String isbn = scanner.nextLine().trim();
            library.borrowBook(isbn);
            System.out.println("Book borrowed successfully!");
        } catch (Exception e) {
            System.err.println("Error borrowing book: " + e.getMessage());
        }
    }
}
