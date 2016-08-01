package com.jantuomi.tunkki.core.runtime.builtins.globals;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.VoidDatatype;
import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 21.6.2016.
 */
public class OutputBuiltinFunction extends BuiltinFunction {
    public OutputBuiltinFunction() {
        super(
                Arrays.asList("expression")
        );
    }

    @Override
    public String getName() {
        return "output";
    }

    @Override
    public Datatype evaluate(List<Datatype> params) throws TunkkiError {
        Datatype param = params.get(0);
        System.out.println(param.getData().toString());
        return new VoidDatatype();
    }
}
