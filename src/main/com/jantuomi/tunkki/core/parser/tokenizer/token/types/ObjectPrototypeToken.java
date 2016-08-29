package com.jantuomi.tunkki.core.parser.tokenizer.token.types;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.FunctionDefineNode;
import com.jantuomi.tunkki.core.parser.ast.ObjectPrototypeNode;
import com.jantuomi.tunkki.core.parser.ast.SymbolNode;
import com.jantuomi.tunkki.core.parser.datatype.CallableDatatype;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.types.ExpectedDifferentTokenTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

/**
 * Created by jan on 8.8.2016.
 */
public class ObjectPrototypeToken extends VarargOperatorToken {
    public ObjectPrototypeToken() {
        super(Type.ObjectPrototypeToken, "obj");
    }

    @Override
    public ASTNode generateNode() throws TunkkiError {
        if (args.size() < 2 || args.size() > 3) {
            throw new ExpectedDifferentTokenTunkkiError(getLine(), getText());
        }

        Token arg1 = args.get(0);
        if (!(arg1 instanceof SymbolToken)) {
            throw new ExpectedDifferentTokenTunkkiError(getLine(), getText());
        }

        Token funcArg;
        if (args.size() == 2) {
            funcArg = args.get(1);
        } else {
            funcArg = args.get(2);
        }

        if (!(funcArg instanceof FunctionDefineToken)) {
            throw new ExpectedDifferentTokenTunkkiError(getLine(), getText());
        }

        SymbolNode symbol = (SymbolNode) arg1.generateNode();
        String name = symbol.getName();

        FunctionDefineNode constructor = (FunctionDefineNode) funcArg.generateNode();
        CallableDatatype constructorCallable = (CallableDatatype) constructor.evaluate();
        ObjectPrototypeNode node = new ObjectPrototypeNode(this, name, constructorCallable);
        node.setName(name);
        return node;
    }

    @Override
    public Type getTerminatorTokenType() {
        return Type.FunctionDefineToken;
    }
}
