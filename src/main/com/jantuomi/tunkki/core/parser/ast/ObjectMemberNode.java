package com.jantuomi.tunkki.core.parser.ast;

import com.jantuomi.tunkki.core.parser.datatype.CallableDatatype;
import com.jantuomi.tunkki.core.parser.datatype.Datatype;
import com.jantuomi.tunkki.core.parser.datatype.ObjectDatatype;
import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.core.runtime.State;
import com.jantuomi.tunkki.exception.types.NotAnObjectTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;
import com.jantuomi.tunkki.exception.types.UndeclaredSymbolTunkkiError;

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
            d = State.getGlobalState().resolveSymbol(getText());
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
            Datatype callable = od.getData().resolveSymbol(cn.getName());
            if (callable != null) {
                return ((CallableDatatype) callable).call(cn.evaluateParameters());
            }
        }
        else if (member instanceof SymbolNode) {
            SymbolNode sn = (SymbolNode) member;
            Datatype res = od.getData().resolveSymbol(sn.getName());
            if (res != null) {
                return res;
            }
        }

        throw new UndeclaredSymbolTunkkiError(getLine(), member.getText());
    }
}
