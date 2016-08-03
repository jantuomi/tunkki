package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.tokenizer.token.ArgumentInfo;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 28.6.2016.
 */
abstract public class UnaryOperatorToken extends Token {
    public UnaryOperatorToken(Type type, String text, String rawText) {
        super(type, text, rawText);
    }
    public UnaryOperatorToken(Type type, String text) {
        super(type, text);
    }

    public UnaryOperatorToken(Type type) {
        super(type);
    }

    protected Token operand;


    @Override
    public ArgumentInfo getArgumentInfo() {
        return new ArgumentInfo(1);
    }

    @Override
    public Token setArguments(List<Token> args) {
        operand = args.get(0);
        return this;
    }

    @Override
    public List<Token> getChildren() {
        return Arrays.asList(operand);
    }
}
