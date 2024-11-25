package com.companyname.doAn.Gui;
import java.util.Scanner;

import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyNhanVien;
import com.companyname.doAn.ql.QuanLyPhongBan;
import com.companyname.doAn.type.NhanVien;

public class OptionMenu implements ShowOption{

    public OptionMenu(){}

    @Override
    public void show(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------");
        System.out.println("Chọn chức năng quản lý");
        System.out.println("1: Quản lý dự án");
        System.out.println("2: Quản lý phòng ban");
        System.out.println("3: Quản lý nhân viên");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                chucNangQuanLyDuAn();
                break;
            case 2:
                chucNangQuanLyPhongBan();
                break;
        }
    }

    public void chucNangQuanLyDuAn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------");
        System.out.println("Chọn chức năng đối với dự án:");
        System.out.println("1: Xem danh sách toàn bộ dự án");
        System.out.println("2: Thêm dự án");
        System.out.println("3: Xóa dự án");
        System.out.println("4: Tìm kiếm thông tin dự án theo id");
        System.out.println("5: Chức năng đối với dự án cụ thể. Cần nhập id dự án");
        System.out.println("0: Quay lại menu trước");
        int choice = Integer.parseInt(sc.nextLine());
        OptionQuanLyDuAn optionDuAn = new OptionQuanLyDuAn();
        switch (choice) {
            case 1: 
                QuanLyDuAn qlda = QuanLyDuAn.getInstance();
                qlda.printDsDuAn();
                chucNangQuanLyDuAn();
                break;
            case 2:
                optionDuAn.themDuAn();
                chucNangQuanLyDuAn();
                break;
            case 3:
                optionDuAn.xoaDuAn();
                chucNangQuanLyDuAn();
                break;
            case 4:
                optionDuAn.getThongTinDuAnById();
                chucNangQuanLyDuAn();
                break;
            case 0:
            default:
                System.out.println("Cần nhập lựa chọn hợp lý");
                chucNangQuanLyDuAn();
                break;
        }
    }

    public void chucNangQuanLyPhongBan(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------");
        System.out.println("Chọn chức năng đối với phòng ban:");
        System.out.println("1: Xem danh sách toàn bộ phòng ban");
        System.out.println("2: Thêm phòng ban");
        System.out.println("3: Xóa phòng ban");
        System.out.println("4: Tìm kiếm thông tin phòng ban theo tên");
        System.out.println("5: Chuyển nhân viên");
        System.out.println("6: Chức năng đối với phòng ban cụ thể. Cần nhập id phòng ban");
        System.out.println("0: Quay lại menu trước");

        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                QuanLyPhongBan qlpb = QuanLyPhongBan.getInstance();
                qlpb.printDsPhongBan();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 0:
                break;
            default:
            System.out.println("Cần nhập lựa chọn hợp lý");
                break;
        }
    }

    public void chucNangQuanLyNhanVien(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chức năng muốn chọn:");
        System.out.println("1: Xem danh sách nhân viên đang làm");
        System.out.println("2: Xem danh sách nhân viên đã nghỉ");
        System.out.println("3: Thêm nhân viên");
        System.out.println("4: Xóa nhân viên");
        int choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1: 
            QuanLyNhanVien qlnv = QuanLyNhanVien.getInstance();
            for(NhanVien nv : qlnv.getDsNhanVien()){
                nv.toString();
            }
            break;
        }
    }
}
