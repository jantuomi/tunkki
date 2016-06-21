package com.jantuomi.interpreter.main.core.runtime;

import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.runtime.builtins.BuiltinManager;
import com.jantuomi.interpreter.main.exception.InterpreterException;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by jan on 11.6.2016.
 */
public class State {
    private static final State instance = new State();

    public static State getInstance() {
        return instance;
    }

    private Stack<Scope> scopes = new Stack<>();

    private State() {
        /* Push global scope onto the stack */
        Scope globalScope = new Scope();

        for (Function builtin : BuiltinManager.getInstance().getBuiltins()) {
            globalScope.addFunction(builtin.getName(), builtin);
        }

        scopes.push(globalScope);

    }

    private DataContainer resolveSymbol(String symbol) throws InterpreterException {
        return scopes.peek().resolveSymbol(symbol, Arrays.asList());
    }

    public DataContainer getSymbolValue(String symbol) throws InterpreterException {
        DataContainer d = resolveSymbol(symbol);
        return d;
    }

    public DataContainer getSymbolValue(String symbol, List<DataContainer> parameters) throws InterpreterException {
        return scopes.peek().resolveSymbol(symbol, parameters);
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

    public void addSymbolToScope(String symbol) {
        scopes.peek().addVariable(symbol);
    }

    public void addFunctionToScope(String symbol, Function func) {
        scopes.peek().addFunction(symbol, func);
    }

    public void setSymbolValueToScope(String symbol, DataContainer value) {
        scopes.peek().setVariableValue(symbol, value);
    }

    public Scope popScope() {
        return scopes.pop();
    }
}
