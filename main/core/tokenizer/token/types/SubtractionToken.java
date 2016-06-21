package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.parser.ast.SubtractionNode;
import com.jantuomi.interpreter.main.exception.InterpreterException;

/**
 * Created by jan on 16.6.2016.
 */
public class SubtractionToken extends BinaryOperatorToken {
    public SubtractionToken() {
        super(Type.SubtractionToken);
    }

    @Override
    public ASTNode generateNode() throws InterpreterException {
        return new SubtractionNode(this,
                lhs.generateNode(),
                rhs.generateNode()
        );
    }
}
