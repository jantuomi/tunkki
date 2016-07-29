package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.BooleanDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.TunkkiError;

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
    public Datatype evaluate() throws TunkkiError {
        Datatype ev = expression.evaluate();
        boolean returnValue = false;
        if (ev instanceof BooleanDatatype) {
            returnValue = ((BooleanDatatype) ev).getData();
            if (returnValue) {
                branch.evaluate();
            }
        }
        return new BooleanDatatype(returnValue);
    }

    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList(expression, branch);
    }
}
