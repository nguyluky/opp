package com.companyname.doAn;

import java.util.Arrays;
import java.util.Scanner;

public class PhongBan {
    private String namePhongBan;
    private String idPhongBan;
    private nhanVien[] dsNhanVien;
    private DuAn[] dsDuAn;
    private boolean isDelete;

    public PhongBan() {
        this.dsNhanVien = new nhanVien[0];  // Initialize to an empty array
        this.dsDuAn = new DuAn[0];          // Initialize to an empty array
    }

    //---------- GETTERS --------------
    public String getNamePhongBan() {
        return this.namePhongBan;
    }

    public String getIdPhongBan() {
        return this.idPhongBan;
    }

    public nhanVien[] getDsNhanVien() {
        return this.dsNhanVien;
    }

    public DuAn[] getDsDuAn() {
        return this.dsDuAn;
    }

    public boolean getIsDelete() {
        return this.isDelete;
    }

    //---------------- SETTERS ------------
    public void setNamePhongBan(String name) {
        this.namePhongBan = name;
    }

    public void setIdPhongBan(String id) {
        this.idPhongBan = id;
    }

    public void setDsNhanVien(nhanVien[] dsnv) {
        this.dsNhanVien = dsnv;
    }

    public void setDsDuAn(DuAn[] dsda) {
        this.dsDuAn = dsda;
    }

    public void setIsDelete(boolean status) {
        this.isDelete = status;
    }

    //--------------------------

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên phòng ban:");
        this.namePhongBan = sc.nextLine();
        System.out.println("Nhập id phòng ban:");
        this.idPhongBan = sc.nextLine();
        System.out.println("Nhập số lượng nhân viên phòng ban:");
        int sl = Integer.parseInt(sc.nextLine());
        this.dsNhanVien = new nhanVien[sl];
        for(int i = 0; i < sl; i++) {
            this.dsNhanVien[i] = new nhanVien();
            this.dsNhanVien[i].nhap();
        }
    }

    public void printDsNhanVien() {
        for(int i = 0; i < dsNhanVien.length; i++) {
            System.out.println("Nhân viên thứ " + (i + 1) + ": " + dsNhanVien[i].getName());
        }
    }

    public void printDsDuAn() {
        for(int i = 0; i < dsDuAn.length; i++) {
            System.out.println("Dự án thứ " + (i + 1) + ": " + dsDuAn[i].getNameDuAn());
        }
    }

    public void addNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng nhân viên muốn thêm vào phòng ban " + this.namePhongBan + ":");
        int sl = Integer.parseInt(sc.nextLine());

        QuanLyNhanVien qlnv = QuanLyNhanVien.getInstance();
        qlnv.printDanhSachIdNhanVien();

        for (int i = 0; i < sl; i++) {
            while (true) {
                System.out.println("Nhập id nhân viên thứ " + (i + 1) + " muốn thêm:");
                String id = sc.nextLine();
                nhanVien nvToAdd = null;
                for(nhanVien nv : qlnv.getDanhSachNhanVien()) {
                    if(nv.getId().equals(id)) {  // Use .equals for string comparison
                        nvToAdd = nv;
                        break;
                    }
                }
                if (nvToAdd == null) {
                    System.out.println("Id nhân viên không tồn tại trong công ty! Vui lòng nhập lại");
                } else if (isEmployeeInDepartment(nvToAdd.getId())) {
                    System.out.println("Nhân viên này đã tồn tại trong phòng ban");
                } else {
                    dsNhanVien = Arrays.copyOf(dsNhanVien, dsNhanVien.length + 1);
                    dsNhanVien[dsNhanVien.length - 1] = nvToAdd;
                    break;  // Exit the loop on successful addition
                }
            }
        }
    }

    private boolean isEmployeeInDepartment(String id) {
        for(nhanVien nv : dsNhanVien) {
            if(nv.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void deleteNhanVien() {
        Scanner sc = new Scanner(System.in);
        printDsNhanVien();
        System.out.println("Nhập số lượng nhân viên muốn đuổi khỏi phòng ban " + this.namePhongBan + ":");
        int sl = Integer.parseInt(sc.nextLine());

        for(int j = 0; j < sl; j++) {
            System.out.println("Nhập id nhân viên muốn bỏ khỏi phòng ban:");
            String id = sc.nextLine();
            if (!isEmployeeInDepartment(id)) {
                System.out.println("Id không tồn tại trong phòng ban!");
                continue; // Skip to the next iteration
            }
            dsNhanVien = Arrays.stream(dsNhanVien)
                    .filter(nv -> !nv.getId().equals(id)) // Filter out the employee to be deleted
                    .toArray(nhanVien[]::new);
        }
    }

    public void addDuAn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng dự án muốn thêm vào phòng ban:");
        int sl = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < sl; i++) {
            dsDuAn = Arrays.copyOf(dsDuAn, dsDuAn.length + 1);
            dsDuAn[dsDuAn.length - 1] = new DuAn();
            dsDuAn[dsDuAn.length - 1].nhap();
        }
    }

    public void deleteDuAn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng dự án muốn bỏ khỏi phòng ban:");
        int sl = Integer.parseInt(sc.nextLine());

        if (sl > dsDuAn.length) {
            System.out.println("Lỗi, số dự án muốn xóa không hợp lý");
            return;
        }

        // Display the list of project IDs for the user to choose from
        QuanLyDuAn qlda = QuanLyDuAn.getInstance();
        qlda.printDanhSachIdDuAn();

        int j = 0;
        while (j < sl) {
            System.out.println("Nhập id dự án muốn bỏ:");
            String id = sc.nextLine();
            boolean projectExists = false;
            for (DuAn da : this.dsDuAn) {
                if (da.getIdDuAn().equals(id)) { // Use .equals for string comparison
                    projectExists = true;
                    break;
                }
            }

            if (!projectExists) {
                System.out.println("Id dự án không tồn tại trong phòng ban. Vui lòng kiểm tra lại.");
                continue;  // Ask for the id again without incrementing j
            }

            // Remove the project with the specified ID
            this.dsDuAn = Arrays.stream(this.dsDuAn)
                    .filter(da -> !da.getIdDuAn().equals(id)) // Filter out the project to be deleted
                    .toArray(DuAn[]::new);

            j++; // Increment the counter only after a successful deletion
            System.out.println("Dự án " + id + " đã được xóa khỏi phòng ban.");
        }
    }
}