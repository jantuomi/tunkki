package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.CallableDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.types.TunkkiError;

/**
 * Created by jan on 30.7.2016.
 */
public class CallNode extends SymbolNode {
    public CallNode(Token token) {
        super(token);
    }

    @Override
    public Datatype evaluate() throws TunkkiError {
        Datatype d = super.evaluate();
        if (d.getType() == Datatype.Type.Callable) {
            try {
                Datatype r = ((CallableDatatype) d).call(evaluateParameters());
                return r;
            }
            catch (TunkkiError ex) {
                ex.setLine(getLine());
                throw ex;
            }
        } else {
            return d;
        }
    }
}
