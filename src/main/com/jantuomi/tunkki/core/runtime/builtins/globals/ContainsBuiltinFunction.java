package com.jantuomi.tunkki.core.runtime.builtins.globals;

import com.jantuomi.tunkki.core.parser.datatype.BooleanDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.ListDatatype;
import com.jantuomi.tunkki.core.parser.datatype.StringDatatype;
import com.jantuomi.tunkki.exception.types.FunctionArgumentTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by jan on 27.7.2016.
 */
public class ContainsBuiltinFunction extends BuiltinFunction {
    public ContainsBuiltinFunction() {
        super(Arrays.asList("list", "element"));
    }

    @Override
    public Datatype executeBlock(List<Datatype> params) throws TunkkiError {
        if (params.get(0).getType() == Datatype.Type.List) {
            return evaluateOnList(params);
        }
        else if (params.get(0).getType() == Datatype.Type.String) {
            return evaluateOnString(params);
        }
        throw new FunctionArgumentTunkkiError(-1, Datatype.toString(params));
    }

    @Override
    public boolean hasVariableArgumentList() {
        return false;
    }

    @Override
    public List<Set<Datatype.Type>> getArgumentTypes() {
        return Arrays.asList(
                createAcceptableTypeSet(Datatype.Type.List, Datatype.Type.String),
                createAcceptableTypeSet()
        );
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
            throw new FunctionArgumentTunkkiError(-1, Datatype.toString(params));
        }

        StringDatatype string = (StringDatatype) params.get(0);
        StringDatatype comp = (StringDatatype) params.get(1);

        return new BooleanDatatype(
                string.getData().contains(comp.getData())
        );
    }
}
