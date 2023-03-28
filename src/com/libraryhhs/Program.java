package com.libraryhhs;

import com.libraryhhs.item.Book;
import com.libraryhhs.item.CD;
import com.libraryhhs.item.DVD;
import com.libraryhhs.item.Manga;
import com.libraryhhs.library.ExcelReader;
import com.libraryhhs.library.Library;
import com.libraryhhs.user.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void printExitMessage() {
        System.out.println("Thank you for using the Library Management System!");
    }

    public void start() throws IOException {

        Scanner scanner = new Scanner(System.in);
        ExcelReader excelReader = new ExcelReader();
        Library hhs = new Library("hhs");

        String fileName = "resources/Library.xlsx";
        String sheetName = "Sheet1";
        excelReader.readExcelFile(fileName, sheetName, hhs.getCatalog());
        excelReader.readExcelFileMembers("resources/Members.xlsx", "Sheet1", hhs.getUsers());
        excelReader.readExcelFileCd("resources/Library.xlsx", "cd", hhs.getCds());
        excelReader.readExcelFileDvd("resources/Library.xlsx", "dvd", hhs.getDvds());
        excelReader.readExcelFileManga("resources/Library.xlsx", "manga", hhs.getMangas());

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
                System.out.println();
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
                    int bookNumber;
                    try {
                        bookNumber = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println();
                        System.out.println("Invalid input.");
                        System.out.println();
                        scanner.next();
                        continue;
                    }
                    scanner.nextLine();
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
                    scanner.nextLine();
                    System.out.println();
                    System.out.println("Please select an option:");
                    System.out.println("1. Search book by title");
                    System.out.println("2. Search book by author");
                    System.out.println("3. Back to menu");

                    System.out.println();
                    System.out.print("Option: ");

                    int option2;

                    try {
                        option2 = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        // User entered a non-integer value
                        System.out.println();
                        System.out.println("Invalid input.");
                        System.out.println();
                        scanner.next();
                        break;
                    }

                    if (option2 < 1 || option2 > 3) {
                        System.out.println();
                        System.out.println("Invalid.");
                        System.out.println();
                        break;
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
                                printExitMessage();
                            } else if (answer.equals("y")) {
                                System.out.println();
                                continue;
                            } else {
                                System.out.println("Invalid input. Please enter 'y' or 'n'.");
                            }
                            running = false;
                            break;

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
                                printExitMessage();
                            } else if (answer.equals("y")) {
                                System.out.println();
                                continue;
                            } else {
                                System.out.println("Invalid input. Please enter 'y' or 'n'.");
                            }
                            running = false;
                        case 3:
                            break;
                    }
                    break;

                case 3:
                    // code to borrow a book
                    scanner.nextLine();
                    System.out.println("Please enter your user ID: ");
                    String userId = scanner.nextLine();
                    User user = hhs.findUserByName(userId);

                    if (user == null) {
                        System.out.println("User not found.");
                        System.out.println();
                        break;
                    }

                    System.out.println("Found you.");
                    System.out.println("Please enter the name of the book that you would like to borrow: ");
                    String bookName = scanner.nextLine();
                    Book book = hhs.findBookByName(bookName);

                    if (book == null) {
                        System.out.println("Book not found.");
                        System.out.println();
                        break;
                    }

                    if (book.getInventory() < 1) {
                        System.out.println("The book is not available for borrowing at this time.");
                        System.out.println();
                        break;
                    }

                    //book.setAvailable(false);
                    user.addBorrowBook(book);
                    book.setInventory(book.getInventory() - 1);

                    // Get the workbook object for the Excel file
                    FileInputStream file = new FileInputStream("resources/Library.xlsx");
                    XSSFWorkbook workbook;
                    try {
                        workbook = new XSSFWorkbook(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    XSSFSheet sheet = workbook.getSheet("Sheet1");

                    // Find the row for the book to be borrowed
                    DataFormatter formatter = new DataFormatter();
                    int rowIndex = -1;
                    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                        Row row = sheet.getRow(i);
                        if (formatter.formatCellValue(row.getCell(0)).equals(bookName)) {
                            rowIndex = row.getRowNum();
                            break;
                        }
                    }

                    // Update the inventory of the book
                    if (rowIndex >= 0) {
                        Row row = sheet.getRow(rowIndex);
                        int inventory = (int) row.getCell(10).getNumericCellValue();
                        row.getCell(10).setCellValue(inventory - 1);
                    }

                    // Save the changes to the Excel file
                    file.close();
                    FileOutputStream outFile = new FileOutputStream("resources/Library.xlsx");
                    workbook.write(outFile);
                    outFile.close();

                    System.out.println("Book borrowed successfully.");
                    System.out.println();

                    // Get the workbook object for the Excel file
                    FileInputStream file8 = new FileInputStream("resources/Members.xlsx");
                    XSSFWorkbook workbook8;
                    try {
                        workbook8 = new XSSFWorkbook(file8);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    XSSFSheet sheet3 = workbook8.getSheet("Sheet1"); // Get the "Sheet1" sheet from the Members.xlsx file

                    // Find the row for the user
                    int rowIndex3 = -1;
                    for (int i = 1; i <= sheet3.getLastRowNum(); i++) {
                        Row row = sheet3.getRow(i);
                        if (formatter.formatCellValue(row.getCell(0)).equals(userId)) {
                            rowIndex3 = row.getRowNum();
                            break;
                        }
                    }

                    // Update the borrowed books for the user
                    if (rowIndex3 >= 0) {
                        Row row3 = sheet3.getRow(rowIndex3);
                        if (row3 != null) { // check if row3 is null
                            String borrowedBooks = formatter.formatCellValue(row3.getCell(5));
                            if (borrowedBooks.isEmpty()) {
                                borrowedBooks = bookName;
                            } else {
                                borrowedBooks += "," + bookName;
                            }
                            Cell cell = row3.getCell(5);
                            if (cell == null) {
                                cell = row3.createCell(5);
                            }
                            cell.setCellValue(borrowedBooks);
                            row3.getCell(5).setCellValue(borrowedBooks);
                        } else {
                            throw new RuntimeException("Row not found.");
                            // or print an error message instead of throwing an exception
                            // System.err.println("Error: Row not found.");
                        }
                    }

                    // Save the changes to the Excel file
                    file8.close();
                    FileOutputStream outFile2 = new FileOutputStream("resources/Members.xlsx");
                    workbook8.write(outFile2);
                    outFile.close();

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
                    break;

                case 4:
                    // code to return a book
                    scanner.nextLine();
                    System.out.println("Please enter your user ID: ");
                    String userIdReturn = scanner.nextLine();
                    User userReturn = hhs.findUserByName(userIdReturn);

                    if (userReturn == null) {
                        System.out.println("User not found.");
                        System.out.println();
                        break;
                    }

                    System.out.println("Found you.");
                    System.out.println("Please enter the book name you would like to return: ");
                    String bookNameReturn = scanner.nextLine();
                    Book bookReturn = hhs.findBookByName(bookNameReturn);

                    if (bookReturn == null) {
                        System.out.println("Book not found.");
                        System.out.println();
                        break;
                    }

                    if (!userReturn.returnBorrowedBook(bookReturn)) {
                        System.out.println("You have not borrowed this book.");
                        System.out.println();
                        break;
                    }

                    bookReturn.setInventory(bookReturn.getInventory() + 1);

                    // Get the workbook object for the Excel file
                    FileInputStream file2 = new FileInputStream("resources/Library.xlsx");
                    XSSFWorkbook workbook2;
                    try {
                        workbook2 = new XSSFWorkbook(file2);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    XSSFSheet sheet2 = workbook2.getSheet("Sheet1");

                    // Find the row for the book to be returned
                    DataFormatter formatter2 = new DataFormatter();
                    int rowIndex2 = -1;
                    for (int i = 1; i <= sheet2.getLastRowNum(); i++) {
                        Row row = sheet2.getRow(i);
                        if (formatter2.formatCellValue(row.getCell(0)).equals(bookNameReturn)) {
                            rowIndex2 = row.getRowNum();
                            break;
                        }
                    }

                    // Update the inventory of the book
                    if (rowIndex2 >= 0) {
                        Row row2 = sheet2.getRow(rowIndex2);
                        int inventory = (int) row2.getCell(10).getNumericCellValue();
                        row2.getCell(10).setCellValue(inventory + 1);
                    }

                    // Save the changes to the Excel file
                    file2.close();
                    FileOutputStream outFile3 = new FileOutputStream("resources/Library.xlsx");
                    workbook2.write(outFile3);
                    outFile3.close();

                    // Get the workbook object for the Excel file
                    FileInputStream file9 = new FileInputStream("resources/Members.xlsx");
                    XSSFWorkbook workbook9;
                    try {
                        workbook9 = new XSSFWorkbook(file9);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    XSSFSheet sheet4 = workbook9.getSheet("Sheet1");

                    // Find the row for the user
                    int rowIndex4 = -1;
                    for (int i = 1; i <= sheet4.getLastRowNum(); i++) {
                        Row row4 = sheet4.getRow(i);
                        if (formatter2.formatCellValue(row4.getCell(0)).equals(userIdReturn)) {
                            rowIndex4 = row4.getRowNum();
                            break;
                        }
                    }

                    // Update the borrowed books for the user
                    if (rowIndex4 >= 0) {
                        Row row4 = sheet4.getRow(rowIndex4);
                        if (row4 != null) { // check if row2 is null
                            DataFormatter formatter4 = new DataFormatter();
                            String borrowedBooks = formatter4.formatCellValue(row4.getCell(5));
                            if (borrowedBooks.contains(bookNameReturn)) {
                                borrowedBooks = borrowedBooks.replace(bookNameReturn, "").replaceAll(",,", ",");
                                borrowedBooks = borrowedBooks.replaceAll(",$", "").replaceAll("^,", "");
                                row4.getCell(5).setCellValue(borrowedBooks);
                            }
                        } else {
                            throw new RuntimeException("Row not found.");
                            // or print an error message instead of throwing an exception
                            // System.err.println("Error: Row not found.");
                        }
                    }

                    // Save the changes to the Excel file
                    file9.close();
                    FileOutputStream outFile1 = new FileOutputStream("resources/Members.xlsx");
                    workbook9.write(outFile1);
                    outFile1.close();

                    System.out.println("Book returned successfully.");
                    System.out.println();

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
                    break;
                case 5:
                    // code for library options
                    System.out.println("Library options.");
                    System.out.println("Please select an option:");
                    System.out.println("1. Add book");
                    System.out.println("2. Remove book (in production)");
                    System.out.println("3. Add user");
                    System.out.println("4. Remove user (in production)");
                    System.out.println("5. Show books");
                    System.out.println("6. Show CD's");
                    System.out.println("7. Show dvds");
                    System.out.println("8. Show mangas");
                    System.out.println("9. Back to menu");

                    System.out.println();
                    System.out.print("Option: ");

                    int option3;

                    try {
                        option3 = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        // User entered a non-integer value
                        System.out.println();
                        System.out.println("Invalid input.");
                        System.out.println();
                        scanner.next(); // Clear the scanner buffer
                        continue; // Go back to the start of the loop
                    }

                    switch (option3) {

                        case 1:
                            // code to add a book
                            scanner.nextLine();
                            System.out.print("The title of the Book: ");
                            String title = scanner.nextLine();
                            System.out.println();
                            System.out.print("The author's name: ");
                            String author = scanner.nextLine();
                            System.out.println();
                            System.out.print("Subtitle (press enter if none): ");
                            String subtitle = scanner.nextLine();
                            System.out.println();
                            System.out.print("ISBN: ");
                            String isbn = scanner.nextLine();
                            System.out.println();
                            System.out.print("Published by: ");
                            String publisher = scanner.nextLine();
                            System.out.println();
                            System.out.print("Published in year : ");
                            String publicationYear = scanner.nextLine();
                            System.out.println();
                            System.out.print("Published in month: ");
                            String publicationMonth = scanner.nextLine();
                            System.out.println();
                            System.out.print("Published on day: ");
                            String publicationDay = scanner.nextLine();
                            System.out.println();
                            System.out.print("Book genre: ");
                            String genre = scanner.nextLine();
                            System.out.println();
                            System.out.print("Book is in language: ");
                            String language = scanner.nextLine();
                            System.out.println();
                            System.out.print("Inventory count: ");
                            int inventory = scanner.nextInt();
                            System.out.println();

                            book = new Book(title, author, subtitle, isbn, publisher, publicationYear, publicationMonth, publicationDay, genre, language, inventory);
                            hhs.addBook(book);

                            System.out.println("Back to menu? (y/n)");
                            System.out.print("Answer: ");
                            scanner.nextLine();
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
                            String rrr = scanner.nextLine();
                            System.out.println();

                            hhs.searchBookByAuthor(rrr);

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
                            // code to add a user
                            scanner.nextLine();
                            System.out.print("Enter userID: ");
                            String userID = scanner.nextLine();
                            System.out.println();
                            System.out.print("Enter firstname: ");
                            String firstname = scanner.nextLine();
                            System.out.println();
                            System.out.print("Enter lastname: ");
                            String lastname = scanner.nextLine();
                            System.out.println();
                            System.out.print("Enter email address: ");
                            String email = scanner.nextLine();
                            System.out.println();
                            System.out.print("Enter phone number: ");
                            String phoneNumber = scanner.nextLine();
                            System.out.println();

                            user = new User(userID, firstname, lastname, email, phoneNumber);
                            hhs.addUser(user);

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
                        case 5:
                            for (Book boek: hhs.getCatalog()) {
                                System.out.println(boek.toString());
                            }
                            continue;
                        case 6:
                            for (CD cd: hhs.getCds()) {
                                System.out.println(cd.toString());
                            }
                            continue;
                        case 7:
                            for (DVD dvd: hhs.getDvds()) {
                                System.out.println(dvd.toString());
                            }
                            continue;
                        case 8:
                            for (Manga manga: hhs.getMangas()) {
                                System.out.println(manga.toString());
                            }
                            continue;
                        case 9:
                            continue;
                        default:
                            System.out.println();
                            System.out.println("Invalid option. Please try again.");
                            System.out.println();
                            break;
                    }
                    continue;

                case 6:
                    running = false;
                    printExitMessage();
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid option. Please try again.");
                    System.out.println();
            }
        }

        scanner.close();

    }

}
