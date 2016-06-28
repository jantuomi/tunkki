package com.jantuomi.borker.core.parser.ast;

import com.jantuomi.borker.core.parser.datatype.BooleanDataContainer;
import com.jantuomi.borker.core.parser.datatype.DataContainer;
import com.jantuomi.borker.core.parser.datatype.IntegerDataContainer;
import com.jantuomi.borker.core.tokenizer.token.Token;
import com.jantuomi.borker.exception.ExceptionManager;
import com.jantuomi.borker.exception.InterpreterException;

/**
 * Created by jan on 21.6.2016.
 */
public class NegationNode extends UnaryOperatorNode {
    public NegationNode(Token token, ASTNode operand) {
        super(token, operand);
    }

    @Override
    public DataContainer evaluate() throws InterpreterException {
        DataContainer d = getOperand().evaluate();

        if (d instanceof BooleanDataContainer) {
            return new BooleanDataContainer(!((BooleanDataContainer) d).getData());
        }
        else if (d instanceof IntegerDataContainer) {
            return new BooleanDataContainer(
                    ((IntegerDataContainer) d).getData() != 0
            );
        }
        ExceptionManager.raise(InterpreterException.ExceptionType.TypeError, source.getLine(), "not", d.toString());
        return null;

    }
}
