package com.companyname.doAn;

import java.util.Arrays;

public class QuanLyNhanSu {
    private NhanSu dsNhanSu[];
    private static QuanLyNhanSu instance = null;

    public static QuanLyNhanSu getInstance(){
        if(instance == null){
            instance = new QuanLyNhanSu();
        }
        return instance;
    }

    public QuanLyNhanSu(){
        instance = this;
        this.dsNhanSu = new NhanSu[0];
    }

    public void addNhanSu(NhanSu nhanSu){
        this.dsNhanSu = Arrays.copyOf(this.dsNhanSu, this.dsNhanSu.length + 1);
        this.dsNhanSu[this.dsNhanSu.length - 1] = nhanSu;
    }

    public NhanSu[] getDanhSachNhanSu(){
        return this.dsNhanSu;
    }

    public void deleteNhanSu(String id){
        for(int i=0; i<this.dsNhanSu.length; i++){
            if(this.dsNhanSu[i].getId().equals(id)){
                this.dsNhanSu[i] = this.dsNhanSu[this.dsNhanSu.length - 1];
                break;
            }
        }

        this.dsNhanSu[this.dsNhanSu.length - 1].setDelete(true);
    }

    public int getSoLuongNhanSu(){
        int count = 0;
        for(NhanSu ns : this.dsNhanSu){
            if(!ns.isDelete()){
                count++;
            }
        }

        return count;
    }

    public NhanSu getNhanSuById(String id){
        for(NhanSu ns : this.dsNhanSu){
            if(ns.getId().equals(id)){
                return ns;
            }
        }

        return null;
    }
}
