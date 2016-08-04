package com.jantuomi.tunkki.core.runtime.builtins.globals;

import com.jantuomi.tunkki.core.parser.datatype.BooleanDatatype;
import com.jantuomi.tunkki.core.parser.datatype.CallableDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.VoidDatatype;
import com.jantuomi.tunkki.exception.types.FunctionArgumentTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jan on 4.8.2016.
 */
public class IfBuiltinFunction extends BuiltinFunction {
    public IfBuiltinFunction() {
        super(Arrays.asList("condition", "function"));
    }

    @Override
    public Datatype evaluate(List<Datatype> params) throws TunkkiError {
        if (params.size() != 2) {
            throw new FunctionArgumentTunkkiError(-1, getName(), Datatype.toString(params));
        }

        Datatype lhs = params.get(0);
        Datatype rhs = params.get(1);
        if (lhs.getType() != Datatype.Type.Boolean || rhs.getType() != Datatype.Type.Callable) {
            throw new FunctionArgumentTunkkiError(-1, getName(), Datatype.toString(params));
        }

        BooleanDatatype cond = (BooleanDatatype) lhs;
        CallableDatatype branch = (CallableDatatype) rhs;
        if (cond.getData()) {
            branch.call(Collections.emptyList());
        }
        return new VoidDatatype();
    }

    @Override
    public String getName() {
        return "if";
    }
}
