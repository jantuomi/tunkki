package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.CallNode;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 26.7.2016.
 */
public class CallToken extends VarargOperatorToken {
    public CallToken(String text, String rawText) {
        super(Type.CallToken, text, rawText);
    }

    @Override
    public ASTNode generateNode() throws TunkkiError {
        CallNode node = new CallNode(this);
        node.setName(this.getText());

        List<ASTNode> arguments = new ArrayList<>();

        for (Token token : args) {
            ASTNode arg = token.generateNode();
            if (arg != null) {
                arguments.add(arg);
            }
        }
        node.setParameters(arguments);
        return node;
    }

    @Override
    public Type getTerminatorTokenType() {
        return Type.CallEndToken;
    }
}
