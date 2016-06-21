package com.jantuomi.interpreter.main.core.tokenizer;


import com.jantuomi.interpreter.main.core.tokenizer.token.Token;
import com.jantuomi.interpreter.main.exception.ExceptionManager;
import com.jantuomi.interpreter.main.exception.InterpreterException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jan on 10.6.2016.
 */
public class Tokenizer {
    private String sourceString;

    public List<Token> getTokens() {
        return tokens;
    }

    private List<Token> tokens = new ArrayList<>();

    private static Map<Token.Type, String> tokenRegexes = new LinkedHashMap<>();
    private static final List<Token.Type> discardedTokenTypes = new ArrayList<>();
    private static final List<Token.Type> erroneousTokenTypes = new ArrayList<>();

    private static final Tokenizer instance = new Tokenizer();

    public static final Tokenizer getInstance() {
        return instance;
    }

    private Tokenizer() {
        tokenRegexes.put(Token.Type.CommentToken, "^\\/\\*(.*)\\*\\/");
        tokenRegexes.put(Token.Type.StringLiteralToken, "^\"(.*)\"");
        tokenRegexes.put(Token.Type.WhitespaceToken, "^( |\t)");
        tokenRegexes.put(Token.Type.NewlineToken, "^(\n|\r\n)");
        tokenRegexes.put(Token.Type.AdditionToken, "^(\\+)");
        tokenRegexes.put(Token.Type.SubtractionToken, "^(\\-)");
        tokenRegexes.put(Token.Type.DivisionToken, "^(\\/)");
        tokenRegexes.put(Token.Type.MultiplicationToken, "^(\\*)");
        tokenRegexes.put(Token.Type.AssignmentToken, "^(set)\\b");
        tokenRegexes.put(Token.Type.LessThanToken, "^(\\<)");
        tokenRegexes.put(Token.Type.GreaterThanToken, "^(\\>)");
        tokenRegexes.put(Token.Type.LessOrEqualThanToken, "^(\\<\\=)");
        tokenRegexes.put(Token.Type.GreaterOrEqualThanToken, "^(\\>\\=)");
        tokenRegexes.put(Token.Type.EqualsToken, "^(\\=\\=)");
        tokenRegexes.put(Token.Type.NotEqualsToken, "^(\\!\\=)");
        tokenRegexes.put(Token.Type.OpenParenToken, "^(\\()");
        tokenRegexes.put(Token.Type.ClosedParenToken, "^(\\))");
        tokenRegexes.put(Token.Type.FunctionDefineToken, "^(func)\\b");
        tokenRegexes.put(Token.Type.FunctionBodyToken, "^(as)\\b");
        tokenRegexes.put(Token.Type.EndFunctionDefineToken, "^(end)\\b");
        tokenRegexes.put(Token.Type.DeclarationToken, "^(decl)\\b");
        tokenRegexes.put(Token.Type.IntegerLiteralToken, "^(\\d+)");
        tokenRegexes.put(Token.Type.SymbolToken, "^([a-zA-Z]+\\w*)");

        discardedTokenTypes.add(Token.Type.WhitespaceToken);
        discardedTokenTypes.add(Token.Type.CommentToken);

        erroneousTokenTypes.add(Token.Type.NotAToken);
    }

    public List<Token> tokenize(String string) throws InterpreterException {
        sourceString = string;
        tokens.clear();
        int line = 1;
        for (int i = 0; i < string.length();) {

            Token token = Token.makeToken(string.substring(i), tokenRegexes, line);

            if (token == null) {
                i++;
                continue;
            }

            if (token.getTokenType() == Token.Type.NewlineToken) {
                line++;
            }

            if (!discardedTokenTypes.contains(token.getTokenType())) {
                tokens.add(token);
            }

            if (erroneousTokenTypes.contains(token.getTokenType())) {
                ExceptionManager.raise(InterpreterException.ExceptionType.IllegalTokenError, line, token.getText());
            }

            String tokenRawText = token.getRawText();
            if (tokenRawText == null) {
                tokenRawText = token.getText();
            }
            if (tokenRawText != null) {
                i += tokenRawText.length();
            } else {
                i++;
            }
        }
        return tokens;
    }

    public static void printTokens(List<Token> tokens) {
        System.out.println("### Tokens: ###");
        for (Token token : tokens) {
            System.out.println(String.format("%-40s %s", token.getTokenType(), token.getText()));
        }
        System.out.println("### End ###");
    }
}
