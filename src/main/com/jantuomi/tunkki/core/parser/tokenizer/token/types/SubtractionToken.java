package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.SubtractionNode;
import com.jantuomi.tunkki.exception.TunkkiError;

/**
 * Created by jan on 16.6.2016.
 */
public class SubtractionToken extends BinaryOperatorToken {
    public SubtractionToken() {
        super(Type.SubtractionToken);
    }

    @Override
    public ASTNode generateNode() throws TunkkiError {
        return new SubtractionNode(this,
                lhs.generateNode(),
                rhs.generateNode()
        );
    }
}
