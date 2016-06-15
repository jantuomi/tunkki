package com.jantuomi.interpreter.main.core.parser;

import com.jantuomi.interpreter.main.core.parser.ast.*;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;
import com.jantuomi.interpreter.main.exception.ExceptionManager;
import com.jantuomi.interpreter.main.exception.InterpreterException;
import com.jantuomi.interpreter.main.utils.Counter;

import java.util.ArrayList;
import java.util.Arrays;
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

    private Token getTokenAt(Counter c) {
        if (c.getValue() >= tokens.size()) {
            return new Token(Token.Type.NotAToken);
        }

        return tokens.get(c.getValue());
    }

    private boolean isTooDeep(Counter c) {
        return c.getRecursionDepth() > tokens.size();
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

            Token failed = tokens.get(c.getValue());
            ExceptionManager.raise(InterpreterException.Exception.SyntaxError, failed.getLine(),
                    Arrays.asList(failed.toString()));
            break;
        }

        return statementSequence;
    }

    public AssignmentNode expectAssignmentRoutine(Counter c) {
        Counter d = c.clone();
        d.deeper();

        if (isTooDeep(d)) {
            return null;
        }

        SymbolNode lhs = expectAssignmentLHS(d);
        if (lhs == null) {
            return null;
        }
        boolean isAssign = expectAssignmentAndAdvance(d);
        if (!isAssign) {
            return null;
        }
        ExpressionNode rhs = expectAssignmentRHS(d);
        if (rhs == null) {
            return null;
        }

        AssignmentNode an = new AssignmentNode(lhs, rhs);
        d.shallower();
        c.assign(d);
        return an;
    }

    private AdditionNode expectAdditionRoutine(Counter c) {
        Counter d = c.clone();
        d.deeper();

        if (isTooDeep(d)) {
            return null;
        }

        ExpressionNode lhs = expectExpression(d);
        if (lhs == null) {
            return null;
        }
        boolean isAddition = expectAdditionAndAdvance(d);
        if (!isAddition) {
            return null;
        }
        ExpressionNode rhs = expectExpression(d);
        if (rhs == null) {
            return null;
        }

        AdditionNode an = new AdditionNode(lhs, rhs);
        d.shallower();
        c.assign(d);
        return an;
    }

//    private ExpressionNode expectAdditionLHS(Counter c) {
//        Counter d = c.clone();
//        d.deeper();
//
//        if (isTooDeep(d)) {
//            return null;
//        }
//
//        IntegerLiteralNode in = parseIntegerLiteralAndAdvance(d);
//        if (in != null) {
//            d.shallower();
//            c.assign(d);
//            return in;
//        }
//        SymbolNode sn = parseSymbolAndAdvance(d);
//        if (sn != null) {
//            d.shallower();
//            c.assign(d);
//            return sn;
//        }
//
//        return null;
//    }


    public SymbolNode expectAssignmentLHS(Counter c) {
        Counter d = c.clone();
        d.deeper();

        if (isTooDeep(d)) {
            return null;
        }

        SymbolNode sn = parseSymbolAndAdvance(d);
        if (sn != null) {
            d.shallower();
            c.assign(d);
            return sn;
        }
        return null;
    }

    public ExpressionNode expectAssignmentRHS(Counter c) {
        Counter d = c.clone();
        d.deeper();

        if (isTooDeep(d)) {
            return null;
        }

        ExpressionNode en = expectExpression(c);
        if (en != null) {
            d.shallower();
            c.assign(d);
            return en;
        }
        return null;
    }

    private ExpressionNode expectExpression(Counter c) {
        Counter d = c.clone();
        d.deeper();

        if (isTooDeep(d)) {
            return null;
        }

        AdditionNode an = expectAdditionRoutine(d);
        if (an != null) {
            d.shallower();
            c.assign(d);
            return an;
        }
        IntegerLiteralNode in = parseIntegerLiteralAndAdvance(d);
        if (in != null) {
            d.shallower();
            c.assign(d);
            return in;
        }
        SymbolNode sn = parseSymbolAndAdvance(d);
        if (sn != null) {
            d.shallower();
            c.assign(d);
            return sn;
        }

        return null;
    }

    private boolean expectAdditionAndAdvance(Counter c) {
        if (getTokenAt(c).is(Token.Type.AdditionToken)) {
            c.advance();
            return true;
        } else {
            return false;
        }
    }

    private IntegerLiteralNode parseIntegerLiteralAndAdvance(Counter c) {
        if (getTokenAt(c).is(Token.Type.IntegerLiteralToken)) {
            IntegerLiteralNode in = new IntegerLiteralNode(getTokenAt(c));
            c.advance();
            return in;
        } else {
            return null;
        }
    }

    public boolean expectAssignmentAndAdvance(Counter c) {
        if (getTokenAt(c).is(Token.Type.AssignmentToken)) {
            c.advance();
            return true;
        } else {
            return false;
        }
    }

    public SymbolNode parseSymbolAndAdvance(Counter c) {
        if (getTokenAt(c).is(Token.Type.SymbolToken)) {
            SymbolNode sn = new SymbolNode(getTokenAt(c));
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
