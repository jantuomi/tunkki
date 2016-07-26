package com.jantuomi.tunkki.core.tokenizer.token.types;

import com.jantuomi.tunkki.core.tokenizer.token.ArgumentInfo;
import com.jantuomi.tunkki.core.tokenizer.token.Token;

import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
abstract public class VarargOperatorToken extends Token {

    protected List<Token> args;

    public VarargOperatorToken(Type type, String text, String rawText) {
        super(type, text, rawText);
    }

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

    abstract public Token.Type getTerminatorTokenType();

    @Override
    public ArgumentInfo getArgumentInfo() {
        ArgumentInfo ai = new ArgumentInfo();
        ai.setVariable(true);
        ai.setTerminator(getTerminatorTokenType());
        return ai;

    }

}
