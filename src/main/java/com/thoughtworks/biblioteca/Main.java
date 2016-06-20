package com.thoughtworks.biblioteca;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        PrintStream printStream = System.out;

        Collection<Book> books = new ArrayList<>();
        Book book = new Book("A book", "Jason Bourne", 2000);
        books.add(book);
        Book book2 = new Book("Cats", "Cat Lady", 2015);
        books.add(book2);

        Library library = new Library(printStream, books);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Input input = new Input(reader);
        Quitter quitCommand = new Quitter();

        Map<String, Command> commandsMap = new TreeMap<>();
        commandsMap.put("1", new ListBooksCommand(library));
        commandsMap.put("2",new CheckoutCommand(printStream, input, library));
        commandsMap.put("3", quitCommand);

        MainMenu mainMenu = new MainMenu(printStream, library, input, quitCommand, commandsMap);

        new ApplicationX(library, printStream, mainMenu).start();
    }
}
