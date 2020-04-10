package com.talviruusu.isbntools;

public class ValidateISBN {

    public static final int LONG_ISBN_LENGTH = 13;
    public static final int SHORT_ISBN_LENGTH = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;
    public static final int LONG_ISBN_MULTIPLIER = 10;

    public boolean checkISBN(String isbn) {

        if(isbn.length() == LONG_ISBN_LENGTH)  return isLongISBN(isbn);
        if(isbn.length() == SHORT_ISBN_LENGTH) return  isShortISBN(isbn);

        throw new NumberFormatException("ISBN number must be 10 or 13 digits long.");
    }

    private boolean isShortISBN(String isbn) {
        int total = 0;

        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            char currentChar = isbn.charAt(i);
            if (!Character.isDigit(currentChar)) {
                if (i == 9 && currentChar == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException("Only last digit can be a non-numeric digit in short ISBN");
                }
            } else {
                total += Character.getNumericValue(currentChar) * (SHORT_ISBN_LENGTH - i);
            }
        }

        return (total % SHORT_ISBN_MULTIPLIER == 0);
    }

    private boolean isLongISBN(String isbn) {
        int total = 0;

        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
            char currentChar = isbn.charAt(i);

            if (!Character.isDigit(currentChar)) throw new NumberFormatException("All values on ISBN must be numeric digits in long ISBN");

            if (i % 2 == 0) {
                total += Character.getNumericValue(currentChar);
            } else {
                total += Character.getNumericValue(currentChar) * 3;
            }
        }

        return (total %  LONG_ISBN_MULTIPLIER == 0);
    }
}
