package com.jantuomi.tunkki.core.runtime.builtins.globals.cast;

import com.jantuomi.tunkki.core.parser.datatype.*;
import com.jantuomi.tunkki.core.runtime.builtins.globals.BuiltinFunction;
import com.jantuomi.tunkki.exception.types.CastTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 21.6.2016.
 */
public class AsIntBuiltinFunction extends BuiltinFunction {
    public AsIntBuiltinFunction() {
        super(
                Arrays.asList("expression")
        );
    }

    @Override
    public IntegerDatatype evaluate(List<Datatype> params) throws TunkkiError {
        if (params.size() != 1) {
            return null;
        }
        Datatype param = params.get(0);
        int i;
        switch (param.getType()) {
            case String:
                try {
                    i = Integer.parseInt(((StringDatatype) param).getData());
                }
                catch (NumberFormatException ex) {
                    throw new CastTunkkiError(-1, "Integer", ((StringDatatype) param).getData());
                }
                return new IntegerDatatype(i);
            case Integer:
                return new IntegerDatatype(((IntegerDatatype) param).getData());
            case Boolean:
                return new IntegerDatatype(((BooleanDatatype) param).getData() ? 1 : 0);
            case Double:
                return new IntegerDatatype((int) Math.round(((DoubleDatatype) param).getData()));
            default:
                throw new CastTunkkiError(-1, "Integer", param.toString());
        }

    }
}
