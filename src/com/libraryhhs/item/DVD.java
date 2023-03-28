package com.libraryhhs.item;

public class DVD extends LibraryItem {

    private String director;
    private String duration;
    private String rating;

    public DVD(String title, String year, String director, String duration, String rating) {
        super(title, "(Director)", year,"DVD");
        this.director = director;
        this.duration = duration;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return  "Title       : " + title    + "\n" +
                "Director    : " + director + "\n" +
                "Duration    : " + duration + "\n" +
                "Rating      : " + rating   + "\n" +
                "Year        : " + year     + "\n" +
                "Item Type   : " + itemType + "\n\n";
    }
}
