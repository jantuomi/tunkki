package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;


/**
 * Created by jan on 13.6.2016.
 */
public class AdditionNode extends ExpressionNode {

    private ExpressionNode lhs;
    private ExpressionNode rhs;

    public AdditionNode(ExpressionNode lhs, ExpressionNode rhs) {
        super(new Token(Token.Type.AdditionToken));

        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public List<ASTNode> getChildren() {
        return Arrays.asList(lhs, rhs);
    }

    @Override
    public DataContainer evaluate() {
        return null;
    }
}
