package com.libraryhhs.user;

public class Student extends User {

    public Student(String userId, String firstName, String lastName, String email, String phoneNumber) {
        super(userId, firstName, lastName, email, phoneNumber);
    }

    @Override
    public void printMe() {
        System.out.println("This is a student account.");
    }




}
