package com.jantuomi.tunkki.core.runtime.builtins;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.IntegerDatatype;
import com.jantuomi.tunkki.core.parser.datatype.ListDatatype;
import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 28.7.2016.
 */
public class GetBuiltinFunction extends BuiltinFunction {
    public GetBuiltinFunction() {
        super(Arrays.asList("index"));
    }

    @Override
    public Datatype evaluate(List<Datatype> params) throws TunkkiError {
        if (params.size() != 2) {
            throw new TunkkiError(TunkkiError.ExceptionType.FunctionArgumentError, -1, getName(), params.toString());
        }

        if (params.get(0).getType() != Datatype.Type.List) {
            throw new TunkkiError(TunkkiError.ExceptionType.FunctionArgumentError, -1, getName(), Datatype.toString(params));
        }

        if (params.get(1).getType() != Datatype.Type.Integer) {
            throw new TunkkiError(TunkkiError.ExceptionType.FunctionArgumentError, -1, getName(), Datatype.toString(params));
        }

        ListDatatype list = (ListDatatype) params.get(0);
        IntegerDatatype index = (IntegerDatatype) params.get(1);

        try {
            return list.getData().get(index.getData());
        }
        catch (Exception ex) {
            throw new TunkkiError(TunkkiError.ExceptionType.GeneralError, -1, "List index out of bounds.");
        }
    }

    @Override
    public String getName() {
        return "get";
    }
}
