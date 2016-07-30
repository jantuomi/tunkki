package com.jantuomi.tunkki.core.runtime.builtins;

import com.jantuomi.tunkki.core.parser.datatype.BooleanDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.ListDatatype;
import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 27.7.2016.
 */
public class ContainsBuiltinFunction extends BuiltinFunction {
    public ContainsBuiltinFunction() {
        super(Arrays.asList("list", "element"));
    }

    @Override
    public Datatype evaluate(List<Datatype> params) throws TunkkiError {
        if (params.size() != 2) {
            throw new TunkkiError(TunkkiError.ExceptionType.FunctionArgumentError, -1, getName(), Datatype.toString(params));
        }

        if (params.get(0).getType() != Datatype.Type.List) {
            throw new TunkkiError(TunkkiError.ExceptionType.FunctionArgumentError, -1, getName(), Datatype.toString(params));
        }

        ListDatatype list = (ListDatatype) params.get(0);
        Datatype comp = params.get(1);

        for (Datatype elem : list.getData()) {
            if (elem.equals(comp).getData()) {
                return new BooleanDatatype(true);
            }
        }
        return new BooleanDatatype(false);
    }

    @Override
    public String getName() {
        return "contains";
    }
}
