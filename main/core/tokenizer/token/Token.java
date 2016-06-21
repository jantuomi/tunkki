package com.jantuomi.interpreter.main.core.tokenizer.token;

import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.tokenizer.token.types.*;
import com.jantuomi.interpreter.main.exception.ExceptionManager;
import com.jantuomi.interpreter.main.exception.InterpreterException;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by jan on 10.6.2016.
 */
abstract public class Token {

    public void print(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("\t");
        }
        System.out.println(toString());
        for (Token child : getChildren()) {
            child.print(indent + 1);
        }
    }

    abstract public ASTNode generateNode() throws InterpreterException;

    /* Token types, ordered by precedence */
    public enum Type {
        CommentToken,
        AdditionToken,
        SubtractionToken,
        DivisionToken,
        MultiplicationToken,
        AssignmentToken,
        LessThanToken,
        GreaterThanToken,
        LessOrEqualThanToken,
        GreaterOrEqualThanToken,
        EqualsToken,
        NotEqualsToken,
        OpenParenToken,
        ClosedParenToken,
        FunctionDefineToken,
        DeclarationToken,
        StringLiteralToken,
        IntegerLiteralToken,
        WhitespaceToken,
        NewlineToken,
        EndStatementToken,
        SymbolToken,
        EndFunctionDefineToken,
        FunctionBodyToken,
        NotAToken
    }

    abstract public Token setArguments(List<Token> args);

    abstract public List<Token> getChildren();

    public boolean is(Type type) {
        return getTokenType() == type;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    private int line;
    private String rawText;
    private String text;
    private Type type;

    public String getText() {
        return text;
    }

    public Type getTokenType() {
        return this.type;
    }

    public String getRawText() {
        return rawText;
    }

    public boolean isHigherPrecedenceThan(Token other) {
        return getTokenType().ordinal() <= other.getTokenType().ordinal();
    }

    public Token(Type type, String text, String rawText) {
        initialize(type, text, rawText);
    }

    public Token(Type type, String text) {
        initialize(type, text);
    }

    public Token(Type type) {
        initialize(type, null);
    }

    private void initialize(Type type, String text, String rawText) {
        this.type = type;
        this.text = text;
        this.rawText = rawText;
    }

    private void initialize(Type type, String text) {
        initialize(type, text, text);
    }

    public static Token makeToken(String string, Map<Type, String> regexes, int line) throws InterpreterException {
        Type type = Type.NotAToken;
        String text = Character.toString(string.charAt(0));

        for (Type t : regexes.keySet()) {
            String regex = regexes.get(t);
            Token found = matchToken(string, t, regex, line);
            if (found != null) {
                found.setLine(line);
                return found;
            }
        }

        // TODO raise error
        return null;
    }

    public static Token matchToken(String string, Type type, String regex, int line) throws InterpreterException {
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            String text = matcher.group(1);
            String rawText = matcher.group(0);

            switch (type) {
                case WhitespaceToken:
                    return new WhitespaceToken();
                case CommentToken:
                    return new CommentToken(text, rawText);

                // TODO placeholder whitespace instead of newline
                case NewlineToken:
                    return new WhitespaceToken();

                case IntegerLiteralToken:
                    return new IntegerLiteralToken(text);
                case StringLiteralToken:
                    return new StringLiteralToken(text, rawText);
                case AdditionToken:
                    return new AdditionToken();
                case SubtractionToken:
                    return new SubtractionToken();
                case FunctionDefineToken:
                    return new FunctionDefineToken();
                case EndFunctionDefineToken:
                    return new EndFunctionDefineToken();
                case FunctionBodyToken:
                    return new FunctionBodyToken();
                case DeclarationToken:
                    return new VariableDeclareToken();
                case AssignmentToken:
                    return new AssignmentToken();
                case SymbolToken:
                    return new SymbolToken(text);
                case OpenParenToken:
                    return new OpenParenToken();
                case ClosedParenToken:
                    return new ClosedParenToken();
                default:
                    ExceptionManager.raise(InterpreterException.ExceptionType.IllegalTokenError, line,
                            type.toString()
                    );
            }
        }

        return null;
    }

    public ArgumentInfo getArgumentInfo() {
        switch (getTokenType()) {

            case FunctionDefineToken:
                ArgumentInfo fdai = new ArgumentInfo();
                fdai.setVariable(true);
                fdai.setTerminator(Type.FunctionBodyToken);
                return fdai;
            case FunctionBodyToken:
                ArgumentInfo fbai = new ArgumentInfo();
                fbai.setVariable(true);
                fbai.setTerminator(Type.EndFunctionDefineToken);
                return fbai;
            case OpenParenToken:
                ArgumentInfo opai = new ArgumentInfo();
                opai.setVariable(true);
                opai.setTerminator(Type.ClosedParenToken);
                return opai;
            case SymbolToken:
                ArgumentInfo sai = new ArgumentInfo();
                sai.setOptionalArgument(Type.OpenParenToken);
                return sai;
            case AdditionToken:
            case SubtractionToken:
            case DivisionToken:
            case MultiplicationToken:
            case AssignmentToken:
            case LessThanToken:
            case GreaterThanToken:
            case LessOrEqualThanToken:
            case GreaterOrEqualThanToken:
            case EqualsToken:
            case NotEqualsToken:
                return new ArgumentInfo(2);
            case DeclarationToken:
                return new ArgumentInfo(1);
            default:
                return new ArgumentInfo(0);
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(text)
                .append(getTokenType())
                .toHashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Token)) return false;
        if (o == this) return true;

        Token rhs = (Token) o;
        return new EqualsBuilder()
                .append(getTokenType(), rhs.getTokenType())
                .append(text, rhs.text)
                .isEquals();
    }

    @Override
    public String toString() {
        return String.format(String.format(
                "%s%s",
                getTokenType().toString().replace("Token", ""),
                getText() == null ? "" : " " + getText()
        ));
    }

    public String toFormattedString() {
        String textRepr = text;
        return String.format("%-40s %s", getTokenType(), textRepr);
    }

    public boolean isSameType(Token other) {
        return type == other.type;
    }
}
