package com.companyname.doAn.Gui;

import java.io.IOException;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

public class Screen {
    private static Screen instance;
    public static boolean isRunning = true;
    

    public static Screen getInstance() {
        return instance;
    }

    Terminal terminal;

    public Screen() {
        try {
            this.terminal = TerminalBuilder.terminal();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }


    public void eventTrigger() {
        NonBlockingReader reader = terminal.reader();
        while (isRunning) {

            if (reader.available() > 0) {
                try {
                    int key = reader.read();
                    if (key == 113) {
                        isRunning = false;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
