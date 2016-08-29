package com.jantuomi.tunkki.core.runtime;

import com.jantuomi.tunkki.core.parser.datatype.CallableDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.NadaDatatype;
import com.jantuomi.tunkki.core.runtime.builtins.BuiltinManager;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.Map;
import java.util.Stack;

/**
 * Created by jan on 11.6.2016.
 */
public class State {
    private static final State globalState = new State();

    public static State getGlobalState() {
        return globalState;
    }

    private Stack<Scope> scopes = new Stack<>();

    static {
        globalState.replaceBaseScopeWithGlobal();
    }

    public State() {
        Scope baseScope = new Scope();
        scopes.push(baseScope);
    }

    public void replaceBaseScopeWithGlobal() {
        /* Push global scope onto the stack */
        Scope globalScope = new Scope();

        Map<String, CallableDatatype> builtins = BuiltinManager.getInstance().getBuiltins();
        for (String builtin : builtins.keySet()) {
            globalScope.addVariable(builtin);
            globalScope.setVariableValue(builtin, builtins.get(builtin));
        }

        /* Add nada to the scope */
        globalScope.addVariable("nada");
        globalScope.setVariableValue("nada", new NadaDatatype());

        scopes.set(0, globalScope);
    }

    public Datatype resolveSymbol(String symbol) throws TunkkiError {
        return scopes.peek().resolveSymbol(symbol);
    }

    public Scope createScope() {
        Scope scope = new Scope();
        if (scopes.size() > 0) {
            scope.setParent(scopes.peek());
        } else {
            scope.setParent(null);
        }
        scopes.push(scope);
        return scope;
    }

    public Scope getGlobalScope() {
        return scopes.get(0);
    }

    public Scope getTopmostScope() {
        return scopes.peek();
    }

    public void addSymbolToScope(String symbol) {
        getTopmostScope().addVariable(symbol);
    }

    public void setSymbolValueToScope(String symbol, Datatype value) {
        scopes.peek().setVariableValue(symbol, value);
    }

    public Scope popScope() {
        return scopes.pop();
    }
}
