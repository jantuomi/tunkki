package com.jantuomi.tunkki.core.runtime.builtins.globals.io;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.VoidDatatype;
import com.jantuomi.tunkki.core.runtime.builtins.globals.BuiltinFunction;
import com.jantuomi.tunkki.exception.types.TunkkiError;
import com.jantuomi.tunkki.utils.IO;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
    public Datatype executeBlock(List<Datatype> params) throws TunkkiError {
        Datatype param = params.get(0);
        //IO.getInstance().printLine(param.toString());
        System.out.println(param.toString());
        return new VoidDatatype();
    }

    @Override
    public boolean hasVariableArgumentList() {
        return false;
    }

    @Override
    public List<Set<Datatype.Type>> getArgumentTypes() {
        return Arrays.asList(
                createAcceptableTypeSet(Datatype.Type.String)
        );
    }
}
