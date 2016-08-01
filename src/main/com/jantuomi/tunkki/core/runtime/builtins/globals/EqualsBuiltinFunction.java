package com.jantuomi.tunkki.core.runtime.builtins.globals;

import com.jantuomi.tunkki.core.parser.datatype.BooleanDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 31.7.2016.
 */
public class EqualsBuiltinFunction extends BuiltinFunction {
    public EqualsBuiltinFunction() {
        super(Arrays.asList("lhs", "rhs"));
    }

    @Override
    public Datatype evaluate(List<Datatype> params) throws TunkkiError {
        if (params.size() != 2) {
            throw new TunkkiError(TunkkiError.ExceptionType.FunctionArgumentError, -1, getName(), Datatype.toString(params));
        }

        return new BooleanDatatype(
            params.get(0).equals(params.get(1)).getData()
        );
    }

    @Override
    public String getName() {
        return "eq";
    }
}
