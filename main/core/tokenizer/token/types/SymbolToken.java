package com.jantuomi.interpreter.main.core.tokenizer.token.types;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.parser.ast.ParameterListNode;
import com.jantuomi.interpreter.main.core.parser.ast.SymbolNode;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 16.6.2016.
 */
public class SymbolToken extends Token {

    public void setCallArgumentList(OpenParenToken callArgumentList) {
        this.callArgumentList = callArgumentList;
    }

    private OpenParenToken callArgumentList = null;

    public SymbolToken(String name) {
        super(Type.SymbolToken, name);
    }

    @Override
    public ASTNode generateNode() {
        SymbolNode node = new SymbolNode(this);
        node.setName(this.getText());
        if (callArgumentList != null) {
            node.setParameterListNode((ParameterListNode) callArgumentList.generateNode());
        }
        return node;
    }

    @Override
    public Token setArguments(List<Token> args) {
        if (args.size() > 0) {
            setCallArgumentList((OpenParenToken) args.get(0));
        }
        return this;
    }

    @Override
    public List<Token> getChildren() {
        if (callArgumentList == null) {
            return Arrays.asList();
        } else {
            return Arrays.asList(callArgumentList);
        }
    }
}
