package com.jantuomi.tunkki;

import com.jantuomi.tunkki.core.CommandLineArgumentContainer;
import com.jantuomi.tunkki.core.parser.ast.ASTNode;

import java.util.List;

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
            List<ASTNode> nodes = tunkki.parseAndInterpret(sourceFileContents);
            tunkki.executeAndOutput(nodes);
        }
    }

}
