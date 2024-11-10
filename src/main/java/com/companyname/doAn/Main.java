
package com.companyname.doAn;

public class Main {
    public static void main(String[] args) {
        nhanSu nv = new nhanVien();
        nv.nhap();
        nv.xuat();
        System.out.println(nv.bonusChucvu() + "  " + nv.bonusChucvu()+ "  " );
    }
}