package com.jantuomi.borker.core.runtime.builtins;

import com.jantuomi.borker.core.parser.datatype.DataContainer;
import com.jantuomi.borker.core.parser.datatype.StringDataContainer;
import com.jantuomi.borker.core.runtime.Function;
import com.jantuomi.borker.exception.BorkError;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jan on 21.6.2016.
 */
public class InBuiltinFunction extends Function {
    public InBuiltinFunction() {
        super(
                Arrays.asList("expression"),
                null
        );
    }

    @Override
    public String getName() {
        return "in";
    }

    @Override
    public DataContainer evaluate(List<DataContainer> params) throws BorkError {
        if (params.size() > 0) {
            DataContainer param = params.get(0);
            System.out.print(param.getData().toString());
        }
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        return new StringDataContainer(userInput);
    }
}
