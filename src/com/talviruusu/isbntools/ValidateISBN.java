package com.talviruusu.isbntools;

public class ValidateISBN {

    public boolean checkISBN(String isbn) {
        if (isbn.length() != 10) throw new NumberFormatException("ISBN number must be 10 digits long.");

        double total = 0.0;

        for (int i = 0;i < 10;i++) {
            char currentChar = isbn.charAt(i);
            if (!Character.isDigit(currentChar)) throw  new NumberFormatException("All values on ISBN must be digits");
            total += currentChar * (10 - i);
        }

        if (total % 11 == 0.0) {
            return true;
        } else {
            return false;
        }
    }
}
