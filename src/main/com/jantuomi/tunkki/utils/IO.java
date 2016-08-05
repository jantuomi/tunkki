package com.jantuomi.tunkki.utils;

import jline.console.ConsoleReader;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jan on 4.8.2016.
 */
public class IO {
    private static IO instance = new IO();
    private ConsoleReader reader;
    private PrintWriter printer;

    public static IO getInstance() {
        return instance;
    }

    private IO() {
        try {
            reader = new ConsoleReader();
            printer = new PrintWriter(System.out);
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

    public void printLine(String line) {
        printer.println(line);
    }

    public void flush() {
        printer.flush();
    }
}
