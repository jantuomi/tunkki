package com.jantuomi.tunkki.core.parser;

import com.jantuomi.tunkki.core.parser.tokenizer.token.Token;
import com.jantuomi.tunkki.core.parser.tokenizer.token.types.AdditionToken;
import com.jantuomi.tunkki.core.parser.tokenizer.token.types.IntegerLiteralToken;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 12.6.2016.
 */
public class ParserTest {

    @Test
    public void testParseAddition() throws Exception {
        List<Token> tokens = Arrays.asList(
                new IntegerLiteralToken("1"),
                new IntegerLiteralToken("2"),
                new AdditionToken()
        );

        Parser parser = Parser.getInstance();
        List<Token> sequence = parser.parse(tokens);
        for (Token t : sequence) {
            parser.printTree(t);
        }
    }
}