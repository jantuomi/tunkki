package com.jantuomi.tunkki.core.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.StringLiteralNode;
import com.jantuomi.tunkki.exception.BorkError;

/**
 * Created by jan on 21.6.2016.
 */
public class StringLiteralToken extends TerminalToken {
    public StringLiteralToken(String text, String rawText) {
        super(Type.StringLiteralToken, text, rawText);
    }

    @Override
    public ASTNode generateNode() throws BorkError {
        return new StringLiteralNode(this);
    }
}
