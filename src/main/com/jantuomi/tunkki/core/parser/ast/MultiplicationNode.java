package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.BorkError;
import com.jantuomi.tunkki.exception.ExceptionManager;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class MultiplicationNode extends BinaryOperatorNode {

    public MultiplicationNode(Token token, ASTNode lhs, ASTNode rhs) {
        super(token, lhs, rhs);
    }

    @Override
    public DataContainer evaluate() throws BorkError {
        DataContainer operand1 = lhs.evaluate();
        DataContainer operand2 = rhs.evaluate();

        DataContainer result = operand1.multiply(operand2);
        if (result != null) {
            return result;
        } else {
            ExceptionManager.raise(BorkError.ExceptionType.TypeError, source.getLine(),
                    operand1.getType().toString(), operand2.getType().toString());
            return null;
        }

    }
    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList(lhs, rhs);
    }
}
