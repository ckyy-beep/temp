package com.libraryhhs.item;

import com.libraryhhs.user.User;

public class Manga extends LibraryItem implements Borrowable {
    private boolean borrowed;
    private String borrower;

    public Manga(String title, String author, String year) {
        super(title, author, year);
        borrowed = false;
        borrower = null;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    @Override
    public void borrow(User user) {
        if (!borrowed) {
            borrowed = true;
            borrower = user.getFirstName();
            System.out.println(user.getFirstName() + " has borrowed " + getTitle() + ".");
        } else {
            System.out.println(getTitle() + " is already borrowed by " + borrower + ".");
        }
    }
}