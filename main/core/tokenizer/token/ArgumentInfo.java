package com.jantuomi.interpreter.main.core.tokenizer.token;

/**
 * Created by jan on 15.6.2016.
 */
public class ArgumentInfo {
    private int count = 0;
    private boolean isVarargs = false;
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
