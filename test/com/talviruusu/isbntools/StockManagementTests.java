package com.talviruusu.isbntools;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class StockManagementTests {

    @Test
    public void testCanGetCorrectLocatorCode () {

        String isbn = "0140177396";

        ExternalISBNDataService testWebService = mock(ExternalISBNDataService.class);
        when(testWebService.lookup(any())).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));

        ExternalISBNDataService testDBService = mock(ExternalISBNDataService.class);
        when(testDBService.lookup(any())).thenReturn(null);

        StockManager stockManager = new StockManager();

        stockManager.setWebService(testWebService);
        stockManager.setDatabaseService(testDBService);

        String locatorCode  =  stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }

    @Test
    public void databaseIsUsedIfDataIsPresent() {
        ExternalISBNDataService databaseService = mock(ExternalISBNDataService.class);
        ExternalISBNDataService webService = mock(ExternalISBNDataService.class);

        StockManager stockManager = new StockManager();

        stockManager.setWebService(webService);
        stockManager.setDatabaseService(databaseService);

        String isbn = "0140177396";

        when(databaseService.lookup(isbn)).thenReturn(new Book(isbn, "abc", "abc"));

        stockManager.getLocatorCode(isbn);
        verify(databaseService).lookup(isbn);
        verify(webService, never()).lookup(anyString());
    }

    @Test
    public void webServiceIsUsedIfDataIsNotPresentInDatabase() {
        ExternalISBNDataService databaseService = mock(ExternalISBNDataService.class);
        ExternalISBNDataService webService = mock(ExternalISBNDataService.class);

        StockManager stockManager = new StockManager();

        stockManager.setWebService(webService);
        stockManager.setDatabaseService(databaseService);

        String isbn = "0140177396";

        when(databaseService.lookup(isbn)).thenReturn(null);
        when(webService.lookup(isbn)).thenReturn(new Book(isbn, "abc", "abc"));

        stockManager.getLocatorCode(isbn);
        verify(databaseService).lookup(isbn);
        verify(webService).lookup(isbn);
    }
}
