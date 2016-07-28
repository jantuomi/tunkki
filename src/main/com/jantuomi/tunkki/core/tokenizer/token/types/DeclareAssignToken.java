package com.jantuomi.tunkki.core.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.AssignmentNode;
import com.jantuomi.tunkki.core.parser.ast.DeclareAssignNode;
import com.jantuomi.tunkki.core.parser.ast.SymbolNode;
import com.jantuomi.tunkki.exception.ExceptionManager;
import com.jantuomi.tunkki.exception.TunkkiError;

/**
 * Created by jan on 28.7.2016.
 */
public class DeclareAssignToken extends BinaryOperatorToken {
    public DeclareAssignToken() {
        super(Type.DeclareAssignToken, "dset");
    }

    @Override
    public ASTNode generateNode() throws TunkkiError {
        ASTNode lhsNode = lhs.generateNode();

        if (!(lhsNode instanceof SymbolNode)) {
            ExceptionManager.raise(TunkkiError.ExceptionType.SyntaxError, getLine(), "non-symbol " + toString());
            return null;
        }

        DeclareAssignNode node = new DeclareAssignNode(this,
                (SymbolNode) lhsNode,
                rhs.generateNode()
        );

        return node;
    }
}
