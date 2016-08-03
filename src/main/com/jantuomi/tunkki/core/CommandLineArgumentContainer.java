package com.jantuomi.tunkki.core;


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

    @Option(name="-d", usage="Display AST output (for debugging purposes).")
    public boolean astModeActive = false;

    public static CommandLineArgumentContainer getInstance() {
        return instance;
    }

    public boolean isInteractive() {
        return interactiveModeActive;
    }

    public boolean isAstModeActive() {
        return astModeActive;
    }

    public String getSourceFileContents() {
        if (srcFile == null) {
            return null;
        }

        return readFileContents(srcFile);
    }

    public String readFileContents(String filename) {
        return readFileContents(new File(filename));
    }

    public String readFileContents(File file) {
        BufferedReader br;
        String contents = null;
        try {
            br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            contents = sb.toString();
        } catch (IOException e) {
            // System.err.println(String.format("Couldn't read file \"%s\".", file.toString()));
            return null;
        }

        // Add a newline at the end for comment rows to terminate nicely
        return contents + "\n";
    }
}
