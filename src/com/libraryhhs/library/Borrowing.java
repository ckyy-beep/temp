package com.libraryhhs.library;

import com.libraryhhs.item.Book;
import com.libraryhhs.user.User;

import java.time.LocalDate;

public class Borrowing {
    private Book book; // The book that's being borrowed.
    private User borrower; // The person borrowing the book.
    private LocalDate borrowDate; // The date the book was borrowed.
    private LocalDate dueDate; // The date the book is due.
    private boolean isReturned; // Whether the book has been returned or not.

    public Borrowing(Book book, User borrower, LocalDate borrowDate, LocalDate dueDate) {
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.isReturned = false;
    }

    public Book getBook() {return book;}
    public void setBook(Book book) {this.book = book;}
    public User getBorrower() {return borrower;}
    public void setBorrower(User borrower) {this.borrower = borrower;}
    public LocalDate getBorrowDate() {return borrowDate;}
    public void setBorrowDate(LocalDate borrowDate) {this.borrowDate = borrowDate;}
    public LocalDate getDueDate() {return dueDate;}
    public boolean isReturned() {return isReturned;}
    public void returnBook() {isReturned = true;}

    // method to calculate overdue days
    public long getOverdueDays() {
        if (isReturned() || LocalDate.now().isBefore(dueDate)) {
            return 0;
        } else {
            return dueDate.toEpochDay() - LocalDate.now().toEpochDay();
        }
    }

    // method to calculate overdue fine
    public double getOverdueFine() {
        long overdueDays = getOverdueDays();
        double finePerDay = 0.50;
        return overdueDays * finePerDay;
    }
}