
package com.companyname.doAn;

public class Main {
    public static void main(String[] args) {
        NhanSu nv = new NhanVien();
        nv.nhap();
        nv.xuat();
        System.out.println(nv.bonusChucvu() + "  " + nv.bonusChucvu()+ "  " );
    }
}