package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.EmptyNode;

/**
 * Created by jan on 19.6.2016.
 */
public class CommentToken extends TerminalToken {
    public CommentToken(String text, String rawText) {
        super(Type.CommentToken, text, rawText);
    }

    @Override
    public ASTNode generateNode() {
        return new EmptyNode(this);
    }
}
