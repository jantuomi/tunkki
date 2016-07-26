package com.jantuomi.tunkki.core.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;

/**
 * Created by jan on 19.6.2016.
 */
public class ClosedParenToken extends TerminalToken {
    public ClosedParenToken() {
        super(Type.ClosedParenToken);
    }

    @Override
    public ASTNode generateNode() {
        return null;
    }

}
