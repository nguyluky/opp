package com.companyname.doAn.Gui;

public interface ShowOption {
    public void show();
    static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}
