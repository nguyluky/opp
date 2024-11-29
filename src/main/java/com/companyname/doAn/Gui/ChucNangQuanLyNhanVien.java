package com.companyname.doAn.Gui;

import java.util.Scanner;

public class ChucNangQuanLyNhanVien implements ShowOption{
    public ChucNangQuanLyNhanVien() {}
    Scanner sc = StaticScanner.sc;
    OptionQuanLyNhanSu optionQuanLyNhanSu = new OptionQuanLyNhanSu();

    public void show(){
        System.out.println("1: Thêm nhân viên");
        System.out.println("2: Xóa nhân viên");
        System.out.println("3: Xem thông tin của nhân viên bằng ID");
        int choice;
        while(true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if(choice > 3 || choice < 0){
                    System.out.println("Vui lòng chọn lựa chọn hợp lý");
                }
                else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên dương");
            }
        }
        switch (choice){
            case 1:
                optionQuanLyNhanSu.themNhanSu();
                break;
            case 2:
                optionQuanLyNhanSu.xoaNhanSu();
                break;
            case 3:
                optionQuanLyNhanSu.show();
        }
    }

}
