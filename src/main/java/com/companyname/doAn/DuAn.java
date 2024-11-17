package com.companyname.doAn;

import java.util.Arrays;
import java.util.Scanner;

public class DuAn {
    private String nameDuAn;
    private String idDuAn;
    private nhanVien dsNhanVien[];
    private int soLuongNhanVien;
    private boolean isDelete = false; // Trạng thái dự án có bị xóa hay không

    public DuAn() {}

    public DuAn(String nameDuAn, String idDuAn, int soLuongNhanVien) {
        this.nameDuAn = nameDuAn;
        this.idDuAn = idDuAn;
        this.soLuongNhanVien = soLuongNhanVien;
        this.dsNhanVien = new nhanVien[this.soLuongNhanVien]; // Khởi tạo mảng danh sách nhân viên
    }

    //--------------GET-------------------------------------
    public String getNameDuAn() {
        return this.nameDuAn;
    }

    public String getIdDuAn() {
        return this.idDuAn;
    }

    public int getSoLuongNhanVien() {
        return this.soLuongNhanVien;
    }

    public boolean isDelete() { // Đổi sang cách gọi getter đúng
        return this.isDelete;
    }

    public nhanVien[] getArrayNhanVienDuAn() {
        return this.dsNhanVien;
    }
    //--------------------------------------------------------

    //----------------------SET-----------------------------
    public void setArrayNhanVienDuAn(nhanVien array[]) {
        this.dsNhanVien = array;
    }

    public void setNameDuAn(String nameDuAn) {
        this.nameDuAn = nameDuAn;
    }

    public void setIdDuAn(String idDuAn) {
        this.idDuAn = idDuAn;
    }

    public void setSoLuongNhanVien(int sl) {
        this.soLuongNhanVien = sl;
        this.dsNhanVien = new nhanVien[sl]; // Cập nhật lại mảng khi số lượng thay đổi
    }

    public void setIsDelete(boolean tmp) {
        this.isDelete = tmp;
    }
    //--------------------------------------------------------------------

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên dự án:");
        this.nameDuAn = sc.nextLine();

        System.out.println("Nhập id dự án:");
        this.idDuAn = sc.nextLine();

        System.out.println("Nhập số lượng nhân viên trong dự án:");
        this.soLuongNhanVien = Integer.parseInt(sc.nextLine());
        this.dsNhanVien = new nhanVien[this.soLuongNhanVien];

        QuanLyNhanVien qlnv = QuanLyNhanVien.getInstance();
        qlnv.printDanhSachIdNhanVien(); // In ra danh sách tất cả nhân viên công ty

        for(int i = 0; i < this.soLuongNhanVien; i++) {
            this.dsNhanVien[i] = new nhanVien();
            addNhanVien();
        }
    }

    public void printDanhSachNhanVienDuAn() {
        if (dsNhanVien.length == 0) {
            System.out.println("Không có nhân viên nào!");
            return;
        }

        System.out.println("Danh sách nhân viên của dự án " + this.nameDuAn + ":");
        for(int i = 0; i < this.dsNhanVien.length; i++) {
            if(this.dsNhanVien[i] != null) { // Kiểm tra nhân viên không null
                System.out.println("Nhân viên " + (i + 1) + ": " + this.dsNhanVien[i].getName());
            }
        }
    }

    public void addNhanVien() {
        Scanner sc = new Scanner(System.in);
        QuanLyNhanVien qlnv = QuanLyNhanVien.getInstance();

        for (int i = 0; i < this.soLuongNhanVien; i++) {
            System.out.println("Nhập id nhân viên thứ " + (i + 1) + " muốn thêm:");
            String id = sc.nextLine();
            nhanVien nv = qlnv.getNhanVienById(id);
            if (nv == null) {
                System.out.println("Id nhân viên không tồn tại! Nhập lại");
                i--; // Đếm lại chỉ số nếu không tìm thấy
            } else {
                this.dsNhanVien[i] = nv; // Gán nhân viên vào danh sách
            }
        }
    }

    public void deleteNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng nhân viên muốn đuổi:");
        int sl = Integer.parseInt(sc.nextLine());
        printDanhSachNhanVienDuAn();

        for (int i = 0; i < sl; i++) {
            System.out.println("Nhập id nhân viên muốn đuổi:");
            String id = sc.nextLine();

            boolean found = false;
            for (int j = 0; j < this.dsNhanVien.length; j++) {
                if (this.dsNhanVien[j] != null && this.dsNhanVien[j].getId().equals(id)) {
                    this.dsNhanVien[j] = null; // Đánh dấu nhân viên cần xóa là null
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Id nhân viên không tồn tại! Nhập lại:");
                i--; // Đếm lại nếu không tìm thấy nhân viên
            }
        }

        // Tạo một mảng mới để lưu các nhân viên còn lại
        dsNhanVien = Arrays.stream(dsNhanVien)
                .filter(nv -> nv != null) // Lọc ra những nhân viên không null
                .toArray(nhanVien[]::new);
    }
}