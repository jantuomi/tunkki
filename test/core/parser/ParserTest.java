package com.jantuomi.interpreter.test.core.parser;

import com.jantuomi.interpreter.main.core.parser.Parser;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;
import com.jantuomi.interpreter.main.core.tokenizer.token.types.AdditionToken;
import com.jantuomi.interpreter.main.core.tokenizer.token.types.IntegerLiteralToken;
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