package com.jantuomi.tunkki.core.runtime.builtins;


import com.jantuomi.tunkki.Main;
import com.jantuomi.tunkki.core.CommandLineArgumentContainer;
import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.parser.datatype.StringDataContainer;
import com.jantuomi.tunkki.core.parser.datatype.VoidDataContainer;
import com.jantuomi.tunkki.exception.ExceptionManager;
import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jan on 28.6.2016.
 */
public class IncludeBuiltinFunction extends BuiltinFunction {

    public IncludeBuiltinFunction() {
        super(Arrays.asList("filename"));
    }

    @Override
    public DataContainer evaluate(List<DataContainer> params) throws TunkkiError {
        String filename;
        if (params.size() == 1 && params.get(0).getType() == DataContainer.Type.String) {
            filename = ((StringDataContainer) params.get(0)).getData();
        } else {
            ExceptionManager.raise(TunkkiError.ExceptionType.GeneralError, -1, "Include argument must be a valid file name string.");
            return null;
        }

        String contents = CommandLineArgumentContainer.getInstance().readFileContents(filename);

        if (contents == null) {
            return null;
        }

        String regex = String.format(".*include\\?\\s+\"\\s?%s\\s?\"\\s?\\!.*", Pattern.quote(filename));
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(contents);
        if (matcher.matches()) {
            ExceptionManager.raise(TunkkiError.ExceptionType.GeneralError, -1, "Recursive include detected, aborting.");
            return null;
        }

        Main.run(contents);
        return new VoidDataContainer();
    }

    @Override
    public String getName() {
        return "include";
    }
}
