package com.jantuomi.borker.core.tokenizer.token.types;

import com.jantuomi.borker.core.parser.ast.ASTNode;
import com.jantuomi.borker.core.parser.ast.DoubleLiteralNode;

/**
 * Created by jan on 15.6.2016.
 */
public class DoubleLiteralToken extends TerminalToken {
    public DoubleLiteralToken(String text, String rawText) {
        super(Type.DoubleLiteralToken, text, rawText);
    }

    @Override
    public ASTNode generateNode() {
        return new DoubleLiteralNode(this);
    }
}
