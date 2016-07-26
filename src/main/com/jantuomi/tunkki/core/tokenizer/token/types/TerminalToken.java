package com.jantuomi.tunkki.core.tokenizer.token.types;

import com.jantuomi.tunkki.core.tokenizer.token.ArgumentInfo;
import com.jantuomi.tunkki.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 28.6.2016.
 */
abstract public class TerminalToken extends Token {
    public TerminalToken(Type type, String text, String rawText) {
        super(type, text, rawText);
    }

    public TerminalToken(Type type, String text) {
        super(type, text);
    }

    public TerminalToken(Type type) {
        super(type);
    }

    @Override
    public Token setArguments(List<Token> args) {
        return this;
    }

    @Override
    public List<Token> getChildren() {
        return Arrays.asList();
    }

    @Override
    public ArgumentInfo getArgumentInfo() {
        return new ArgumentInfo(0);
    }
}
