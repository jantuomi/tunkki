package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.parser.ast.DivisionNode;
import com.jantuomi.interpreter.main.exception.InterpreterException;

/**
 * Created by jan on 15.6.2016.
 */
public class DivisionToken extends BinaryOperatorToken {
    public DivisionToken() {
        super(Type.DivisionToken);
    }

    @Override
    public ASTNode generateNode() throws InterpreterException {
        return new DivisionNode(this,
                lhs.generateNode(),
                rhs.generateNode()
        );

    }
}
