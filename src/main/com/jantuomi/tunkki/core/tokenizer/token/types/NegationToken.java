package com.jantuomi.tunkki.core.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.NegationNode;
import com.jantuomi.tunkki.exception.TunkkiError;

/**
 * Created by jan on 21.6.2016.
 */
public class NegationToken extends UnaryOperatorToken {

    public NegationToken() {
        super(Type.NegationToken, "not");
    }

    @Override
    public ASTNode generateNode() throws TunkkiError {
        return new NegationNode(this, operand.generateNode());
    }
}
