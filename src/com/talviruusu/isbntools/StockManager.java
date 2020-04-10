package com.talviruusu.isbntools;

public class StockManager {

    private ExternalISBNDataService databaseService;
    private ExternalISBNDataService webService;

    public void setWebService(ExternalISBNDataService webService) {
        this.webService = webService;
    }

    public void setDatabaseService(ExternalISBNDataService databaseService) {
        this.databaseService = databaseService;
    }

    public String getLocatorCode(String isbn) {
        Book book = databaseService.lookup(isbn);
        if (book == null) book = webService.lookup(isbn);
        return isbn.substring(isbn.length() - 4) +
                book.getAuthor().substring(0, 1) +
                book.getTitle().split(" ").length;
    }
}
