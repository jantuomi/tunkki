package com.jantuomi.tunkki.repl;

import com.jantuomi.tunkki.Tunkki;
import com.jantuomi.tunkki.core.parser.datatype.IntegerDatatype;
import com.jantuomi.tunkki.exception.TunkkiError;
import jline.console.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jan on 31.7.2016.
 */
public class Repl {

    private Tunkki tunkki;

    public Repl(Tunkki tunkki) {
        this.tunkki = tunkki;
    }

    public void run() throws IOException, InterruptedException {
        showWelcomeText();

        ConsoleReader reader = new ConsoleReader();
        reader.setBellEnabled(false);
        reader.setExpandEvents(false);

        String line;
        String command = "";
        PrintWriter out = new PrintWriter(System.out);
        boolean isMultilineInput = false;
        while (true)  {
            if (isMultilineInput) {
                line = readLine(reader, "... ");
            } else {
                line = readLine(reader, "tunkki> ");
            }

            if (line.endsWith("\\")) {
                isMultilineInput = true;
                command += line.substring(0, line.length() - 1) + " ";
            } else {
                try {
                    isMultilineInput = false;
                    command += line;
                    tunkki.run(command);
                } catch (TunkkiError ex) {
                    ex.printStackTrace();
                    Thread.sleep(50);
                } finally {
                    command = "";
                }
            }

            out.flush();
        }
    }

    private String readLine(ConsoleReader reader, String promptMessage)
            throws IOException {
        System.out.print(promptMessage);
        String line = reader.readLine();
        return line.trim();
    }

    private void showWelcomeText() {
        System.out.println(String.format("tunkki REPL version %s", tunkki.versionString()));
        System.out.println("Copyright: Jan Tuomi 2016");
    }
}
