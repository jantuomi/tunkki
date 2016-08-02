package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.runtime.State;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 21.6.2016.
 */
public class AssignmentNode extends BinaryOperatorNode {
    public AssignmentNode(Token token, SymbolNode lhs, ASTNode rhs) {
        super(token, lhs, rhs);
    }

    @Override
    public Datatype evaluate() throws TunkkiError {
        SymbolNode symbol = (SymbolNode) lhs;
        Datatype rValue = rhs.evaluate();
        State.getInstance().setSymbolValueToScope(
                symbol.getName(),
                rValue
        );
        return rValue;
    }

    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList(lhs, rhs);
    }
}
