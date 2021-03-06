package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.DeclareAssignNode;
import com.jantuomi.tunkki.core.parser.ast.SymbolNode;
import com.jantuomi.tunkki.exception.ExceptionManager;
import com.jantuomi.tunkki.exception.types.SyntaxTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

/**
 * Created by jan on 28.7.2016.
 */
public class DeclareAssignToken extends BinaryOperatorToken {
    public DeclareAssignToken(String text) {
        super(Type.DeclareAssignToken, text);
    }

    @Override
    public ASTNode generateNode() throws TunkkiError {
        ASTNode lhsNode = lhs.generateNode();

        if (!(lhsNode instanceof SymbolNode)) {
            throw new SyntaxTunkkiError(getLine(), "non-symbol " + toString());
        }

        DeclareAssignNode node = new DeclareAssignNode(this,
                (SymbolNode) lhsNode,
                rhs.generateNode()
        );

        return node;
    }
}
