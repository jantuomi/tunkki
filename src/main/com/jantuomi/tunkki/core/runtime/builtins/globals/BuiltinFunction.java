package com.jantuomi.tunkki.core.runtime.builtins.globals;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.runtime.Function;
import com.jantuomi.tunkki.core.runtime.UserDefinedFunction;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.List;
import java.util.Set;

/**
 * Created by jan on 28.6.2016.
 */
abstract public class BuiltinFunction extends Function {
    public BuiltinFunction(List<String> argumentNames) {
        super(argumentNames, null);
    }

    @Override
    abstract public List<Set<Datatype.Type>> getArgumentTypes();

    @Override
    public boolean hasDynamicallyTypedArguments() {
        return false;
    }
}
