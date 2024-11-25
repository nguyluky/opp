package com.companyname.doAn.Gui;
import java.util.Scanner;

import com.companyname.doAn.ql.QuanLyNhanVien;
import com.companyname.doAn.ql.QuanLyPhongBan;
import com.companyname.doAn.type.DuAn;
import com.companyname.doAn.type.NhanVien;
import com.companyname.doAn.type.PhongBan;
public class OptionQuanLyPhongBan implements ShowOption{
    public OptionQuanLyPhongBan(){}
    Scanner sc = StaticScanner.sc;
    QuanLyPhongBan qlpb = QuanLyPhongBan.getInstance();
    OptionPhongBan optionPhongBan = new OptionPhongBan();

    public void themPhongBan(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập tên phòng ban: ");
        String namePhongBan = sc.nextLine();
        System.out.printf("Nhập id phòng ban: ");
        String idPhongBan = sc.nextLine();
        NhanVien dsnhanVien[] = new NhanVien[0];
        DuAn dsDuAn[] = new DuAn[0];

        QuanLyPhongBan qlpb = QuanLyPhongBan.getInstance();
        PhongBan currentPhongBan = new PhongBan(namePhongBan, idPhongBan, dsnhanVien, dsDuAn, false);
        qlpb.addPhongBan(currentPhongBan);

        System.out.println("---------------------------------------");
        System.out.println("Chọn chức năng tiếp theo đối với phòng ban vừa tạo: ");
        System.out.println("1: Thêm dự án");
        System.out.println("2: Xóa dự án");
        System.out.println("3: Thêm nhân viên");
        System.out.println("4: Xóa nhân viên");
        System.out.println("5: Đổi tên phòng ban");
        System.out.println("6: Đổi id phòng ban");
        System.out.println("0: Quay lại menu trước");

        int choice = Integer.parseInt(sc.nextLine());
        OptionPhongBan optionPhongBan = new OptionPhongBan();
        switch(choice){
            case 1:
                optionPhongBan.themDuAn(currentPhongBan);
                break;
            case 2:
                optionPhongBan.xoaDuAn(currentPhongBan);
                break;
            case 3: 
                optionPhongBan.themNhanVien(currentPhongBan);
                break;
            case 4: 
                optionPhongBan.xoaNhanVien(currentPhongBan);   
                break;
            case 5:
                while(true){
                    System.out.println("Nhập tên mới: ");
                    String newName = sc.nextLine();
                    if(qlpb.getPhongBanByID(idPhongBan) == null){
                        currentPhongBan.setNamePhongBan(newName);
                        break;
                    }
                    else{
                        System.out.println("Tên phòng ban đã tồn tại! Vui lòng nhập tên khác!");
                    }
                }
                break;
            case 6:
                while(true){
                    System.out.println("Nhập ID mới: ");
                    String newID = sc.nextLine();
                    if(qlpb.getPhongBanByID(idPhongBan) == null){
                        currentPhongBan.setIdPhongBan(newID);
                        break;
                    }
                    else{
                        System.out.println("ID phòng ban đã tồn tại! Vui lòng nhập ID khác");
                    }
                }
                break;
            case 7:
                break;
            default:
                System.out.println("Nhập không đúng");
                break;
        }
    }

    public void xoaPhongBan(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập ID phòng ban muốn xóa: ");
        String id = sc.nextLine();
        QuanLyPhongBan qlpb = QuanLyPhongBan.getInstance();
        if(qlpb.getPhongBanByID(id) != null){
            qlpb.getPhongBanByID(id).setIsDelete(true);
        }
        else{
            System.out.println("ID phòng ban không tồn tại. Quay lại menu trước.");
        }
    }

    public void searchPhongBanByName(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập tên phòng ban cần tìm thông tin: ");
        String name = sc.nextLine();
        QuanLyPhongBan qlpb = QuanLyPhongBan.getInstance();
        if(qlpb.getPhongBanByName(name) != null){
            qlpb.getPhongBanByName(name).printThongTinPhongBan();
        }
        else{
            System.out.println("ID phòng ban không tồn tại. Quay lại menu trước");
        }
    }

    public void moveNhanVien(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập ID nhân viên muốn di chuyển phòng ban: ");
        String idNhanVien = sc.nextLine();
        //kiểm tra xem ID nhân viên có tồn tại trong công ty không
        QuanLyNhanVien qlnv = QuanLyNhanVien.getInstance();
        if(qlnv.getNhanVienById(idNhanVien) != null){
            //kiểm tra xem nhân viên đang ở phòng ban nào, hay chưa có phòng ban
            boolean checkTonTaiPhongBan = false;
            PhongBan phongBanHaveNhanVien = null;
            QuanLyPhongBan qlpb = QuanLyPhongBan.getInstance();
            for(PhongBan pb : qlpb.getDsPhongBan()){
                for(NhanVien nv : pb.getDsNhanVien()){
                    if(nv.getId().equals(idNhanVien)){
                        checkTonTaiPhongBan = true;
                        phongBanHaveNhanVien = pb;
                    }
                }
            }
            if(checkTonTaiPhongBan){
                System.out.println("Nhân viên đang ở phòng ban: " + phongBanHaveNhanVien.getNamePhongBan());
                System.out.printf("Nhập ID phòng ban nhân viên sẽ chuyển đến: ");
                String idPhongBan = sc.nextLine();
                if(qlpb.getPhongBanByID(idPhongBan) != null){
                    qlpb.getPhongBanByID(idPhongBan).addNhanVien(qlnv.getNhanVienById(idNhanVien));
                    //xóa nhân viên khỏi phòng ban cũ
                    phongBanHaveNhanVien.removeNhanVien(idNhanVien);
                }
            }
            else{
                System.out.printf("Nhân viên hiện chưa thuộc phòng ban nào. Nhập ID phòng ban thêm nhân viên: ");
                while(true){
                    String idPhongBan = sc.nextLine();
                    if(qlpb.getPhongBanByID(idPhongBan) != null){
                        qlpb.getPhongBanByID(idPhongBan).addNhanVien(qlnv.getNhanVienById(idNhanVien));
                        break;
                    }
                    else{
                        System.out.println("ID phòng ban không tồn tại! Vui lòng nhập lại ID phòng ban");
                    }
                }
            }
        }
        else{
            System.out.println("ID nhân viên không tồn tại");
        }
    }

    @Override
    public void show(){
        System.out.printf("Nhập ID phòng ban cụ thể: ");
        String idPhongBan = sc.nextLine();
        if(qlpb.getPhongBanByID(idPhongBan) == null){
            System.out.println("ID phòng ban không tồn tại");
            return;
        }
        PhongBan currentPhongBan = qlpb.getPhongBanByID(idPhongBan);
        System.out.println("---------------------------------------");
        System.out.println("Chọn chức năng tiếp theo đối với phòng ban: ");
        System.out.println("1: Thêm nhân viên");
        System.out.println("2: Xóa nhân viên");
        System.out.println("3: Thêm dự án");
        System.out.println("2: Xóa dự án");
        System.out.println("5: Chức năng đối với dự án cụ thể");
        System.out.println("0: Quay lại menu trước");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                optionPhongBan.themNhanVien(currentPhongBan);
                break;
            case 2:
                optionPhongBan.xoaNhanVien(currentPhongBan);
                break;
            case 3:
                optionPhongBan.themDuAn(currentPhongBan);
                break;
            case 4:
                optionPhongBan.xoaDuAn(currentPhongBan);
                break;
            case 5: 
                optionPhongBan.show();
                break;
            case 0:

                break;
            default:
                System.out.println("Cần nhập lựa chọn hợp lý");
                break;
        }
    }
}
