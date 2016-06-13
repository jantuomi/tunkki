package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

/**
 * Created by jan on 11.6.2016.
 */
abstract public class ExpressionNode extends ASTNode {
    public ExpressionNode(Token token) {
        super(token);
    }
}
