package com.jantuomi.tunkki.core.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.AssignmentNode;
import com.jantuomi.tunkki.core.parser.ast.SymbolNode;
import com.jantuomi.tunkki.exception.ExceptionManager;
import com.jantuomi.tunkki.exception.TunkkiError;

/**
 * Created by jan on 20.6.2016.
 */
public class AssignmentToken extends BinaryOperatorToken {

    public AssignmentToken() {
        super(Type.AssignmentToken, "set");
    }

    // TODO this and the node

    @Override
    public ASTNode generateNode() throws TunkkiError {
        ASTNode lhsNode = lhs.generateNode();

        if (!(lhsNode instanceof SymbolNode)) {
            ExceptionManager.raise(TunkkiError.ExceptionType.SyntaxError, getLine(), "non-symbol " + toString());
            return null;
        }

        AssignmentNode node = new AssignmentNode(this,
                (SymbolNode) lhsNode,
                rhs.generateNode()
        );

        return node;
    }
}
