package com.jantuomi.tunkki.core.runtime.builtins;

import com.jantuomi.tunkki.core.runtime.Function;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 21.6.2016.
 */
public class BuiltinManager {
    private static BuiltinManager instance = new BuiltinManager();

    public static BuiltinManager getInstance() {
        return instance;
    }

    private List<BuiltinFunction> builtins;

    private BuiltinManager() {
        instance = this;
        builtins = new ArrayList<>();
        new OutputBuiltinFunction();
        new InputBuiltinFunction();
        new ConcatBuiltinFunction();
        new AsIntBuiltinFunction();
        new IncludeBuiltinFunction();
        new ListBuiltinFunction();
        new ContainsBuiltinFunction();
        new GetBuiltinFunction();
    }

    public void addBuiltin(BuiltinFunction func) {
        builtins.add(func);
    }

    public List<BuiltinFunction> getBuiltins() {
        return builtins;
    }
}
