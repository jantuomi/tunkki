package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.core.parser.datatype.StringDataContainer;
import com.jantuomi.tunkki.core.runtime.Function;
import com.jantuomi.tunkki.core.runtime.State;
import com.jantuomi.tunkki.core.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.ArrayList;
import java.util.List;

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
    public DataContainer evaluate() throws TunkkiError {
        List<String> argumentNames = new ArrayList<>();
        try {
            for (ASTNode arg : args) {
                SymbolNode argSym = (SymbolNode) arg;
                argumentNames.add(argSym.getName());
            }
        }
        catch (Exception ex) {
            throw new TunkkiError(TunkkiError.ExceptionType.ExpectedTokenError, getLine(), getText());
        }
        Function function = new Function(argumentNames, (BlockBodyNode) body);
        function.setName(name);
        State.getInstance().addFunctionToScope(name, function);

        return new StringDataContainer("function " + name);
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

        System.out.println("Arguments: ");

        for (ASTNode node : args) {
            node.print(indent + 2);
        }

        for (int i = 0; i < indent + 1; i++) {
            System.out.print("\t");
        }

        System.out.println("Body statements: ");
        body.print(indent + 2);
    }
}
