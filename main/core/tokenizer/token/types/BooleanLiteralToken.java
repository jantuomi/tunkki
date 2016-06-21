package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.parser.ast.BooleanLiteralNode;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 15.6.2016.
 */
public class BooleanLiteralToken extends Token{
    public BooleanLiteralToken(String text) {
        super(Type.BooleanLiteralToken, text);
    }

    @Override
    public ASTNode generateNode() {
        return new BooleanLiteralNode(this);
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
