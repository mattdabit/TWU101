package com.thoughtworks.bilbioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    @Test
    public void shouldWelcomeUserWhenStarting(){

        PrintStream printStream = mock(PrintStream.class);
        Application application = new Application(printStream);

        application.start();
        verify(printStream).println(contains("Welcome"));
    }

}