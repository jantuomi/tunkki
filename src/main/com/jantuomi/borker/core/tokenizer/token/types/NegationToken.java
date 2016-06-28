package com.jantuomi.borker.core.tokenizer.token.types;

import com.jantuomi.borker.core.parser.ast.ASTNode;
import com.jantuomi.borker.core.parser.ast.NegationNode;
import com.jantuomi.borker.exception.InterpreterException;

/**
 * Created by jan on 21.6.2016.
 */
public class NegationToken extends UnaryOperatorToken {

    public NegationToken() {
        super(Type.NegationToken, "not");
    }

    @Override
    public ASTNode generateNode() throws InterpreterException {
        return new NegationNode(this, operand.generateNode());
    }
}
