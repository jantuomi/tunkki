package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.List;

/**
 * Created by jan on 11.6.2016.
 */
abstract public class ASTNode {

    public abstract DataContainer evaluate();

    protected Token source;

    public ASTNode(Token token) {
        this.source = token;
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
            node.print(indent + 1);
        }
    }
}
