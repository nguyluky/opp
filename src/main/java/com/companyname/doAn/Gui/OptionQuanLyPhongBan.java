package com.companyname.doAn.Gui;

import com.companyname.doAn.type.PhongBan;

import static com.companyname.doAn.Gui.StaticScanner.*;

public class OptionQuanLyPhongBan implements ShowOption{
    public OptionQuanLyPhongBan(){}

    public void themPhongBan() {
        System.out.println("---------------------------------------");
        System.out.print("Nhập số phòng ban muốn thêm: ");
        int slPb;
        while (true) {
            try {
                slPb = Integer.parseInt(sc.nextLine());
                if (slPb < 0) {
                    System.out.println("Nhập số nguyên dương");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập số nguyên dương");
            }
        }
        for (int i = 0; i < slPb; i++) {
            String namePhongBan;
            while(true){
                System.out.print("Nhập tên phòng ban thứ " + (i + 1) + ": ");
                namePhongBan = sc.nextLine().trim();
                if(qlpb.getPhongBanByName(namePhongBan) != null){
                    System.out.println("Tên đã tồn tại");
                }
                else break;
            }
            String idPhongBan;
            while(true){
                System.out.print("Nhập ID phòng ban thứ " + (i + 1) + ": ");
                idPhongBan = sc.nextLine().trim();
                if (qlpb.getPhongBanByID(idPhongBan) != null) {
                    System.out.println("ID đã tồn tại");
                }
                else break;
            }

            PhongBan currentPhongBan = new PhongBan(namePhongBan, idPhongBan);
            qlpb.addPhongBan(currentPhongBan);

            System.out.println("1: Thêm dự án");
            System.out.println("2: Thêm nhân viên");
            System.out.println("0: Không làm gì hết");
            System.out.print("Chọn chức năng: ");

            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    if (choice > 2 || choice < 0) {
                        System.out.println("Cần nhập số nguyên dương");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Cần nhập số nguyên dương");
                }
            }


            switch (choice) {
                case 1:
                    optionPhongBan.themDuAn(currentPhongBan);
                    break;
                case 2:
                    optionPhongBan.themNhanVien(currentPhongBan);
                    break;
                case 0:
                    break;
            }

        }
    }

    public void xoaPhongBan(){
        System.out.println("---------------------------------------");
//        ShowOption.clearScreen();

        System.out.print("Nhập ID phòng ban muốn xóa: ");
        String id = sc.nextLine();
        if(qlpb.getPhongBanByID(id) == null || qlpb.getPhongBanByID(id).getIsDelete()){
            System.out.println("ID phòng ban không tồn tại");
        }
        else{
            qlpb.getPhongBanByID(id).setIsDelete(true);
            System.out.println("Xóa phòng ban thành công");
        }
    }

    public void moveNhanVien(){
        qlns.printDsNhanSu();
        System.out.print("Nhập ID nhân viên muốn di chuyển phòng ban: ");
        String idNhanVien = sc.nextLine().trim();
        //kiểm tra xem ID nhân viên có tồn tại trong công ty không
        if(qlns.getNhanVienById(idNhanVien) == null || qlns.getNhanVienById(idNhanVien).getIsDelete()){
            System.out.println("ID nhân viên không tồn tại");
            return;
        }
        System.out.print("Nhập ID phòng ban cho nhân viên: ");
        String idPhongBan = sc.nextLine().trim();
        if(qlpb.getPhongBanByID(idPhongBan) == null || qlpb.getPhongBanByID(idPhongBan).getIsDelete()){
            System.out.println("ID phòng ban không tồn tại");
            return;
        }
        qlpb.moveNhanVien(qlns.getNhanVienById(idNhanVien), qlpb.getPhongBanByID(idPhongBan));

    }

    @Override
    public void show(){

            qlpb.printDsPhongBan();
            System.out.println("-----------------------------------");
            System.out.print("Nhập ID phòng ban cụ thể: ");
            String idPhongBan = sc.nextLine();
            if(qlpb.getPhongBanByID(idPhongBan) == null){
                System.out.println("ID phòng ban không tồn tại");
                return;
            }
            PhongBan currentPhongBan = qlpb.getPhongBanByID(idPhongBan);

            if(currentPhongBan.getIsDelete()){
                System.out.println("Thông tin cơ bản");
                currentPhongBan.printThongTinPhongBan();
            }
            else {
                System.out.println("1: Thêm nhân viên");
                System.out.println("2: Xóa nhân viên");
                System.out.println("3: Thêm dự án");
                System.out.println("4: Xóa dự án");
                System.out.println("5: Thay doi truong phong");
                System.out.println("6: Xem thong tin phong ban");
                System.out.println("0: Quay lại menu trước");
                System.out.print("Chon chuc nang: ");

                int choice;
                while (true) {
                    try {
                        choice = Integer.parseInt(sc.nextLine());
                        if (choice > 6 || choice < 0) {
                            System.out.println("Can chon chuc nang hop ly");
                        } else break;
                    } catch (NumberFormatException e) {
                        System.out.println("Can chon chuc nang hop ly");
                    }
                }

                ShowOption.clearScreen();


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
                        optionPhongBan.thayDoiTruongPhong(currentPhongBan);
                        break;
                    case 6:
                        currentPhongBan.printThongTinPhongBan();
                        break;
                    case 0:
                        return;
                }
            }
        }

    public void searchByTen(){
        System.out.println("---------------------------------------");
        System.out.print("Nhập tên phòng ban: ");
        String ten = sc.nextLine().trim().toLowerCase();
        int k=1;
        for(int i=0; i<qlpb.getDsPhongBan().length; i++){
            if(qlpb.getDsPhongBan()[i].getNamePhongBan().toLowerCase().contains(ten)){
                System.out.println("Phòng ban thứ " + k + ": " + qlpb.getDsPhongBan()[i].getNamePhongBan() + ". ID: " + qlpb.getDsPhongBan()[i].getIdPhongBan());
                k++;
            }
        }
        if(k==1){
            System.out.println("Không tìm thấy");
        }
    }
}
