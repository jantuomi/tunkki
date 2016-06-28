package com.jantuomi.borker.core.tokenizer.token.types;

import com.jantuomi.borker.core.parser.ast.ASTNode;
import com.jantuomi.borker.core.parser.ast.ParameterListNode;
import com.jantuomi.borker.core.parser.ast.SymbolNode;
import com.jantuomi.borker.exception.InterpreterException;

/**
 * Created by jan on 16.6.2016.
 */
public class SymbolToken extends OptionalArgumentToken {

    public SymbolToken(String name) {
        super(Type.SymbolToken, name);
    }

    @Override
    public ASTNode generateNode() throws InterpreterException {
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
