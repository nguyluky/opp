
package com.companyname.doAn;


import com.companyname.doAn.Gui.OptionMenu;
import com.companyname.doAn.fileManager.FileManager;

public class Main {
    public static void main(String[] args) {

        try {

            FileManager fileManager = new FileManager();
            fileManager.read();
            
            OptionMenu menu = new OptionMenu();
            menu.show();

            fileManager.write();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}