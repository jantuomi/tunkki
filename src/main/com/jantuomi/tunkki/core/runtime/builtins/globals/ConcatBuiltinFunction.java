package com.jantuomi.tunkki.core.runtime.builtins.globals;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.StringDatatype;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
    public Datatype executeBlock(List<Datatype> params) throws TunkkiError {
        StringBuilder sb = new StringBuilder();
        for (Datatype d : params) {
            sb.append(d.getData());
        }

        return new StringDatatype(
                sb.toString()
        );
    }

    @Override
    public boolean hasVariableArgumentList() {
        return true;
    }

    @Override
    public List<Set<Datatype.Type>> getArgumentTypes() {
        return Arrays.asList(
                createAcceptableTypeSet(Datatype.Type.String)
        );
    }
}
