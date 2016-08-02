package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.BooleanDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.IntegerDatatype;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.ExceptionManager;
import com.jantuomi.tunkki.exception.types.TunkkiError;
import com.jantuomi.tunkki.exception.types.TypeTunkkiError;

/**
 * Created by jan on 21.6.2016.
 */
public class NegationNode extends UnaryOperatorNode {
    public NegationNode(Token token, ASTNode operand) {
        super(token, operand);
    }

    @Override
    public Datatype evaluate() throws TunkkiError {
        Datatype d = getOperand().evaluate();

        if (d instanceof BooleanDatatype) {
            return new BooleanDatatype(!((BooleanDatatype) d).getData());
        }
        else if (d instanceof IntegerDatatype) {
            return new BooleanDatatype(
                    ((IntegerDatatype) d).getData() != 0
            );
        }
        throw new TypeTunkkiError(source.getLine(), "not", d.toString());

    }
}
