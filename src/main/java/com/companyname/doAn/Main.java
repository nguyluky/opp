
package com.companyname.doAn;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

import com.companyname.doAn.Gui.OptionMenu;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {
    public static void main(String[] args) {
        OptionMenu optionMenu = new OptionMenu();
        optionMenu.show();
        // try {
        //     PrintStream out = new PrintStream(System.out, true, UTF_8);
        //     out.println("đây là tiếng việt");

        //     // System.out.println("đây là tiếng việt");
        // }

        // catch (Exception e) {
        //     e.printStackTrace();
        // }
    }
}