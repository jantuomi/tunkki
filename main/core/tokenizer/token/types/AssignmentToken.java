package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.parser.ast.AssignmentNode;
import com.jantuomi.interpreter.main.core.parser.ast.SymbolNode;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;
import com.jantuomi.interpreter.main.exception.ExceptionManager;
import com.jantuomi.interpreter.main.exception.InterpreterException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 20.6.2016.
 */
public class AssignmentToken extends Token {

    private Token lhs;
    private Token rhs;

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

    @Override
    public Token setArguments(List<Token> args) {
        this.lhs = args.get(0);
        this.rhs = args.get(1);
        return this;
    }

    @Override
    public List<Token> getChildren() {
        return Arrays.asList(lhs, rhs);
    }
}
