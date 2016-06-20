package com.thoughtworks.biblioteca;

public class Quitter implements Command {
    private boolean shouldContinue;

    public Quitter(){
        this.shouldContinue = true;
    }
    @Override
    public void executeCommand() {
        shouldContinue = false;
    }

    @Override
    public String menuRepresentation() {
        return "Quit";
    }


    public boolean continueProgram() {
        return shouldContinue;
    }
}

