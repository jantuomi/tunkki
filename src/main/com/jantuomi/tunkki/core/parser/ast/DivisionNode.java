package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
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
    public Datatype evaluate() throws TunkkiError {
        Datatype operand1 = lhs.evaluate();
        Datatype operand2 = rhs.evaluate();

        Datatype result;
        try {
            result = operand1.divide(operand2);
        }
        catch (ArithmeticException ex) {
            throw new TunkkiError(TunkkiError.ExceptionType.DivisionByZeroError, getLine());
        }

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
