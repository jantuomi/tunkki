package com.jantuomi.tunkki.core.runtime.builtins;

import com.jantuomi.tunkki.core.parser.datatype.BooleanDataContainer;
import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.parser.datatype.ListDataContainer;
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
    public DataContainer evaluate(List<DataContainer> params) throws TunkkiError {
        if (params.size() != 2) {
            throw new TunkkiError(TunkkiError.ExceptionType.FunctionArgumentError, -1, getName(), DataContainer.toString(params));
        }

        if (params.get(0).getType() != DataContainer.Type.List) {
            throw new TunkkiError(TunkkiError.ExceptionType.FunctionArgumentError, -1, getName(), DataContainer.toString(params));
        }

        ListDataContainer list = (ListDataContainer) params.get(0);
        DataContainer comp = params.get(1);

        for (DataContainer elem : list.getData()) {
            if (elem.equals(comp)) {
                return new BooleanDataContainer(true);
            }
        }
        return new BooleanDataContainer(false);
    }

    @Override
    public String getName() {
        return "contains";
    }
}
