package com.jantuomi.tunkki.core.parser;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.tokenizer.token.ArgumentInfo;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.types.ExpectedDifferentTokenTunkkiError;
import com.jantuomi.tunkki.exception.types.MissingTerminatorTokenTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jan on 11.6.2016.
 */
public class Parser {
    private static final Parser instance = new Parser();

    public static Parser getInstance() {
        return instance;
    }

    private Parser() {}

    private Stack<Token> stack;

    public List<Token> parse(List<Token> tokens) throws TunkkiError {
        this.stack = new Stack<>();

        List<Token> args;
        List<Token> output = new ArrayList<>();
        for (Token t : tokens) {
            /* Skip newline tokens */
            if (t.getTokenType() == Token.Type.NewlineToken) {
                continue;
            }

            args = new ArrayList<>();
            ArgumentInfo argumentInfo = t.getArgumentInfo();

            /*
            This branch is executed if the token has a variable list of arguments
             */
            if (argumentInfo.getVarargs()) {
                boolean foundTerminatorToken = false;
                while (stack.size() > 0) {
                    Token arg = stack.pop();
                    args.add(arg);
                    if (arg.getTokenType() == argumentInfo.getTerminator()) {
                        foundTerminatorToken = true;
                        break;
                    }
                }
                if (!foundTerminatorToken) {
                    throw new MissingTerminatorTokenTunkkiError(t.getLine(), t.getText());
                }
            }
            /*
            If the token has an optional argument type (it is only an argument if
            it is of certain type)
             */
            else if (argumentInfo.getOptionalArgument() != null) {
                if (stack.size() > 0 && stack.peek().getTokenType() == argumentInfo.getOptionalArgument()) {
                    args.add(stack.pop());
                }
            }
            /* Normal cases with a fixed list of arguments */
            else {
                for (int i = 0; i < argumentInfo.getCount(); i++) {
                    if (stack.size() > 0) {
                        args.add(stack.pop());
                    } else {
                        throw new ExpectedDifferentTokenTunkkiError(t.getLine(), t.getText());
                    }
                }
            }

            Token result = t.setArguments(args);
            stack.push(result);
        }

        /* When the token list is empty, pop all remaining tokens from the stack */
        while (stack.size() > 0) {
            output.add(stack.pop());
        }
        return output;
    }

    public void printTree(Token e) {
        System.out.println("### Token Tree begin ###");
        e.print(0);
        System.out.println("### Token Tree end ###");
    }

    public void printAllTrees(List<Token> trees) {
        for (Token tree : trees) {
            printTree(tree);
        }
    }
}
