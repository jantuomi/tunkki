package com.jantuomi.tunkki.core.runtime;

import com.jantuomi.tunkki.core.parser.ast.BlockBodyNode;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.*;

/**
 * Created by jan on 20.6.2016.
 */
public class UserDefinedFunction extends Function {

    public UserDefinedFunction(List<String> argumentNames, BlockBodyNode body) {
        super(argumentNames, body);
    }

    @Override
    public Datatype evaluate(List<Datatype> params) throws TunkkiError {

        super.evaluate(params);

        for (int i = 0; i < argumentNames.size(); i++) {
            State.getGlobalState().addSymbolToScope(argumentNames.get(i));
            State.getGlobalState().setSymbolValueToScope(argumentNames.get(i), params.get(i));
        }

        Datatype returnValue = body.evaluate();
        State.getGlobalState().popScope();

        return returnValue;
    }

    @Override
    public boolean hasVariableArgumentList() {
        return false;
    }

    @Override
    public boolean hasDynamicallyTypedArguments() {
        return true;
    }

    @Override
    public List<Set<Datatype.Type>> getArgumentTypes() {
        return Collections.emptyList();
    }
}
