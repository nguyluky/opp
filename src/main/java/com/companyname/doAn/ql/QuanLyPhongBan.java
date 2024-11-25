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

    //---------GET------------------------------------
    public PhongBan[] getDsPhongBan(){
        return this.dsPhongBan;
    }
    //------------------------------------------------
    //------------SET---------------------------------
    public void setDsPhongBan(PhongBan dsPhongBan[]){
        this.dsPhongBan = dsPhongBan;
    }
    //------------------------------------------------

    public void printDsPhongBan(){
        for(int i=0; i<this.dsPhongBan.length; i++){
            System.out.println("Phòng ban " + this.dsPhongBan[i].getNamePhongBan());
        }
    }

    public void addPhongBan(PhongBan phongBan){
        this.dsPhongBan = Arrays.copyOf(this.dsPhongBan, this.dsPhongBan.length + 1);
        this.dsPhongBan[this.dsPhongBan.length - 1] = phongBan;
    }

    public void deletePhongBan(String id){
        for(int i=0; i<this.dsPhongBan.length; i++){
            if(this.dsPhongBan[i].getIdPhongBan().equals(id)){
                this.dsPhongBan[i].setIsDelete(true);
                break;
            }
        }
    }

    public int getSoLuongPhongBan(){
        int count = 0;
        for(PhongBan pb : this.dsPhongBan){
            if(!pb.getIsDelete()){
                count++;
            }
        }
        return count;
    }

    public PhongBan getPhongBanByID(String id){
        for(PhongBan pb : this.getDsPhongBan()){
            if(pb.getIdPhongBan().equals(id)){
                return pb;
            }
        }
        return null;
    }

    public PhongBan getPhongBanByName(String name){
        for(PhongBan pb : this.getDsPhongBan()){
            if(pb.getNamePhongBan().equals(name)){
                return pb;
            }
        }
        return null;
    }
}

