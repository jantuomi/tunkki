package com.jantuomi.borker.core.tokenizer;

import com.jantuomi.borker.core.tokenizer.token.Token;
import com.jantuomi.borker.core.tokenizer.token.types.IntegerLiteralToken;
import com.jantuomi.borker.exception.BorkError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by jan on 10.6.2016.
 */
public class TokenizerTest {

    @Test
    public void testAddition() throws BorkError {
        String testString = "1 2 +";
        List<Token> list = Tokenizer.getInstance().tokenize(testString);

        System.out.println(String.format("test string:\n%s", testString));
        Tokenizer.printTokens(list);
        assertTrue(list.contains(new IntegerLiteralToken("2")));
    }
}