package com.jantuomi.tunkki.core.runtime.builtins.globals;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.ListDatatype;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by jan on 27.7.2016.
 */
public class ListBuiltinFunction extends BuiltinFunction {
    public ListBuiltinFunction() {
        super(Arrays.asList("elements"));
    }

    @Override
    public Datatype evaluate(List<Datatype> params) throws TunkkiError {
        ListDatatype data = new ListDatatype(params);
        return data;
    }

    @Override
    public boolean hasVariableArgumentList() {
        return true;
    }

    @Override
    public List<Set<Datatype.Type>> getArgumentTypes() {
        return Collections.emptyList();
    }
}
