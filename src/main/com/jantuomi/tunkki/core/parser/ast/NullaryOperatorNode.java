package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.Collections;
import java.util.List;

/**
 * Created by jan on 8.8.2016.
 */
abstract public class NullaryOperatorNode extends ASTNode {
    public NullaryOperatorNode(Token token) {
        super(token);
    }

    @Override
    List<ASTNode> getChildren() {
        return Collections.emptyList();
    }
}
