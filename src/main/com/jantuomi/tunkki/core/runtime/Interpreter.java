package com.jantuomi.tunkki.core.runtime;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.exception.types.SyntaxTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

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
            if (node == null) {
                throw new SyntaxTunkkiError(-1, "null node");
            }

            data = node.evaluate();

            if (data != null) {
                output = data.toString();
            } else {
                break;
            }
        }
        return output;
    }
}
