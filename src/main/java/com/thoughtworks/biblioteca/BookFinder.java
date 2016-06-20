package com.thoughtworks.biblioteca;

import java.util.Collection;

public class BookFinder {
    public Book findBook(Collection<Book> books, String bookTitle) {
        for(Book book : books){
            if(book.getTitle().equals(bookTitle)){
                return book;
            }
        }
        return null;
    }
}
