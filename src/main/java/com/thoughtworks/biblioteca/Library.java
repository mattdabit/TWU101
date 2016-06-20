package com.thoughtworks.biblioteca;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Map;

public class Library {

    private PrintStream printStream;
    private Collection<Book> books;

    public Library(PrintStream printStream, Collection books) {
        this.printStream = printStream;
        this.books = books;
    }

    public void listBooks() {
        for(Book book : books){
            printStream.println(book.getDescription());
        }
    }

    public void checkOutBook(String bookTitle, String bookAuthor) {

    }
}
