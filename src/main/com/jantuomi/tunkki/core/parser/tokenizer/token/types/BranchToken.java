package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.BlockBodyNode;
import com.jantuomi.tunkki.core.parser.ast.BranchNode;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 21.6.2016.
 */
public class BranchToken extends VarargOperatorToken {

    private Token expression;
    private BlockBodyToken branch;

    public BranchToken() {
        super(Type.BranchToken, "if");
    }

    @Override
    public ASTNode generateNode() throws TunkkiError {
        return new BranchNode(this,
                expression.generateNode(),
                (BlockBodyNode) branch.generateNode()
        );
    }

    @Override
    public Token setArguments(List<Token> args) {
        expression = args.get(0);
        branch = (BlockBodyToken) args.get(1);
        return this;
    }

    @Override
    public List<Token> getChildren() {
        return Arrays.asList(expression, branch);
    }

    @Override
    public Type getTerminatorTokenType() {
        return Type.BranchBodyToken;
    }
}
