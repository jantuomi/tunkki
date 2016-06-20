package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.parser.ast.ParameterListNode;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

/**
 * Created by jan on 19.6.2016.
 */
public class OpenParenToken extends VarargOperatorToken {
    public OpenParenToken() {
        super(Type.OpenParenToken);
    }

    @Override
    public ASTNode generateNode() {
        ParameterListNode node = new ParameterListNode(this);

        for (Token token : args) {
            if (token.getTokenType() == Type.ClosedParenToken) {
                continue;
            }

            node.addParameter(token.generateNode());
        }
        return node;
    }
}
