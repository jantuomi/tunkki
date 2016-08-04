package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.BlockBodyNode;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class BlockBodyToken extends VarargOperatorToken {
    public BlockBodyToken() {
        super(Type.FunctionBodyToken, "|");
    }

    @Override
    public ASTNode generateNode() throws TunkkiError {
        BlockBodyNode node = new BlockBodyNode(this);
        List<ASTNode> statements = new ArrayList<>();
        for (int i = 0; i < args.size() - 1; i++) {
            Token arg = args.get(i);
            statements.add(arg.generateNode());
        }
        node.setArgs(statements);
        return node;
    }

    @Override
    public Type getTerminatorTokenType() {
        return Type.BlockEndToken;
    }
}
