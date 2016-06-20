package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;

public class Input {
    private BufferedReader reader;

    public Input(BufferedReader reader) {
        this.reader = reader;
    }


    public String receiveUserCommand() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
