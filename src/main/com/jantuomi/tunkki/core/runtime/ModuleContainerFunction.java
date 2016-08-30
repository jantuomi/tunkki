package com.jantuomi.tunkki.core.runtime;

import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.core.parser.ast.BlockBodyNode;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.VoidDatatype;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by jan on 30.8.2016.
 */
public class ModuleContainerFunction extends Function {

    List<ASTNode> nodes;

    public ModuleContainerFunction(List<ASTNode> nodes) {
        super(Collections.emptyList(), null);
        this.nodes = nodes;
    }

    @Override
    public Datatype executeBlock(List<Datatype> params) throws TunkkiError {
        Datatype returnValue = new VoidDatatype();

        for (ASTNode node : nodes) {
            returnValue = node.evaluate();
        }

        return returnValue;
    }

    @Override
    public boolean hasVariableArgumentList() {
        return false;
    }

    @Override
    public boolean hasDynamicallyTypedArguments() {
        return false;
    }

    @Override
    public List<Set<Datatype.Type>> getArgumentTypes() {
        return null;
    }
}
