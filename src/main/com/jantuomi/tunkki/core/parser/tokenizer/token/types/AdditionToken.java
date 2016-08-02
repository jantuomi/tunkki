package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.AdditionNode;
import com.jantuomi.tunkki.exception.types.TunkkiError;

/**
 * Created by jan on 15.6.2016.
 */
public class AdditionToken extends BinaryOperatorToken {
    public AdditionToken() {
        super(Type.AdditionToken);
    }

    @Override
    public ASTNode generateNode() throws TunkkiError {
        return new AdditionNode(this,
                lhs.generateNode(),
                rhs.generateNode()
        );
    }
}
