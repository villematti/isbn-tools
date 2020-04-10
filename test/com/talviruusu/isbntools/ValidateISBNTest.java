package com.talviruusu.isbntools;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ValidateISBNTest {

    @Test
    public void checkValidISBN() {
        ValidateISBN validateISBN = new ValidateISBN();
        boolean result =  validateISBN.checkISBN(140449116);
        assertTrue(result);
    }
}
