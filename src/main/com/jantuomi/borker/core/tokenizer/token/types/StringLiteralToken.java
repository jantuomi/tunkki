package com.jantuomi.borker.core.tokenizer.token.types;

import com.jantuomi.borker.core.parser.ast.ASTNode;
import com.jantuomi.borker.core.parser.ast.StringLiteralNode;
import com.jantuomi.borker.exception.InterpreterException;

/**
 * Created by jan on 21.6.2016.
 */
public class StringLiteralToken extends TerminalToken {
    public StringLiteralToken(String text, String rawText) {
        super(Type.StringLiteralToken, text, rawText);
    }

    @Override
    public ASTNode generateNode() throws InterpreterException {
        return new StringLiteralNode(this);
    }
}
