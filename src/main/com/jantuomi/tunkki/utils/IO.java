package com.jantuomi.tunkki.utils;

import jline.console.ConsoleReader;
import org.apache.commons.lang3.SystemUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by jan on 4.8.2016.
 */
public class IO {
    private static IO instance = new IO();
    private IOHandler ioHandler;

    public static IO getInstance() {
        return instance;
    }

    private IO() {
        if (SystemUtils.IS_OS_WINDOWS) {
            ioHandler = new WindowsIOHandler();
        } else {
            ioHandler = new StandardIOHandler();
        }
    }

    public String readLine(String promptMessage)
            throws IOException {
        System.out.print(promptMessage);

        String line = ioHandler.readLine();
        return line.trim();
    }

    public void printLine(String line) {
        ioHandler.printLine(line);
    }

    public void flush() {
        ioHandler.flush();
    }

    private class WindowsIOHandler implements IOHandler {
        private Scanner scanner = new Scanner(System.in);

        @Override
        public String readLine() {
            return scanner.nextLine();
        }

        @Override
        public void printLine(String line) {
            System.out.println(line);
        }

        @Override
        public void flush() {
            System.out.flush();
        }
    }

    private class StandardIOHandler implements IOHandler {
        private ConsoleReader reader;
        private PrintWriter writer;

        public StandardIOHandler() {
            try {
                reader = new ConsoleReader();
                writer = new PrintWriter(System.out);
            } catch (IOException e) {
                e.printStackTrace();
            }
            reader.setBellEnabled(false);
            reader.setExpandEvents(false);
        }

        @Override
        public String readLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public void printLine(String line) {
            writer.println(line);
        }

        @Override
        public void flush() {
            writer.flush();
        }
    }

    private interface IOHandler {
        String readLine();
        void printLine(String line);
        void flush();
    }
}
