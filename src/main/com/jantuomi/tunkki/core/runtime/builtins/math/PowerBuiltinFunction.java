package com.jantuomi.tunkki.core.runtime.builtins.math;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.DoubleDatatype;
import com.jantuomi.tunkki.core.parser.datatype.IntegerDatatype;
import com.jantuomi.tunkki.core.runtime.builtins.globals.BuiltinFunction;
import com.jantuomi.tunkki.exception.types.FunctionArgumentTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by jan on 2.8.2016.
 */
public class PowerBuiltinFunction extends BuiltinFunction {
    public PowerBuiltinFunction() {
        super(Arrays.asList("number", "exponent"));
    }

    @Override
    public Datatype executeBlock(List<Datatype> params) throws TunkkiError {
        if (params.size() != 2) {
            throw new FunctionArgumentTunkkiError(-1, Datatype.toString(params));
        }

        Datatype lhs = params.get(0);
        Datatype rhs = params.get(1);

        double number = getDoubleValue(params, lhs);
        double exponent = getDoubleValue(params, rhs);

        try {
            double result = Math.pow(number, exponent);
            return new DoubleDatatype(result);
        }
        catch (Exception ex) {
            throw new FunctionArgumentTunkkiError(-1, Datatype.toString(params));
        }
    }

    @Override
    public boolean hasVariableArgumentList() {
        return false;
    }

    private double getDoubleValue(List<Datatype> params, Datatype dt) throws TunkkiError {
        double number;
        if (dt.getType() == Datatype.Type.Integer) {
            number = ((IntegerDatatype) dt).asDouble().getData();
        } else if (dt.getType() == Datatype.Type.Double) {
            number = ((DoubleDatatype) dt).getData();
        }
        else {
            throw new FunctionArgumentTunkkiError(-1, Datatype.toString(params));
        }
        return number;
    }

    @Override
    public List<Set<Datatype.Type>> getArgumentTypes() {
        return Arrays.asList(
                createAcceptableTypeSet(Datatype.Type.Integer, Datatype.Type.Double),
                createAcceptableTypeSet(Datatype.Type.Integer, Datatype.Type.Double)
        );
    }
}
