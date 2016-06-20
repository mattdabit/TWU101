package com.thoughtworks.biblioteca;


import java.io.PrintStream;
import java.util.Map;

public class MainMenu {
    private Input inputReader;
    private PrintStream printStream;
    private Map<String, Command> commandMap;

    public MainMenu(PrintStream printStream, Input inputReader, Map<String, Command> commandMap) {

        this.printStream = printStream;
        this.inputReader = inputReader;
        this.commandMap = commandMap;
    }


    public void display() {
        for (String key : commandMap.keySet()) {
            printStream.println(key + ". " + commandMap.get(key).menuRepresentation());
        }
    }

    public void executeUserCommand() {
        String input = inputReader.receiveUserCommand();

        if(commandMap.containsKey(input)){
            Command userCommand = commandMap.get(input);
            userCommand.executeCommand();

        } else {
            printStream.println("Select a valid option!");
        }
    }
}
