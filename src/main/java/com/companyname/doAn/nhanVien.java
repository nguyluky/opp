package com.companyname.doAn;

import java.time.LocalDate;

public class nhanVien extends nhanSu {  // Đổi tên lớp theo quy tắc CamelCase
    private int kinhNghiem;
    private double heSophucap;
    private double phuCapthamnien;
    private int soNgaynghi;
    private final String chuVu = "Nhan Vien";
    private final int soNgayduocphepnghi = 2;

    @Override
    double bonusChucvu() {
        return luongCoban() * 2.25 + luongCoban() * getHeSophucap();
    }

    @Override
    double luongCoban() {
        return 3000000;  // Lương cơ bản  
    }

    @Override
    double bonusMoneyhesothidua() {
        switch (getHeSothidua()) {  // switch expression  
            case "A":
                return luongCoban() * 3.5;
            case "B":
                return luongCoban() * 2.5;
            case "C":
                return luongCoban() * 1.5;
            case "D":
                return luongCoban() * 1;
            case "E":
                return luongCoban();
            default:
                return 0;
        }
    }

    @Override
    double tienLuong() {
        double deduction = Math.max(0, getSoNgaynghi() - getSoNgayduocphepnghi()) * 200000;  // Tính toán tiền phạt cho ngày nghỉ  
        return (luongCoban() + bonusChucvu() + bonusMoneyhesothidua() + getPhuCapthamnien()) - deduction;
    }

    public nhanVien() {
    }

    public nhanVien(String id, String name, String phone, String diaChi, int namVaolam, int kinhNghiem, double phuCapthamnien, int soNgaynghi) {
        super(id, name, phone, diaChi, namVaolam);
        this.kinhNghiem = kinhNghiem;
        this.phuCapthamnien = phuCapthamnien;
        this.soNgaynghi = soNgaynghi;
    }

    public int getKinhNghiem() {
        return LocalDate.now().getYear() - super.getNamVaolam();  // Tính số năm kinh nghiệm  
    }

    public void setKinhNghiem(int kinhNghiem) {
        this.kinhNghiem = kinhNghiem;
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

    public void setHeSophucap(double heSophucap) {
        this.heSophucap = heSophucap;
    }

    public double getPhuCapthamnien() {
        return getKinhNghiem() * luongCoban() / 100;  // Tính phụ cấp thâm niên  
    }

    public void setPhuCapthamnien(double phuCapthamnien) {
        this.phuCapthamnien = phuCapthamnien;
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

    @Override
    public void nhap() {
        super.nhap();
        System.out.println("Số ngày nghỉ:");
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

    @Override
    public void xuat() {
        System.out.println(toString());
    }
}