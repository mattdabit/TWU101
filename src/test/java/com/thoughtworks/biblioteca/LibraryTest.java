package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Mockito.*;


public class LibraryTest {

    private PrintStream printStream;
    private Book book;
    private Collection<Book> booksInLibrary;
    private Collection<Book> checkedOutBooks;
    private Library library;
    private BookFinder bookFinder;


    @Before
    public void setUp() throws Exception {
        book = mock(Book.class);
        printStream = mock(PrintStream.class);
        bookFinder = mock(BookFinder.class);

        booksInLibrary = new ArrayList<>();
        booksInLibrary.add(book);
        checkedOutBooks = new ArrayList<>();

        library = new Library(printStream, booksInLibrary, checkedOutBooks, bookFinder);
    }

    @Test
    public void shouldPrintBookDescriptionWhenListingBooks(){

        library.listBooks();

        verify(book).getDescription();
    }

    @Test
    public void shouldPrintMultipleBookDescriptionsWhenThereAreMultipleBooks(){
        booksInLibrary.add(book);
        library.listBooks();

        verify(book, times(2)).getDescription();
    }


    @Test
    public void shouldNotDisplayBookWhenCheckedOut(){
        when(bookFinder.findBook(booksInLibrary, "Garbage")).thenReturn(book);
        library.checkOutBook("Garbage");
        library.listBooks();
        verify(book, never()).getDescription();
    }
}