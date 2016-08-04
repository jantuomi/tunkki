package com.jantuomi.tunkki.utils;

import jline.console.ConsoleReader;

import java.io.IOException;

/**
 * Created by jan on 4.8.2016.
 */
public class IO {
    private static IO instance = new IO();
    private ConsoleReader reader;

    public static IO getInstance() {
        return instance;
    }

    private IO() {
        try {
            reader = new ConsoleReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.setBellEnabled(false);
        reader.setExpandEvents(false);
    }

    public String readLine(String promptMessage)
            throws IOException {
        System.out.print(promptMessage);
        String line = reader.readLine();
        return line.trim();
    }
}
