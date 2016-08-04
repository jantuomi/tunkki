package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;

/**
 * Created by jan on 16.6.2016.
 */
public class EndBlockToken extends TerminalToken {
    public EndBlockToken() {
        super(Type.BlockEndToken, "!");
    }

    @Override
    public ASTNode generateNode() {
        return null;
    }
}
