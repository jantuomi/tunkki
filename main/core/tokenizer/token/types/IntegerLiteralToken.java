package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.parser.ast.IntegerLiteralNode;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 15.6.2016.
 */
public class IntegerLiteralToken extends Token{
    public IntegerLiteralToken(String text) {
        super(Type.IntegerLiteralToken, text);
    }

    @Override
    public ASTNode generateNode() {
        return new IntegerLiteralNode(this);
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
