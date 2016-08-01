package com.jantuomi.tunkki;

import com.jantuomi.tunkki.core.CommandLineArgumentContainer;
import com.jantuomi.tunkki.core.parser.ASTGenerator;
import com.jantuomi.tunkki.core.parser.Parser;
import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.runtime.Interpreter;
import com.jantuomi.tunkki.core.tokenizer.Tokenizer;
import com.jantuomi.tunkki.core.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.TunkkiError;
import com.jantuomi.tunkki.repl.Repl;
import com.jantuomi.tunkki.utils.Utilities;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Tunkki {

    private static Tunkki instance;

    public Tunkki() {
        instance = this;
    }

    public static Tunkki getInstance() {
        return instance;
    }

    public void repl() throws InterruptedException, IOException {
        Repl repl = new Repl(this);
        repl.run();
    }

    public void run(String input) throws TunkkiError {
        Tokenizer tokenizer = Tokenizer.getInstance();
        List<Token> sequence = tokenizer.tokenize(input);

        Collections.reverse(sequence);

        List<Token> trees = Parser.getInstance().parse(sequence);
        if (CommandLineArgumentContainer.getInstance().isAstModeActive()) {
            Parser.getInstance().printAllTrees(trees);
        }

        List<ASTNode> nodes = ASTGenerator.getInstance().generate(trees);
        if (CommandLineArgumentContainer.getInstance().isAstModeActive()) {
            ASTGenerator.getInstance().printAllTrees(nodes);
        }

        String output = Interpreter.execute(nodes);

        if (output.trim().length() > 0) {
            System.out.println(output);
        }
    }

    public boolean parseArguments(String[] args) {
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

    public String versionString() {
        return Utilities.getVersionFromFile();
    }
}
