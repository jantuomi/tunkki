package com.jantuomi.interpreter.test;

import com.jantuomi.interpreter.main.Main;
import com.jantuomi.interpreter.main.exception.InterpreterException;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jan on 10.6.2016.
 */
public class MainTest {
    @Test
    public void testParseArguments1() {
        String[] notAnArgument = {"--not-an-argument"};
        assertFalse(Main.parseArguments(notAnArgument));
    }

    @Test
    public void testParseArguments2() {
        String[] fileTestArgument = {"-f", "test.file"};
        assertTrue(Main.parseArguments(fileTestArgument));
    }

    @Test
    public void testWholeProcedure() throws InterpreterException {
        String input = "x <- 1 + 2";
        Main.run(input);
    }
}