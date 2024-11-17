package com.companyname.doAn;

import java.time.LocalDate;
import java.util.Scanner;

public class truongPhong extends nhanSu {
    private int kinhNghiem; // Years of experience
    private final double heSophucap; // Derived from kinhNghiem
    private double phuCapthamnien; // Seniority allowance
    private int soNgaynghi; // Number of days off
    private final String chuVu = "Truong Phong"; // Position title
    private final int soNgayduocphepnghi = 3; // Allowed days off

    public truongPhong() {
        this.heSophucap = calculateHeSoPhucap(); // Calculate based on kinhNghiem
    }

    public truongPhong(String id, String name, String phone, String diaChi, int namVaolam, int kinhNghiem, double phuCapthamnien, int soNgaynghi) {
        super(id, name, phone, diaChi, namVaolam);
        this.kinhNghiem = kinhNghiem;
        this.phuCapthamnien = phuCapthamnien;
        this.soNgaynghi = soNgaynghi;
        this.heSophucap = calculateHeSoPhucap(); // Calculate based on kinhNghiem
    }

    @Override
    double bonusChucvu() {
        return luongCoban() * 2.25 + luongCoban() * heSophucap;
    }

    @Override
    double luongCoban() {
        return 4000000; // Base salary
    }

    @Override
    double bonusMoneyhesothidua() {
        switch (getHeSothidua()) {
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
        int daysOff = Math.max(0, soNgaynghi - soNgayduocphepnghi);
        return (luongCoban() + bonusChucvu() + bonusMoneyhesothidua() + getPhuCapthamnien()) - (daysOff * 300000);
    }

    public int getKinhNghiem() {
        return LocalDate.now().getYear() - super.getNamVaolam(); // Calculate experience
    }

    public double getHeSophucap() {
        return heSophucap; // Return calculated value
    }

    private double calculateHeSoPhucap() {
        int kinhNghiem = getKinhNghiem();
        if (kinhNghiem < 3) return 1.25;
        if (kinhNghiem < 5) return 1.5;
        if (kinhNghiem < 10) return 2.0;
        if (kinhNghiem <= 15) return 2.5;
        return 3.0; // For more than 15 years
    }

    public double getPhuCapthamnien() {
        return getKinhNghiem() * luongCoban() / 100; // 1% of base salary per year of experience
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
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("So ngay nghi:");
        setSoNgaynghi(Integer.parseInt(sc.nextLine()));
    }

    @Override
    public String toString() {
        return String.format("%s\t\tKinh nghiem: %d\t\tHe so phu cap: %.2f\t\tChuc vu: %s\t\tSo ngay nghi: %d\t\tTong tien luong: %.2f",
                super.toString(), getKinhNghiem(), getHeSophucap(), getChuVu(), getSoNgaynghi(), tienLuong());
    }

    public void xuat() {
        System.out.println(toString());
    }
}