package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class Application {
    private PrintStream printStream;
    private MainMenu mainMenu;
    private Quitter quitter;

    public Application(PrintStream printStream, MainMenu mainMenu, Quitter quitter) {
        this.printStream = printStream;
        this.mainMenu = mainMenu;
        this.quitter = quitter;
    }

    public void start() {
        printStream.println("Welcome");
        while(quitter.continueProgram()){
            mainMenu.display();
            mainMenu.executeUserCommand();
        }
    }

}
