package com.jantuomi.interpreter.main.core.parser.ast;

import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.List;

/**
 * Created by jan on 17.6.2016.
 */
public abstract class VarargOperatorNode extends ASTNode {

    protected List<ASTNode> args;

    public VarargOperatorNode(Token token) {
        super(token);
    }

    @Override
    public List<ASTNode> getChildren() {
        return args;
    }

    public void setArgs(List<ASTNode> args) {
        this.args = args;
    }
}
