package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class ApplicationX {
    private PrintStream printStream;
    private Library library;
    private MainMenu mainMenu;

    public ApplicationX(Library library, PrintStream printStream, MainMenu mainMenu) {
        this.printStream = printStream;
        this.library = library;
        this.mainMenu = mainMenu;
    }

    public void start() {
        printStream.println("Welcome");
        mainMenu.startMenuSession();
    }

}
