package com.jantuomi.borker.core.parser.ast;

import com.jantuomi.borker.core.parser.datatype.DataContainer;
import com.jantuomi.borker.core.parser.datatype.VoidDataContainer;
import com.jantuomi.borker.core.tokenizer.token.Token;
import com.jantuomi.borker.exception.BorkError;

/**
 * Created by jan on 17.6.2016.
 */
public class BlockBodyNode extends VarargOperatorNode {
    public BlockBodyNode(Token token) {
        super(token);
    }

    @Override
    public DataContainer evaluate() throws BorkError {
        DataContainer returnValue = new VoidDataContainer();

        for (ASTNode node : args) {
            returnValue = node.evaluate();
        }

        return returnValue;
    }
}
