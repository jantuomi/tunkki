package com.jantuomi.interpreter.test.core.parser;

import com.jantuomi.interpreter.main.core.parser.Parser;
import com.jantuomi.interpreter.main.core.parser.ast.ASTNode;
import com.jantuomi.interpreter.main.core.tokenizer.token.Token;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jan on 12.6.2016.
 */
public class ParserTest {

    @Test
    public void parseAssignment() throws Exception {
        List<Token> tokens = Arrays.asList(
                new Token(Token.Type.SymbolToken, "x"),
                new Token(Token.Type.AssignmentToken),
                new Token(Token.Type.SymbolToken, "y"),
                new Token(Token.Type.AdditionToken),
                new Token(Token.Type.SymbolToken, "x"),
                new Token(Token.Type.AdditionToken),
                new Token(Token.Type.IntegerLiteralToken, "1")
        );

        Parser parser = Parser.getInstance();
        List<ASTNode> sequence = parser.parse(tokens);
        for (ASTNode e : sequence) {
            parser.printTree(e);
        }
    }
}