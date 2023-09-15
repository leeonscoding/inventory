package com.leeonscoding.inventory.api;

import com.leeonscoding.inventory.contact.ContactType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validator {
    public static boolean phoneValidate(String phoneNumber) {
        Pattern pattern = Pattern.compile("\\d{5,}");

        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.find();
    }

    public static boolean validateContactType(ContactType contactType) {
        if(contactType == null) {
            return false;
        } else {
            return contactType.equals(ContactType.SELLER) || contactType.equals(ContactType.CUSTOMER);
        }
    }
}
