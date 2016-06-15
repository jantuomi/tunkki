package com.jantuomi.interpreter.main;

import com.jantuomi.interpreter.main.core.CommandLineArgumentContainer;
import com.jantuomi.interpreter.main.core.parser.Parser;
import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.runtime.Interpreter;
import com.jantuomi.interpreter.main.core.tokenizer.Tokenizer;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean parseSuccess = parseArguments(args);
        if (!parseSuccess) {
            throw new Exception("Argument files could not be parsed successfully.");
        }

        if (CommandLineArgumentContainer.getInstance().isInteractive()) {
            repl();
        } else {
            String sourceFileContents = CommandLineArgumentContainer.getInstance().getSourceFileContents();
            run(sourceFileContents);
        }
    }

    public static void repl() {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print(">> ");
            input = scanner.nextLine();

            run(input);
        }
    }

    public static void run(String input) {
        Tokenizer tokenizer = Tokenizer.getInstance();
        tokenizer.tokenize(input);
        List<ASTNode> nodes = Parser.getInstance().parse(tokenizer.getTokens());
        String output = Interpreter.execute(nodes);
        System.out.println(output);
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
