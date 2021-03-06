package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class MainMenuTest {

    private PrintStream printStream;
    private MainMenu mainMenu;
    private Library library;
    private Input inputReader;
    private Quitter quitter;
    private ListBooksCommand listBookCommand;
    private CheckoutCommand checkoutCommand;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        inputReader = mock(Input.class);
        quitter = mock(Quitter.class);
        listBookCommand = mock(ListBooksCommand.class);
        checkoutCommand = mock(CheckoutCommand.class);

        Map<String, Command> commandsMap = new HashMap<>();
        commandsMap.put("1",listBookCommand );
        commandsMap.put("2", checkoutCommand);
        commandsMap.put("3", quitter);

        mainMenu = new MainMenu(printStream, inputReader, commandsMap);

    }

    @Test
    public void shouldShowListBooksOption(){
        mainMenu.display();
        verify(listBookCommand).menuRepresentation();
        verify(checkoutCommand).menuRepresentation();
        verify(quitter).menuRepresentation();

    }


    @Test
    public void shouldGiveInvalidInputMessageWhenUserEntersInvalidCommand() {
        mainMenu.executeUserCommand();
        verify(printStream).println(contains("Select a valid option!"));
    }

    @Test
    public void shouldExecuteListBookCommandWhenUserEntersOne() throws IOException {
        when(inputReader.receiveUserCommand()).thenReturn("1");
        mainMenu.executeUserCommand();
        verify(listBookCommand).executeCommand();
    }

    @Test
    public void shouldExecuteCheckoutBookCommandWhenCustomerEntersTwo(){
        when(inputReader.receiveUserCommand()).thenReturn("2");
        mainMenu.executeUserCommand();
        verify(checkoutCommand).executeCommand();
    }

    @Test
    public void shouldQuitApplicationWhenUserEntersThree(){
        when(inputReader.receiveUserCommand()).thenReturn("3");
        mainMenu.executeUserCommand();
        verify(printStream, atMost(0)).println("Select a valid option!");

    }
}