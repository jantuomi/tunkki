package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 15.6.2016.
 */
abstract public class BinaryOperatorToken extends Token {
    protected Token lhs;
    protected Token rhs;

    public BinaryOperatorToken(Type type) {
        super(type);
    }

    @Override
    public Token setArguments(List<Token> args) {
        lhs = args.get(0);
        rhs = args.get(1);
        return this;
    }

    @Override
    public List<Token> getChildren() {
        return Arrays.asList(lhs, rhs);

    }
}
