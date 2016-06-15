package com.jantuomi.interpreter.main.core.tokenizer.token;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jan on 10.6.2016.
 */
public class Token {

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
        NotAToken
    }

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

    public static Token makeToken(String string, Map<Type, String> regexes, int line) {
        Type type = Type.NotAToken;
        String text = Character.toString(string.charAt(0));

        for (Type t : regexes.keySet()) {
            String regex = regexes.get(t);
            Token found = matchToken(string, t, regex);
            if (found != null) {
                found.setLine(line);
                return found;
            }
        }

        // TODO raise error
        return null;
    }

    public static Token matchToken(String string, Type type, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            String text = matcher.group(1);
            String rawText = matcher.group(0);

            return new Token(type, text, rawText);
        }

        return null;
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
        return String.format(String.format("%s %s", getTokenType(), getText()));
    }

    public String toFormattedString() {
        String textRepr = text;
        return String.format("%-40s %s", getTokenType(), textRepr);
    }

    public boolean isSameType(Token other) {
        return type == other.type;
    }
}
