package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class EndFunctionDefineToken extends Token {
    public EndFunctionDefineToken() {
        super(Type.EndBlockToken, "end");
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
