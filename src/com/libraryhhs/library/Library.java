package com.libraryhhs.library;

import com.libraryhhs.item.Book;
import com.libraryhhs.item.CD;
import com.libraryhhs.item.DVD;
import com.libraryhhs.item.Manga;
import com.libraryhhs.user.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Library {
    private String libraryName;
    private static ArrayList<Book> catalog;
    private static ArrayList<CD> cds;
    private static ArrayList<DVD> dvds;
    private static ArrayList<Manga> mangas;
    private ArrayList<User> users;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        catalog = new ArrayList<>();
        cds = new ArrayList<>();
        dvds = new ArrayList<>();
        mangas = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void setBooks(ArrayList<Book> books) {
        this.catalog = books;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public ArrayList<Book> getCatalog() {
        return catalog;
    }
    public ArrayList<CD> getCds() {return cds;}
    public ArrayList<DVD> getDvds() {return dvds;}
    public ArrayList<Manga> getMangas() {return mangas;}
    public ArrayList<User> getUsers() {return users;}

    public void removeBook(Book book) {
        catalog.remove(book);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void showCatalog() {
        for (int i = 0; i < catalog.size(); i++) {
            System.out.printf("%3d. %s\n", i + 1, catalog.get(i).getTitle());
        }
        System.out.println();
    }

    public void showUsers() {
        for (int i = 0; i < users.size(); i++) {
            System.out.printf("%3d. %20s %20s %20s\n", i + 1, users.get(i).getUserId(), users.get(i).getFirstName(), users.get(i).getLastName());
        }
        System.out.println();
    }

    public void searchBookByTitle(String title) {
        boolean bookFound = false;
        for (Book book : catalog) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                book.printInformation();
                bookFound = true;
            }
        }
        if (!bookFound) {
            System.out.println("No books found containing \"" + title + "\" in the title.");
            System.out.println();
        }
    }

    public void searchBookByAuthor(String author) {
        boolean bookFound = false;
        for (Book book : catalog) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                book.printInformation();
                bookFound = true;
            }
        }
        if (!bookFound) {
            System.out.println("No books found from \"" + author + "\".");
            System.out.println();
        }
    }

    public void addBook(Book book) {
        catalog.add(book);

        try {
            // open the existing workbook
            FileInputStream inputStream = new FileInputStream("resources/Library.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            // get the existing sheet or create a new one
            Sheet sheet = workbook.getSheet("Sheet1");
            if (sheet == null) {
                sheet = workbook.createSheet("Sheet1");
            }

            // add the new user to the end of the sheet
            Row row = sheet.createRow(sheet.getLastRowNum() + 1);

            Cell cell = row.createCell(0);
            cell.setCellValue(book.getTitle());

            cell = row.createCell(1);
            cell.setCellValue(book.getAuthor());

            cell = row.createCell(2);
            cell.setCellValue(book.getSubtitle());

            cell = row.createCell(3);
            cell.setCellValue(book.getIsbn());

            cell = row.createCell(4);
            cell.setCellValue(book.getPublisher());

            cell = row.createCell(5);
            cell.setCellValue(book.getPublicationYear());

            cell = row.createCell(6);
            cell.setCellValue(book.getPublicationMonth());

            cell = row.createCell(7);
            cell.setCellValue(book.getPublicationDay());

            cell = row.createCell(8);
            cell.setCellValue(book.getGenre());

            cell = row.createCell(9);
            cell.setCellValue(book.getLanguage());

            cell = row.createCell(10);
            cell.setCellValue(book.getInventory());

            // write the updated workbook back to the file
            FileOutputStream outputStream = new FileOutputStream("resources/Library.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        users.add(user);

        try {
            // open the existing workbook
            FileInputStream inputStream = new FileInputStream("resources/Members.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            // get the existing sheet or create a new one
            Sheet sheet = workbook.getSheet("Members");
            if (sheet == null) {
                sheet = workbook.createSheet("Members");
            }

            // add the new user to the end of the sheet
            Row row = sheet.createRow(sheet.getLastRowNum() + 1);

            Cell cell = row.createCell(0);
            cell.setCellValue(user.getUserId());

            cell = row.createCell(1);
            cell.setCellValue(user.getFirstName());

            cell = row.createCell(2);
            cell.setCellValue(user.getLastName());

            cell = row.createCell(3);
            cell.setCellValue(user.getEmail());

            cell = row.createCell(4);
            cell.setCellValue(user.getPhoneNumber());

            // write the updated workbook back to the file
            FileOutputStream outputStream = new FileOutputStream("resources/Members.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User findUserByName(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public static Book findBookByName(String bookName) {
        for (Book book : catalog) {
            if (book.getTitle().equals(bookName)) {
                return book;
            }
        }
        return null; // book not found
    }

}



//    public void searchBookByTitle(String title) {
//        boolean bookFound = false;
//        for (Book book : catalog) {
//        if (book.getTitle().equalsIgnoreCase(title)) {
//            book.printInformation();
//            bookFound = true;
//            }
//        }
//        if (!bookFound) {
//        System.out.println("Book not found.");
//        }
//    }

//    public void searchBookByAuthor(String author) {
//        boolean bookFound = false;
//        for (Book book : catalog) {
//            if (book.getAuthor().equalsIgnoreCase(author)) {
//                book.printInformation();
//            }
//            bookFound = true;
//        }
//        if (!bookFound) {
//            System.out.println("No books by this author.");
//        }
//    }

//    boolean found = false;
//        for (Book book : catalog) {
//        if (book.getTitle().equals(title)) {
//            book.printInformation();
//            found = true;
//            break;
//        }
//    }
//        if (!found) {
//        System.out.println("Book not found.");
//    }

//    boolean bookFound = false;
//                    for (Book book : hhs.getCatalog()) {
//        if (book.getTitle().equalsIgnoreCase(bookName)) {
//            book.printInformation();
//            bookFound = true;
//        }
//    }
//                    if (!bookFound) {
//        System.out.println("Book not found.");
//    }
//
//                    System.out.println("Back to menu? (y/n)");
//                    System.out.print("Answer: ");
//    answer = scanner.nextLine();
//
//                    if (answer.equals("n")) {
//        running = false;
//        printExitMessage();
//    } else {
//        System.out.println();
//        continue;
//    }

//    public void searchBookByTitle(String title) {
//        ArrayList<Book> searchResult = new ArrayList<>();
//        for (Book book : catalog) {
//            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
//                searchResult.add(book);
//            }
//        }
//        if (searchResult.isEmpty()) {
//            System.out.println("No books found.");
//        } else {
//            System.out.println("Search result:");
//            for (int i = 0; i < searchResult.size(); i++) {
//                System.out.println((i + 1) + ". " + searchResult.get(i).getTitle());
//                searchResult.get(i).printInformation();
//            }
//        }
//    }

//    public void searchBookByTitle(String title) {
//
//        for (Book book: catalog) {
//            if (book.getTitle().equals(title)) {
//                book.printInformation();
//            }
//        }
//    }

//    public void searchBookByAuthor(String author) {
//
//        for (Book book: catalog) {
//            if (book.getAuthor1().equals(author) || book.getAuthor2().equals(author) || book.getAuthor3().equals(author)) {
//                printInformation(book);
//            }
//        }
//    }
//
//    public void searchByISBN(long isbn) {
//
//        for (Book book: catalog) {
//            if (book.getIsbn() == isbn) {
//                printInformation(book);
//            }
//        }
//    }
