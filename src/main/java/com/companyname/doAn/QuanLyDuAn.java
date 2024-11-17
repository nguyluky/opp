package com.companyname.doAn;

import java.util.Arrays;
import java.util.Scanner;

public class QuanLyDuAn {
    private DuAn[] dsDuAn;
    private int soLuongDuAn;
    private static QuanLyDuAn instance = new QuanLyDuAn(); // Singleton instance initialization

    private QuanLyDuAn() {
        this.dsDuAn = new DuAn[0]; // Initialize with an empty array
        this.soLuongDuAn = 0;
    }

    public static QuanLyDuAn getInstance() {
        return instance;
    }

    //--------------GET-----------------------------
    public DuAn[] getDanhSachDuAn() {
        return this.dsDuAn;
    }

    public int getSoLuongDuAn() {
        return this.soLuongDuAn;
    }
    //--------------------------------------------------------------------

    //------------SET------------------
    public void setSoLuongDuAn(int sl) {
        this.soLuongDuAn = sl;
        this.dsDuAn = Arrays.copyOf(this.dsDuAn, sl);
    }
    //---------------------------------

    public void printDanhSachIdDuAn() {
        if (this.dsDuAn.length == 0) {
            System.out.println("Danh sách dự án trống.");
            return;
        }
        for (int i = 0; i < this.dsDuAn.length; i++) {
            System.out.println("Id của dự án thứ " + (i + 1) + ": " + this.dsDuAn[i].getIdDuAn());
        }
    }

    public void addDuAn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng dự án muốn thêm:");
        int sl = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < sl; i++) {
            this.dsDuAn = Arrays.copyOf(this.dsDuAn, this.dsDuAn.length + 1);
            this.dsDuAn[this.dsDuAn.length - 1] = new DuAn();
            this.dsDuAn[this.dsDuAn.length - 1].nhap();
        }
        // Update project count
        this.soLuongDuAn += sl;
    }

    public void deleteDuAn(String idDuAn) {
        boolean found = false;
        for (int i = 0; i < this.dsDuAn.length; i++) {
            if (this.dsDuAn[i].getIdDuAn().equals(idDuAn)) {
                System.out.println("Dự án với ID " + idDuAn + " đã được đánh dấu là đã xóa.");
                this.dsDuAn[i].setIsDelete(true); // Mark as deleted
                found = true;
                break; // Exit loop once found
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy dự án với ID " + idDuAn + ".");
        }
    }
}