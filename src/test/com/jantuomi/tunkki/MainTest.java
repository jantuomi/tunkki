package com.jantuomi.tunkki;

import com.jantuomi.tunkki.exception.TunkkiError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jan on 10.6.2016.
 */
public class MainTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @Before
    public void setupStreams() {
        originalOut = System.out;
        System.setOut(new PrintStream(out));
    }

    @After
    public void cleanStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testParseArguments1() {
        String[] notAnArgument = {"--not-an-argument"};
        assertFalse(Tunkki.getInstance().parseArguments(notAnArgument));
    }

    @Test
    public void testParseArguments2() {
        String[] fileTestArgument = {"-f", "test.file"};
        assertTrue(Tunkki.getInstance().parseArguments(fileTestArgument));
    }

    @Test
    public void testWholeProcedure() throws TunkkiError {
        String input = "- + 2 5 1";

        Tunkki.getInstance().run(input);
        assertTrue(out.toString().contains("6"));
    }
}