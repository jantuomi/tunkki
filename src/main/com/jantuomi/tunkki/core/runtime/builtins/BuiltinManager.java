package com.jantuomi.tunkki.core.runtime.builtins;

import com.jantuomi.tunkki.core.parser.datatype.CallableDatatype;
import com.jantuomi.tunkki.core.runtime.builtins.globals.*;
import com.jantuomi.tunkki.core.runtime.builtins.globals.cast.AsBooleanBuiltinFunction;
import com.jantuomi.tunkki.core.runtime.builtins.globals.cast.AsIntBuiltinFunction;
import com.jantuomi.tunkki.core.runtime.builtins.globals.io.InputBuiltinFunction;
import com.jantuomi.tunkki.core.runtime.builtins.globals.io.OutputBuiltinFunction;
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

    private Map<String, CallableDatatype> builtins = new HashMap<>();

    public final Set<String> BUILTIN_MODULES = new HashSet<>(Arrays.asList(
            "math", "io", "cast"
    ));

    private BuiltinManager() {
        initializeGlobals();
    }

    private void initializeGlobals() {
        builtins.put("concat", new ConcatBuiltinFunction().makeCallable());
        builtins.put("include", new IncludeBuiltinFunction().makeCallable());
        builtins.put("list", new ListBuiltinFunction().makeCallable());
        builtins.put("contains", new ContainsBuiltinFunction().makeCallable());
        builtins.put("get", new GetBuiltinFunction().makeCallable());
        builtins.put("eq", new EqualsBuiltinFunction().makeCallable());
        builtins.put("if", new IfBuiltinFunction().makeCallable());
    }

    private Map<String, CallableDatatype> getFunctionsFromMathModule() {
        Map<String, CallableDatatype> map = new HashMap<>();
        map.put("pow", new PowerBuiltinFunction().makeCallable());
        return map;
    }

    private Map<String, CallableDatatype> getFunctionsFromIOModule() {
        Map<String, CallableDatatype> map = new HashMap<>();
        map.put("input", new InputBuiltinFunction().makeCallable());
        map.put("output", new OutputBuiltinFunction().makeCallable());
        return map;
    }

    private Map<String, CallableDatatype> getFunctionsFromCastModule() {
        Map<String, CallableDatatype> map = new HashMap<>();
        builtins.put("as_int", new AsIntBuiltinFunction().makeCallable());
        builtins.put("as_bool", new AsBooleanBuiltinFunction().makeCallable());
        return map;
    }

    public Map<String, CallableDatatype> getFunctionsFromModule(String name) throws TunkkiError {
        if ("math".equals(name)) {
            return getFunctionsFromMathModule();
        }
        else if ("io".equals(name)) {
            return getFunctionsFromIOModule();
        }
        else if ("cast".equals(name)) {
            return getFunctionsFromCastModule();
        }
        else {
            throw new IncludeTunkkiError(-1, name);
        }
    }

    public Map<String, CallableDatatype> getBuiltins() {
        return builtins;
    }
}
