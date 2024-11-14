package com.companyname.doAn;

import java.util.Arrays;

public class QuanLyNhanVien {
    private int soLuongNhanVien;
    private NhanVien dsNhanVien[];
    private static QuanLyNhanVien instance;

    public static QuanLyNhanVien getInstance() {
        return instance;
    }

    public QuanLyNhanVien(){}
    
    public QuanLyNhanVien(int soLuongNhanVien){
        instance=this;
        this.soLuongNhanVien = soLuongNhanVien;
        for(int i=0; i<this.soLuongNhanVien; i++){
            this.dsNhanVien[i] = new NhanVien();
            this.dsNhanVien[i].nhap();
        }
    };

    //----------------GET-------------------

    public NhanVien[] getDanhSachNhanVien(){
        return this.dsNhanVien;
    }

    public int getSoLuongNhanVien(){
        return this.soLuongNhanVien;
    }

    //-------------------------------------------
    
    public void printDanhSachIdNhanVien(){
        for(int i=0; i<dsNhanVien.length; i++){
            System.out.println("Id nhân viên" + i + 1 + ":");
            String idNhanVien = dsNhanVien[i].getId();
            System.out.println(idNhanVien);
        }
    }

    public void addNhanVien(String nameNhanvien){
        this.dsNhanVien = Arrays.copyOf(this.dsNhanVien, this.dsNhanVien.length + 1);
        this.dsNhanVien[this.dsNhanVien.length - 1] = new NhanVien();
        this.dsNhanVien[this.dsNhanVien.length - 1].nhap();
    }

    public NhanVien getNhanVienById(String id){
        for(NhanVien nv : this.dsNhanVien){
            if(nv.getId() == id){
                return nv;
            }
        }
        return null;
    }
    
}
