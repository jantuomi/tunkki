package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.VoidDatatype;
import com.jantuomi.tunkki.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 17.6.2016.
 */
public class EmptyNode extends ASTNode {
    public EmptyNode(Token source) {
        super(source);
    }

    @Override
    public Datatype evaluate() {
        return new VoidDatatype();
    }

    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList();
    }
}
