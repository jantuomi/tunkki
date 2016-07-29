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
        for (ASTNode node : sequence) {
            Datatype data = node.evaluate();

            if (data != null) {
                output = data.toString();
            } else {
                break;
            }
        }
        return output;
    }
}
