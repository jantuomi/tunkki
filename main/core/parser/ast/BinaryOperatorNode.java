package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

/**
 * Created by jan on 16.6.2016.
 */
abstract public class BinaryOperatorNode extends ASTNode {
    protected ASTNode lhs;
    protected ASTNode rhs;

    public BinaryOperatorNode(Token token, ASTNode lhs, ASTNode rhs) {
        super(token);
        this.lhs = lhs;
        this.rhs = rhs;
    }
}
