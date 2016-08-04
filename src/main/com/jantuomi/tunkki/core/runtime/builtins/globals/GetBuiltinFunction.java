package com.jantuomi.tunkki.core.runtime.builtins.globals;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.IntegerDatatype;
import com.jantuomi.tunkki.core.parser.datatype.ListDatatype;
import com.jantuomi.tunkki.exception.types.FunctionArgumentTunkkiError;
import com.jantuomi.tunkki.exception.types.OutOfBoundsTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 28.7.2016.
 */
public class GetBuiltinFunction extends BuiltinFunction {
    public GetBuiltinFunction() {
        super(Arrays.asList("index"));
    }

    @Override
    public Datatype evaluate(List<Datatype> params) throws TunkkiError {
        if (params.size() != 2) {
            throw new FunctionArgumentTunkkiError(-1, params.toString());
        }

        if (params.get(0).getType() != Datatype.Type.List) {
            throw new FunctionArgumentTunkkiError(-1, Datatype.toString(params));
        }

        if (params.get(1).getType() != Datatype.Type.Integer) {
            throw new FunctionArgumentTunkkiError(-1, Datatype.toString(params));
        }

        ListDatatype list = (ListDatatype) params.get(0);
        IntegerDatatype index = (IntegerDatatype) params.get(1);

        try {
            return list.getData().get(index.getData());
        }
        catch (Exception ex) {
            throw new OutOfBoundsTunkkiError(-1, index.toString());
        }
    }
}
