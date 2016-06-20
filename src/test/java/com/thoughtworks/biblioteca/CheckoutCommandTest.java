package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutCommandTest {

    private PrintStream printStream;
    private Input inputReader;
    private Library library;
    private CheckoutCommand checkoutCommand;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        inputReader = mock(Input.class);
        library = mock(Library.class);
        checkoutCommand = new CheckoutCommand(printStream, inputReader, library);
    }

    @Test
    public void shouldCheckoutABookFromLibraryWhenExecuteCommandIsCalled() {
        String book = "blah";
        String author = "garbage";
        when(inputReader.receiveUserCommand()).thenReturn(book, author);

        checkoutCommand.executeCommand();

        verify(library).checkOutBook(book, author);
    }

    @Test
    public void shouldReturnMenuRepresentationStringWhenMenuRepresentationIsCalled() {
        String menuRepresentation = checkoutCommand.menuRepresentation();

        assertThat(menuRepresentation, is("2. Checkout Book"));
    }

}