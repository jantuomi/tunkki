package com.jantuomi.borker.core.tokenizer.token.types;

import com.jantuomi.borker.core.parser.ast.ASTNode;
import com.jantuomi.borker.core.parser.ast.BlockBodyNode;
import com.jantuomi.borker.core.tokenizer.token.Token;
import com.jantuomi.borker.exception.InterpreterException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class BlockBodyToken extends VarargOperatorToken {
    public BlockBodyToken(String keyword) {
        super(Type.FunctionBodyToken, keyword);
    }

    @Override
    public ASTNode generateNode() throws InterpreterException {
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
        return Type.EndBlockToken;
    }
}
