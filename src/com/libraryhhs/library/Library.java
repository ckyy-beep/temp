package com.libraryhhs.library;

import com.libraryhhs.item.Book;

import java.util.ArrayList;

public class Library {
    private String libraryName;
    private ArrayList<Book> catalog;
    private ArrayList<User> users;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        catalog = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void setBooks(ArrayList<Book> books) {
        this.catalog = books;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void addBook(Book book) {
        catalog.add(book);
    }

    public ArrayList<Book> getCatalog() {
        return catalog;
    }

    public void addUser(User user) {
        users.add(user);
    }

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
            System.out.println("No books found containing \"" + author + "\" in the title.");
        }
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
