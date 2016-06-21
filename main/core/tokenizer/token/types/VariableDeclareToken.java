package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.parser.ast.SymbolNode;
import com.jantuomi.interpreter.main.core.parser.ast.VariableDeclareNode;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;
import com.jantuomi.interpreter.main.exception.InterpreterException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 20.6.2016.
 */
public class VariableDeclareToken extends Token {

    private SymbolToken variable;

    public VariableDeclareToken() {
        super(Type.DeclarationToken, "decl");
    }

    @Override
    public ASTNode generateNode() throws InterpreterException {
        VariableDeclareNode node =  new VariableDeclareNode(this,
                (SymbolNode) variable.generateNode());
        return node;
    }

    @Override
    public Token setArguments(List<Token> args) {
        if (args.size() > 0) {
            this.variable = (SymbolToken) args.get(0);
        }
        return this;
    }

    @Override
    public List<Token> getChildren() {
        return Arrays.asList(variable);
    }
}
