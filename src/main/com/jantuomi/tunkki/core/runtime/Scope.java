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

    public Set<String> getVariableNames() {
        return variables.keySet();
    }

    public void addVariable(String symbol) {
        variables.put(symbol, null);
    }

    public void setVariableValue(String symbol, Datatype value) {
        variables.replace(symbol, value);
    }

    public void addAndSetVariable(String symbol, Datatype value) {
        addVariable(symbol);
        setVariableValue(symbol, value);
    }

    public Datatype resolveSymbol(String symbol, List<Datatype> params) throws TunkkiError {
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

    public void setParent(Scope parent) {
        this.parent = parent;
    }
}
