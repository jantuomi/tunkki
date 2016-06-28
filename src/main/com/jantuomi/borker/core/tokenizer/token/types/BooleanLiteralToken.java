package com.jantuomi.borker.core.tokenizer.token.types;

import com.jantuomi.borker.core.parser.ast.ASTNode;
import com.jantuomi.borker.core.parser.ast.BooleanLiteralNode;

/**
 * Created by jan on 15.6.2016.
 */
public class BooleanLiteralToken extends TerminalToken{
    public BooleanLiteralToken(String text) {
        super(Type.BooleanLiteralToken, text);
    }

    @Override
    public ASTNode generateNode() {
        return new BooleanLiteralNode(this);
    }
}
