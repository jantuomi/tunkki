package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.DoubleDatatype;
import com.jantuomi.tunkki.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class DoubleLiteralNode extends ASTNode {
    private DoubleDatatype value;

    public DoubleLiteralNode(Token token) {
        super(token);
        value = new DoubleDatatype(Double.parseDouble(token.getText()));
    }

    @Override
    public Datatype evaluate() {
        return value;
    }

    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList();
    }
}
