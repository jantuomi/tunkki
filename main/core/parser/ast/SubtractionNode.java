package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;
import com.jantuomi.interpreter.main.exception.InterpreterException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class SubtractionNode extends BinaryOperatorNode {
    public SubtractionNode(Token token, ASTNode lhs, ASTNode rhs) {
        super(token, lhs, rhs);
    }

    @Override
    public DataContainer evaluate() throws InterpreterException {
        DataContainer operand1 = lhs.evaluate();
        DataContainer operand2 = rhs.evaluate();

        DataContainer result = operand1.subtract(operand2);
        return result;

    }
    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList(lhs, rhs);
    }
}
