package com.jantuomi.borker.core.parser.ast;

import com.jantuomi.borker.core.parser.datatype.DataContainer;
import com.jantuomi.borker.core.runtime.State;
import com.jantuomi.borker.core.tokenizer.token.Token;
import com.jantuomi.borker.exception.InterpreterException;

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
    public DataContainer evaluate() throws InterpreterException {
        SymbolNode symbol = (SymbolNode) lhs;
        DataContainer rValue = rhs.evaluate();
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
