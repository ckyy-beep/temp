package com.libraryhhs.item;

import com.libraryhhs.user.User;

public class CD extends LibraryItem implements Borrowable {

    public CD(String title, String author, String year) {
        super(title, author, year);
    }

    @Override
    public void borrow(User user) {

    }
}
