package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.exception.ExceptionManager;
import com.jantuomi.tunkki.exception.types.TunkkiError;
import com.jantuomi.tunkki.exception.types.TypeTunkkiError;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class AdditionNode extends BinaryOperatorNode {

    public AdditionNode(Token token, ASTNode lhs, ASTNode rhs) {
        super(token, lhs, rhs);
    }

    @Override
    public Datatype evaluate() throws TunkkiError {
        Datatype operand1 = lhs.evaluate();
        Datatype operand2 = rhs.evaluate();

        Datatype result = operand1.add(operand2);
        if (result != null) {
            return result;
        } else {
            throw new TypeTunkkiError(source.getLine(),
                operand2.getType().toString(), operand1.getType().toString());
        }

    }
    @Override
    List<ASTNode> getChildren() {
        return Arrays.asList(lhs, rhs);
    }
}
