package com.jantuomi.interpreter.main.core.parser;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.tokenizer.token.ArgumentInfo;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by jan on 11.6.2016.
 */
public class Parser {
    private static final Parser instance = new Parser();

    private List<Token> tokens;
    private List<ASTNode> statementSequence;

    public static Parser getInstance() {
        return instance;
    }

    private Parser() {

    }

    private Stack<Token> stack;

    public List<Token> parse(List<Token> tokens) {
        this.tokens = tokens;
        this.stack = new Stack<>();

        List<Token> args = new ArrayList<>();
        List<Token> output = new ArrayList<>();
        for (Token t : tokens) {
            if (t.getTokenType() == Token.Type.NewlineToken) {
//                if (stack.size() > 0) {
//                    output.add(stack.pop());
//                }
                continue;
            }

            args.clear();
            ArgumentInfo argumentInfo = t.getArgumentInfo();
            if (!argumentInfo.getVarargs()) {
                for (int i = 0; i < argumentInfo.getCount(); i++) {
                    args.add(stack.pop());
                }
            } else {
                System.err.println("no vararg support yet");
            }
            Collections.reverse(args);
            Token result = t.setArguments(args);
            stack.push(result);
        }
        while (stack.size() > 0) {
            output.add(stack.pop());
        }
        return output;
    }

    public void printTree(Token e) {
        System.out.println("### Tree begin ###");
        e.print(0);
        System.out.println("### Tree end ###");
    }
}
