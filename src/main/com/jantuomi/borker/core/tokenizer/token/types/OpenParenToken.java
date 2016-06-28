package com.jantuomi.borker.core.tokenizer.token.types;

import com.jantuomi.borker.core.parser.ast.ASTNode;
import com.jantuomi.borker.core.parser.ast.ParameterListNode;
import com.jantuomi.borker.core.tokenizer.token.Token;
import com.jantuomi.borker.exception.InterpreterException;

/**
 * Created by jan on 19.6.2016.
 */
public class OpenParenToken extends VarargOperatorToken {
    public OpenParenToken() {
        super(Type.OpenParenToken);
    }

    @Override
    public ASTNode generateNode() throws InterpreterException {
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
