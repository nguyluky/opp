package com.companyname.doAn.ql;

import java.util.Arrays;

import com.companyname.doAn.type.NhanVien;

public class QuanLyNhanVien {
    // private int soLuongNhanVien;
    private NhanVien dsNhanVien[];
    private static QuanLyNhanVien instance = new QuanLyNhanVien();

    public static QuanLyNhanVien getInstance() {
        return instance;
    }

    public QuanLyNhanVien(){
        this.dsNhanVien = new NhanVien[0];
    }
    
    // public QuanLyNhanVien(int soLuongNhanVien){
    //     instance=this;
    //     this.soLuongNhanVien = soLuongNhanVien;
    //     for(int i=0; i<this.soLuongNhanVien; i++){
    //         this.dsNhanVien[i] = new NhanVien();
    //         // TODO: nhớ là bỏ comment dòng này ra
    //         // this.dsNhanVien[i].nhap();
    //     }
    // };

    //----------------GET-------------------

    public NhanVien[] getDsNhanVien(){
        return this.dsNhanVien;
    }


    //-------------------------------------

    
    public void addNhanVien(NhanVien nhanVien){
        this.dsNhanVien = Arrays.copyOf(this.dsNhanVien, this.dsNhanVien.length + 1);
        this.dsNhanVien[this.dsNhanVien.length - 1] = nhanVien;
    }

    public void removeNhanVien(String id){
        for(int i=0; i<this.dsNhanVien.length; i++){
            if(this.dsNhanVien[i].getId().equals(id)){
                this.dsNhanVien[i] = this.dsNhanVien[this.dsNhanVien.length - 1];
                break;
            }
        }

        this.dsNhanVien[this.dsNhanVien.length - 1].setDelete(true);
    }

    public int getSoLuongNhanVien(){
        int count = 0;
        for(NhanVien nv : this.dsNhanVien){
            if(!nv.isDelete()){
                count++;
            }
        }

        return count;
    }

    public NhanVien getNhanVienById(String id){
        for(NhanVien nv : this.dsNhanVien){
            if(nv.getId().equals(id)){
                return nv;
            }
        }
        return null;
    }
    //-------------------------------------------
    
    // public void printDanhSachIdNhanVien(){
    //     for(int i=0; i<dsNhanVien.length; i++){
    //         System.out.println("Id nhân viên" + i + 1 + ":");
    //         String idNhanVien = dsNhanVien[i].getId();
    //         System.out.println(idNhanVien);
    //     }
    // }

    // public void addNhanVien(String nameNhanvien){
    //     this.dsNhanVien = Arrays.copyOf(this.dsNhanVien, this.dsNhanVien.length + 1);
    //     this.dsNhanVien[this.dsNhanVien.length - 1] = new NhanVien();
    //     // TODO: nhớ là bỏ comment dòng này ra
    //     // this.dsNhanVien[this.dsNhanVien.length - 1].nhap();
    // }

    // public NhanVien getNhanVienById(String id){
    //     for(NhanVien nv : this.dsNhanVien){
    //         if(nv.getId() == id){
    //             return nv;
    //         }
    //     }
    //     return null;
    // }
    
}
