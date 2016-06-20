package com.thoughtworks.biblioteca;
import java.io.PrintStream;
import java.util.Collection;

public class Library {

    private PrintStream printStream;
    private Collection<Book> booksInLibrary;
    private Collection<Book> checkedOutBooks;
    private BookFinder bookFinder;

    public Library(PrintStream printStream, Collection<Book> booksInLibrary, Collection<Book> checkedOutBooks, BookFinder bookFinder) {
        this.printStream = printStream;
        this.booksInLibrary = booksInLibrary;
        this.checkedOutBooks = checkedOutBooks;
        this.bookFinder = bookFinder;
    }

    public void listBooks() {
        for(Book book : booksInLibrary){
            printStream.println(book.getDescription());
        }
    }

    public void checkOutBook(String bookTitle) {
        Book bookToCheckOut = bookFinder.findBook(booksInLibrary, bookTitle);
        checkedOutBooks.add(bookToCheckOut);
        booksInLibrary.remove(bookToCheckOut);
    }


}
