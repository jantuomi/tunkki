package com.jantuomi.tunkki.core.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.ParameterListNode;
import com.jantuomi.tunkki.core.parser.ast.SymbolNode;
import com.jantuomi.tunkki.exception.BorkError;

/**
 * Created by jan on 16.6.2016.
 */
public class SymbolToken extends OptionalArgumentToken {

    public SymbolToken(String name) {
        super(Type.SymbolToken, name);
    }

    @Override
    public ASTNode generateNode() throws BorkError {
        SymbolNode node = new SymbolNode(this);
        node.setName(this.getText());
        if (optionalArgument != null) {
            node.setParameterListNode((ParameterListNode) optionalArgument.generateNode());
        }
        return node;
    }

    @Override
    public Type getOptionalArgumentType() {
        return Type.OpenParenToken;
    }
}
