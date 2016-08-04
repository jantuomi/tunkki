package com.jantuomi.tunkki.core.runtime;

import com.jantuomi.tunkki.core.parser.datatype.CallableDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.exception.types.TunkkiError;
import com.jantuomi.tunkki.exception.types.UndeclaredSymbolTunkkiError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by jan on 20.6.2016.
 */
public class Scope {
    private Scope parent = null;

    private Map<String, Datatype> variables = new HashMap<>();
    private Map<String, Function> functions = new HashMap<>();

    public Set<String> getVariableNames() {
        return variables.keySet();
    }

    public Set<String> getFunctionNames() {
        return functions.keySet();
    }

    public void addVariable(String symbol) {
        variables.put(symbol, null);
    }

    public void setVariableValue(String symbol, Datatype value) {
        variables.replace(symbol, value);
    }

    public Datatype resolveSymbol(String symbol, List<Datatype> params) throws TunkkiError {
        if (functions.containsKey(symbol)) {
            return functions.get(symbol).evaluate(params);
        }
        if (variables.containsKey(symbol)) {
            return variables.get(symbol);
        }
        else if (parent != null) {
            return parent.resolveSymbol(symbol, params);
        }
        else {
            throw new UndeclaredSymbolTunkkiError(-1, symbol);
        }
    }

    public CallableDatatype getCallable(String symbol) {
        if (functions.containsKey(symbol)) {
            Function f = functions.get(symbol);
            CallableDatatype c = new CallableDatatype();
            c.setData(f);
            return c;
        }
        else if (parent != null) {
            return parent.getCallable(symbol);
        }
        else {
            return null;
        }
    }

    public void setParent(Scope parent) {
        this.parent = parent;
    }

    public void addFunction(String symbol, Function func) {
        functions.put(symbol, func);
    }

    public boolean isFunction(String symbol) {
        return functions.containsKey(symbol);
    }
}
