package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.parser.datatype.BooleanDataContainer;
import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.parser.datatype.IntegerDataContainer;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;
import com.jantuomi.interpreter.main.exception.ExceptionManager;
import com.jantuomi.interpreter.main.exception.InterpreterException;

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
