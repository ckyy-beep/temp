package com.libraryhhs.item;

public class Manga extends LibraryItem  {

    private String numVolumes;

    public Manga(String title, String author, String year, String numVolumes) {
        super(title, author, year, "Manga");
        this.numVolumes = numVolumes;
    }

    @Override
    public String toString() {
        return  "Title          : "  + title      + "\n" +
                "Author         : "  + author     + "\n" +
                "# of volumes   : "  + numVolumes + "\n" +
                "Year           : "  + year       + "\n" +
                "Item Type      : "  + itemType   + "\n\n";
    }
}

//    public boolean isBorrowed() {
//        return borrowed;
//    }
//
//    public void setBorrowed(boolean borrowed) {
//        this.borrowed = borrowed;
//    }
//
//    public String getBorrower() {
//        return borrower;
//    }
//
//    public void setBorrower(String borrower) {
//        this.borrower = borrower;
//    }

//    @Override
//    public void borrow(User user) {
//        if (!borrowed) {
//            borrowed = true;
//            borrower = user.getFirstName();
//            System.out.println(user.getFirstName() + " has borrowed " + getTitle() + ".");
//        } else {
//            System.out.println(getTitle() + " is already borrowed by " + borrower + ".");
//        }
//    }
