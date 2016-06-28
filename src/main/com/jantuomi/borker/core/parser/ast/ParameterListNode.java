package com.jantuomi.borker.core.parser.ast;

import com.jantuomi.borker.core.parser.datatype.DataContainer;
import com.jantuomi.borker.core.tokenizer.token.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 19.6.2016.
 */
public class ParameterListNode extends ASTNode {

    private List<ASTNode> parameters = new ArrayList<>();

    public void addParameter(ASTNode param) {
        parameters.add(param);
    }

    public List<ASTNode> getParameters() {
        return parameters;
    }

    public ParameterListNode(Token token) {
        super(token);
    }

    @Override
    public DataContainer evaluate() {
        // TODO use State to evaluate function
        return null;
    }

    @Override
    List<ASTNode> getChildren() {
        return parameters;
    }
}
