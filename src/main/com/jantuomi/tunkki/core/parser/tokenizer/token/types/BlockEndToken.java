package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;

/**
 * Created by jan on 19.6.2016.
 */
public class BlockEndToken extends TerminalToken {
    public BlockEndToken() {
        super(Type.BlockEndToken);
    }

    @Override
    public ASTNode generateNode() {
        return null;
    }

}
