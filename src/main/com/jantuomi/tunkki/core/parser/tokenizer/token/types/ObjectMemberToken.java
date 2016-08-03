package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.ObjectMemberNode;
import com.jantuomi.tunkki.exception.types.TunkkiError;

/**
 * Created by jan on 3.8.2016.
 */
public class ObjectMemberToken extends UnaryOperatorToken {
    public ObjectMemberToken(String text, String rawText) {
        super(Type.ObjectMemberToken, text, rawText);
    }

    @Override
    public ASTNode generateNode() throws TunkkiError {
        ObjectMemberNode node = new ObjectMemberNode(this, operand.generateNode());
        return node;
    }
}
