package com.jantuomi.tunkki.core.runtime.builtins.globals;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.NadaDatatype;
import com.jantuomi.tunkki.core.parser.datatype.StringDatatype;
import com.jantuomi.tunkki.exception.types.TunkkiError;
import com.jantuomi.tunkki.utils.IO;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
    public Datatype evaluate(List<Datatype> params) throws TunkkiError {
        if (params.size() > 0) {
            Datatype param = params.get(0);
            System.out.print(param.getData().toString());
        }
        String in;
        try {
            in = IO.getInstance().readLine("");
            return new StringDatatype(in);
        } catch (IOException e) {
            e.printStackTrace();
            return new NadaDatatype();
        }

    }
}
