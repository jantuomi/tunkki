package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class AdditionNode extends ASTNode {

    private ASTNode lhs;
    private ASTNode rhs;

    public AdditionNode(Token token, ASTNode lhs, ASTNode rhs) {
        super(token);
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public DataContainer evaluate() {
        DataContainer operand1 = lhs.evaluate();
        DataContainer operand2 = rhs.evaluate();

        DataContainer result = operand1.add(operand2);
        return result;

    }
    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList(lhs, rhs);
    }
}
