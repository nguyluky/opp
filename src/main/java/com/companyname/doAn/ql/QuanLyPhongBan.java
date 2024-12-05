package com.companyname.doAn.ql;

import com.companyname.doAn.type.NhanVien;
import com.companyname.doAn.type.PhongBan;

import java.util.Arrays;

public class QuanLyPhongBan {
    private PhongBan[] dsPhongBan;

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

    //------------SET---------------------------------
    public void setDsPhongBan(PhongBan[] dsPhongBan){
        this.dsPhongBan = dsPhongBan;
    }

    public void printDsPhongBan(){
        System.out.println("-----------------------------------");
        System.out.println("Danh sách phòng ban đã dừng hoạt động:");
        int i=1;
        for(PhongBan pb : this.dsPhongBan) {
            if(pb.getIsDelete()) {
                System.out.println("Phòng ban thứ " + i + ": " + pb.getNamePhongBan() + ". ID: " + pb.getIdPhongBan());
                i++;
            }
        }
        if(i==1)  System.out.println("Không có");

        System.out.println("Danh sách phòng ban đang hoạt động:");
        int j=1;
        for(PhongBan pb : this.dsPhongBan) {
            if(!pb.getIsDelete()) {
                System.out.println("Phòng ban thứ " + j + ": " + pb.getNamePhongBan() + ". ID: " + pb.getIdPhongBan());
                j++;
            }
        }
        if(j==1)  System.out.println("Không có");
    }

    public void addPhongBan(PhongBan phongBan){
        this.dsPhongBan = Arrays.copyOf(this.dsPhongBan, this.dsPhongBan.length + 1);
        this.dsPhongBan[this.dsPhongBan.length - 1] = phongBan;
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
            if(pb.getNamePhongBan().equals(name.trim())){
                return pb;
            }
        }
        return null;
    }

    public void moveNhanVien(NhanVien nv, PhongBan newPhongBan){
        for(PhongBan pb : this.getDsPhongBan()){
            for(NhanVien nhanVien : pb.getDsNhanVien()){
                if(nhanVien.getId().equals(nv.getId())){
                    pb.removeNhanVien(nv.getId());
                    break;
                }
            }
        }
        for(int i=0; i<this.dsPhongBan.length; i++) {
            if (this.dsPhongBan[i].getIdPhongBan().equals(newPhongBan.getIdPhongBan())) {
                this.dsPhongBan[i].addNhanVien(nv);
                break;
            }
        }
    }
}

