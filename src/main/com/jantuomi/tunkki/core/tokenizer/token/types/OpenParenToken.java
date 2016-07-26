package com.jantuomi.tunkki.core.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.ParameterListNode;
import com.jantuomi.tunkki.core.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.BorkError;

/**
 * Created by jan on 19.6.2016.
 */
public class OpenParenToken extends VarargOperatorToken {
    public OpenParenToken() {
        super(Type.OpenParenToken);
    }

    @Override
    public ASTNode generateNode() throws BorkError {
        ParameterListNode node = new ParameterListNode(this);

        for (Token token : args) {
            if (token.getTokenType() == Type.ClosedParenToken) {
                continue;
            }

            node.addParameter(token.generateNode());
        }
        return node;
    }

    @Override
    public Type getTerminatorTokenType() {
        return Type.ClosedParenToken;
    }
}
