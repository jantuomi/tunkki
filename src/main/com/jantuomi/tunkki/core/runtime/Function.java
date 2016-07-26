package com.jantuomi.tunkki.core.runtime;

import com.jantuomi.tunkki.core.parser.ast.BlockBodyNode;
import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.List;

/**
 * Created by jan on 20.6.2016.
 */
public class Function {

    private List<String> argumentNames;

    private BlockBodyNode body;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Function(List<String> argumentNames, BlockBodyNode body) {
        this.argumentNames = argumentNames;
        this.body = body;
    }

    public DataContainer evaluate(List<DataContainer> params) throws TunkkiError {
        State.getInstance().createScope();

        if (params.size() != argumentNames.size()) {
            return null;
        }

        for (int i = 0; i < argumentNames.size(); i++) {
            State.getInstance().addSymbolToScope(argumentNames.get(i));
            State.getInstance().setSymbolValueToScope(argumentNames.get(i), params.get(i));
        }

        DataContainer returnValue = body.evaluate();

        State.getInstance().popScope();

        return returnValue;
    }

}
