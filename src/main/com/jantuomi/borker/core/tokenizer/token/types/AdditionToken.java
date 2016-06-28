package com.jantuomi.borker.core.tokenizer.token.types;

import com.jantuomi.borker.core.parser.ast.ASTNode;
import com.jantuomi.borker.core.parser.ast.AdditionNode;
import com.jantuomi.borker.exception.BorkError;

/**
 * Created by jan on 15.6.2016.
 */
public class AdditionToken extends BinaryOperatorToken {
    public AdditionToken() {
        super(Type.AdditionToken);
    }

    @Override
    public ASTNode generateNode() throws BorkError {
        return new AdditionNode(this,
                lhs.generateNode(),
                rhs.generateNode()
        );
    }
}
