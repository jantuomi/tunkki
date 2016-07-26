package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.BooleanDataContainer;
import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.parser.datatype.IntegerDataContainer;
import com.jantuomi.tunkki.core.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.BorkError;
import com.jantuomi.tunkki.exception.ExceptionManager;

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
