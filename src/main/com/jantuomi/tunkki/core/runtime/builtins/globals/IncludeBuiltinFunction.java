package com.jantuomi.tunkki.core.runtime.builtins.globals;


import com.jantuomi.tunkki.Tunkki;
import com.jantuomi.tunkki.core.CommandLineArgumentContainer;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.StringDatatype;
import com.jantuomi.tunkki.core.parser.datatype.VoidDatatype;
import com.jantuomi.tunkki.core.runtime.State;
import com.jantuomi.tunkki.core.runtime.builtins.BuiltinManager;
import com.jantuomi.tunkki.exception.ExceptionManager;
import com.jantuomi.tunkki.exception.types.*;

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
    public Datatype evaluate(List<Datatype> params) throws TunkkiError {
        if (params.size() != 1) {
            throw new FunctionArgumentTunkkiError(-1, getName(), Datatype.toString(params));
        }

        if (params.get(0).getType() != Datatype.Type.String) {
            throw new TypeTunkkiError(-1, params.get(0).getType().toString(), getName());
        }

        String filename = ((StringDatatype) params.get(0)).getData();

        if (BuiltinManager.getInstance().BUILTIN_MODULES.contains(filename)) {

            BuiltinManager.getInstance().getFunctionsFromModule(filename)
                    .forEach( f -> State.getInstance().addFunctionToScope(f.getName(), f) );

        }
        else {
            String contents = CommandLineArgumentContainer.getInstance().readFileContents(filename);

            if (contents == null) {
                return null;
            }

            String regex = String.format(".*include\\?\\s+\"\\s?%s\\s?\"\\s?\\!.*", Pattern.quote(filename));
            Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
            Matcher matcher = pattern.matcher(contents);
            if (matcher.matches()) {
                throw new RecursiveIncludeTunkkiError(-1, filename);
            }

            Tunkki.getInstance().run(contents);
        }

        return new VoidDatatype();
    }

    @Override
    public String getName() {
        return "include";
    }
}
