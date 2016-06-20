package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldCreateDescriptionOfBook(){
        Book book = new Book("A book", "Jason Bourne", 2000);
        String expectedDescription = "A book    Jason Bourne  2000";

        String actualDescription = book.getDescription();

        assertThat(actualDescription, is(expectedDescription));
    }

}