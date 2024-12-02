package com.companyname.doAn.Gui.Screen;

import java.util.Scanner;

import com.companyname.doAn.Gui.Display;

public abstract class ScreenOption extends Screen {

    int minWith = -1;
    String title;
    String[] options;
    
    private int maxWidth;

    
    public abstract void processOption(Display display, int choice);
    
    public ScreenOption(String title, String[] options) {
        this(title, options, -1);
    }
    
    public ScreenOption(String title, String[] options, int minWith) {
        this.title = title;
        this.options = options;
        this.minWith = minWith;
        this.calulateMaxWidth();
    }

    void printTitle() {
        System.out.println("╔" + "═".repeat(maxWidth + 2) + "╗");
        System.out.println("║ " + this.colorText(this.centerText(this.title, maxWidth), FG_COLOR.GREEN, BG_COLOR.NONE)  + " ║");
        System.out.println("╠" + "═".repeat(maxWidth + 2) + "╣");
    }

    void calulateMaxWidth() {
        for (String option : options) {
            if (option.length() > maxWidth) {
                maxWidth = option.length();
            }
        }

        if (this.minWith >= 0 && maxWidth < this.minWith) {
            maxWidth = this.minWith;
        }
    }

    protected void printOption() {

        if (!title.equals(""))
            this.printTitle(); 

        for (String option : options) {
            System.out.println("║ " + option + " ".repeat(maxWidth - option.length()) + " ║");
        }

        System.out.println("╚" + "═".repeat(maxWidth + 2) + "╝");
    }
    
    protected int getChoice(Scanner sc) {
        return super.getChoice(sc, 0, options.length);
    }

    @Override
    public void show(Display display) {
        printOption();
        processOption(display, getChoice(new Scanner(System.in)));
    }

}