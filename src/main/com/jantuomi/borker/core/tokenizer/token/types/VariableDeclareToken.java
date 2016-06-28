package com.jantuomi.borker.core.tokenizer.token.types;

import com.jantuomi.borker.core.parser.ast.ASTNode;
import com.jantuomi.borker.core.parser.ast.SymbolNode;
import com.jantuomi.borker.core.parser.ast.VariableDeclareNode;
import com.jantuomi.borker.exception.InterpreterException;

/**
 * Created by jan on 20.6.2016.
 */
public class VariableDeclareToken extends UnaryOperatorToken {


    public VariableDeclareToken() {
        super(Type.DeclarationToken, "decl");
    }

    @Override
    public ASTNode generateNode() throws InterpreterException {
        SymbolToken st = (SymbolToken) operand;
        VariableDeclareNode node =  new VariableDeclareNode(this,
                (SymbolNode) st.generateNode());
        return node;
    }
}
