package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.ObjectInstantiationNode;
import com.jantuomi.tunkki.core.parser.ast.ObjectPrototypeNode;
import com.jantuomi.tunkki.core.parser.ast.SymbolNode;
import com.jantuomi.tunkki.exception.types.TunkkiError;

/**
 * Created by jan on 29.8.2016.
 */
public class ObjectInstantiationToken extends UnaryOperatorToken {
    public ObjectInstantiationToken() {
        super(Type.ObjectInstantiationToken, "new");
    }

    @Override
    public ASTNode generateNode() throws TunkkiError {
        SymbolNode symbol = (SymbolNode) operand.generateNode();

        return new ObjectInstantiationNode(this, symbol);
    }
}
