package com.jantuomi.tunkki.core.runtime.builtins;

import com.jantuomi.tunkki.core.runtime.Function;
import com.jantuomi.tunkki.core.runtime.builtins.globals.*;
import com.jantuomi.tunkki.core.runtime.builtins.globals.cast.AsBooleanBuiltinFunction;
import com.jantuomi.tunkki.core.runtime.builtins.globals.cast.AsIntBuiltinFunction;
import com.jantuomi.tunkki.core.runtime.builtins.math.PowerBuiltinFunction;
import com.jantuomi.tunkki.exception.types.IncludeTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.*;

/**
 * Created by jan on 21.6.2016.
 */
public class BuiltinManager {
    private static BuiltinManager instance = new BuiltinManager();

    public static BuiltinManager getInstance() {
        return instance;
    }

    private List<BuiltinFunction> builtins;

    public final Set<String> BUILTIN_MODULES = new HashSet<>(Arrays.asList(
            "math"
    ));

    private BuiltinManager() {
        instance = this;
        builtins = new ArrayList<>();
        initializeGlobals();
    }

    private void initializeGlobals() {
        builtins.add(new OutputBuiltinFunction());
        builtins.add(new InputBuiltinFunction());
        builtins.add(new ConcatBuiltinFunction());
        builtins.add(new AsIntBuiltinFunction());
        builtins.add(new AsBooleanBuiltinFunction());
        builtins.add(new IncludeBuiltinFunction());
        builtins.add(new ListBuiltinFunction());
        builtins.add(new ContainsBuiltinFunction());
        builtins.add(new GetBuiltinFunction());
        builtins.add(new EqualsBuiltinFunction());
    }

    private List<Function> getFunctionsFromMathModule() {
        return Arrays.asList(new PowerBuiltinFunction());
    }

    public List<Function> getFunctionsFromModule(String name) throws TunkkiError {
        if (name.equals("math")) {
            return getFunctionsFromMathModule();
        }
        else {
            throw new IncludeTunkkiError(-1, name);
        }
    }

    public void addBuiltin(BuiltinFunction func) {
        builtins.add(func);
    }

    public List<BuiltinFunction> getBuiltins() {
        return builtins;
    }
}
