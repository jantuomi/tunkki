package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.runtime.State;
import com.jantuomi.tunkki.core.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.ExceptionManager;
import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 17.6.2016.
 */
public class SymbolNode extends ASTNode {

    public List<ASTNode> getParameters() {
        return parameters;
    }

    public void setParameters(List<ASTNode> parameters) {
        this.parameters = parameters;
    }

    private List<ASTNode> parameters = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;

    public SymbolNode(Token token) {
        super(token);
    }

    @Override
    public Datatype evaluate() throws TunkkiError {


        Datatype returnValue;
        try {
            if (State.getInstance().isFunction(name)) {
                returnValue = State.getInstance().makeFunctionReference(name);
            } else {
                List<Datatype> paramValues = evaluateParameters();
                returnValue = State.getInstance().evaluateSymbol(name, paramValues);
            }

        }
        /* If a TunkkiError is caught, pass it on with line information */
        catch (TunkkiError ex) {
            throw new TunkkiError(ex.getType(), getLine(),
                    ex.getArguments().toArray(new String[ex.getArguments().size()]));
        }

        if (returnValue != null) {
            return returnValue;
        } else {
            ExceptionManager.raise(TunkkiError.ExceptionType.UndeclaredSymbolError, getLine(), name);
            return null;
        }
    }

    public List<Datatype> evaluateParameters() throws TunkkiError {
        List<Datatype> paramValues = new ArrayList<>();
        for (ASTNode param : parameters) {
            Datatype value = param.evaluate();
            if (value != null) {
                paramValues.add(value);
            }
        }
        return paramValues;
    }

    @Override
    List<ASTNode> getChildren() {
        return parameters;
    }
}
