package com.companyname.doAn.Gui;

import static com.companyname.doAn.Gui.ShareIntance.*;
import com.companyname.doAn.type.*;

public class OptionQuanLyPhongBan implements ShowOption{
    public OptionQuanLyPhongBan(){}

    public void themPhongBan() {
        System.out.println("---------------------------------------");
        System.out.print("Nhap so phong ban muon them: ");
        int slPb;
        while (true) {
            try {
                slPb = Integer.parseInt(sc.nextLine());
                if (slPb < 0) {
                    System.out.println("Nhap so nguyen duong");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhap so nguyen duong");
            }
        }
        for (int i = 0; i < slPb; i++) {
            System.out.print("Nhập tên phòng ban thứ " + (i + 1) + ": ");
            String namePhongBan = sc.nextLine();
            if(qlpb.getPhongBanByName(namePhongBan) != null){
                System.out.println("Tên đã tồn tại");
                continue;
            }

            System.out.print("Nhập ID phòng ban thứ " + (i + 1) + ": ");
            String idPhongBan = sc.nextLine();
            if (qlpb.getPhongBanByID(idPhongBan) != null) {
                System.out.println("ID đã tồn tại");
                continue;
            }

            PhongBan currentPhongBan = new PhongBan(namePhongBan, idPhongBan);
            qlpb.addPhongBan(currentPhongBan);

            System.out.println("1: Thêm dự án");
            System.out.println("2: Xóa dự án");
            System.out.println("3: Thêm nhân viên");
            System.out.println("4: Xóa nhân viên");
            System.out.println("0: Khong lam gi het");
            System.out.print("Chon chuc nang: ");

            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    if (choice > 4 || choice < 0) {
                        System.out.println("Can nhap so nguyen duong");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Can nhap so nguyen duong");
                }
            }

            switch (choice) {
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
                case 0:
                    break;
            }

        }
    }

    public void xoaPhongBan(){
        System.out.println("---------------------------------------");
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
        //in danh sách nhân viên đang làm
        qlns.printDsNhanVienDangLam();
        System.out.print("Nhập ID nhân viên muốn di chuyển phòng ban: ");
        String idNhanVien = sc.nextLine();
        //kiểm tra xem ID nhân viên có tồn tại trong công ty không
        if(qlns.getNhanVienById(idNhanVien) == null || qlns.getNhanVienById(idNhanVien).getIsDelete()){
            System.out.println("ID nhân viên không tồn tại");
        }
        else{
            //kiểm tra xem nhân viên đang ở phòng ban nào, hay chưa có phòng ban
            boolean checkTonTaiPhongBan = false;
            PhongBan phongBanHaveNhanVien = null;

            for(PhongBan pb : qlpb.getDsPhongBan()){
                for(NhanVien nv : pb.getDsNhanVien()){
                    if(nv.getId().equals(idNhanVien)){
                        checkTonTaiPhongBan = true;
                        phongBanHaveNhanVien = pb;
                    }
                }
            }
            //nếu đã có phòng ban
            if(checkTonTaiPhongBan){
                System.out.println("Nhân viên đang ở phòng ban: " + phongBanHaveNhanVien.getIdPhongBan());
                qlpb.printDsPhongBan(); //in id danh sach phong ban
                System.out.print("Nhập ID phòng ban mà nhân viên sẽ chuyển đến: ");
                String idPhongBan = sc.nextLine();
                if(qlpb.getPhongBanByID(idPhongBan) != null && !qlpb.getPhongBanByID(idPhongBan).getIsDelete()){
                    qlpb.getPhongBanByID(idPhongBan).addNhanVien(qlns.getNhanVienById(idNhanVien));
                    //xóa nhân viên khỏi phòng ban cũ
                    phongBanHaveNhanVien.removeNhanVien(idNhanVien);
                }
                else{
                    System.out.println("ID phòng ban không tồn tại");
                }
            }
            else{
                System.out.print("Nhân viên hiện chưa thuộc phòng ban nào. Nhập ID phòng ban thêm nhân viên: ");
                while(true){
                    String idPhongBan = sc.nextLine();
                    if(qlpb.getPhongBanByID(idPhongBan) != null){
                        qlpb.getPhongBanByID(idPhongBan).addNhanVien(qlns.getNhanVienById(idNhanVien));
                        break;
                    }
                    else{
                        System.out.println("ID phòng ban không tồn tại! Vui lòng nhập lại ID phòng ban");
                    }
                }
            }
        }
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
            System.out.println("2: Xóa dự án");
            System.out.println("5: Chức năng đối với dự án cụ thể");
            System.out.println("6: Thay doi truong phong");
            System.out.println("7: In danh sach nhan su");
            System.out.println("8: Xem thong tin phong ban");
            System.out.println("0: Quay lại menu trước");
            System.out.print("Chon chuc nang: ");

            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    if (choice > 8 || choice < 0) {
                        System.out.println("Can chon chuc nang hop ly");
                    } else break;
                } catch (NumberFormatException e) {
                    System.out.println("Can chon chuc nang hop ly");
                }
            }
            switch (choice) {
                case 1:
                    optionPhongBan.themNhanVien(currentPhongBan);
                    optionMenu.chucNangQuanLyPhongBan();
                    break;
                case 2:
                    optionPhongBan.xoaNhanVien(currentPhongBan);
                    optionMenu.chucNangQuanLyPhongBan();
                    break;
                case 3:
                    optionPhongBan.themDuAn(currentPhongBan);
                    optionMenu.chucNangQuanLyPhongBan();
                    break;
                case 4:
                    optionPhongBan.xoaDuAn(currentPhongBan);
                    optionMenu.chucNangQuanLyPhongBan();
                    break;
                case 5:
                    optionPhongBan.show();
                    optionMenu.chucNangQuanLyPhongBan();
                    break;
                case 6:
                    optionPhongBan.thayDoiTruongPhong(currentPhongBan);
                    optionMenu.chucNangQuanLyPhongBan();
                    break;
                case 7:
                    currentPhongBan.printDsNhanSu();
                    optionMenu.chucNangQuanLyPhongBan();
                    break;
                case 8:
                    currentPhongBan.printThongTinPhongBan();
                    optionMenu.chucNangQuanLyPhongBan();
                    break;
                case 0:
                    optionMenu.chucNangQuanLyPhongBan();
                    break;
            }
        }
    }
}
