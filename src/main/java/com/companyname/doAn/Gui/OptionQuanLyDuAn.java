package com.companyname.doAn.Gui;

import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyNhanVien;
import com.companyname.doAn.ql.QuanLyPhongBan;
import com.companyname.doAn.type.DuAn;
import com.companyname.doAn.type.NhanVien;
import java.util.Scanner;

public class OptionQuanLyDuAn implements ShowOption{
    public OptionQuanLyDuAn(){}
    Scanner sc = StaticScanner.sc;
    OptionMenu optionMenu = new OptionMenu();
    QuanLyDuAn qlda = QuanLyDuAn.getInstance();
    OptionDuAn optionDuAn = new OptionDuAn();

    public void themDuAn(){
        System.out.println("Nhập số dự án muốn thêm");
        int slDa;
        while(true){
            try {
                slDa = Integer.parseInt(sc.nextLine());
                if(slDa<0){
                    System.out.println("Nhập số âm là lỗi");
                }
                else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        }

        for(int i=0; i<slDa; i++){
            System.out.printf("Nhập tên dự án: ");
            String nameDuAn = sc.nextLine();
            System.out.printf("Nhập id dự án: ");
            String idDuAn = sc.nextLine();
            //tạo đối tượng dự án
            DuAn currentDuAn = new DuAn(nameDuAn, idDuAn, false);

            System.out.println("---------------------------------------");
            System.out.println("Chọn chức năng tiếp theo đối với dự án vừa tạo: ");
            System.out.println("1: Thêm nhân viên");
            System.out.println("2: Xóa nhân viên");
            System.out.println("3: Đổi tên dự án");
            System.out.println("0: Quay lại menu trước");
            int choice = Integer.parseInt(sc.nextLine());
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
                    break;
                default:
                    break;
            }
            qlda.addDuAn(currentDuAn);
        }
    }

    public void xoaDuAn(){
        System.out.println("Nhập số dự án muốn xóa");
        int slDa;
        while(true){
            try {
                slDa = Integer.parseInt(sc.nextLine());
                if(slDa<0){
                    System.out.println("Nhập số âm là lỗi");
                }
                else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        }

        for(int i=0; i<slDa; i++){
            System.out.println("Nhập ID dự án muốn xóa");
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
        System.out.printf("Nhập ID dự án muốn lấy thông tin:");
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
        System.out.printf("Nhập ID dự án cụ thể: ");
        String idDuAn = sc.nextLine();
        if(qlda.getDuAnById(idDuAn) == null){
            System.out.println("ID dự án không tồn tại");
            return;
        }
        DuAn currentDuAn = qlda.getDuAnById(idDuAn);
        System.out.println("---------------------------------------");
        System.out.println("Chọn chức năng tiếp theo đối với dự án: ");
        System.out.println("1: Thêm nhân viên");
        System.out.println("2: Xóa nhân viên");
        System.out.println("3: Đổi tên dự án");
        System.out.println("0: Quay lại menu trước");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                optionDuAn.themNhanVien(currentDuAn);
                optionMenu.chucNangQuanLyDuAn();
                break;
            case 2:
                optionDuAn.xoaNhanVien(currentDuAn);
                optionMenu.chucNangQuanLyDuAn();
                break;
            case 3:
                optionDuAn.doiTenDuAn(currentDuAn);
                optionMenu.chucNangQuanLyDuAn();
                break;
            case 0:
                optionMenu.chucNangQuanLyDuAn();
                break;
            default:
                System.out.println("Cần nhập lựa chọn hợp lý");
                optionMenu.chucNangQuanLyDuAn();
                break;
        }
    }
}
