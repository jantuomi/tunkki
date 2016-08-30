package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;

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
    public Datatype evaluate() {
        // TODO use State to executeBlock function
        return null;
    }

    @Override
    List<ASTNode> getChildren() {
        return parameters;
    }
}
