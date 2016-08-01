package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 21.6.2016.
 */
abstract public class UnaryOperatorNode extends ASTNode {
    public UnaryOperatorNode(Token token, ASTNode operand) {
        super(token);
        this.operand = operand;
    }

    public ASTNode getOperand() {
        return operand;
    }

    public void setOperand(ASTNode operand) {
        this.operand = operand;
    }

    private ASTNode operand;

    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList(operand);
    }
}
