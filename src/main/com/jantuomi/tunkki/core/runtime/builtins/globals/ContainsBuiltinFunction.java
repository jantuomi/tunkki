package com.jantuomi.tunkki.core.runtime.builtins.globals;

import com.jantuomi.tunkki.core.parser.datatype.BooleanDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.ListDatatype;
import com.jantuomi.tunkki.core.parser.datatype.StringDatatype;
import com.jantuomi.tunkki.exception.types.FunctionArgumentTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 27.7.2016.
 */
public class ContainsBuiltinFunction extends BuiltinFunction {
    public ContainsBuiltinFunction() {
        super(Arrays.asList("list", "element"));
    }

    @Override
    public Datatype evaluate(List<Datatype> params) throws TunkkiError {
        if (params.size() != 2) {
            throw new FunctionArgumentTunkkiError(-1, getName(), Datatype.toString(params));
        }

        if (params.get(0).getType() == Datatype.Type.List) {
            return evaluateOnList(params);
        }
        else if (params.get(0).getType() == Datatype.Type.String) {
            return evaluateOnString(params);
        }
        throw new FunctionArgumentTunkkiError(-1, getName(), Datatype.toString(params));
    }

    private Datatype evaluateOnList(List<Datatype> params) throws TunkkiError {
        ListDatatype list = (ListDatatype) params.get(0);
        Datatype comp = params.get(1);

        for (Datatype elem : list.getData()) {
            if (elem.equals(comp).getData()) {
                return new BooleanDatatype(true);
            }
        }
        return new BooleanDatatype(false);
    }

    private Datatype evaluateOnString(List<Datatype> params) throws TunkkiError {
        if (params.get(1).getType() != Datatype.Type.String) {
            throw new FunctionArgumentTunkkiError(-1, getName(), Datatype.toString(params));
        }

        StringDatatype string = (StringDatatype) params.get(0);
        StringDatatype comp = (StringDatatype) params.get(1);

        return new BooleanDatatype(
                string.getData().contains(comp.getData())
        );
    }

    @Override
    public String getName() {
        return "contains";
    }
}
