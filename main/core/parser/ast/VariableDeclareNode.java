package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.parser.datatype.StringDataContainer;
import com.jantuomi.interpreter.main.core.runtime.State;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 20.6.2016.
 */
public class VariableDeclareNode extends ASTNode {
    private SymbolNode variable;

    public VariableDeclareNode(Token source, SymbolNode variable) {
        super(source);
        this.variable = variable;
    }

    @Override
    public DataContainer evaluate() {
        State.getInstance().addSymbolToScope(variable.getName());
        return new StringDataContainer(variable.getName());
    }

    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList();
    }
}