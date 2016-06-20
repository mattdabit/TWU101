package com.thoughtworks.biblioteca;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class ApplicationTest {
    private PrintStream printStream;
    private Library library;
    private Application application;
    private MainMenu mainMenu;
    private Quitter quitter;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        mainMenu = mock(MainMenu.class);
        quitter = mock(Quitter.class);
        application = new Application(printStream, mainMenu, quitter);
    }

    @Test
    public void shouldWelcomeUserWhenStarting(){
        application.start();
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayMainMenuOnceWhenStarting() {
        when(quitter.continueProgram()).thenReturn(true, false);
        application.start();
        verify(mainMenu).display();
    }

    @Test
    public void shouldNotDisplayMainMenuWhenProgramShouldQuit() {
        when(quitter.continueProgram()).thenReturn(false);
        application.start();
        verify(mainMenu, never()).display();
    }

    @Test
    public void shouldExecuteUserCommandWhenStarting() {
        when(quitter.continueProgram()).thenReturn(true, false);
        application.start();
        verify(mainMenu).executeUserCommand();
    }

}