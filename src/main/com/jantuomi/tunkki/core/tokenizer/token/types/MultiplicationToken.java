package com.jantuomi.tunkki.core.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.MultiplicationNode;
import com.jantuomi.tunkki.exception.BorkError;

/**
 * Created by jan on 15.6.2016.
 */
public class MultiplicationToken extends BinaryOperatorToken {
    public MultiplicationToken() {
        super(Type.MultiplicationToken);
    }

    @Override
    public ASTNode generateNode() throws BorkError {
        return new MultiplicationNode(this,
                lhs.generateNode(),
                rhs.generateNode()
        );

    }
}
