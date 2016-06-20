package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.parser.datatype.VoidDataContainer;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

/**
 * Created by jan on 17.6.2016.
 */
public class FunctionBodyNode extends VarargOperatorNode {
    public FunctionBodyNode(Token token) {
        super(token);
    }

    @Override
    public DataContainer evaluate() {
        DataContainer returnValue = new VoidDataContainer();

        for (ASTNode node : args) {
            returnValue = node.evaluate();
        }

        return returnValue;
    }
}
