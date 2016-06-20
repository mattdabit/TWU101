package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;


public class LibraryTest {

    private PrintStream printStream;
    private Book book;
    private Collection<Book> books;

    @Before
    public void setUp() throws Exception {
        book = mock(Book.class);
        when(book.getDescription()).thenReturn("Foo");
        printStream = mock(PrintStream.class);

        books = new ArrayList<>();
        books.add(book);

    }

    @Test
    public void shouldPrintBookDescriptionWhenListingBooks(){

        Library library = new Library(printStream, books);
        library.listBooks();

        verify(book).getDescription();
        verify(printStream).println(contains("Foo"));
    }

    @Test
    public void shouldPrintMultipleBookDescriptionsWhenThereAreMultipleBooks(){
        books.add(book);
        Library library = new Library(printStream, books);
        library.listBooks();

        verify(printStream, times(2)).println(contains("Foo"));

    }

//    @Ignore
//    public void shouldNotDisplayBookWhenCheckedOut(){
//        Book book = new Book("A book", "Jason Bourne", 2000);
//        Collection<Book> books = new ArrayList<>();
//        books.add(book);
//        Library library = new Library(printStream, books);
//        library.checkOutBook(bookTitle, "A book");
//        library.listBooks();
//        verify(printStream).println(not(contains("A book")));
//    }
}