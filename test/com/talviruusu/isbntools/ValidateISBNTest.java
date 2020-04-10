package com.talviruusu.isbntools;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTest {

    @Test
    public void checkAValid10DigitsISBN() {
        ValidateISBN validateISBN = new ValidateISBN();
        boolean result =  validateISBN.checkISBN("0140449116");
        assertTrue("first value", result);
        result = validateISBN.checkISBN("0140177396");
        assertTrue("second value", result);
    }

    @Test
    public void TenDigitsISBNNumbersEndingInAnXAreValid() {
        ValidateISBN validateISBN = new ValidateISBN();
        boolean result =  validateISBN.checkISBN("012000030X");
        assertTrue(result);
    }

    @Test
    public void checkAnInvalid10DigitsISBN() {
        ValidateISBN validateISBN = new ValidateISBN();
        boolean result = validateISBN.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test
    public void checkAValid13DigitsISBN() {
        ValidateISBN validateISBN = new ValidateISBN();
        boolean result = validateISBN.checkISBN("9781644450000");
        assertTrue("first value", result);
        result = validateISBN.checkISBN("9781853260087");
        assertTrue("second value", result);
    }

    @Test
    public void checkAnInvalid13DigitsISBN() {
        ValidateISBN validateISBN = new ValidateISBN();
        boolean result = validateISBN.checkISBN("9781644450006");
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
