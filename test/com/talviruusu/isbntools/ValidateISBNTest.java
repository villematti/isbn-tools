package com.talviruusu.isbntools;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTest {

    @Test
    public void checkAValidISBN() {
        ValidateISBN validateISBN = new ValidateISBN();
        boolean result =  validateISBN.checkISBN("0140449116");
        assertTrue("first value", result);
        result = validateISBN.checkISBN("0140177396");
        assertTrue("second value", result);
    }

    @Test
    public void checkAnInvalidISBN() {
        ValidateISBN validateISBN = new ValidateISBN();
        boolean result = validateISBN.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class )
    public void nineDigitIsNotAllowed() {
        ValidateISBN validateISBN = new ValidateISBN();
        validateISBN.checkISBN("123456789");
    }

    @Test(expected = NumberFormatException.class)
    public void nonNumericISBNAreNotAllowed() {
        ValidateISBN validateISBN = new ValidateISBN();
        validateISBN.checkISBN("helloworld");
    }
}
