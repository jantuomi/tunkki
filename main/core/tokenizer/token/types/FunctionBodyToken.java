package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.parser.ast.FunctionBodyNode;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class FunctionBodyToken extends VarargOperatorToken {
    public FunctionBodyToken() {
        super(Type.FunctionBodyToken, "as");
    }

    @Override
    public ASTNode generateNode() {
        FunctionBodyNode node = new FunctionBodyNode(this);
        List<ASTNode> statements = new ArrayList<>();
        for (int i = 0; i < args.size() - 1; i++) {
            Token arg = args.get(i);
            statements.add(arg.generateNode());
        }
        node.setArgs(statements);
        return node;
    }
}
