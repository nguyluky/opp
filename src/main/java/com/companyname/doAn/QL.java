package com.companyname.doAn;

import java.util.Arrays;
import java.util.Scanner;

public class QL {
    nhanSu[] arr_nv; // Đổi tên thành nhanSu
    Scanner sc = new Scanner(System.in);

    public QL() {
        arr_nv = new nhanSu[0]; // Đổi tên thành nhanSu
    }

    public void menu_chinh() {
        System.out.println("---------------------menu---------------------");
        System.out.println("1. Quan Ly Nhan Vien");
        System.out.println("2. Quan Ly Du An");
        System.out.println("3. Quan Ly Phong Ban");
        System.out.println("4. Thoat");
        System.out.println("---------------------------------------------");
    }

    public void menu_ns() {
        System.out.println("1. Them nhan su");
        System.out.println("2. Sua");
        System.out.println("3. Xoa");
        System.out.println("4. In tep txt");
        System.out.println("5. Xuat");
    }

    public void menu_con_ns() {
        System.out.println("1. Nhan vien");
        System.out.println("2. Truong phong");
        System.out.println("3. Giam doc");
    }

    public void them_1_nhan_su(nhanSu ns) { // Đổi tên thành nhanSu
        arr_nv = Arrays.copyOf(arr_nv, arr_nv.length + 1);
        arr_nv[arr_nv.length - 1] = ns;
    }

    public void menu_con_xuat() {
        System.out.println("1. Nhan vien");
        System.out.println("2. Truong phong");
        System.out.println("3. Giam doc");
        System.out.println("4. Tat ca");
    }

    public void menu() {
        int choice;
        boolean flag = true;
        nhanSu ns; // Đổi tên thành nhanSu
        while (flag) {
            menu_chinh();
            System.out.print("[Nhap 1->4] : ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    menu_ns();
                    int k = Integer.parseInt(sc.nextLine());
                    switch (k) {
                        case 1 -> {
                            menu_con_ns();
                            int i = Integer.parseInt(sc.nextLine());
                            switch (i) {
                                case 1 -> {
                                    ns = new nhanVien(); // Đổi tên thành nhanVien
                                    ns.nhap(); // Giả định nhap() được cài đặt chính xác trong nhanSu
                                    them_1_nhan_su(ns);
                                }
                                case 2 -> {
                                    ns = new truongPhong(); // Đổi tên thành truongPhong
                                    ns.nhap();
                                    them_1_nhan_su(ns);
                                }
                                case 3 -> {
                                    ns = new giamDoc(); // Đổi tên thành giamDoc
                                    ns.nhap();
                                    them_1_nhan_su(ns);
                                }
                                default -> System.out.println("Lua chon khong hop le");
                            }
                        }
                        case 2 -> {
                            // Sua nhan su
                            System.out.print("Nhap ID hoac ten nhan su can sua: ");
                            String searchKey = sc.nextLine();

                            for (nhanSu ns1 : arr_nv) {
                                if (ns1.getId().equals(searchKey) || ns1.getName().equalsIgnoreCase(searchKey)) {
                                    System.out.println("Thong tin hien tai cua nhan su:");
                                    System.out.println(ns1);

                                    System.out.println("Nhap thong tin moi cho nhan su:");
                                    ns1.nhap(); // Giả định nhap() được cài đặt chính xác trong nhanSu
                                    System.out.println("Da cap nhat thong tin nhan su thanh cong.");
                                    return;
                                }
                            }
                            System.out.println("Khong tim thay nhan su voi ID hoac ten da nhap.");
                        }
                        case 3 -> {
                            // Xoa nhan su
                            // Implementation needed for deletion.
                        }
                        case 4 -> {
                            // In ra file txt
                            // Implementation needed for file output.
                        }
                        case 5 -> {
                            menu_con_xuat();
                            int p = Integer.parseInt(sc.nextLine());
                            switch (p) {
                                case 1 -> {
                                    for (nhanSu nv : arr_nv) {
                                        if (nv instanceof nhanVien) {
                                            System.out.println(nv);
                                        }
                                    }
                                }
                                case 2 -> {
                                    for (nhanSu tp : arr_nv) {
                                        if (tp instanceof truongPhong) {
                                            System.out.println(tp);
                                        }
                                    }
                                }
                                case 3 -> {
                                    for (nhanSu gd : arr_nv) {
                                        if (gd instanceof giamDoc) {
                                            System.out.println(gd);
                                        }
                                    }
                                }
                                case 4 -> {
                                    for (nhanSu tc : arr_nv) {
                                        System.out.println(tc);
                                    }
                                }
                                default -> System.out.println("Lua chon khong hop le");
                            }
                        }
                        default -> System.out.println("Lua chon khong hop le");
                    }
                }
                case 2 -> System.out.println("Dang lam chuc nang Quan Ly Du An");
                case 3 -> System.out.println("Dang lam chuc nang Quan Ly Phong Ban");
                case 4 -> {
                    System.out.println("Bye Bye !!");
                    flag = false;
                }
                default -> System.out.println("Lua chon khong hop le");
            }
        }
    }
}