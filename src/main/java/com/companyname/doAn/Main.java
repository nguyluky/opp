
package com.companyname.doAn;


import com.companyname.doAn.Gui.OptionMenu;
import com.companyname.doAn.fileManager.FileManager;
import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyNhanSu;

public class Main {
    public static void main(String[] args) {

        try {

            FileManager fileManager = new FileManager();
            fileManager.read();

            // QuanLyDuAn ql = QuanLyDuAn.getInstance();
            // QuanLyNhanSu qlNhanSu = QuanLyNhanSu.getInstance();

            // for (int i = 0; i < ql.getDsDuAn().length; i++) {
            //     // ql.addDuAn(ql.getDsDuAn()[i]);
            //     System.out.println(ql.getDsDuAn()[i]);
            // }
            // System.out.println(ql);

            // for (int i = 0; i < qlNhanSu.getDsNhanSu().length; i++) {
            //     System.out.println(qlNhanSu.getDsNhanSu()[i]);
            // }
            // System.out.println(qlNhanSu);
            
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