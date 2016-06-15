package com.jantuomi.interpreter.main.core.parser.datatype;


import com.jantuomi.interpreter.main.exception.ExceptionManager;
import com.jantuomi.interpreter.main.exception.InterpreterException;

import java.util.Arrays;

/**
 * Created by jan on 11.6.2016.
 */
public class IntegerDataContainer extends DataContainer<Integer> {
    public IntegerDataContainer(Integer data) {
        this.setData(data);
    }

    @Override
    public String toString() {
        return getData().toString();
    }

    @Override
    public DataContainer add(DataContainer rhs) {
        if (rhs instanceof IntegerDataContainer) {
            return new IntegerDataContainer(
                getData() + ((IntegerDataContainer) rhs).getData()
            );
        }
        else {
            ExceptionManager.raise(InterpreterException.Exception.TypeError, -1,
                    Arrays.asList(this.getClass().toString(), rhs.getClass().toString()));

            return null;
        }
    }
}
