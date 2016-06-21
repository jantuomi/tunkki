package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.parser.datatype.StringDataContainer;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 21.6.2016.
 */
public class StringLiteralNode extends ASTNode {
    @Override
    public DataContainer evaluate() {
        return new StringDataContainer(source.getText());
    }

    public StringLiteralNode(Token source) {
        super(source);
    }

    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList();
    }
}
