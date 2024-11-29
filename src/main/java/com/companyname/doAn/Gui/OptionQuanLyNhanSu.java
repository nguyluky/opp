package com.companyname.doAn.Gui;

import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.type.NhanSu;
import com.companyname.doAn.type.NhanVien;

import java.util.Scanner;

public class OptionQuanLyNhanSu implements ShowOption{
    public OptionQuanLyNhanSu() {}
    Scanner sc = StaticScanner.sc;
    QuanLyNhanSu qlns = QuanLyNhanSu.getInstance();

    public void themNhanSu(){
        System.out.println("Nhập số lượng nhân sự muốn thêm:");
        int slNhanVien;
        while(true){
            try {
                slNhanVien = Integer.parseInt(sc.nextLine());
                if(slNhanVien<0){
                    System.out.println("Vui lòng nhập số nguyên dương");
                }
                else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên dương");
            }
        }
        for(int i=0; i<slNhanVien;i++){
            System.out.println("Nhân viên thứ " + i+1 + ":");
            System.out.print("Nhập ID: ");
            String id = sc.next();
            System.out.print("Nhập tên: ");
            String name = sc.nextLine();
            System.out.print("Nhập số điện thoại: ");
            String phone = sc.nextLine();
            System.out.print("Nhập địa chỉ: ");
            String address = sc.nextLine();
            System.out.print("Nhập năm vào làm: ");
            int year = Integer.parseInt(sc.next());
            System.out.print("Nhập số năm kinh nghiệm đã tích lũy trước đó: ");
            int kinhnghiem = Integer.parseInt(sc.next());

            NhanVien newNhanVien = new NhanVien(id, name, phone, address, year, kinhnghiem);
            qlns.addNhanSu(newNhanVien);
            System.out.println("Thêm nhân sự thành công. Quay lại menu trước\n");
        }

    }

    public void xoaNhanSu(){
        System.out.print("Nhập số lượng nhân sự muốn xóa: ");
        int slNhanVien;
        while(true){
            try {
                slNhanVien = Integer.parseInt(sc.nextLine());
                if(slNhanVien<0){
                    System.out.println("Vui lòng nhập số nguyên dương");
                }
                else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên dương");
            }
        }
        for(int i=0; i<slNhanVien;i++){
            System.out.print("Nhập ID nhân viên thứ " + (i+1) + " muốn xóa: ");
            String idNhanVien = sc.nextLine();
            if(qlns.getNhanSuById(idNhanVien) != null && !qlns.getNhanSuById(idNhanVien).getIsDelete()){
                qlns.getNhanSuById(idNhanVien).setDelete(true);
            }
            else{
                System.out.println("ID nhân viên không tồn tại. Bỏ qua");
            }
        }
    }

    @Override
    public void show(){
        System.out.print("Nhập ID nhân sự: ");
        String idNhanSu = sc.nextLine();
        if(qlns.getNhanSuById(idNhanSu) == null && !qlns.getNhanSuById(idNhanSu).getIsDelete()){
            System.out.println("ID nhân sự không tồn tại");
            return;
        }
        NhanSu currentNhanSu = qlns.getNhanSuById(idNhanSu);
        System.out.println("Chọn chức năng tiếp theo đối với sự: ");
        System.out.println("1: Xem thông tin cơ bản");
        System.out.println("2: Xem tình trạng kỷ luật");
        System.out.println("3: Xem tình trạng khen thưởng");
        System.out.println("0: Quay lại menu trước");
        int choiceNhanSu;
        while(true) {
            try {
                choiceNhanSu = Integer.parseInt(sc.nextLine());
                if (choiceNhanSu < 0) {
                    System.out.println("Vui lòng nhập số dương");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        }
        switch (choiceNhanSu){
            case 1:
                currentNhanSu.printThongTinCoBan();
                break;
            case 2:
                currentNhanSu.printTinhTrangKyLuat();
                break;
            case 3:
                currentNhanSu.printTinhTrangKhenThuong();
                break;
            case 0:
                break;
        }
    }
}
