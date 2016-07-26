package com.jantuomi.tunkki.core.tokenizer.token.types;

import com.jantuomi.tunkki.core.tokenizer.token.ArgumentInfo;
import com.jantuomi.tunkki.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 28.6.2016.
 */
public abstract class OptionalArgumentToken extends Token {
    public OptionalArgumentToken(Type type, String text) {
        super(type, text);
    }

    protected Token optionalArgument;

    public void setOptionalArgument(Token optionalArgument) {
        this.optionalArgument = optionalArgument;
    }

    abstract public Token.Type getOptionalArgumentType();

    @Override
    public ArgumentInfo getArgumentInfo() {
        ArgumentInfo ai = new ArgumentInfo();
        ai.setOptionalArgument(getOptionalArgumentType());
        return ai;
    }

    @Override
    public Token setArguments(List<Token> args) {
        if (args.size() > 0) {
            setOptionalArgument(args.get(0));
        }
        return this;
    }

    @Override
    public List<Token> getChildren() {
        if (optionalArgument == null) {
            return Arrays.asList();
        } else {
            return Arrays.asList(optionalArgument);
        }
    }
}
