package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.StringDatatype;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 21.6.2016.
 */
public class StringLiteralNode extends ASTNode {
    @Override
    public Datatype evaluate() {
        return new StringDatatype(source.getText());
    }

    public StringLiteralNode(Token source) {
        super(source);
    }

    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList();
    }
}
