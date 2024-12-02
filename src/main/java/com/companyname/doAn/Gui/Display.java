package com.companyname.doAn.Gui;

import java.util.Arrays;
import java.util.Scanner;

import com.companyname.doAn.Gui.Screen.Screen;

public class Display {
    private static Display instance = null;
    public Scanner sc;

    public static Display getInstance() {
        if (instance == null) {
            instance = new Display();
        }
        return instance;
    }

    Screen[] stackOptions = new Screen[0];

    public Display() {
        sc = new Scanner(System.in);
    }

    public void setOptionMenu(Screen optionMenu) {
        this.stackOptions = Arrays.copyOf(this.stackOptions, this.stackOptions.length + 1);
        this.stackOptions[this.stackOptions.length - 1] = optionMenu;
    }

    public void back() {
        stackOptions = Arrays.copyOf(stackOptions, stackOptions.length - 1);
    }

    public void show() {
        while (stackOptions.length > 0) {
            System.out.println("\033[H\033[2J");
            stackOptions[stackOptions.length - 1].show(this);
        }
    }

    public Screen getParent() {
        return stackOptions[stackOptions.length - 2];
    }
}
