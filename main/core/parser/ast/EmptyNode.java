package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.parser.datatype.VoidDataContainer;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

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
    public DataContainer evaluate() {
        return new VoidDataContainer();
    }

    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList();
    }
}
