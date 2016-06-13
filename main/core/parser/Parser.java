package com.jantuomi.interpreter.main.core.parser;

import com.jantuomi.interpreter.main.core.parser.ast.*;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;
import com.jantuomi.interpreter.main.utils.Counter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 11.6.2016.
 */
public class Parser {
    private static final Parser instance = new Parser();

    private List<Token> tokens;
    private List<ASTNode> statementSequence;

    public static Parser getInstance() {
        return instance;
    }

    private Parser() {

    }

    public List<ASTNode> parse(List<Token> tokens) {
        this.tokens = tokens;
        this.statementSequence = new ArrayList<>();

        Counter c = new Counter();
        while (c.getValue() < tokens.size()) {
            AssignmentNode asn = expectAssignmentRoutine(c);
            if (asn != null) {
                statementSequence.add(asn);
                continue;
            }
            AdditionNode adn = expectAdditionRoutine(c);
            if (adn != null) {
                statementSequence.add(adn);
                continue;
            }
        }

        return statementSequence;
    }

    public AssignmentNode expectAssignmentRoutine(Counter c) {
        Counter d = c.clone();

        SymbolNode lhs = expectLHS(d);
        if (lhs == null) {
            return null;
        }
        boolean isAssign = expectAssignmentAndAdvance(d);
        if (!isAssign) {
            return null;
        }
        ExpressionNode rhs = expectRHS(d);
        if (rhs == null) {
            return null;
        }

        AssignmentNode an = new AssignmentNode(lhs, rhs);
        c.setValue(d.getValue());
        return an;
    }

    public SymbolNode expectLHS(Counter c) {
        SymbolNode sn = parseSymbolAndAdvance(c);
        if (sn != null) {
            return sn;
        }
        return null;
    }

    public ExpressionNode expectRHS(Counter c) {
        ExpressionNode en = expectExpression(c);
        if (en != null) {
            return en;
        }
        return null;
    }

    private ExpressionNode expectExpression(Counter c) {
        Counter d = c.clone();

        AdditionNode an = expectAdditionRoutine(d);
        if (an != null) {
            c.setValue(d.getValue());
            return an;
        }
        IntegerLiteralNode in = parseIntegerLiteralAndAdvance(d);
        if (in != null) {
            c.setValue(d.getValue());
            return in;
        }
        SymbolNode sn = parseSymbolAndAdvance(d);
        if (sn != null) {
            c.setValue(d.getValue());
            return sn;
        }

        return null;
    }

    private AdditionNode expectAdditionRoutine(Counter c) {
        Counter d = c.clone();

        ExpressionNode lhs = expectLHS(d);
        if (lhs == null) {
            return null;
        }
        boolean isAddition = expectAdditionAndAdvance(d);
        if (!isAddition) {
            return null;
        }
        ExpressionNode rhs = expectRHS(d);
        if (rhs == null) {
            return null;
        }

        AdditionNode an = new AdditionNode(lhs, rhs);
        c.setValue(d.getValue());
        return an;
    }

    private boolean expectAdditionAndAdvance(Counter c) {
        if (tokens.get(c.getValue()).is(Token.Type.AdditionToken)) {
            c.advance();
            return true;
        } else {
            return false;
        }
    }

    private IntegerLiteralNode parseIntegerLiteralAndAdvance(Counter c) {
        if (tokens.get(c.getValue()).is(Token.Type.IntegerLiteralToken)) {
            IntegerLiteralNode in = new IntegerLiteralNode(tokens.get(c.getValue()));
            c.advance();
            return in;
        } else {
            return null;
        }
    }

    public boolean expectAssignmentAndAdvance(Counter c) {
        if (tokens.get(c.getValue()).is(Token.Type.AssignmentToken)) {
            c.advance();
            return true;
        } else {
            return false;
        }
    }

    public SymbolNode parseSymbolAndAdvance(Counter c) {
        if (tokens.get(c.getValue()).is(Token.Type.SymbolToken)) {
            SymbolNode sn = new SymbolNode(tokens.get(c.getValue()));
            c.advance();
            return sn;
        } else {
            return null;
        }
    }

    public void printTree(ASTNode e) {
        System.out.println("### Tree begin ###");
        e.print(0);
        System.out.println("### Tree end ###");
    }
}
