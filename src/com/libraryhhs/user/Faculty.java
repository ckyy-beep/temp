package com.libraryhhs.user;

import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;

public class Faculty extends User {

    public Faculty(String userId, String firstName, String lastName, String email, String phoneNumber) {
        super(userId, firstName, lastName, email, phoneNumber);
    }

    @Override
    public void printMe() {
        System.out.println("This is a faculty account.");
    }

}
