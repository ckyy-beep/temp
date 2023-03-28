package com.libraryhhs.user;

import com.libraryhhs.item.Book;

import java.util.ArrayList;

public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private ArrayList<Book> borrowingBooks;

    public User(String userId, String firstName, String lastName, String email, String phoneNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowingBooks = new ArrayList<>();
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void addBorrowBook(Book book) {
        borrowingBooks.add(book);
    }

//    public void returnBorrowedBook(Book book) {
//        borrowingBooks.remove(book);
//    }

    public void printMe() {
        System.out.println("This is a user ccount.");
    }

    public boolean returnBorrowedBook(Book book) {
        if (borrowingBooks.contains(book)) {
            borrowingBooks.remove(book);
            book.setInventory(book.getInventory() + 1);
            return true;
        } else {
            return false;
        }
    }
}
