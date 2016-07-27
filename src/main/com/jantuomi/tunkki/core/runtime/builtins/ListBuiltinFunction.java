package com.jantuomi.tunkki.core.runtime.builtins;

import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.parser.datatype.ListDataContainer;
import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 27.7.2016.
 */
public class ListBuiltinFunction extends BuiltinFunction {
    public ListBuiltinFunction() {
        super(Arrays.asList("elements"));
    }

    @Override
    public DataContainer evaluate(List<DataContainer> params) throws TunkkiError {
        ListDataContainer data = new ListDataContainer(params);
        return data;
    }

    @Override
    public String getName() {
        return "list";
    }
}
