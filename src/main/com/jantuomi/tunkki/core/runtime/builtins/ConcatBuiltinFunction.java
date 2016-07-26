package com.jantuomi.tunkki.core.runtime.builtins;

import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.parser.datatype.StringDataContainer;
import com.jantuomi.tunkki.exception.BorkError;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 21.6.2016.
 */
public class ConcatBuiltinFunction extends BuiltinFunction {
    public ConcatBuiltinFunction() {
        super(
                Arrays.asList("strings")
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
