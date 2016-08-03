package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.types.TunkkiError;

/**
 * Created by jan on 3.8.2016.
 */
public class ObjectMemberNode extends UnaryOperatorNode {
    public ObjectMemberNode(Token token, ASTNode operand) {
        super(token, operand);
    }

    @Override
    public Datatype evaluate() throws TunkkiError {
        // TODO
        return null;
    }
}
