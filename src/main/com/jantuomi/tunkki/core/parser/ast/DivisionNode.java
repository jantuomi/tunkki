package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.ExceptionManager;
import com.jantuomi.tunkki.exception.TunkkiError;

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
    public DataContainer evaluate() throws TunkkiError {
        DataContainer operand1 = lhs.evaluate();
        DataContainer operand2 = rhs.evaluate();

        DataContainer result = operand1.divide(operand2);
        if (result != null) {
            return result;
        } else {
            ExceptionManager.raise(TunkkiError.ExceptionType.TypeError, source.getLine(),
                    operand1.getType().toString(), operand2.getType().toString());
            return null;
        }

    }
    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList(lhs, rhs);
    }
}