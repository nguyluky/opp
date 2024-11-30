package com.companyname.doAn.Gui;


import static com.companyname.doAn.Gui.ShareIntance.*;
import static com.companyname.doAn.Gui.StaticScanner.sc;

public class OptionMenu implements ShowOption{
    public OptionMenu(){}


    @Override
    public void show(){
        System.out.println("---------------------------------------");
        System.out.println("1: Quản lý dự án");
        System.out.println("2: Quản lý phòng ban");
        System.out.println("3: Quản lý nhân sự");
        System.out.println("0: Thoát chương trình");
        System.out.print("Chọn chức năng quản lý: ");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                chucNangQuanLyDuAn();
                break;
            case 2:
                chucNangQuanLyPhongBan();
                break;
            case 3:
                chucNangQuanLyNhanSu();
                break;
            case 0:
                return;
            default:
                System.out.println("Không hợp lệ! Thoát");
        }
    }

    public void chucNangQuanLyDuAn(){
        System.out.println("---------------------------------------");
        System.out.println("1: Xem danh sách toàn bộ dự án");
        System.out.println("2: Thêm dự án");
        System.out.println("3: Xóa dự án");
        System.out.println("4: Chức năng đối với dự án cụ thể. Cần nhập ID dự án");
        System.out.println("0: Quay lại menu trước");
        System.out.print("Chọn chức năng: ");
        int choice;
        while (true){
            try {
                choice = Integer.parseInt(sc.nextLine());
                if(choice > 4 || choice < 0){
                    System.out.println("Cần chọn chức năng hợp lệ");
                }
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Cần chọn chức năng hợp lệ");
            }
        }
        switch (choice) {
            case 1:
                qlda.printDsDuAn();
                chucNangQuanLyDuAn();
                break;
            case 2:
                optionQuanLyDuAn.themDuAn();
                chucNangQuanLyDuAn();
                break;
            case 3:
                optionQuanLyDuAn.xoaDuAn();
                chucNangQuanLyDuAn();   
                break;
            case 4:
                optionQuanLyDuAn.show();
                chucNangQuanLyDuAn();
                break;
            case 0:
                show();
                break;
            default:
                System.out.println("Cần nhập lựa chọn hợp lý");
                chucNangQuanLyDuAn();
                break;
        }
    }

    public void chucNangQuanLyPhongBan(){
        System.out.println("---------------------------------------");
        System.out.println("1: Xem danh sách toàn bộ phòng ban");
        System.out.println("2: Thêm phòng ban");
        System.out.println("3: Xóa phòng ban");
        System.out.println("4: Chuyển nhân viên");
        System.out.println("5: Chức năng đối với phòng ban cụ thể. Cần nhập ID phòng ban");
        System.out.println("0: Quay lại menu trước");
        System.out.print("Chon chuc nang: ");

        int choice;
        while(true){
            try {
                choice = Integer.parseInt(sc.nextLine());
                if(choice < 0 || choice > 5){
                    System.out.println("Can chon chuc nang hop le");
                }
                else break;
            }catch(NumberFormatException e){
                System.out.println("Can chon chuc nang hop le");
            }
        }
        switch (choice) {
            case 1:
                qlpb.printDsPhongBan();
                chucNangQuanLyPhongBan();
                break;
            case 2:
                optionQuanLyPhongBan.themPhongBan();
                chucNangQuanLyPhongBan();
                break;
            case 3:
                optionQuanLyPhongBan.xoaPhongBan();
                chucNangQuanLyPhongBan();
                break;
            case 4:
                optionQuanLyPhongBan.moveNhanVien();
                chucNangQuanLyPhongBan();
                break;
            case 5:
                optionQuanLyPhongBan.show();
                chucNangQuanLyPhongBan();
                break;
            case 0:
                show();
                break;
        }
    }

    public void chucNangQuanLyNhanSu(){
        System.out.println("---------------------------------------");
        System.out.println("1: Xem danh sách nhân sự");
        System.out.println("2: Thêm nhân sự");
        System.out.println("3: Xóa nhân sự");
        System.out.println("4: Chuc nang doi voi nhan su cu the");
        System.out.println("0: Quay lại menu trước");
        System.out.print("Chọn chức năng: ");
        int choice;
        while(true){
            try {
                 choice = Integer.parseInt(sc.nextLine());
                if(choice>4){
                    System.out.println("Vui lòng nhập đúng lựa chọn");
                }
                else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        }
        switch (choice){
            case 1:
                qlns.printDsNhanSu();
                chucNangQuanLyNhanSu();
                break;
            case 2:
                optionQuanLyNhanSu.themNhanSu();
                chucNangQuanLyNhanSu();
                break;
            case 3:
                optionQuanLyNhanSu.xoaNhanSu();
                chucNangQuanLyNhanSu();
                break;
            case 4:
                optionQuanLyNhanSu.show();
                chucNangQuanLyNhanSu();
            case 0:
                show();
                break;
        }
    }
}
