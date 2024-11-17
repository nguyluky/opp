package com.companyname.doAn;

import java.util.Scanner;
import java.util.Arrays;

public class QuanLyPhongBan {
    private int soLuongPhongBan;
    private PhongBan[] dsPhongBan;

    public QuanLyPhongBan() {
        this.soLuongPhongBan = 0;
        this.dsPhongBan = new PhongBan[0]; // Initialize as empty array
    }

    public QuanLyPhongBan(int soLuongPhongBan, PhongBan[] dsPhongBan) {
        this.soLuongPhongBan = soLuongPhongBan;
        this.dsPhongBan = dsPhongBan;
    }

    //-----GET---------
    public int getSoLuongPhongBan() {
        return this.soLuongPhongBan;
    }

    public PhongBan[] getDanhSachPhongBan() {
        return this.dsPhongBan;
    }
    //-----------------

    //-----SET------------
    public void setSoLuongPhongBan(int sl) {
        this.soLuongPhongBan = sl;
    }

    public void setDanhSachPhongBan(PhongBan[] dsPhongBan) {
        this.dsPhongBan = dsPhongBan;
    }
    //---------------------

    public void printDanhSachIdPhongBan() {
        if (this.dsPhongBan.length == 0) {
            System.out.println("Danh sách phòng ban trống.");
            return;
        }

        for (int i = 0; i < this.dsPhongBan.length; i++) {
            System.out.println("Id phòng ban thứ " + (i + 1) + " : " + this.dsPhongBan[i].getIdPhongBan());
        }
    }

    public void addPhongBan() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Nhập số lượng phòng ban muốn thêm:");
            int sl = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < sl; i++) {
                this.dsPhongBan = Arrays.copyOf(this.dsPhongBan, this.dsPhongBan.length + 1);
                this.dsPhongBan[this.dsPhongBan.length - 1] = new PhongBan();
                this.dsPhongBan[this.dsPhongBan.length - 1].nhap();
            }
            this.soLuongPhongBan += sl; // Update the count of departments
            System.out.println(sl + " phòng ban đã được thêm.");
        } catch (NumberFormatException e) {
            System.out.println("Số lượng phải là một số hợp lệ.");
        }
    }

    public void deletePhongBan() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Nhập số lượng phòng ban muốn xóa:");
            int sl = Integer.parseInt(sc.nextLine());
            printDanhSachIdPhongBan();

            for (int i = 0; i < sl; i++) {
                System.out.println("Nhập id phòng ban muốn xóa:");
                String id = sc.nextLine();

                boolean found = false;
                for (PhongBan pb : this.dsPhongBan) {
                    if (pb.getIdPhongBan().equals(id)) {
                        pb.setIsDelete(true);
                        found = true;
                        System.out.println("Phòng ban với id " + id + " đã được xóa.");
                        break; // Exit loop once found and deleted
                    }
                }

                if (!found) {
                    System.out.println("Id phòng ban không tồn tại trong công ty.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Số lượng phải là một số hợp lệ.");
        }
    }
}