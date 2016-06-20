package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 19.6.2016.
 */
public class ClosedParenToken extends Token {
    public ClosedParenToken() {
        super(Type.ClosedParenToken);
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
}
