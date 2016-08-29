package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.ObjectDatatype;
import com.jantuomi.tunkki.core.parser.datatype.ObjectPrototypeDatatype;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.core.parser.tokenizer.token.types.ObjectPrototypeToken;
import com.jantuomi.tunkki.exception.types.NotAPrototypeTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

/**
 * Created by jan on 29.8.2016.
 */
public class ObjectInstantiationNode extends UnaryOperatorNode {
    public ObjectInstantiationNode(Token token, SymbolNode operand) {
        super(token, operand);
    }

    @Override
    public Datatype evaluate() throws TunkkiError {
        SymbolNode symbol = (SymbolNode) getOperand();
        Datatype value = symbol.evaluate();

        if (value.getType() != Datatype.Type.ObjectPrototype) {
            throw new NotAPrototypeTunkkiError(getLine(), getText());
        }

        ObjectDatatype obj = ((ObjectPrototypeDatatype) value).instantiate();
        return obj;
    }
}
