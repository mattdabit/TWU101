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
        printStream.println("Please enter the book author!");
        String bookAuthor = inputReader.receiveUserCommand();
        library.checkOutBook(bookTitle, bookAuthor);
    }

    @Override
    public String menuRepresentation() {
        return "2. Checkout Book";
    }
}
