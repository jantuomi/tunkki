package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.SymbolNode;
import com.jantuomi.tunkki.core.parser.ast.VariableDeclareNode;
import com.jantuomi.tunkki.exception.types.TunkkiError;

/**
 * Created by jan on 20.6.2016.
 */
public class VariableDeclareToken extends UnaryOperatorToken {


    public VariableDeclareToken() {
        super(Type.DeclarationToken, "decl");
    }

    @Override
    public ASTNode generateNode() throws TunkkiError {
        SymbolToken st = (SymbolToken) operand;
        VariableDeclareNode node =  new VariableDeclareNode(this,
                (SymbolNode) st.generateNode());
        return node;
    }
}
