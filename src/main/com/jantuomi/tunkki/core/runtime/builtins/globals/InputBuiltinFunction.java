package com.jantuomi.tunkki.core.runtime.builtins.globals;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.StringDatatype;
import com.jantuomi.tunkki.exception.TunkkiError;

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
    public String getName() {
        return "input";
    }

    @Override
    public Datatype evaluate(List<Datatype> params) throws TunkkiError {
        if (params.size() > 0) {
            Datatype param = params.get(0);
            System.out.print(param.getData().toString());
        }
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        return new StringDatatype(userInput);
    }
}
