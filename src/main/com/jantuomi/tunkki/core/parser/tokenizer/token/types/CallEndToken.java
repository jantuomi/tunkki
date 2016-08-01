package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;

/**
 * Created by jan on 19.6.2016.
 */
public class CallEndToken extends TerminalToken {
    public CallEndToken() {
        super(Type.CallEndToken);
    }

    @Override
    public ASTNode generateNode() {
        return null;
    }

}
