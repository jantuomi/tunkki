package com.jantuomi.tunkki.core.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.BlockBodyNode;
import com.jantuomi.tunkki.core.parser.ast.FunctionDefineNode;
import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class FunctionDefineToken extends VarargOperatorToken {
    public FunctionDefineToken() {
        super(Type.FunctionDefineToken, "func");
    }

    @Override
    public ASTNode generateNode() throws TunkkiError {
        FunctionDefineNode node = new FunctionDefineNode(this);

        if (args.size() == 0) {
            throw new TunkkiError(TunkkiError.ExceptionType.ExpectedDifferentTokenError, getLine(), getText());
        }

        node.setName(args.get(0).getText());

        List<ASTNode> funcArgs = new ArrayList<>();
        for (int i = 1; i < args.size() - 1; i++) {
            funcArgs.add(args.get(i).generateNode());
        }
        node.setArgs(funcArgs);

        BlockBodyNode bodyNode;
        try {
            bodyNode = (BlockBodyNode) args.get(args.size() - 1).generateNode();
        }
        catch (Exception ex) {
            throw new TunkkiError(TunkkiError.ExceptionType.ExpectedDifferentTokenError, getLine(), getText());
        }
        node.setBody(bodyNode);
        return node;
    }

    @Override
    public Type getTerminatorTokenType() {
        return Type.FunctionBodyToken;
    }
}