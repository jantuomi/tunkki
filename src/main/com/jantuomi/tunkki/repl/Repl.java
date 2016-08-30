package com.jantuomi.tunkki.repl;

import com.jantuomi.tunkki.Tunkki;
import com.jantuomi.tunkki.core.parser.ast.ASTNode;
import com.jantuomi.tunkki.exception.types.TunkkiError;
import com.jantuomi.tunkki.utils.IO;

import java.io.IOException;
import java.util.List;

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

        String line;
        String command = "";
        boolean isMultilineInput = false;
        while (true)  {
            if (isMultilineInput) {
                line = IO.getInstance().readLine("... ");
            } else {
                line = IO.getInstance().readLine("tunkki> ");
            }

            if (line.endsWith("\\")) {
                isMultilineInput = true;
                command += line.substring(0, line.length() - 1) + " ";
            } else {
                try {
                    isMultilineInput = false;
                    command += line;
                    List<ASTNode> nodes = tunkki.parseAndInterpret(command);
                    tunkki.executeAndOutput(nodes);
                } catch (TunkkiError ex) {
                    ex.printStackTrace();
                    Thread.sleep(50);
                } finally {
                    command = "";
                }
            }

            IO.getInstance().flush();
        }
    }

    private void showWelcomeText() {
        System.out.println(String.format("tunkki REPL version %s", tunkki.versionString()));
        System.out.println("Copyright: Jan Tuomi 2016");
    }
}
