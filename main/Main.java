package com.jantuomi.interpreter.main;

import com.jantuomi.interpreter.main.core.CommandLineArgumentContainer;
import com.jantuomi.interpreter.main.core.parser.Parser;
import com.jantuomi.interpreter.main.core.tokenizer.Tokenizer;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean parseSuccess = parseArguments(args);
        if (!parseSuccess) {
            throw new Exception("Argument files could not be parsed successfully.");
        }

        String sourceFileContents = CommandLineArgumentContainer.getInstance().getSourceFileContents();
        Tokenizer tokenizer = Tokenizer.getInstance();
        tokenizer.tokenize(sourceFileContents);
        Parser.getInstance().parse(tokenizer.getTokens());
    }

    public static boolean parseArguments(String[] args) {
        CommandLineArgumentContainer container = CommandLineArgumentContainer.getInstance();
        CmdLineParser parser = new CmdLineParser(container);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
            return false;
        }

        return true;
    }
}
