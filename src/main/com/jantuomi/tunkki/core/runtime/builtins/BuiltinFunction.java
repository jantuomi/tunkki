package com.jantuomi.tunkki.core.runtime.builtins;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.runtime.Function;
import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.List;

/**
 * Created by jan on 28.6.2016.
 */
abstract public class BuiltinFunction extends Function{
    public BuiltinFunction(List<String> argumentNames) {
        super(argumentNames, null);
        BuiltinManager.getInstance().addBuiltin(this);
    }

    @Override
    abstract public Datatype evaluate(List<Datatype> params) throws TunkkiError;

    @Override
    abstract public String getName();
}
