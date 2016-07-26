package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.parser.datatype.DoubleDataContainer;
import com.jantuomi.tunkki.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class DoubleLiteralNode extends ASTNode {
    private DoubleDataContainer value;

    public DoubleLiteralNode(Token token) {
        super(token);
        value = new DoubleDataContainer(Double.parseDouble(token.getText()));
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
