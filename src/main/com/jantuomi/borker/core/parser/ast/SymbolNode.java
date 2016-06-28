package com.jantuomi.borker.core.parser.ast;

import com.jantuomi.borker.core.parser.datatype.DataContainer;
import com.jantuomi.borker.core.runtime.State;
import com.jantuomi.borker.core.tokenizer.token.Token;
import com.jantuomi.borker.exception.ExceptionManager;
import com.jantuomi.borker.exception.InterpreterException;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jan on 17.6.2016.
 */
public class SymbolNode extends ASTNode {

    public ParameterListNode getParameterListNode() {
        return parameterListNode;
    }

    public void setParameterListNode(ParameterListNode parameterListNode) {
        this.parameterListNode = parameterListNode;
    }

    private ParameterListNode parameterListNode;

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
    public DataContainer evaluate() throws InterpreterException {
        List<DataContainer> paramValues = new ArrayList<>();
        if (parameterListNode != null) {
            for (ASTNode param : parameterListNode.getChildren()) {
                paramValues.add(param.evaluate());
            }
        }
        DataContainer returnValue = State.getInstance().getSymbolValue(name, paramValues);
        if (returnValue != null) {
            return returnValue;
        } else {
            ExceptionManager.raise(InterpreterException.ExceptionType.UndeclaredSymbolError, source.getLine(), name,
                    StringUtils.join(paramValues.stream().map(dataContainer -> dataContainer.toString()).collect(Collectors.toList()), ","));
            return null;
        }
    }

    @Override
    List<ASTNode> getChildren() {
        if (parameterListNode == null) {
            return Arrays.asList();
        } else {
            return Arrays.asList(parameterListNode);
        }
    }
}
