package com.jantuomi.tunkki.core.runtime.builtins.globals;

import com.jantuomi.tunkki.core.parser.datatype.BooleanDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.exception.types.FunctionArgumentTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;
import com.jantuomi.tunkki.exception.types.TypeTunkkiError;

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
            throw new FunctionArgumentTunkkiError(-1, getName(), Datatype.toString(params));
        }

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
    public String getName() {
        return "eq";
    }
}
