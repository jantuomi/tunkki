package com.jantuomi.tunkki.core.runtime.builtins;

import com.jantuomi.tunkki.core.parser.datatype.BooleanDataContainer;
import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.parser.datatype.IntegerDataContainer;
import com.jantuomi.tunkki.core.parser.datatype.StringDataContainer;
import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 21.6.2016.
 */
public class AsIntBuiltinFunction extends BuiltinFunction {
    public AsIntBuiltinFunction() {
        super(
                Arrays.asList("expression")
        );
    }

    @Override
    public String getName() {
        return "as_int";
    }

    @Override
    public DataContainer evaluate(List<DataContainer> params) throws TunkkiError {
        if (params.size() != 1) {
            return null;
        }
        DataContainer param = params.get(0);
        int i = 0;
        if (param instanceof StringDataContainer) {
            try {
                i = Integer.parseInt(((StringDataContainer) param).getData());
            }
            catch (NumberFormatException ex) {
                return null;
            }
        }
        else if (param instanceof IntegerDataContainer) {
            i = ((IntegerDataContainer) param).getData();
        }
        else if (param instanceof BooleanDataContainer) {
            i = ((BooleanDataContainer) param).getData() ? 1 : 0;
        }
        return new IntegerDataContainer(i);
    }
}
