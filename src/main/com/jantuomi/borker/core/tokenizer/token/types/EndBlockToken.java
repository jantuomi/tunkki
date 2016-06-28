package com.jantuomi.borker.core.tokenizer.token.types;

import com.jantuomi.borker.core.parser.ast.ASTNode;

/**
 * Created by jan on 16.6.2016.
 */
public class EndBlockToken extends TerminalToken {
    public EndBlockToken() {
        super(Type.EndBlockToken, "end");
    }

    @Override
    public ASTNode generateNode() {
        return null;
    }
}
