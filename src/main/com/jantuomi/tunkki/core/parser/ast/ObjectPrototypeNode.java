package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.CallableDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.ObjectPrototypeDatatype;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.core.runtime.Function;
import com.jantuomi.tunkki.core.runtime.State;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.Collections;

/**
 * Created by jan on 8.8.2016.
 */
public class ObjectPrototypeNode extends NullaryOperatorNode {
    public ObjectPrototypeNode(Token token, String name, CallableDatatype constructor) {
        super(token);
        this.name = name;
        this.constructor = constructor;
    }

    private String name;
    private CallableDatatype constructor;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Datatype evaluate() throws TunkkiError {
        ObjectPrototypeDatatype prototype = new ObjectPrototypeDatatype();

        State state = new State();
        constructor.call(Collections.emptyList());
        Function func = constructor.getData();
        func.setState(state);

        prototype.setData(func);
        State.getGlobalState().addSymbolToScope(name);
        return prototype;
    }
}
