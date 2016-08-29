package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.runtime.State;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.types.ExpectedDifferentTokenTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

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
    public Datatype evaluate() throws TunkkiError {
        SymbolNode var;
        try {
            var = (SymbolNode) lhs;
        }
        catch (Exception ex) {
            throw new ExpectedDifferentTokenTunkkiError(getLine(), getText());
        }

        State.getGlobalState().addSymbolToScope(var.getName());

        Datatype rValue = rhs.evaluate();
        State.getGlobalState().setSymbolValueToScope(
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
