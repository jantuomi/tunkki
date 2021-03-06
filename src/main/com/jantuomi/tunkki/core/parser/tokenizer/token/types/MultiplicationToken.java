package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.MultiplicationNode;
import com.jantuomi.tunkki.exception.types.TunkkiError;

/**
 * Created by jan on 15.6.2016.
 */
public class MultiplicationToken extends BinaryOperatorToken {
    public MultiplicationToken() {
        super(Type.MultiplicationToken);
    }

    @Override
    public ASTNode generateNode() throws TunkkiError {
        return new MultiplicationNode(this,
                lhs.generateNode(),
                rhs.generateNode()
        );

    }
}
