package com.jantuomi.borker.core.tokenizer.token.types;

import com.jantuomi.borker.core.parser.ast.ASTNode;
import com.jantuomi.borker.core.parser.ast.AssignmentNode;
import com.jantuomi.borker.core.parser.ast.SymbolNode;
import com.jantuomi.borker.exception.ExceptionManager;
import com.jantuomi.borker.exception.InterpreterException;

/**
 * Created by jan on 20.6.2016.
 */
public class AssignmentToken extends BinaryOperatorToken {

    public AssignmentToken() {
        super(Type.AssignmentToken, "set");
    }

    // TODO this and the node

    @Override
    public ASTNode generateNode() throws InterpreterException {
        ASTNode lhsNode = lhs.generateNode();

        if (!(lhsNode instanceof SymbolNode)) {
            ExceptionManager.raise(InterpreterException.ExceptionType.SyntaxError, getLine(), "non-symbol " + toString());
            return null;
        }

        AssignmentNode node = new AssignmentNode(this,
                (SymbolNode) lhsNode,
                rhs.generateNode()
        );

        return node;
    }
}
