package com.libraryhhs.item;

public class LibraryItem {
    protected String title;
    protected String author;
    protected String year;
    protected String itemType;
//    protected boolean borrowed;
//    protected String borrower;

    public LibraryItem(String title, String author, String year, String itemType) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.itemType = itemType;
//        borrowed = false;
//        borrower = null;
    }

    public void setTitle(String title) {this.title = title;}
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPublicationYear(String publicationYear) {this.year = publicationYear;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public String getPublicationYear() {
        return year;
    }

    public String toString() {
        return  "Title    : " + title    + "\n" +
                "Author   : " + author   + "\n" +
                "Year     : " + year     + "\n" +
                "Item Type: " + itemType + "\n\n";
    }
}

//    public void returnItem() {
//        if (borrowed) {
//            System.out.println(getTitle() + " has been returned to the library.");
//            borrowed = false;
//            borrower = null;
//        } else {
//            System.out.println(getTitle() + " was not borrowed.");
//        }
//    }