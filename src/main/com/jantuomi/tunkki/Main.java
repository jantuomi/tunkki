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
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Tunkki tunkki;

    public static void main(String[] args) throws Exception {
        tunkki = new Tunkki();

        boolean parseSuccess = tunkki.parseArguments(args);
        if (!parseSuccess) {
            return;
        }

        if (CommandLineArgumentContainer.getInstance().isInteractive()) {
            tunkki.repl();
        } else {
            String sourceFileContents = CommandLineArgumentContainer.getInstance().getSourceFileContents();
            tunkki.run(sourceFileContents);
        }
    }

}
