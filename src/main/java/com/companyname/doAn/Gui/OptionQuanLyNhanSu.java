package com.companyname.doAn.Gui;

import com.companyname.doAn.type.NhanSu;
import com.companyname.doAn.type.NhanVien;

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
            String ho;
            while(true){
                boolean check = true;
                System.out.print("Nhập họ: ");
                ho = sc.nextLine().trim();
                for(int k=0; k<ho.length(); k++){
                    if(!(ho.charAt(k) >= 'A' && ho.charAt(k) <= 'Z' || ho.charAt(k) >= 'a' && ho.charAt(k) <= 'z')){
                        System.out.println("Họ chỉ chứa kí tự A -> Z, a->z");
                        check = false;
                        break;
                    }
                }
                if(check) break;
            }

            String ten;
            while(true){
                boolean check = true;
                System.out.print("Nhập tên: ");
                ten = sc.nextLine().trim();

                if(ten.isEmpty()){
                    continue;
                }
                for(int k=0; k<ten.length(); k++){
                    if(!(ten.charAt(k) >= 'A' && ten.charAt(k) <= 'Z' || ten.charAt(k) >= 'a' && ten.charAt(k) <= 'z' || ten.charAt(k) == ' ')){
                        System.out.println("Tên chỉ chứa kí tự A -> Z, a->z");
                        check = false;
                        break;
                    }
                }

                if(check) break;
            }

            String phone;
            while (true) {
                System.out.print("Nhập số điện thoại: ");
                phone = sc.nextLine().trim();
                boolean checkPhone = true;
                for (int k = 0; k < phone.length(); k++) {
                    if (!Character.isDigit(phone.charAt(k))) {
                        checkPhone = false;
                    }
                }
                if (phone.length() != 10 || !checkPhone) {
                    System.out.println("Cần nhập đúng định dạng số điện thoại");
                    continue;
                }
                boolean checkExist = false;
                for(int k=0; k<qlns.getDsNhanSu().length; k++) {
                    if (qlns.getDsNhanSu()[k].getPhone().equals(phone)) {
                        System.out.println("Số điện thoại đã tồn tại");
                        checkExist = true;
                        break;
                    }
                }
                if (checkExist) {continue;}
                break;
            }
            System.out.print("Nhập địa chỉ: ");
            String address = sc.nextLine();
            System.out.print("Nhập năm vào làm: ");
            int year = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập số năm kinh nghiệm đã tích lũy trước đó: ");
            int kinhnghiem = Integer.parseInt(sc.nextLine());

            NhanVien newNhanVien = new NhanVien(id, ho, ten, phone, address, year, kinhnghiem);
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
                qlns.getNhanSuById(idNhanVien).setDelete(true);
                System.out.println("---------------------------------------");
                System.out.println("Xóa thành công !");
            } else {
                System.out.println("ID nhân sự không tồn tại");
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

    public void list(){
        System.out.println("---------------------------------------");
        System.out.println("Danh sách nhân sự được khen thưởng: ");
        for(int i=0; i<qlns.getDsNhanSu().length; i++){
            if(!qlns.getDsNhanSu()[i].getIsDelete() && qlns.getDsNhanSu()[i].getDsKhenThuong().length>0){
                System.out.println("Nhân sự thứ " + (i+1) + ": " + qlns.getDsNhanSu()[i].getHo() + " " + qlns.getDsNhanSu()[i].getTen() + ". ID: " + qlns.getDsNhanSu()[i].getId());
            }
        }
        System.out.println("Danh sách nhân sự bị kỷ luật: ");
        for(int i=0; i<qlns.getDsNhanSu().length; i++){
            if(!qlns.getDsNhanSu()[i].getIsDelete() && qlns.getDsNhanSu()[i].getDsKyLuat().length>0){
                System.out.println("Nhân sự thứ " + (i+1) + ": " + qlns.getDsNhanSu()[i].getHo() + " " + qlns.getDsNhanSu()[i].getTen() + ". ID: " + qlns.getDsNhanSu()[i].getId());
            }
        }
    }

    public void searchByName(){
        System.out.println("---------------------------------------");
        System.out.println("Nhập tên nhân sự: ");
        String name = sc.nextLine().trim().toLowerCase();
        boolean checkSearch = false;
        for(int i=0; i<qlns.getDsNhanSu().length; i++){
            if(qlns.getDsNhanSu()[i].getTen().toLowerCase().contains(name)){
                System.out.println("Nhân sự thứ " + (i+1) + ": " + qlns.getDsNhanSu()[i].getTen() + ". ID: " + qlns.getDsNhanSu()[i].getId());
                checkSearch = true;
            }
        }
        if(!checkSearch){
            System.out.println("Không tìm thấy");
        }
    }

    public void rangeByName(){
        for(int i=0; i<qlns.getDsNhanSu().length; i++){
            int index_1 = qlns.getDsNhanSu()[i].getTen().lastIndexOf(' ');
            for(int j=i; j<qlns.getDsNhanSu().length-1; j++){
                int index_2 = qlns.getDsNhanSu()[j].getTen().lastIndexOf(' ');
                if(qlns.getDsNhanSu()[i].getTen().charAt((index_1)+1) > qlns.getDsNhanSu()[j].getTen().charAt((index_2+1))){
                    NhanSu tmp = qlns.getDsNhanSu()[i];
                    qlns.getDsNhanSu()[i] = qlns.getDsNhanSu()[j];
                    qlns.getDsNhanSu()[j] = tmp;
                }
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("Sắp xếp xong!");
    }
}
