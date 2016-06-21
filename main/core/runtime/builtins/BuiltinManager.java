package com.jantuomi.interpreter.main.core.runtime.builtins;

import com.jantuomi.interpreter.main.core.runtime.Function;

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
        builtins.add(new OutBuiltinFunction());
    }

    public List<Function> getBuiltins() {
        return builtins;
    }
}
