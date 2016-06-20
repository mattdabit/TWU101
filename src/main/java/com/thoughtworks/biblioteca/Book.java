package com.thoughtworks.biblioteca;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.author = author;
        this.year = year;
        this.title = title;
    }

    public String getDescription() {
        return String.format("%s    %s  %d", title, author, year);
    }
}
