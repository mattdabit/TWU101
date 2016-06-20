package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Mockito.*;


public class LibraryTest {

    private PrintStream printStream;
    private Book book;
    private Map<String, Book> booksInLibrary;
    private Map<String, Book> checkedOutBooks;
    private Library library;


    @Before
    public void setUp() throws Exception {
        book = mock(Book.class);
        printStream = mock(PrintStream.class);

        booksInLibrary = new HashMap<>();
        when(book.getTitle()).thenReturn("Stardust");
        booksInLibrary.put(book.getTitle(), book);
        checkedOutBooks = new HashMap<>();

        library = new Library(printStream, booksInLibrary, checkedOutBooks);
    }

    @Test
    public void shouldPrintBookDescriptionWhenListingBooks(){

        library.listBooks();

        verify(book).getDescription();
    }

    @Test
    public void shouldPrintMultipleBookDescriptionsWhenThereAreMultipleBooks(){
        Book book2 = mock(Book.class);
        when(book2.getTitle()).thenReturn(("rr"));
        booksInLibrary.put(book2.getTitle(), book2);
        library.listBooks();

        verify(book).getDescription();
        verify(book2).getDescription();
    }


    @Test
    public void shouldNotDisplayBookWhenCheckedOut(){
        library.checkOutBook("Stardust");
        library.listBooks();
        verify(book, never()).getDescription();
    }

    @Test
    public void shouldPrintSuccessfulCheckoutWhenBookIsCheckedOut() {
        library.checkOutBook("Stardust");
        verify(printStream).println("Thank you! Enjoy the book");
    }


    @Test
    public void shouldPrintUnsuccessfulCheckoutWhenBookIsNotInLibrary() {
        library.checkOutBook("Garbage");
        verify(printStream).println("That book is not available.");
    }
}