package com.jantuomi.interpreter.test.core.tokenizer;

import com.jantuomi.interpreter.main.core.tokenizer.Tokenizer;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by jan on 10.6.2016.
 */
public class TokenizerTest {

    @Test
    public void testTokenizeCommentAndSymbol() {
        String testString = "\"string literal\"\n/*comment*/\n1 2\nsymbol_Test3";
        List<Token> list = Tokenizer.getInstance().tokenize(testString);

        System.out.println(String.format("test string:\n%s", testString));
        Tokenizer.printTokens(list);
        assertTrue(list.contains(new Token(Token.Type.CommentToken, "comment")));
    }

    @Test
    public void testTokenizeMultilineString() {
        String testString = "\"this is a\nmultiline\nstring\"";
        List<Token> list = Tokenizer.getInstance().tokenize(testString);

        System.out.println(String.format("test string:\n%s", testString));
        Tokenizer.printTokens(list);
        assertTrue(list.contains(new Token(Token.Type.StringLiteralToken, "this is a\nmultiline\nstring")));
    }

    @Test
    public void testTokenizeMath() {
        String testString = "x <- (1 + 2) / 3 * 4";
        List<Token> list = Tokenizer.getInstance().tokenize(testString);

        System.out.println(String.format("test string:\n%s", testString));
        Tokenizer.printTokens(list);
        for (Token t : list) {
            if (t.isSameType(new Token(Token.Type.AssignmentToken))) {
                return;
            }
        }
        assertTrue("No assignment token found!" == null);
    }

    @Test
    public void testTokenizeDeclAndAssign() {
        String testString = "decl x\nx <- 1 + 2";
        List<Token> list = Tokenizer.getInstance().tokenize(testString);

        System.out.println(String.format("test string:\n%s", testString));
        Tokenizer.printTokens(list);
        for (Token t : list) {
            if (t.isSameType(new Token(Token.Type.DeclarationToken))) {
                return;
            }
        }
        assertTrue("No declaration token found!" == null);
    }

    @Test
    public void testTokenizeFunction() {
        String testString = "func name(arg)\nx <- 1\nend";
        List<Token> list = Tokenizer.getInstance().tokenize(testString);

        System.out.println(String.format("test string:\n%s", testString));
        Tokenizer.printTokens(list);
        for (Token t : list) {
            if (t.isSameType(new Token(Token.Type.FunctionDefineToken))) {
                return;
            }
        }
        assertTrue("No function declaration token found!" == null);
    }
}