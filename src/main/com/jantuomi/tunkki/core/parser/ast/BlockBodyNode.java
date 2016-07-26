package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.parser.datatype.VoidDataContainer;
import com.jantuomi.tunkki.core.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.TunkkiError;

/**
 * Created by jan on 17.6.2016.
 */
public class BlockBodyNode extends VarargOperatorNode {
    public BlockBodyNode(Token token) {
        super(token);
    }

    @Override
    public DataContainer evaluate() throws TunkkiError {
        DataContainer returnValue = new VoidDataContainer();

        for (ASTNode node : args) {
            returnValue = node.evaluate();
        }

        return returnValue;
    }
}
