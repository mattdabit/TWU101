package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksCommandTest {

    private Library library;
    private ListBooksCommand listBooksCommand;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        listBooksCommand = new ListBooksCommand(library);
    }

    @Test

    public void shouldListBooksWhenExecuteCommandCalled() {
        listBooksCommand.executeCommand();
        verify(library).listBooks();
    }

    @Test
    public void shouldReturnMenuRepresentationWhenMenuRepresentationCalled() {
        String menuRepresentation = listBooksCommand.menuRepresentation();
        assertThat(menuRepresentation, is("List Books"));
    }
}