package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.tokenizer.token.ArgumentInfo;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class WhitespaceToken extends Token {
    public WhitespaceToken() {
        super(Type.WhitespaceToken);
    }

    @Override
    public ASTNode generateNode() {
        return null;
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
