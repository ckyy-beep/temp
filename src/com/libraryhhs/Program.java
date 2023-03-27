package com.libraryhhs;

import com.libraryhhs.library.ExcelReader;
import com.libraryhhs.library.Library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void printExitMessage() {
        System.out.println("Thank you for using the Library Management System!");
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);
        ExcelReader excelReader = new ExcelReader();
        Library hhs = new Library("hhs");

        String fileName = "resources/Library.xlsx";
        String sheetName = "Sheet1";
        excelReader.readExcelFile(fileName, sheetName, hhs.getCatalog());

        //excelReader.writeExcelFile(fileName, sheetName, hhs.getCatalog());

        boolean running = true;

        while (running) {

            //System.out.println();
            System.out.println("Welcome to the Library Management System!");
            System.out.println("Please select an option:");
            System.out.println("1. Display list of books");
            System.out.println("2. Search for a book");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Library");
            System.out.println("6. Exit");

            System.out.println();
            System.out.print("Option: ");

            int option;

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                // User entered a non-integer value
                System.out.println("Invalid input. Please enter a number.");
                System.out.println();
                scanner.next(); // Clear the scanner buffer
                continue; // Go back to the start of the loop
            }

            switch (option) {
                case 1:
                    // code to display list of books
                    hhs.showCatalog();
                    System.out.print("Which book would you like information on? Book number: ");
                    int bookNumber = scanner.nextInt(); scanner.nextLine();
                    System.out.println();

                    if (bookNumber - 1 >= hhs.getCatalog().size()) {
                        System.out.println("This book number does not exist.");
                        System.out.println();
                        continue;
                    }

                    hhs.getCatalog().get(bookNumber - 1).printInformation();

                    System.out.println("Back to menu? (y/n)");
                    System.out.print("Answer: ");
                    String answer = scanner.nextLine();

                    if (answer.equals("n")) {
                        running = false;
                        printExitMessage();
                    } else {
                        System.out.println();
                    }
                    break;

                case 2:
                    // code to search for a book
                    System.out.println();
                    System.out.println("Please select an option:");
                    System.out.println("1. Search book by title");
                    System.out.println("2. Search book by author");

                    System.out.println();
                    System.out.print("Option: ");

                    int option2;

                    try {
                        option2 = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        // User entered a non-integer value
                        System.out.println("Invalid input. Please enter a number.");
                        System.out.println();
                        scanner.next(); // Clear the scanner buffer
                        continue; // Go back to the start of the loop
                    }

                    switch (option2) {

                        case 1:
                            // code to search for a book by title.
                            scanner.nextLine();
                            System.out.println("What book are you looking for? ");
                            System.out.print("Book: ");
                            String bookName = scanner.nextLine();
                            System.out.println();

                            hhs.searchBookByTitle(bookName);

                            System.out.println("Back to menu? (y/n)");
                            System.out.print("Answer: ");
                            answer = scanner.nextLine();

                            if (answer.equals("n")) {
                                running = false;
                                printExitMessage();
                            } else {
                                System.out.println();
                                break;
                            }

                        case 2:
                            // code to search for a book by author.
                            scanner.nextLine();
                            System.out.println("Which author's books are you looking for? ");
                            System.out.print("Author: ");
                            String author = scanner.nextLine();
                            System.out.println();

                            hhs.searchBookByAuthor(author);

                            System.out.println("Back to menu? (y/n)");
                            System.out.print("Answer: ");
                            answer = scanner.nextLine();

                            if (answer.equals("n")) {
                                running = false;
                                printExitMessage();
                            } else {
                                System.out.println();
                                break;
                            }
                    }

                case 3:
                    // code to borrow a book
                    break;
                case 4:
                    // code to return a book
                    break;
                case 5:
                    System.out.println("Library options.");
                    System.out.println("Please select an option:");
                    System.out.println("1. Add book");
                    System.out.println("2. Remove book");
                    System.out.println("3. Add user");
                    System.out.println("4. Remove user");

                    System.out.println();
                    System.out.print("Option: ");

                    int option3;

                    try {
                        option3 = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        // User entered a non-integer value
                        System.out.println("Invalid input. Please enter a number.");
                        System.out.println();
                        scanner.next(); // Clear the scanner buffer
                        continue; // Go back to the start of the loop
                    }

                    switch (option3) {

                        case 1:
                            // code to search for a book by title.
                            scanner.nextLine();
                            System.out.println("What book are you looking for? ");
                            System.out.print("Book: ");
                            String bookName = scanner.nextLine();
                            System.out.println();

                            hhs.searchBookByTitle(bookName);

                            System.out.println("Back to menu? (y/n)");
                            System.out.print("Answer: ");
                            answer = scanner.nextLine();

                            if (answer.equals("n")) {
                                running = false;
                                printExitMessage();
                            } else {
                                System.out.println();
                                continue;
                            }

                        case 2:
                            // code to search for a book by author.
                            scanner.nextLine();
                            System.out.println("Which author's books are you looking for? ");
                            System.out.print("Author: ");
                            String author = scanner.nextLine();
                            System.out.println();

                            hhs.searchBookByAuthor(author);

                            System.out.println("Back to menu? (y/n)");
                            System.out.print("Answer: ");
                            answer = scanner.nextLine();

                            if (answer.equals("n")) {
                                running = false;
                                printExitMessage();
                            } else {
                                System.out.println();
                                continue;
                            }
                        case 3:
                            // code to search for a book by author.
                            scanner.nextLine();
                            System.out.println("Which author's books are you looking for? ");
                            System.out.print("Author: ");
                            author = scanner.nextLine();
                            System.out.println();

                            hhs.searchBookByAuthor(author);

                            System.out.println("Back to menu? (y/n)");
                            System.out.print("Answer: ");
                            answer = scanner.nextLine();

                            if (answer.equals("n")) {
                                running = false;
                                printExitMessage();
                            } else {
                                System.out.println();
                                continue;
                            }
                        case 4:
                            // code to search for a book by author.
                            scanner.nextLine();
                            System.out.println("Which author's books are you looking for? ");
                            System.out.print("Author: ");
                            author = scanner.nextLine();
                            System.out.println();

                            hhs.searchBookByAuthor(author);

                            System.out.println("Back to menu? (y/n)");
                            System.out.print("Answer: ");
                            answer = scanner.nextLine();

                            if (answer.equals("n")) {
                                running = false;
                                printExitMessage();
                            } else {
                                System.out.println();
                                continue;
                            }
                    }

                case 6:
                    running = false;
                    printExitMessage();
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();

    }
}
