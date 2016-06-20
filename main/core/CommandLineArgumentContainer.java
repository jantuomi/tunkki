package com.jantuomi.interpreter.main.core;

import org.kohsuke.args4j.Option;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by jan on 10.6.2016.
 */

public class CommandLineArgumentContainer {

    private CommandLineArgumentContainer() {}

    private static final CommandLineArgumentContainer instance = new CommandLineArgumentContainer();
    private File srcFile;


    @Option(name="-f", usage="Execute script in file FILE.")
    public void setFile(File file) {
        this.srcFile = file;
    }

    @Option(name="-i", usage="Run in interactive mode.")
    public boolean interactiveModeActive = false;


    @Option(name="-d", usage="Display verbose debug output.")
    public boolean debugModeActive = false;

    public static CommandLineArgumentContainer getInstance() {
        return instance;
    }

    public boolean isInteractive() {
        return interactiveModeActive;
    }

    public boolean isDebugModeActive() {
        return debugModeActive;
    }

    public String getSourceFileContents() {
        if (srcFile == null) {
            return null;
        }

        BufferedReader br;
        String contents = null;
        try {
            br = new BufferedReader(new FileReader(srcFile));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            contents = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            // Add a newline at the end for comment rows to terminate nicely
            return contents + "\n";
        }
    }
}
