package com.libraryhhs.item;

import com.libraryhhs.user.User;

public class Book extends LibraryItem {
    private String subtitle;
    private String Isbn;
    private String publisher;
    private String  publicationMonth;
    private String publicationDay;
    private String genre;
    private String language;
    private int inventory;

    public Book(String title, String author, String subtitle, String ISBN, String publisher, String publicationYear,
                String publicationMonth, String publicationDay, String genre, String language, int inventory) {
        super(title, author, publicationYear, "Book");
        this.subtitle = subtitle;
        this.Isbn = ISBN;
        this.publisher = publisher;
        this.publicationMonth = publicationMonth;
        this.publicationDay = publicationDay;
        this.genre = genre;
        this.language = language;
        this.inventory = inventory;
    }

    public void printInformation() {

        System.out.printf("%-10s %s\n", "Title     :", getTitle());
        if (!subtitle.equals("")) {
            System.out.printf("%-10s %s\n", "Subtitle  :", subtitle);
        }
        System.out.printf("%-10s %s\n", "Author    :", getAuthor());

        System.out.printf("%-10s %s\n", "ISBN      :", getIsbn());
        if (!year.equals("")  && publicationMonth.equals("") && publicationDay.equals("")) {
            System.out.printf("%-10s %4s\n", "Published :", year);
        }
        else if (!year.equals("")  && !publicationMonth.equals("") && !publicationDay.equals("")) {
            if (publicationMonth.length() < 2 && publicationDay.length() < 2) {
                System.out.printf("%-10s 0%s 0%s %4s\n", "Published :", publicationDay, publicationMonth, year);
            }
            else if (publicationMonth.length() < 2 && publicationDay.length() == 2) {
                System.out.printf("%-10s %2s 0%s %4s\n", "Published :", publicationDay, publicationMonth, year);
            }
            else if (publicationMonth.length() == 2 && publicationDay.length() < 2) {
                System.out.printf("%-10s 0%s %2s %4s\n", "Published :", publicationDay, publicationMonth, year);
            }
            else {
                System.out.printf("%-10s %2s %2s %4s\n", "Published :", publicationDay, publicationMonth, year);
            }
        }

        System.out.printf("%-10s %s\n", "Inventory :", inventory);
        System.out.println();

    }

    // Getters and setters
    public String getSubtitle() {
        return subtitle;
    }
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
    public String getIsbn() {
        return Isbn;
    }
    public void setISBN(String ISBN) {
        this.Isbn = ISBN;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getPublicationMonth() {
        return publicationMonth;
    }
    public void setPublicationMonth(String publicationMonth) {
        this.publicationMonth = publicationMonth;
    }
    public String getPublicationDay() {
        return publicationDay;
    }
    public void setPublicationDay(String publicationDay) {this.publicationDay = publicationDay;}
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public int getInventory() {
        return inventory;
    }
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return  "Title        : " + title          + "\n" +
                "Subtitle     : " + subtitle       + "\n" +
                "Author       : " + author         + "\n" +
                "ISBN         : " + Isbn           + "\n" +
                "Publisher    : " + publisher      + "\n" +
                "Publish date : " + publicationDay + " " + publicationMonth + " " + year + "\n" +
                "Genre        : " + genre          + "\n" +
                "Language     : " + language       + "\n" +
                "Item Type    : " + itemType       + "\n\n";
    }
}
