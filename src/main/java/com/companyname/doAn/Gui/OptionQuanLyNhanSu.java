package com.companyname.doAn.Gui;

import com.companyname.doAn.type.NhanSu;
import com.companyname.doAn.type.NhanVien;
import com.companyname.doAn.type.PhongBan;
import com.companyname.doAn.type.TruongPhong;

import static com.companyname.doAn.Gui.StaticScanner.*;

public class OptionQuanLyNhanSu implements ShowOption {
    public OptionQuanLyNhanSu() {
    }

    public void themNhanSu() {
        System.out.println("---------------------------------------");
        System.out.print("Nhập số lượng nhân sự muốn thêm: ");
        int slNhanVien;
        while (true) {
            try {
                slNhanVien = Integer.parseInt(sc.nextLine());
                if (slNhanVien < 0) {
                    System.out.println("Vui lòng nhập số nguyên dương");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên dương");
            }
        }
        for (int i = 0; i < slNhanVien; i++) {
            System.out.println("---------------------------------------");
            System.out.println("Nhân sự thứ " + (i + 1) + ":");
            String id;
            while (true) {
                System.out.print("Nhập ID: ");
                id = sc.nextLine();
                if (qlns.getNhanSuById(id) != null) {
                    System.out.println("ID nhân sự đã tồn tại");
                } else
                    break;
            }
            System.out.print("Nhập tên: ");
            String name = sc.nextLine();
            String phone;
            while (true) {
                System.out.print("Nhập số điện thoại: ");
                phone = sc.nextLine().trim();
                boolean check = true;
                for (int k = 0; k < phone.length(); k++) {
                    if (!Character.isDigit(phone.charAt(k))) {
                        check = false;
                    }
                }
                if (phone.length() != 10 || !check) {
                    System.out.println("Cần nhập đúng định dạng số điện thoại");
                    continue;
                }
                boolean checkExist = false;
                for (NhanSu ns : qlns.getDsNhanSu()) {
                    if (ns.getPhone().equals(phone)) {
                        checkExist = true;
                        break;
                    }
                }
                if (checkExist) {
                    System.out.println("Số điện thoại đã tồn tại");
                    continue;
                }
                break;
            }
            System.out.print("Nhập địa chỉ: ");
            String address = sc.nextLine();
            System.out.print("Nhập năm vào làm: ");
            int year = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập số năm kinh nghiệm đã tích lũy trước đó: ");
            int kinhnghiem = Integer.parseInt(sc.nextLine());

            NhanVien newNhanVien = new NhanVien(id, name, phone, address, year, kinhnghiem);
            qlns.addNhanSu(newNhanVien);
            System.out.println("---------------------------------------");
            System.out.println("Thêm nhân sự thành công.");
        }
    }

    public void xoaNhanSu() {
        qlns.printDsNhanSu();
        System.out.print("Nhập số lượng nhân sự muốn xóa: ");
        int slNhanSu;
        while (true) {
            try {
                slNhanSu = Integer.parseInt(sc.nextLine());
                if (slNhanSu < 0 || slNhanSu > qlns.getDsNhanSu().length) {
                    System.out.println("Vui lòng nhập số nguyên dương");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên dương");
            }
        }
        if (slNhanSu == 0)
            return;
        for (int i = 0; i < slNhanSu; i++) {
            System.out.print("Nhập ID nhân sự thứ " + (i + 1) + " muốn xóa: ");
            String idNhanVien = sc.nextLine().trim();
            if (qlns.getNhanSuById(idNhanVien) != null && !qlns.getNhanSuById(idNhanVien).getIsDelete()) {
                if(qlns.getNhanSuById(idNhanVien) instanceof TruongPhong) {
                    int index = 0;
                    for(int k=0; k< qlns.getDsNhanSu().length; k++){
                        if(qlns.getDsNhanSu()[k].getId().equals(idNhanVien)){
                            index = k;
                            break;
                        }
                    }
                    NhanVien newNv = new NhanVien(qlns.getNhanSuById(idNhanVien).getId(), qlns.getNhanSuById(idNhanVien).getName(), qlns.getNhanSuById(idNhanVien).getPhone(), qlns.getNhanSuById(idNhanVien).getDiaChi(), qlns.getNhanSuById(idNhanVien).getNamVaoLam(), qlns.getNhanSuById(idNhanVien).getSoNgayNghi(), qlns.getNhanSuById(idNhanVien).getKinhNghiem(), qlns.getNhanSuById(idNhanVien).getLuongCoBan(), qlns.getNhanSuById(idNhanVien).getDsKyLuat(), qlns.getNhanSuById(idNhanVien).getDsKhenThuong(), true);
                    qlns.getDsNhanSu()[index] = newNv;
                    for(PhongBan pb : qlpb.getDsPhongBan()){
                        if(pb.getDsTruongPhong().getId().equals(idNhanVien)){
                            pb.setDsTruongPhong(null);
                            pb.addNhanVien(newNv);
                        }
                    }
                }
                qlns.getNhanSuById(idNhanVien).setDelete(true);

                System.out.println("---------------------------------------");
                System.out.println("Xoa Thanh cong !!!!!");
            } else {
                System.out.println("ID nhân viên không tồn tại");
            }
        }
    }

    @Override
    public void show() {
        // ShowOption.clearScreen();
            qlns.printDsNhanSu();
            System.out.println("---------------------------------------");
            System.out.print("Nhập ID nhân sự: ");
            String idNhanSu = sc.nextLine();
            if (qlns.getNhanSuById(idNhanSu) == null) {
                System.out.println("ID nhân sự không tồn tại");
                return;
            }
            if(qlns.getNhanSuById(idNhanSu).getIsDelete()){
                qlns.getNhanSuById(idNhanSu).printThongTinCoBan();
                return;
            }
            NhanSu currentNhanSu = qlns.getNhanSuById(idNhanSu);
            System.out.println("1: Xem thông tin cơ bản");
            System.out.println("2: Xem tình trạng kỷ luật");
            System.out.println("3: Xem tình trạng khen thưởng");
            System.out.println("4: Khen thuong");
            System.out.println("4: Ky luat");
            System.out.println("0: Quay lại menu trước");
            System.out.print("Chọn chức năng: ");
            int choiceNhanSu;
            while (true) {
                try {
                    choiceNhanSu = Integer.parseInt(sc.nextLine());
                    if (choiceNhanSu < 0) {
                        System.out.println("Can nhap so nguyen duong");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Can nhap so nguyen duong");
                }
            }
            switch (choiceNhanSu) {
                case 1:
                    currentNhanSu.printThongTinCoBan();
                    break;
                case 2:
                    optionNhanSu.printTinhTrangKyLuat(currentNhanSu);
                    break;
                case 3:
                    optionNhanSu.printTinhTrangKhenThuong(currentNhanSu);
                    break;
                case 4:
                    optionNhanSu.khenThuong(currentNhanSu);
                    break;
                case 5:
                    optionNhanSu.kyLuat(currentNhanSu);
                    break;
                case 0:
                    break;
            }
        }
}
