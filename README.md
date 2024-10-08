# Library Management System

---

## Overview

The **Library Management System** is a Java application that allows users to manage books in a library. This system supports basic operations such as adding, borrowing, returning, and viewing available books. 

### Features

- **Add a Book**: Add new books to the library with details such as ISBN, title, author, and publication year.
- **Borrow a Book**: Borrow a book using its ISBN. The book's availability status will be updated.
- **Return a Book**: Return a borrowed book using its ISBN, making it available for others.
- **View Available Books**: List all books currently available for borrowing.

## Prerequisites
Before you run the application, make sure you have the following installed:

- **Java Development Kit (JDK)**: Version 8 or higher. This project uses Java.

## Setup and Running the Application

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/JitendraVarma11/Library-Management-System-Incubyte.git
   ```
2. **Navigate to the Project Directory**:
    ```bash
   cd Library-Management-System-Incubyte
    ```
   
3. **To Compile Project**:
   ```bash
   javac -d out src/main/java/com/example/*.java
   ```

4. **Run the Application**:
   ```bash
   java -cp out com.example.App
   ```

   The application will start, and you can interact with it through the console. Upon running the application, a menu will be displayed:

   ```bash
   ******* Library Management System *******
    1. Add Book
    2. Borrow Book
    3. Return Book
    4. View Available Books
    5. Exit
    Please select an option (1-5):
   ```

## Running the Tests

## Prerequisites
Before you run the test cases, make sure you have the following installed:
- [**Apache Maven**: For building the project and managing dependencies.](https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.zip)
- Add the bin directory of Maven to your system’s PATH environment variable.

1. **Build the Project and Run Tests**:
   ```bash
   mvn test
   ```
   This command compiles the project and runs all the tests.

2. **Run Specific Tests**:
   To run tests from a specific test class, use:
   ```bash
   mvn -Dtest=TestClassName test
   ```
   Replace `TestClassName` with the name of the test class you want to run.


## Additional Information
- **Dependencies**: This project uses JUnit for testing.
- **Directory Structure**:
  - `src/main/java`: Contains the source code.
  - `src/test/java`: Contains the test code.
  - `out`: Directory for compiled classes.
    

