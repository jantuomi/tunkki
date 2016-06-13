package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.runtime.State;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 11.6.2016.
 */
public class SymbolNode extends ExpressionNode {
    private String symbol;

    public SymbolNode(Token token) {
        super(token);

        this.symbol = token.getText();
    }

    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList();
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public DataContainer evaluate() {
        return State.getInstance().getSymbolValue(symbol);
    }
}
