package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.parser.ast.AdditionNode;

/**
 * Created by jan on 15.6.2016.
 */
public class AdditionToken extends BinaryOperatorToken {
    public AdditionToken() {
        super(Type.AdditionToken);
    }

    @Override
    public ASTNode generateNode() {
        return new AdditionNode(this,
                lhs.generateNode(),
                rhs.generateNode()
        );

    }
}
