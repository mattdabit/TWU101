package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class BookFinderTest {

        @Test
        public void shouldReturnBookWhenFindBookIsCalled() {
            Book book = new Book("A Book", "Author", 1994);
            Collection<Book> books = new ArrayList<>();
            books.add(book);

        }
}