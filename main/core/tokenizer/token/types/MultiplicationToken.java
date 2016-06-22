package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.parser.ast.MultiplicationNode;
import com.jantuomi.interpreter.main.exception.InterpreterException;

/**
 * Created by jan on 15.6.2016.
 */
public class MultiplicationToken extends BinaryOperatorToken {
    public MultiplicationToken() {
        super(Type.MultiplicationToken);
    }

    @Override
    public ASTNode generateNode() throws InterpreterException {
        return new MultiplicationNode(this,
                lhs.generateNode(),
                rhs.generateNode()
        );

    }
}
