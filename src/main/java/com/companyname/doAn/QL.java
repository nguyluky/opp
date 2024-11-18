// package com.companyname.doAn;

// import java.util.Arrays;
// import java.util.Scanner;

// import com.companyname.doAn.type.GiamDoc;
// import com.companyname.doAn.type.NhanSu;
// import com.companyname.doAn.type.NhanVien;
// import com.companyname.doAn.type.TruongPhong;

// public class QL {
//     NhanSu[] arr_nv;
//     Scanner sc = new Scanner(System.in);

//     public QL() {
//         arr_nv = new NhanSu[0];
//     }

//     public void menu_chinh() {
//         System.out.println("---------------------menu---------------------");
//         System.out.println("1. Quan Ly Nhan Vien");
//         System.out.println("2. Quan Ly Du An");
//         System.out.println("3. Quan Ly Phong Ban");
//         System.out.println("4. Thoat");
//         System.out.println("---------------------------------------------");
//     }

//     public void menu_ns() {
//         System.out.println("1.Them nhan su");
//         System.out.println("2.Sua");
//         System.out.println("3.Xoa");
//         System.out.println("4.In tep txt");
//         System.out.println("5.Xuat");
//     }

//     public void menu_con_ns() {
//         System.out.println("1. Nhan vien");
//         System.out.println("2. Truong phong");
//         System.out.println("3. Giam doc");
//     }

//     public void them_1_nhan_su(NhanSu ns) {
//         arr_nv = Arrays.copyOf(arr_nv, arr_nv.length + 1);
//         arr_nv[arr_nv.length - 1] = ns;
//     }

//     public void menu_con_xuat() {
//         System.out.println("1. Nhan vien");
//         System.out.println("2. Truong phong");
//         System.out.println("3. Giam doc");
//         System.out.println("4. Tat ca");
//     }

//     public void menu() {
//         int choice;
//         boolean flag = true;
//         NhanSu ns;
//         while (flag) {
//             menu_chinh();
//             System.out.print("[Nhap 1->4] : ");
//             choice = Integer.parseInt(sc.nextLine());
//             switch (choice) {
//                 case 1: {
//                     menu_ns();
//                     int k = Integer.parseInt(sc.nextLine());
//                     switch (k) {
//                         case 1: {
//                             int i = Integer.parseInt(sc.nextLine());
//                             menu_con_ns();
//                             switch (i) {
//                                 case 1: {
//                                     ns = new NhanVien();
//                                     ns.nhap(sc);
//                                     break;

//                                 }
//                                 case 2: {
//                                     ns = new TruongPhong();
//                                     ns.nhap(sc);
//                                 }
//                                 case 3: {
//                                     ns = new GiamDoc();
//                                     ns.nhap(sc);
//                                 }
//                             }
//                         }
//                         case 2: {
//                             // sua
//                             break;
//                         }
//                         case 3: {
//                             // xoa
//                             break;

//                         }
//                         case 4: {
//                             // in txt
//                             break;

//                         }
//                         case 5: {
//                             menu_con_ns();
//                             int p = Integer.parseInt(sc.nextLine());
//                             switch (p) {
//                                 case 1 -> {
//                                     for (NhanSu nv : arr_nv) {
//                                         if (nv instanceof NhanVien) {
//                                             System.out.println(nv);
//                                         }
//                                     }
//                                 }
//                                 case 2 -> {
//                                     for (NhanSu tp : arr_nv) {
//                                         if (tp instanceof TruongPhong) {
//                                             System.out.println(tp);
//                                         }
//                                     }
//                                 }
//                                 case 3 -> {
//                                     for (NhanSu gd : arr_nv) {
//                                         if (gd instanceof GiamDoc) {
//                                             System.out.println(gd);
//                                         }
//                                     }
//                                 }
//                                 case 4 -> {
//                                     for (NhanSu tc : arr_nv) {
//                                         System.out.println(tc);
//                                     }
//                                 }
//                                 default -> System.out.println("Lua chon khong hop le");
//                             }
//                             break;
//                         }
//                         default:
//                             System.out.println("Lua chon khong hop le");
//                     }
//                 }
//                 case 2 :{ System.out.println("Dang lam chuc nang Quan Ly Du An"); break;}
//                 case 3 : {System.out.println("Dang lam chuc nang Quan Ly Phong Ban"); break;}
//                 case 4 : {
//                     System.out.println("Bye Bye !!");
//                     flag = false;
//                     break;
//                 }
//                 default: { System.out.println("Lua chon khong hop le");}
//             }
//         }
//     }
// }
