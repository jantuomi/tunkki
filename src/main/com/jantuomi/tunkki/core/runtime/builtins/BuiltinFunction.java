package com.jantuomi.tunkki.core.runtime.builtins;

import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.runtime.Function;
import com.jantuomi.tunkki.exception.BorkError;

import java.util.List;

/**
 * Created by jan on 28.6.2016.
 */
abstract public class BuiltinFunction extends Function{
    public BuiltinFunction(List<String> argumentNames) {
        super(argumentNames, null);
    }

    @Override
    abstract public DataContainer evaluate(List<DataContainer> params) throws BorkError;

    @Override
    abstract public String getName();
}
