package com.companyname.doAn.ql;

import com.companyname.doAn.type.DuAn;
import com.companyname.doAn.type.TruongPhong;

public class QuanLyTruongPhong {
    private TruongPhong dsTruongPhong[];
    private static QuanLyTruongPhong instance;

    public static QuanLyTruongPhong getInstance() {
        return instance;
    }

    public QuanLyTruongPhong() {}

    public QuanLyTruongPhong(TruongPhong[] dsTruongPhong){
        this.dsTruongPhong = dsTruongPhong;
    }

    public void printDsTruongPhong(){
        int i = 1;
        System.out.println("Danh sách các trưởng phòng trong công ty:");
        for(TruongPhong tp : this.dsTruongPhong){
            System.out.println("Trưởng phòng thứ " + i + ": " + tp.getName() + ". ID: " + tp.getId());
        }
        System.out.println("-------------------------------------------");
    }

    public TruongPhong getTruongPhongById(String id){
        for(TruongPhong tp : this.dsTruongPhong){
            if(tp.getId().equals(id)){
                return tp;
            }
        }
        return null;
    }


}
