package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.parser.datatype.IntegerDataContainer;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 13.6.2016.
 */
public class IntegerLiteralNode extends ExpressionNode {

    private int data;

    public IntegerLiteralNode(Token token) {
        super(token);
        this.data = Integer.parseInt(token.getText());
    }

    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList();
    }

    @Override
    public DataContainer evaluate() {
        return new IntegerDataContainer(data);
    }
}
