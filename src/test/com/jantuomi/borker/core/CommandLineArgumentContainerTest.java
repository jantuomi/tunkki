package com.jantuomi.borker.core;

import com.jantuomi.borker.utils.Utilities;
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
        c.setFile(new File(basePath, "src/test/com/jantuomi/borker/resources/test.file"));
        String contents = c.getSourceFileContents();
        System.out.println(contents);
        assertTrue(contents.contains("###"));
    }

}