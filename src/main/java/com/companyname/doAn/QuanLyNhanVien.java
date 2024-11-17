package com.companyname.doAn;

import java.util.Arrays;

public class QuanLyNhanVien {
    private int soLuongNhanVien;
    private nhanVien[] dsNhanVien; // Changed nhanVien to NhanVien to follow naming conventions
    private static QuanLyNhanVien instance = new QuanLyNhanVien(); // Singleton instance initialization

    private QuanLyNhanVien() {
        this.soLuongNhanVien = 0;
        this.dsNhanVien = new nhanVien[0]; // Initialize with an empty array
    }

    public static QuanLyNhanVien getInstance() {
        return instance;
    }

    public QuanLyNhanVien(int soLuongNhanVien) {
        this(); // Call the default constructor to initialize the instance
        this.soLuongNhanVien = soLuongNhanVien;
        this.dsNhanVien = new nhanVien[soLuongNhanVien]; // Allocate the array based on the provided size

        for (int i = 0; i < this.soLuongNhanVien; i++) {
            this.dsNhanVien[i] = new nhanVien();
            this.dsNhanVien[i].nhap();
        }
    }

    //----------------GET-------------------
    public nhanVien[] getDanhSachNhanVien() {
        return this.dsNhanVien;
    }

    public int getSoLuongNhanVien() {
        return this.soLuongNhanVien;
    }

    //-------------------------------------------

    public void printDanhSachIdNhanVien() {
        if (dsNhanVien.length == 0) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }

        for (int i = 0; i < dsNhanVien.length; i++) {
            System.out.println("Id nhân viên thứ " + (i + 1) + ": " + dsNhanVien[i].getId());
        }
    }

    public void addNhanVien() {
        this.dsNhanVien = Arrays.copyOf(this.dsNhanVien, this.dsNhanVien.length + 1);
        this.dsNhanVien[this.dsNhanVien.length - 1] = new nhanVien();
        this.dsNhanVien[this.dsNhanVien.length - 1].nhap();
        this.soLuongNhanVien++; // Update employee count
        System.out.println("Nhân viên mới đã được thêm.");
    }

    public nhanVien getNhanVienById(String id) {
        for (nhanVien nv : this.dsNhanVien) {
            if (nv.getId().equals(id)) {
                return nv;
            }
        }
        return null; // Return null if no employee found with the given ID
    }
}