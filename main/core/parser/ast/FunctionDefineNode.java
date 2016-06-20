package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

/**
 * Created by jan on 17.6.2016.
 */
public class FunctionDefineNode extends VarargOperatorNode {

    private String name;

    public void setBody(ASTNode body) {
        this.body = body;
    }

    public void setName(String name) {
        this.name = name;
    }

    private ASTNode body;

    public FunctionDefineNode(Token token) {
        super(token);
    }

    @Override
    public DataContainer evaluate() {
        // TODO add function in State
        return null;
    }

    @Override
    public void print(int indent) {

        for (int i = 0; i < indent; i++) {
            System.out.print("\t");
        }

        System.out.println(String.format("Function %s", name));

        for (int i = 0; i < indent + 1; i++) {
            System.out.print("\t");
        }

        System.out.println(String.format("Arguments: "));

        for (ASTNode node : args) {
            node.print(indent + 2);
        }

        for (int i = 0; i < indent + 1; i++) {
            System.out.print("\t");
        }

        System.out.println(String.format("Body statements: "));
        body.print(indent + 2);
    }
}
