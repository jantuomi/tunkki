package com.jantuomi.tunkki.core;

import com.jantuomi.tunkki.utils.Utilities;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * Created by jan on 10.6.2016.
 */
public class CommandLineArgumentContainerTest {
    @Test
    public void getSourceFileContents() throws Exception {
        CommandLineArgumentContainer c = CommandLineArgumentContainer.getInstance();
        File basePath = new File(Utilities.getBasePath());
        c.setFile(new File(basePath, "src/test/com/jantuomi/tunkki/resources/test.file"));
        String contents = c.getSourceFileContents();
        System.out.println(contents);
        assertTrue(contents.contains("###"));
    }

}