package com.talviruusu.isbntools;

public interface ExternalISBNDataService {
    Book lookup(String isbn);
}
