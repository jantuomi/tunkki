package com.jantuomi.tunkki.core.runtime.builtins;

import com.jantuomi.tunkki.core.parser.datatype.BooleanDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.IntegerDatatype;
import com.jantuomi.tunkki.core.parser.datatype.StringDatatype;
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
    public Datatype evaluate(List<Datatype> params) throws TunkkiError {
        if (params.size() != 1) {
            return null;
        }
        Datatype param = params.get(0);
        int i = 0;
        if (param instanceof StringDatatype) {
            try {
                i = Integer.parseInt(((StringDatatype) param).getData());
            }
            catch (NumberFormatException ex) {
                return null;
            }
        }
        else if (param instanceof IntegerDatatype) {
            i = ((IntegerDatatype) param).getData();
        }
        else if (param instanceof BooleanDatatype) {
            i = ((BooleanDatatype) param).getData() ? 1 : 0;
        }
        return new IntegerDatatype(i);
    }
}
