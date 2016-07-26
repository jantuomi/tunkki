package com.jantuomi.tunkki.core.tokenizer.token;

/**
 * Created by jan on 15.6.2016.
 */
public class ArgumentInfo {
    private int count = 0;
    private boolean isVarargs = false;

    public Token.Type getOptionalArgument() {
        return optionalArgument;
    }

    public void setOptionalArgument(Token.Type optionalArgument) {
        this.optionalArgument = optionalArgument;
    }

    private Token.Type optionalArgument = null;

    public Token.Type getTerminator() {
        return terminator;
    }

    public void setTerminator(Token.Type terminator) {
        this.terminator = terminator;
    }

    private Token.Type terminator;

    public ArgumentInfo(int count) {
        this.count = count;
    }

    public ArgumentInfo() {

    }

    public void setVariable(boolean value) {
        this.isVarargs = value;
    }

    public boolean getVarargs() {
        return isVarargs;
    }

    public int getCount() {
        return count;
    }
}
