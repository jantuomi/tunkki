package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.parser.datatype.StringDataContainer;
import com.jantuomi.tunkki.core.runtime.State;
import com.jantuomi.tunkki.core.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.TunkkiError;
import com.sun.java_cup.internal.runtime.Symbol;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 21.6.2016.
 */
public class DeclareAssignNode extends BinaryOperatorNode {
    public DeclareAssignNode(Token token, SymbolNode lhs, ASTNode rhs) {
        super(token, lhs, rhs);
    }

    @Override
    public DataContainer evaluate() throws TunkkiError {
        SymbolNode var;
        try {
            var = (SymbolNode) lhs;
        }
        catch (Exception ex) {
            throw new TunkkiError(TunkkiError.ExceptionType.ExpectedDifferentTokenError, getLine(), getText());
        }

        State.getInstance().addSymbolToScope(var.getName());

        DataContainer rValue = rhs.evaluate();
        State.getInstance().setSymbolValueToScope(
                var.getName(),
                rValue
        );
        return rValue;
    }

    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList(lhs, rhs);
    }
}
