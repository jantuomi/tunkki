package com.jantuomi.tunkki.core.runtime.builtins.globals;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.StringDatatype;
import com.jantuomi.tunkki.exception.TunkkiError;

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
    public Datatype evaluate(List<Datatype> params) throws TunkkiError {
        StringBuilder sb = new StringBuilder();
        for (Datatype d : params) {
            sb.append(d.getData());
        }

        return new StringDatatype(
                sb.toString()
        );
    }
}
