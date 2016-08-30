package com.jantuomi.tunkki.core.runtime;

import com.jantuomi.tunkki.core.parser.ast.BlockBodyNode;
import com.jantuomi.tunkki.core.parser.datatype.CallableDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.exception.types.FunctionArgumentTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.*;

/**
 * Created by jan on 5.8.2016.
 */
abstract public class Function {
    protected List<String> argumentNames;
    protected BlockBodyNode body;

    private State state = null;

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        if (this.state != null) {
            return this.state;
        } else {
            return State.getGlobalState();
        }
    }

    public Function(List<String> argumentNames, BlockBodyNode body) {
        this.argumentNames = argumentNames;
        this.body = body;
    }

    public Datatype evaluate(List<Datatype> params) throws TunkkiError {
        Scope scope = getState().createScope();

        if (!checkArgumentListValidity(params)) {
            throw new FunctionArgumentTunkkiError(-1, Datatype.toString(params));
        }

        Datatype returnValue = executeBlock(params);
        getState().popScope();

        return returnValue;
    }

    abstract public Datatype executeBlock(List<Datatype> params) throws TunkkiError;

    protected boolean checkArgumentListValidity(List<Datatype> params) throws FunctionArgumentTunkkiError {
        int argumentCount = getArgumentCount();
        boolean isSizeCorrect;
        if (!hasVariableArgumentList()) {
            isSizeCorrect = (argumentCount == params.size());
        } else {
            isSizeCorrect = true;
        }

        if (!isSizeCorrect) {
            return false;
        }

        if (hasDynamicallyTypedArguments()) {
            // do nothing if types can be whatever
        } else {
            List<Set<Datatype.Type>> argumentTypes = getArgumentTypes();
            Set<Datatype.Type> acceptableTypes;
            for (int i = 0; i < params.size(); i++) {
                /* The first type set of the list should be tested against for all arguments
                if the function's argument list is variable in size
                 */
                if (hasVariableArgumentList()) {
                    acceptableTypes = argumentTypes.get(0);
                } else {
                    acceptableTypes = argumentTypes.get(i);
                }
                if (!acceptableTypes.contains(params.get(i).getType())) {
                    return false;
                }
            }
        }

        return true;
    }

    public int getArgumentCount() {
        return argumentNames.size();
    }

    abstract public boolean hasVariableArgumentList();

    abstract public boolean hasDynamicallyTypedArguments();

    /**
     * Return a list of possible argument type sets for each positional argument
     * If the function has variable arguments, the first (and only) list element set
     * is tested against for all parameters
     * @return A list of sets of acceptable datatypes for each argument, in order
     */
    abstract public List<Set<Datatype.Type>> getArgumentTypes();

    public CallableDatatype makeCallable() {
        CallableDatatype c = new CallableDatatype();
        c.setData(this);
        return c;
    }

    protected Set<Datatype.Type> createAcceptableTypeSet(Datatype.Type... types) {
        return new HashSet<>(Arrays.asList(types));
    }

    final protected Set<Datatype.Type> allTypesSet() {
        return new HashSet<>(Arrays.asList(
                Datatype.Type.Boolean, Datatype.Type.Double, Datatype.Type.Integer,
                Datatype.Type.List, Datatype.Type.Nada, Datatype.Type.Object, Datatype.Type.String
        ));
    }
}
