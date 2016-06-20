package com.thoughtworks.biblioteca;


import java.io.PrintStream;
import java.util.Map;

public class MainMenu {
    private Input inputReader;
    private Quitter quitter;
    private PrintStream printStream;
    private Library library;
    private Map<String, Command> commandMap;

    public MainMenu(PrintStream printStream, Library library, Input inputReader, Quitter quitter, Map<String, Command> commandMap) {

        this.printStream = printStream;
        this.library = library;
        this.inputReader = inputReader;
        this.quitter = quitter;
        this.commandMap = commandMap;
    }

    public void startMenuSession() {
        String input = "";
        while(quitter.continueProgram()){
            display();
            input = inputReader.receiveUserCommand();
            executeUserCommand(input);
        }
    }

    public void display() {
        for (Command command : commandMap.values()) {
            printStream.println(command.menuRepresentation());
        }
    }


    public void executeUserCommand(String input) {

        if(commandMap.containsKey(input)){
            Command userCommand = commandMap.get(input);
            userCommand.executeCommand();

        } else {
            printStream.println("Select a valid option!");
        }
    }
}
