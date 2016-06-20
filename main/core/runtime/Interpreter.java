package com.jantuomi.interpreter.main.core.runtime;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;
import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
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
    public static String execute(List<ASTNode> sequence) {
        List<String> output = new ArrayList<>();
        for (ASTNode node : sequence) {
            DataContainer data = node.evaluate();

            if (data != null) {
                String out = data.toString();
                output.add(out);
            } else {
                break;
            }
        }
        return StringUtils.join(output, " ");
    }
}
