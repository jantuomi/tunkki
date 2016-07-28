package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.List;

/**
 * Created by jan on 11.6.2016.
 */
abstract public class ASTNode {

    public abstract DataContainer evaluate() throws TunkkiError;

    protected Token source;

    public ASTNode(Token token) {
        this.source = token;
    }

    public String getText() {
        if (source != null) {
            return source.getText();
        } else {
            return "unknown node";
        }
    }

    public int getLine() {
        if (source != null) {
            return source.getLine();
        } else {
            return -1;
        }
    }

    public Token.Type tokenType() {
        return source.getTokenType();
    }

    abstract List<ASTNode> getChildren();

    public void print(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("\t");
        }

        System.out.println(source.toString());
        for (ASTNode node : getChildren()) {
            if (node != null) {
                node.print(indent + 1);
            }
        }
    }
}
