package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.DivisionNode;
import com.jantuomi.tunkki.exception.TunkkiError;

/**
 * Created by jan on 15.6.2016.
 */
public class DivisionToken extends BinaryOperatorToken {
    public DivisionToken() {
        super(Type.DivisionToken);
    }

    @Override
    public ASTNode generateNode() throws TunkkiError {
        return new DivisionNode(this,
                lhs.generateNode(),
                rhs.generateNode()
        );

    }
}
