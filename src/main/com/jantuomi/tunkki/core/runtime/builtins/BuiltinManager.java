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

    private List<Function> builtins = new ArrayList<>();

    private BuiltinManager() {
        builtins.add(new OutputBuiltinFunction());
        builtins.add(new InputBuiltinFunction());
        builtins.add(new ConcatBuiltinFunction());
        builtins.add(new AsIntBuiltinFunction());
        builtins.add(new IncludeBuiltinFunction());
        builtins.add(new ListBuiltinFunction());
        builtins.add(new ContainsBuiltinFunction());
    }

    public List<Function> getBuiltins() {
        return builtins;
    }
}
