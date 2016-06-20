package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
abstract public class VarargOperatorToken extends Token {

    protected List<Token> args;

    public VarargOperatorToken(Type type, String text) {
        super(type, text);
    }

    public VarargOperatorToken(Type type) {
        super(type);
    }

    @Override
    public Token setArguments(List<Token> args) {
        this.args = args;
        return this;
    }

    @Override
    public List<Token> getChildren() {
        return args;
    }

}
