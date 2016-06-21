package com.jantuomi.interpreter.main.core.runtime.builtins;

import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.runtime.Function;
import com.jantuomi.interpreter.main.exception.InterpreterException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 21.6.2016.
 */
public class OutBuiltinFunction extends Function {
    public OutBuiltinFunction() {
        super(
                Arrays.asList("expression"),
                null
        );
    }

    @Override
    public String getName() {
        return "out";
    }

    @Override
    public DataContainer evaluate(List<DataContainer> params) throws InterpreterException {
        DataContainer param = params.get(0);
        System.out.println(param.getData().toString());
        return param;
    }
}
