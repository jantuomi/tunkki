package com.jantuomi.tunkki.core.runtime.builtins;

import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.parser.datatype.StringDataContainer;
import com.jantuomi.tunkki.exception.BorkError;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jan on 21.6.2016.
 */
public class InBuiltinFunction extends BuiltinFunction {
    public InBuiltinFunction() {
        super(
                Arrays.asList("expression")
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
