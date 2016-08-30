package com.jantuomi.tunkki.core.runtime.builtins.globals.cast;

import com.jantuomi.tunkki.core.parser.datatype.*;
import com.jantuomi.tunkki.core.runtime.builtins.globals.BuiltinFunction;
import com.jantuomi.tunkki.exception.types.CastTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by jan on 21.6.2016.
 */
public class AsBooleanBuiltinFunction extends BuiltinFunction {
    public AsBooleanBuiltinFunction() {
        super(
                Arrays.asList("expression")
        );
    }

    @Override
    public BooleanDatatype executeBlock(List<Datatype> params) throws TunkkiError {
        Datatype param = params.get(0);
        switch (param.getType()) {
            case Integer:
                return new BooleanDatatype(((IntegerDatatype) param).getData() != 0);
            case Boolean:
                return new BooleanDatatype(((BooleanDatatype) param).getData());
            default:
                throw new CastTunkkiError(-1, "Boolean", param.toString());
        }

    }

    @Override
    public boolean hasVariableArgumentList() {
        return false;
    }

    @Override
    public List<Set<Datatype.Type>> getArgumentTypes() {
        return Arrays.asList(
                createAcceptableTypeSet(Datatype.Type.Integer, Datatype.Type.Boolean)
        );
    }
}
