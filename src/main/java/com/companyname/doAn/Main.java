
package com.companyname.doAn;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        nhanSu nv = new nhanVien();
//        nv.nhap(sc);
//        nv.xuat();
//        System.out.println(nv.bonusChucvu() + "  " + nv.bonusChucvu()+ "  " );

        try {
            Terminal t = TerminalBuilder.terminal();
            t.input().available();

        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }


}