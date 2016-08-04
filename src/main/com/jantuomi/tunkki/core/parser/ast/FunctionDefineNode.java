package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.CallableDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.runtime.Function;
import com.jantuomi.tunkki.core.runtime.State;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.types.ExpectedDifferentTokenTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 17.6.2016.
 */
public class FunctionDefineNode extends VarargOperatorNode {

    public void setBody(ASTNode body) {
        this.body = body;
    }

    private ASTNode body;

    public FunctionDefineNode(Token token) {
        super(token);
    }

    @Override
    public Datatype evaluate() throws TunkkiError {
        List<String> argumentNames = new ArrayList<>();
        try {
            for (ASTNode arg : args) {
                SymbolNode argSym = (SymbolNode) arg;
                argumentNames.add(argSym.getName());
            }
        }
        catch (Exception ex) {
            throw new ExpectedDifferentTokenTunkkiError(getLine(), getText());
        }
        Function function = new Function(argumentNames, (BlockBodyNode) body);

        CallableDatatype c = new CallableDatatype();
        c.setData(function);
        return c;
    }

    @Override
    public void print(int indent) {

        for (int i = 0; i < indent; i++) {
            System.out.print("\t");
        }

        System.out.println(String.format("Function"));

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
