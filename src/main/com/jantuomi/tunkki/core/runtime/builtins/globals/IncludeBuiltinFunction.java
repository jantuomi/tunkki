package com.jantuomi.tunkki.core.runtime.builtins.globals;


import com.jantuomi.tunkki.Tunkki;
import com.jantuomi.tunkki.core.CommandLineArgumentContainer;
import com.jantuomi.tunkki.core.parser.datatype.*;
import com.jantuomi.tunkki.core.runtime.State;
import com.jantuomi.tunkki.core.runtime.builtins.BuiltinManager;
import com.jantuomi.tunkki.exception.types.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        super.evaluate(params);

        StringDatatype param = (StringDatatype) params.get(0);
        String filename = param.getData();

        if (BuiltinManager.getInstance().BUILTIN_MODULES.contains(filename)) {

            ObjectDatatype namespace = new ObjectDatatype();
            Map<String, CallableDatatype> funcs = BuiltinManager.getInstance().getFunctionsFromModule(filename);
            for (String funcName : funcs.keySet()) {
                namespace.getData().addAndSetVariable(funcName, funcs.get(funcName));
            }
            State.getGlobalState().addSymbolToScope(filename);
            State.getGlobalState().setSymbolValueToScope(filename, namespace);

        }
        else {
            String contents = CommandLineArgumentContainer.getInstance().readFileContents(filename);

            if (contents == null) {
                throw new FileNotFoundTunkkiError(-1, param.toString());
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
