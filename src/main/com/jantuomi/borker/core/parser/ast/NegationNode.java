package com.jantuomi.borker.core.parser.ast;

import com.jantuomi.borker.core.parser.datatype.BooleanDataContainer;
import com.jantuomi.borker.core.parser.datatype.DataContainer;
import com.jantuomi.borker.core.parser.datatype.IntegerDataContainer;
import com.jantuomi.borker.core.tokenizer.token.Token;
import com.jantuomi.borker.exception.BorkError;
import com.jantuomi.borker.exception.ExceptionManager;

/**
 * Created by jan on 21.6.2016.
 */
public class NegationNode extends UnaryOperatorNode {
    public NegationNode(Token token, ASTNode operand) {
        super(token, operand);
    }

    @Override
    public DataContainer evaluate() throws BorkError {
        DataContainer d = getOperand().evaluate();

        if (d instanceof BooleanDataContainer) {
            return new BooleanDataContainer(!((BooleanDataContainer) d).getData());
        }
        else if (d instanceof IntegerDataContainer) {
            return new BooleanDataContainer(
                    ((IntegerDataContainer) d).getData() != 0
            );
        }
        ExceptionManager.raise(BorkError.ExceptionType.TypeError, source.getLine(), "not", d.toString());
        return null;

    }
}
