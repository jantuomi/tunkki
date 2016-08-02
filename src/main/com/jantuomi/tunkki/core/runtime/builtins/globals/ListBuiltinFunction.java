package com.jantuomi.tunkki.core.runtime.builtins.globals;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.ListDatatype;
import com.jantuomi.tunkki.exception.TunkkiError;

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
    public Datatype evaluate(List<Datatype> params) throws TunkkiError {
        ListDatatype data = new ListDatatype(params);
        return data;
    }

    @Override
    public String getName() {
        return "list";
    }
}