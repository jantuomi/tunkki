package com.jantuomi.tunkki.repl;

import com.jantuomi.tunkki.Tunkki;
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

        String line;
        PrintWriter out = new PrintWriter(System.out);

        while ((line = readLine(reader, "")) != null) {
            try {
                tunkki.run(line);
            }
            catch (TunkkiError ex) {
                ex.printStackTrace();
                Thread.sleep(50);
            }

            out.flush();
        }
    }

    private String readLine(ConsoleReader reader, String promptMessage)
            throws IOException {
        String line = reader.readLine(promptMessage + "\ntunkki> ");
        return line.trim();
    }

    private void showWelcomeText() {
        System.out.println(String.format("tunkki REPL version %s", tunkki.versionString()));
    }
}
