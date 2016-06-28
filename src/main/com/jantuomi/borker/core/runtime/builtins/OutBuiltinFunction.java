package com.jantuomi.borker.core.runtime.builtins;

import com.jantuomi.borker.core.parser.datatype.DataContainer;
import com.jantuomi.borker.core.parser.datatype.VoidDataContainer;
import com.jantuomi.borker.core.runtime.Function;
import com.jantuomi.borker.exception.BorkError;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 21.6.2016.
 */
public class OutBuiltinFunction extends Function {
    public OutBuiltinFunction() {
        super(
                Arrays.asList("expression"),
                null
        );
    }

    @Override
    public String getName() {
        return "out";
    }

    @Override
    public DataContainer evaluate(List<DataContainer> params) throws BorkError {
        DataContainer param = params.get(0);
        System.out.println(param.getData().toString());
        return new VoidDataContainer();
    }
}
