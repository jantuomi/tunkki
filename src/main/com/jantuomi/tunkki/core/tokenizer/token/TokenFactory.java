package com.jantuomi.tunkki.core.tokenizer.token;

import com.jantuomi.tunkki.core.tokenizer.token.types.*;

/**
 * Created by jan on 28.6.2016.
 */
public class TokenFactory {
    private static TokenFactory instance = new TokenFactory();

    public static TokenFactory getInstance() {
        return instance;
    }

    private TokenFactory() {
    }

    public static Token create(Token.Type type, String text, String rawText) {
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
            case BooleanLiteralToken:
                return new BooleanLiteralToken(text);
            case DoubleLiteralToken:
                return new DoubleLiteralToken(text, rawText);
            case AdditionToken:
                return new AdditionToken();
            case SubtractionToken:
                return new SubtractionToken();
            case MultiplicationToken:
                return new MultiplicationToken();
            case DivisionToken:
                return new DivisionToken();
            case FunctionDefineToken:
                return new FunctionDefineToken();
            case EndBlockToken:
                return new EndBlockToken();
            case FunctionBodyToken:
                return new BlockBodyToken("as");
            case BranchBodyToken:
                return new BlockBodyToken("then");
            case DeclarationToken:
                return new VariableDeclareToken();
            case AssignmentToken:
                return new AssignmentToken();
            case SymbolToken:
                return new SymbolToken(text);
            case CallToken:
                return new CallToken(text, rawText);
            case CallEndToken:
                return new CallEndToken();
            case BranchToken:
                return new BranchToken();
            case NegationToken:
                return new NegationToken();
            default:
                return null;
        }
    }
}
