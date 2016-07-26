package com.jantuomi.tunkki.core.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.BooleanLiteralNode;

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
