package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class QuitterTest {

    private Quitter quitter;

    @Before
    public void setUp() throws Exception {
        quitter = new Quitter();
    }

    @Test
    public void shouldNotContinueProgramWhenExecuteCommandIsCalled() {

        quitter.executeCommand();

        assertThat(quitter.continueProgram(), is(false));
    }

    @Test
    public void shouldReturnMenuRepresentationWhenMenuRepresentationIsCalled() {
        String menuRepresentation = quitter.menuRepresentation();

        assertThat(menuRepresentation, is("Quit"));
    }
}