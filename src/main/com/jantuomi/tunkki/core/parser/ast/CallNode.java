package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.CallableDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.TunkkiError;

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
            return ((CallableDatatype) d).call(evaluateParameters());
        } else {
            return d;
        }
    }
}
