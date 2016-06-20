package com.thoughtworks.biblioteca;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        PrintStream printStream = System.out;

        Collection<Book> booksInLibrary = new ArrayList<>();
        Collection<Book> checkedOutBooks = new ArrayList<>();
        Book book = new Book("A book", "Jason Bourne", 2000);
        booksInLibrary.add(book);
        Book book2 = new Book("Cats", "Cat Lady", 2015);
        booksInLibrary.add(book2);

        BookFinder bookFinder = new BookFinder();
        Library library = new Library(printStream, booksInLibrary, checkedOutBooks, bookFinder);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Input input = new Input(reader);
        Quitter quitter = new Quitter();

        Map<String, Command> commandsMap = new TreeMap<>();
        commandsMap.put("1", new ListBooksCommand(library));
        commandsMap.put("2", new CheckoutCommand(printStream, input, library));
        commandsMap.put("3", quitter);

        MainMenu mainMenu = new MainMenu(printStream, input, commandsMap);

        new Application(printStream, mainMenu, quitter).start();
    }
}
