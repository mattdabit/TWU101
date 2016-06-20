package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class CheckoutCommand implements Command {
    private PrintStream printStream;
    private Input inputReader;
    private Library library;

    public CheckoutCommand(PrintStream printStream, Input inputReader, Library library){
        this.printStream = printStream;
        this.inputReader = inputReader;
        this.library = library;
    }

    @Override
    public void executeCommand() {
        printStream.println("Please enter the book title you want to checkout!");
        String bookTitle = inputReader.receiveUserCommand();

        library.checkOutBook(bookTitle);
    }

    @Override
    public String menuRepresentation() {
        return "Checkout Book";
    }
}
