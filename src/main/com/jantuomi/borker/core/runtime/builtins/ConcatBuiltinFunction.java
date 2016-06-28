package com.jantuomi.borker.core.runtime.builtins;

import com.jantuomi.borker.core.parser.datatype.DataContainer;
import com.jantuomi.borker.core.parser.datatype.StringDataContainer;
import com.jantuomi.borker.core.runtime.Function;
import com.jantuomi.borker.exception.BorkError;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 21.6.2016.
 */
public class ConcatBuiltinFunction extends Function {
    public ConcatBuiltinFunction() {
        super(
                Arrays.asList("strings"),
                null
        );
    }

    @Override
    public String getName() {
        return "concat";
    }

    @Override
    public DataContainer evaluate(List<DataContainer> params) throws BorkError {
        StringBuilder sb = new StringBuilder();
        for (DataContainer d : params) {
            sb.append(d.getData());
        }

        return new StringDataContainer(
                sb.toString()
        );
    }
}
