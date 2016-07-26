package com.jantuomi.tunkki.core.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.DivisionNode;
import com.jantuomi.tunkki.exception.BorkError;

/**
 * Created by jan on 15.6.2016.
 */
public class DivisionToken extends BinaryOperatorToken {
    public DivisionToken() {
        super(Type.DivisionToken);
    }

    @Override
    public ASTNode generateNode() throws BorkError {
        return new DivisionNode(this,
                lhs.generateNode(),
                rhs.generateNode()
        );

    }
}
