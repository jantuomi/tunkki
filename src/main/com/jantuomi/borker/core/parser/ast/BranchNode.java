package com.jantuomi.borker.core.parser.ast;

import com.jantuomi.borker.core.parser.datatype.BooleanDataContainer;
import com.jantuomi.borker.core.parser.datatype.DataContainer;
import com.jantuomi.borker.core.tokenizer.token.Token;
import com.jantuomi.borker.exception.BorkError;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 17.6.2016.
 */
public class BranchNode extends ASTNode {

    private ASTNode expression;
    private BlockBodyNode branch;

    public BranchNode(Token token, ASTNode expression, BlockBodyNode branch) {
        super(token);
        this.expression = expression;
        this.branch = branch;
    }

    @Override
    public DataContainer evaluate() throws BorkError {
        DataContainer ev = expression.evaluate();
        boolean returnValue = false;
        if (ev instanceof BooleanDataContainer) {
            returnValue = ((BooleanDataContainer) ev).getData();
            if (returnValue) {
                branch.evaluate();
            }
        }
        return new BooleanDataContainer(returnValue);
    }

    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList(expression, branch);
    }
}
