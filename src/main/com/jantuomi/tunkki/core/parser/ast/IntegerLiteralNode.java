package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.IntegerDatatype;
import com.jantuomi.tunkki.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class IntegerLiteralNode extends ASTNode {
    private IntegerDatatype value;

    public IntegerLiteralNode(Token token) {
        super(token);
        value = new IntegerDatatype(Integer.parseInt(token.getText()));
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
