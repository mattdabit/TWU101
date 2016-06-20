package com.thoughtworks.biblioteca;
import java.io.PrintStream;
import java.util.Map;

public class Library {

    private PrintStream printStream;
    private Map<String, Book> booksInLibrary;
    private Map<String, Book> checkedOutBooks;

    public Library(PrintStream printStream, Map<String, Book> booksInLibrary, Map<String, Book> checkedOutBooks) {
        this.printStream = printStream;
        this.booksInLibrary = booksInLibrary;
        this.checkedOutBooks = checkedOutBooks;
    }

    public void listBooks() {
        for(Book book : booksInLibrary.values()){
            printStream.println(book.getDescription());
        }
    }

    public void checkOutBook(String bookTitle) {
        if (booksInLibrary.containsKey(bookTitle)){
            checkedOutBooks.put(bookTitle, booksInLibrary.get(bookTitle));
            booksInLibrary.remove(bookTitle);
            printStream.println("Thank you! Enjoy the book");
        }else{
            printStream.println("That book is not available.");
        }

    }


}
