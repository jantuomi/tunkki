package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.VoidDatatype;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.types.TunkkiError;

/**
 * Created by jan on 17.6.2016.
 */
public class BlockBodyNode extends VarargOperatorNode {
    public BlockBodyNode(Token token) {
        super(token);
    }

    @Override
    public Datatype evaluate() throws TunkkiError {
        Datatype returnValue = new VoidDatatype();

        for (ASTNode node : args) {
            returnValue = node.evaluate();
        }

        return returnValue;
    }
}
