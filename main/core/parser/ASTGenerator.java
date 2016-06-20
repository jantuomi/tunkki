package com.jantuomi.interpreter.main.core.parser;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

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

    public List<ASTNode> generate(List<Token> trees) {
        List<ASTNode> list = new ArrayList<>();

        for (Token root : trees) {
            list.add(root.generateNode());
        }

        return list;
    }

    public void printTree(ASTNode root) {
        System.out.println("### AST Tree begin ###");
        root.print(0);
        System.out.println("### AST Tree end ###");
    }

    public void printAllTrees(List<ASTNode> trees) {
        for (ASTNode tree : trees) {
            printTree(tree);
        }
    }
}
