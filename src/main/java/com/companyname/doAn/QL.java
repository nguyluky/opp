package com.companyname.doAn;


import java.util.Scanner;

public class QL {
    Scanner sc = new Scanner(System.in);

    public void menu_chinh(){
        System.out.println("---------------------meunu---------------------");
        System.out.println("1. Quan Ly Nhan Su");
        System.out.println("2. Quan Ly Du An");
        System.out.println("3. Quan Ly Phong Ban");
        System.out.println("4. Thoat");
        System.out.println("-----------------------------------------------");
    }
    public void menu_ns(){
        System.out.println("1.Them nhan su");
        System.out.println("2.Sua");
        System.out.println("3.Xoa");
        System.out.println("4.In tep txt");
        System.out.println("5.Xuat");
    }
    public void menu_con_ns(){
        System.out.println("1. Nhan vien");
        System.out.println("2. Truong phong");
        System.out.println("3. Giam doc");
    }


    public void menu(){
       int choice;
       boolean flag = true;
       nhanSu ns;
       while(flag){
           menu_chinh();
           System.out.print("[Nhap 1->4] : ");
           choice = Integer.parseInt(sc.nextLine());
           switch (choice) {
               case 1 :{
                   menu_ns();
                   int k = Integer.parseInt(sc.nextLine());
                   switch (k) {
                       case 1 : {
                           int i = Integer.parseInt(sc.nextLine());
                            menu_con_ns();
                                switch (i) {
                                    case 1 :{
                                        ns = new nhanVien();
                                        ns.nhap();
                                    }
                                    case 2 :{
                                        ns = new truongPhong();
                                        ns.nhap();
                                    }
                                    case 3 :{
                                        ns = new giamDoc();
                                        ns.nhap();
                                    }
                                }
                       }
                       case 2: {
                           //sua
                       }
                       case 3: {
                           //xoa
                       }
                       case 4: {
                           //in txt
                       }
                       case 5: {
                            int p = Integer.parseInt(sc.nextLine());
                            switch (p) {
                                case 1: {
                                    ns = new nhanVien();
                                    ns.nhap();
                                }
                                case 2: {
                                    ns = new truongPhong();
                                    ns.xuat();
                                }
                                case 3: {
                                    ns = new giamDoc();
                                    ns.xuat();
                                }
                            }

                       }

                   }

               }
               case 2 : System.out.println("dag lam =)))");
               case 3 : System.out.println("dag lam luon =))");
               case 4 : {
                   System.out.println("Bye Bye !!");
                   flag = false;
               }
           }
       }



    }
}
