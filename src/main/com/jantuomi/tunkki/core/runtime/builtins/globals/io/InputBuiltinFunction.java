package com.jantuomi.tunkki.core.runtime.builtins.globals.io;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.NadaDatatype;
import com.jantuomi.tunkki.core.parser.datatype.StringDatatype;
import com.jantuomi.tunkki.core.runtime.builtins.globals.BuiltinFunction;
import com.jantuomi.tunkki.exception.types.TunkkiError;
import com.jantuomi.tunkki.utils.IO;

import java.io.IOException;
import java.util.*;

/**
 * Created by jan on 21.6.2016.
 */
public class InputBuiltinFunction extends BuiltinFunction {
    public InputBuiltinFunction() {
        super(
                Arrays.asList("expression")
        );
    }

    @Override
    public Datatype executeBlock(List<Datatype> params) throws TunkkiError {
        Datatype param = params.get(0);
        System.out.print(param.getData().toString());

        String in;
        try {
            in = IO.getInstance().readLine("");
            return new StringDatatype(in);
        } catch (IOException e) {
            e.printStackTrace();
            return new NadaDatatype();
        }
    }

    @Override
    public boolean hasVariableArgumentList() {
        return false;
    }

    @Override
    public List<Set<Datatype.Type>> getArgumentTypes() {
        return Collections.singletonList(
                createAcceptableTypeSet(Datatype.Type.String)
        );
    }
}
