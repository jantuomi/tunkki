package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.tokenizer.token.ArgumentInfo;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;

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

    public BinaryOperatorToken(Type type, String text) {
        super(type, text);
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

    @Override
    public ArgumentInfo getArgumentInfo() {
        return new ArgumentInfo(2);
    }
}
