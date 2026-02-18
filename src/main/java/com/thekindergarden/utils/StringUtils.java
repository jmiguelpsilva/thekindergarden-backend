package com.thekindergarden.utils;

public class StringUtils {

    public static String getFirstAndLastName(String fullName) {
        String[] namesArr = fullName.split(" ");
        if (namesArr.length == 0) {
            return "nameless";
        }
        if (namesArr.length > 1) {
            String firstName = namesArr[0];
            String lastName = namesArr[namesArr.length - 1];
            return (firstName + " " + lastName).trim();
        } else
            return namesArr[0];
    }

    public static boolean verifyPhoneNumberIsValid(String phoneNumber) {
        // Check if the phone number is null or empty
        if (phoneNumber != null && phoneNumber.length() == 9) {
            // TODO: add regex to verify phone number is valid
        }

        return false;
    }
}
