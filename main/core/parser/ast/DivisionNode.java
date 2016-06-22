package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;
import com.jantuomi.interpreter.main.exception.ExceptionManager;
import com.jantuomi.interpreter.main.exception.InterpreterException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class DivisionNode extends BinaryOperatorNode {

    public DivisionNode(Token token, ASTNode lhs, ASTNode rhs) {
        super(token, lhs, rhs);
    }

    @Override
    public DataContainer evaluate() throws InterpreterException {
        DataContainer operand1 = lhs.evaluate();
        DataContainer operand2 = rhs.evaluate();

        DataContainer result = operand1.divide(operand2);
        if (result != null) {
            return result;
        } else {
            ExceptionManager.raise(InterpreterException.ExceptionType.TypeError, source.getLine(),
                    operand1.getType().toString(), operand2.getType().toString());
            return null;
        }

    }
    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList(lhs, rhs);
    }
}
