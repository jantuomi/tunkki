package com.jantuomi.tunkki.core.runtime.builtins.globals;

import com.jantuomi.tunkki.core.parser.datatype.BooleanDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.exception.types.FunctionArgumentTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;
import com.jantuomi.tunkki.exception.types.TypeTunkkiError;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by jan on 31.7.2016.
 */
public class EqualsBuiltinFunction extends BuiltinFunction {
    public EqualsBuiltinFunction() {
        super(Arrays.asList("lhs", "rhs"));
    }

    @Override
    public Datatype evaluate(List<Datatype> params) throws TunkkiError {
        super.evaluate(params);

        Datatype lhs = params.get(0);
        Datatype rhs = params.get(1);

        BooleanDatatype isEqual = lhs.equals(rhs);
        if (isEqual != null) {
            return isEqual;
        } else {
            throw new TypeTunkkiError(-1, lhs.getType().toString(), rhs.getType().toString());
        }
    }

    @Override
    public boolean hasVariableArgumentList() {
        return false;
    }

    @Override
    public boolean hasDynamicallyTypedArguments() {
        return true;
    }

    @Override
    public List<Set<Datatype.Type>> getArgumentTypes() {
        return Collections.emptyList();
    }
}
