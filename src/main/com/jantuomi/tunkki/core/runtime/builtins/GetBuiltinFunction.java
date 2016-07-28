package com.jantuomi.tunkki.core.runtime.builtins;

import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.parser.datatype.IntegerDataContainer;
import com.jantuomi.tunkki.core.parser.datatype.ListDataContainer;
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
    public DataContainer evaluate(List<DataContainer> params) throws TunkkiError {
        if (params.size() != 2) {
            throw new TunkkiError(TunkkiError.ExceptionType.FunctionArgumentError, -1, getName(), params.toString());
        }

        if (params.get(0).getType() != DataContainer.Type.List) {
            throw new TunkkiError(TunkkiError.ExceptionType.FunctionArgumentError, -1, getName(), DataContainer.toString(params));
        }

        if (params.get(1).getType() != DataContainer.Type.Integer) {
            throw new TunkkiError(TunkkiError.ExceptionType.FunctionArgumentError, -1, getName(), DataContainer.toString(params));
        }

        ListDataContainer list = (ListDataContainer) params.get(0);
        IntegerDataContainer index = (IntegerDataContainer) params.get(1);

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