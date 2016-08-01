package com.jantuomi.tunkki.core.parser;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class ASTGenerator {
    private static final ASTGenerator instance = new ASTGenerator();

    private ASTGenerator() {}

    public static ASTGenerator getInstance() {
        return instance;
    }

    public List<ASTNode> generate(List<Token> trees) throws TunkkiError {
        List<ASTNode> list = new ArrayList<>();

        for (Token root : trees) {
            list.add(root.generateNode());
        }

        return list;
    }

    public void printTree(ASTNode root) throws TunkkiError {
        System.out.println("### AST Tree begin ###");
        try {
            root.print(0);
        } catch (NullPointerException ex) {
            throw new TunkkiError(TunkkiError.ExceptionType.GeneralError, -1, "Malformed syntax tree.");
        }

        System.out.println("### AST Tree end ###");
    }

    public void printAllTrees(List<ASTNode> trees) throws TunkkiError {
        for (ASTNode tree : trees) {
            printTree(tree);
        }
    }
}
