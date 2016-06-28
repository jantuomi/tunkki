package com.jantuomi.borker;

import com.jantuomi.borker.core.CommandLineArgumentContainer;
import com.jantuomi.borker.core.parser.ASTGenerator;
import com.jantuomi.borker.core.parser.Parser;
import com.jantuomi.borker.core.parser.ast.ASTNode;
import com.jantuomi.borker.core.runtime.Interpreter;
import com.jantuomi.borker.core.tokenizer.Tokenizer;
import com.jantuomi.borker.core.tokenizer.token.Token;
import com.jantuomi.borker.exception.InterpreterException;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean parseSuccess = parseArguments(args);
        if (!parseSuccess) {
            return;
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

            try {
                run(input);
            } catch (InterpreterException e) {
                e.printStackTrace();
            }
        }
    }

    public static void run(String input) throws InterpreterException {
        Tokenizer tokenizer = Tokenizer.getInstance();
        List<Token> sequence = tokenizer.tokenize(input);

        Collections.reverse(sequence);

        List<Token> trees = Parser.getInstance().parse(sequence);
        if (CommandLineArgumentContainer.getInstance().isDebugModeActive()) {
            Parser.getInstance().printAllTrees(trees);
        }

        List<ASTNode> nodes = ASTGenerator.getInstance().generate(trees);
        if (CommandLineArgumentContainer.getInstance().isDebugModeActive()) {
            ASTGenerator.getInstance().printAllTrees(nodes);
        }

        String output = Interpreter.execute(nodes);

        if (output.trim().length() > 0) {
            System.out.println(output);
        }
    }

    public static boolean parseArguments(String[] args) {
        CommandLineArgumentContainer container = CommandLineArgumentContainer.getInstance();
        CmdLineParser parser = new CmdLineParser(container);


        try {
            if (args.length == 0) {
                throw new CmdLineException("Please provide an argument.");
            }
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
            return false;
        }

        return true;
    }
}
