package com.jantuomi.tunkki.core.runtime;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.List;

/**
 * Created by jan on 14.6.2016.
 */
public class Interpreter {
    private static final Interpreter instance = new Interpreter();

    public static Interpreter getInstance() {
        return instance;
    }

    private Interpreter() {

    }
    public static String execute(List<ASTNode> sequence) throws TunkkiError {
        String output = "";
        Datatype data;
        for (ASTNode node : sequence) {
            try {
                 data = node.evaluate();
            }
            catch (NullPointerException ex) {
                throw new TunkkiError(TunkkiError.ExceptionType.GeneralError, -1, "Malformed input.");
            }

            if (data != null) {
                output = data.toString();
            } else {
                break;
            }
        }
        return output;
    }
}
