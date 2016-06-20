package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.parser.ast.FunctionBodyNode;
import com.jantuomi.interpreter.main.core.parser.ast.FunctionDefineNode;

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
    public ASTNode generateNode() {
        FunctionDefineNode node = new FunctionDefineNode(this);
        node.setName(args.get(0).getText());

        List<ASTNode> funcArgs = new ArrayList<>();
        for (int i = 1; i < args.size() - 1; i++) {
            funcArgs.add(args.get(i).generateNode());
        }
        node.setArgs(funcArgs);

        FunctionBodyNode bodyNode = (FunctionBodyNode) args.get(args.size() - 1).generateNode();
        node.setBody(bodyNode);
        return node;
    }
}
