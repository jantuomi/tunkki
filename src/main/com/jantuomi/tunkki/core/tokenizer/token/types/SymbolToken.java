package com.jantuomi.tunkki.core.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.SymbolNode;
import com.jantuomi.tunkki.exception.TunkkiError;

/**
 * Created by jan on 16.6.2016.
 */
public class SymbolToken extends TerminalToken {

    public SymbolToken(String name) {
        super(Type.SymbolToken, name);
    }

    @Override
    public ASTNode generateNode() throws TunkkiError {
        SymbolNode node = new SymbolNode(this);
        node.setName(this.getText());

        return node;
    }
}
