package com.companyname.doAn;

import java.time.LocalDate;
import java.util.Scanner;

public class giamDoc extends nhanSu { // Đổi tên lớp theo quy tắc CamelCase
    private int kinhNghiem;
    private double heSophucap;
    private double phuCapthamnien;
    private int soNgaynghi;
    private final String chuVu = "Giám Đốc"; // Đổi tên cho chuẩn
    private final int soNgayduocphepnghi = 3;
    private Scanner sc = new Scanner(System.in); // Thêm scanner để nhập dữ liệu

    @Override
    double bonusChucvu() {
        return luongCoban() * 2.25 + luongCoban() * getHeSophucap();
    }

    @Override
    double luongCoban() {
        return 5000000; // Lương cố định cho Giám đốc
    }

    @Override
    double bonusMoneyhesothidua() {
        switch (getHeSothidua()) {  // switch expression
            case "A": return luongCoban() * 3.5;
            case "B": return luongCoban() * 2.5;
            case "C": return luongCoban() * 1.5;
            case "D": return luongCoban() * 1;
            case "E": return luongCoban();
            default: return 0;
        }
    }

    @Override
    double tienLuong() {
        double d = Math.max(0, getSoNgaynghi() - getSoNgayduocphepnghi());
        return (luongCoban() + bonusChucvu() + bonusMoneyhesothidua() + getPhuCapthamnien()) - (d * 300000);
    }

    public giamDoc() {
        // Constructor rỗng
    }

    public giamDoc(String id, String name, String phone, String diaChi, int namVaolam, int kinhNghiem, double phuCapthamnien, int soNgaynghi) {
        super(id, name, phone, diaChi, namVaolam);
        this.kinhNghiem = kinhNghiem;
        this.phuCapthamnien = phuCapthamnien;
        this.soNgaynghi = soNgaynghi;
    }

    public int getKinhNghiem() {
        LocalDate year = LocalDate.now();
        return year.getYear() - super.getNamVaolam(); // Tính số năm kinh nghiệm
    }

    public double getHeSophucap() {
        if (getKinhNghiem() < 3) {
            return 1.25;
        } else if (getKinhNghiem() < 5) {
            return 1.5;
        } else if (getKinhNghiem() < 10) {
            return 2.0;
        } else if (getKinhNghiem() <= 15) {
            return 2.5;
        } else {
            return 3.0;
        }
    }

    public double getPhuCapthamnien() {
        return getKinhNghiem() * luongCoban() / 100; // Tính phụ cấp thâm niên
    }

    public int getSoNgaynghi() {
        return soNgaynghi;
    }

    public void setSoNgaynghi(int soNgaynghi) {
        this.soNgaynghi = soNgaynghi;
    }

    public String getChuVu() {
        return chuVu;
    }

    public int getSoNgayduocphepnghi() {
        return soNgayduocphepnghi;
    }

    public void nhap() {
        super.nhap(); // Gọi phương thức nhập của lớp cha
        System.out.print("Số ngày nghỉ: ");
        setSoNgaynghi(Integer.parseInt(sc.nextLine()));
    }

    @Override
    public String toString() {
        return super.toString() +
                "\t\tKinh nghiệm: " + getKinhNghiem() +
                "\t\tHệ số phụ cấp: " + getHeSophucap() +
                "\t\tChức vụ: " + getChuVu() +
                "\t\tSố ngày nghỉ: " + getSoNgaynghi() +
                "\t\tTổng tiền lương: " + tienLuong();
    }

    public void xuat() {
        System.out.println(toString());
    }
}