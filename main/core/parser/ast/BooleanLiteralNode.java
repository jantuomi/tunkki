package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.parser.datatype.BooleanDataContainer;
import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class BooleanLiteralNode extends ASTNode {
    private BooleanDataContainer value;

    public BooleanLiteralNode(Token token) {
        super(token);
        value = new BooleanDataContainer(Boolean.parseBoolean(token.getText()));
    }

    @Override
    public DataContainer evaluate() {
        return value;
    }

    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList();
    }
}