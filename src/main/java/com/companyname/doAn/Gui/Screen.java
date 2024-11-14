package com.companyname.doAn.Gui;

import java.io.IOException;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class Screen {
    

    private static Screen instance;

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
        
    }

}
