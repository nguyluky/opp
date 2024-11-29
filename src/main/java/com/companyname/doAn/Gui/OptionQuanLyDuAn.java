package com.companyname.doAn.Gui;

import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.type.DuAn;
import java.util.Scanner;

public class OptionQuanLyDuAn implements ShowOption{
    Scanner sc = StaticScanner.sc;
    OptionMenu optionMenu = new OptionMenu();
    QuanLyDuAn qlda = QuanLyDuAn.getInstance();
    OptionDuAn optionDuAn = new OptionDuAn();
    OptionQuanLyPhongBan optionQuanLyPhongBan = new OptionQuanLyPhongBan();

    public OptionQuanLyDuAn(){}


    public void themDuAn(){
        System.out.print("Nhap so du an muon them: ");
        int slDa;
        while(true){
            try {
                slDa = Integer.parseInt(sc.nextLine());
                if(slDa<0){
                    System.out.println("Nhap so nguyen duong");
                }
                else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhap so nguyen duong");
            }
        }

        for(int i=0; i<slDa; i++){
            System.out.print("Nhập tên dự án: ");
            String nameDuAn = sc.nextLine();
            System.out.print("Nhập id dự án: ");
            String idDuAn = sc.nextLine();
            //tạo đối tượng dự án
            DuAn currentDuAn = new DuAn(nameDuAn, idDuAn);

            System.out.println("1: Thêm nhân viên");
            System.out.println("2: Xóa nhân viên");
            System.out.println("3: Đổi tên dự án");
            System.out.println("0: Quay lại menu trước");
            System.out.print("Chọn chức năng tiếp theo đối với dự án vừa tạo: ");
            int choice;
            while (true){
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    if(choice > 4 || choice < 0){
                        System.out.println("Chọn lựa chọn chưa hợp lý");
                    }
                    else{
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Chọn lựa chọn chưa hợp lý");
                }
            }
            switch(choice){
                case 1:
                    optionDuAn.themNhanVien(currentDuAn);
                    break;
                case 2:
                    optionDuAn.xoaNhanVien(currentDuAn);   
                    break;
                case 3: 
                    optionDuAn.doiTenDuAn(currentDuAn);
                    break;
                case 0:
                    optionMenu.chucNangQuanLyDuAn();
                    break;
            }
            qlda.addDuAn(currentDuAn);
        }
    }

    public void xoaDuAn(){
        qlda.printDsDuAn();

        System.out.print("Nhap so du an muon xoa: ");
        int slDa;
        while(true){
            try {
                slDa = Integer.parseInt(sc.nextLine());
                if(slDa<0){
                    System.out.println("Vui long nhap so nguyen duong");
                }
                else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen duong");
            }
        }

        for(int i=0; i<slDa; i++){
            System.out.print("Nhap ID du an thu: " + i+1 + " muon xoa: ");
            String idDuAn = sc.nextLine();
            DuAn da = qlda.getDuAnById(idDuAn);
            if(da!=null){
                da.setIsDelete(true);
            }
            else{
                System.out.println("Id dự án không tồn tại");
            }
        }
    }

    public void getThongTinDuAnById(){
        System.out.print("Nhập ID dự án muốn lấy thông tin:");
        String idDuAn = sc.nextLine();
        DuAn da = qlda.getDuAnById(idDuAn);
        if(da!=null){
            System.out.println(da); //toString nếu sai thì sửa giùm
        }
        else{
            System.out.println("Id dự án không tồn tại");
        }
    }

    @Override
    public void show(){
        System.out.print("Nhập ID dự án cụ thể: ");
        String idDuAn = sc.nextLine();
        if(qlda.getDuAnById(idDuAn) == null){
            System.out.println("ID dự án không tồn tại");
            return;
        }
        DuAn currentDuAn = qlda.getDuAnById(idDuAn);

        System.out.println("1: Thêm nhân viên");
        System.out.println("2: Xóa nhân viên");
        System.out.println("3: Đổi tên dự án");
        System.out.println("0: Quay lại menu trước");
        System.out.print("Chon chuc nang: ");
        int choice;
        while(true){
            try {
                choice = Integer.parseInt(sc.nextLine());
                if(choice > 3 || choice < 0){
                    System.out.println("Can chon chuc nang hop le");
                }
                else break;
            }catch(NumberFormatException e){
                System.out.println("Can chon chuc nang hop le");
            }
        }
        switch (choice) {
            case 1:
                optionDuAn.themNhanVien(currentDuAn);
                show();
                break;
            case 2:
                optionDuAn.xoaNhanVien(currentDuAn);
                show();
                break;
            case 3:
                optionDuAn.doiTenDuAn(currentDuAn);
                show();
                break;
            case 0:
                optionQuanLyPhongBan.show();
                break;
        }
    }
}
