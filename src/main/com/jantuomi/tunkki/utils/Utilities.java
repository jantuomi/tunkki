package com.jantuomi.tunkki.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by jan on 10.6.2016.
 */
public class Utilities {

    public static final String VERSION_FILE_PATH = "VERSION";

    private Utilities() {}

    public static String getBasePath() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        return s;
    }

    public static String getVersionFromFile() {
        Path path = Paths.get(getBasePath(), VERSION_FILE_PATH);

        List<String> lines = null;
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            StringBuilder builder = new StringBuilder();
            lines.stream().forEach(s -> builder.append(s));
            return builder.toString();
        } catch (IOException e) {
            return "Unknown version";
        }

    }
}
