package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.runtime.State;
import com.jantuomi.tunkki.core.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.ExceptionManager;
import com.jantuomi.tunkki.exception.TunkkiError;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public DataContainer evaluate() throws TunkkiError {
        List<DataContainer> paramValues = new ArrayList<>();
        for (ASTNode param : parameters) {
            DataContainer value = param.evaluate();
            if (value != null) {
                paramValues.add(value);
            }
        }

        DataContainer returnValue;
        try {
             returnValue = State.getInstance().getSymbolValue(name, paramValues);
        }
        /* If a TunkkiError is caught, pass it on with line information */
        catch (TunkkiError ex) {
            throw new TunkkiError(ex.getType(), getLine(),
                    ex.getArguments().toArray(new String[ex.getArguments().size()]));
        }

        if (returnValue != null) {
            return returnValue;
        } else {
            ExceptionManager.raise(TunkkiError.ExceptionType.UndeclaredSymbolError, getLine(), name,
                    StringUtils.join(paramValues.stream().map(DataContainer::toString).collect(Collectors.toList()), ","));
            return null;
        }
    }

    @Override
    List<ASTNode> getChildren() {
        return parameters;
    }
}
