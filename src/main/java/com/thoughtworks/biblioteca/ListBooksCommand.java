package com.thoughtworks.biblioteca;

public class ListBooksCommand implements Command {

    private Library library;

    public ListBooksCommand(Library library){
        this.library = library;
    }

    @Override
    public void executeCommand() {
        library.listBooks();
    }

    @Override
    public String menuRepresentation() {
        return "1. List Books";
    }
}

