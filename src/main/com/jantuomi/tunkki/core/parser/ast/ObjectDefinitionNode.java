package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.CallableDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.ObjectDatatype;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.core.runtime.Function;
import com.jantuomi.tunkki.core.runtime.State;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.Collections;

/**
 * Created by jan on 8.8.2016.
 */
public class ObjectDefinitionNode extends NullaryOperatorNode {
    public ObjectDefinitionNode(Token token, String name, CallableDatatype constructor) {
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
        ObjectDatatype obj = new ObjectDatatype();

        State state = new State();
        constructor.call(Collections.emptyList());
        Function func = constructor.getData();
        func.setState(state);

        obj.setData(func.getState().getGlobalScope());
        return obj;
    }
}
