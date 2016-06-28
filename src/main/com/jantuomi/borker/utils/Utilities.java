package com.jantuomi.borker.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by jan on 10.6.2016.
 */
public class Utilities {
    private Utilities() {}

    public static String getBasePath() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        return s;
    }
}
