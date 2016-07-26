package com.jantuomi.tunkki.core.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.IntegerLiteralNode;

/**
 * Created by jan on 15.6.2016.
 */
public class IntegerLiteralToken extends TerminalToken {
    public IntegerLiteralToken(String text) {
        super(Type.IntegerLiteralToken, text);
    }

    @Override
    public ASTNode generateNode() {
        return new IntegerLiteralNode(this);
    }
}
