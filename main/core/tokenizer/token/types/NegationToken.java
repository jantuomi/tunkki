package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.parser.ast.NegationNode;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;
import com.jantuomi.interpreter.main.exception.InterpreterException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 21.6.2016.
 */
public class NegationToken extends Token {

    private Token operand;

    public NegationToken() {
        super(Type.NegationToken, "not");
    }

    @Override
    public ASTNode generateNode() throws InterpreterException {
        return new NegationNode(this, operand.generateNode());
    }

    @Override
    public Token setArguments(List<Token> args) {
        operand = args.get(0);
        return this;
    }

    @Override
    public List<Token> getChildren() {
        return Arrays.asList(operand);
    }
}
