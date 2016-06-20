package com.jantuomi.interpreter.main.core.parser;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.tokenizer.token.ArgumentInfo;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;
import com.jantuomi.interpreter.main.exception.ExceptionManager;
import com.jantuomi.interpreter.main.exception.InterpreterException;

import java.util.ArrayList;
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

    public List<Token> parse(List<Token> tokens) throws InterpreterException {
        this.tokens = tokens;
        this.stack = new Stack<>();

        List<Token> args;
        List<Token> output = new ArrayList<>();
        for (Token t : tokens) {
            if (t.getTokenType() == Token.Type.NewlineToken) {
//                if (stack.size() > 0) {
//                    output.add(stack.pop());
//                }
                continue;
            }

            args = new ArrayList<>();
            ArgumentInfo argumentInfo = t.getArgumentInfo();

            /*
            This branch is executed if the token has a variable list of arguments
             */
            if (argumentInfo.getVarargs()) {
                while (true) {
                    if (stack.size() > 0) {
                        Token arg = stack.pop();
                        if (arg.getTokenType() != argumentInfo.getTerminator()) {
                            args.add(arg);
                        }
                        else {
                            args.add(arg);
                            break;
                        }
                    }
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
                        ExceptionManager.raise(InterpreterException.ExceptionType.ArgumentError, t.getLine(),
                                t.toString(), Integer.toString(argumentInfo.getCount()));
                        return null;
                    }
                }
            }

            Token result = t.setArguments(args);
            stack.push(result);
        }
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
