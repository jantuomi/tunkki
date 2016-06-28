package com.jantuomi.borker.core.tokenizer.token.types;

import com.jantuomi.borker.core.parser.ast.ASTNode;
import com.jantuomi.borker.core.parser.ast.BlockBodyNode;
import com.jantuomi.borker.core.parser.ast.FunctionDefineNode;
import com.jantuomi.borker.exception.InterpreterException;

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
    public ASTNode generateNode() throws InterpreterException {
        FunctionDefineNode node = new FunctionDefineNode(this);
        node.setName(args.get(0).getText());

        List<ASTNode> funcArgs = new ArrayList<>();
        for (int i = 1; i < args.size() - 1; i++) {
            funcArgs.add(args.get(i).generateNode());
        }
        node.setArgs(funcArgs);

        BlockBodyNode bodyNode = (BlockBodyNode) args.get(args.size() - 1).generateNode();
        node.setBody(bodyNode);
        return node;
    }

    @Override
    public Type getTerminatorTokenType() {
        return Type.FunctionBodyToken;
    }
}
