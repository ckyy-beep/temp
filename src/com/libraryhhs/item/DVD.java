package com.libraryhhs.item;

import com.libraryhhs.user.User;

public class DVD extends LibraryItem implements Borrowable {

    public DVD(String title, String author, String year) {
        super(title, author, year);
    }

    @Override
    public void borrow(User user) {

    }
}
