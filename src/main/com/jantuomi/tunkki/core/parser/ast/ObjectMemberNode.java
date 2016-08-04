package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.ObjectDatatype;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.core.runtime.State;
import com.jantuomi.tunkki.exception.types.NotAnObjectTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;
import com.jantuomi.tunkki.exception.types.UndeclaredSymbolTunkkiError;

import java.util.Collections;

/**
 * Created by jan on 3.8.2016.
 */
public class ObjectMemberNode extends UnaryOperatorNode {
    public ObjectMemberNode(Token token, ASTNode operand) {
        super(token, operand);
    }

    @Override
    public Datatype evaluate() throws TunkkiError {
        Datatype d;
        try {
            d = State.getInstance().evaluateSymbol(getText());
        } catch (TunkkiError ex) {
            ex.setLine(getLine());
            throw ex;
        }

        if (d.getType() != Datatype.Type.Object) {
            throw new NotAnObjectTunkkiError(getLine(), getText());
        }

        ObjectDatatype od = (ObjectDatatype) d;
        ASTNode member = getOperand();
        if (member instanceof CallNode) {
            CallNode cn = (CallNode) member;
            Datatype res = od.getData().resolveSymbol(cn.getName(), cn.evaluateParameters());
            if (res != null) {
                return res;
            }
        }
        else if (member instanceof SymbolNode) {
            SymbolNode sn = (SymbolNode) member;
            Datatype res = od.getData().resolveSymbol(sn.getName(), Collections.emptyList());
            if (res != null) {
                return res;
            }
        }

        throw new UndeclaredSymbolTunkkiError(getLine(), member.getText());
    }
}
