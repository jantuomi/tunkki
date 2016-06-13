package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.runtime.State;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 11.6.2016.
 */
public class AssignmentNode extends ASTNode {

    private SymbolNode lhs;
    private ExpressionNode rhs;

    public AssignmentNode(SymbolNode lhs, ExpressionNode rhs) {
        super(new Token(Token.Type.AssignmentToken));

        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public DataContainer evaluate() {
        DataContainer value = rhs.evaluate();
        State.getInstance().setSymbolValue(lhs.getSymbol(), value);
        return value;
    }

    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList(lhs, rhs);
    }
}
