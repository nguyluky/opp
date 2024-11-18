package com.companyname.doAn.ql;
import java.util.Arrays;

import com.companyname.doAn.type.PhongBan;

public class QuanLyPhongBan {
    private PhongBan dsPhongBan[];

    private static QuanLyPhongBan instance = null;

    public static QuanLyPhongBan getInstance(){
        if(instance == null){
            instance = new QuanLyPhongBan();
        }
        return instance;
    }

    public QuanLyPhongBan(){
        instance = this;
        this.dsPhongBan = new PhongBan[0];
    }

    public void addPhongBan(PhongBan phongBan){
        this.dsPhongBan = Arrays.copyOf(this.dsPhongBan, this.dsPhongBan.length + 1);
        this.dsPhongBan[this.dsPhongBan.length - 1] = phongBan;
    }

    public PhongBan[] getDanhSachPhongBan(){
        return this.dsPhongBan;
    }

    public void deletePhongBan(String id){
        for(int i=0; i<this.dsPhongBan.length; i++){
            if(this.dsPhongBan[i].getIdPhongBan().equals(id)){
                this.dsPhongBan[i] = this.dsPhongBan[this.dsPhongBan.length - 1];
                break;
            }
        }

        this.dsPhongBan[this.dsPhongBan.length - 1].setDelete(true);
    }

    public int getSoLuongPhongBan(){
        int count = 0;
        for(PhongBan pb : this.dsPhongBan){
            if(!pb.isDelete()){
                count++;
            }
        }

        return count;
    }
}

