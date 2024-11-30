package com.companyname.doAn.ql;

import java.util.Arrays;
import com.companyname.doAn.type.DuAn;

public class QuanLyDuAn {
    private DuAn[] dsDuAn;
    private static QuanLyDuAn instance = null;

    public static QuanLyDuAn getInstance() {
        if (instance == null) {
            instance = new QuanLyDuAn();
        }
        return instance;
    }

    public QuanLyDuAn(){
        this.dsDuAn = new DuAn[0];
    }

    //--------------GET-----------------------------

    public DuAn[] getDsDuAn(){
        return this.dsDuAn;
    }

    //---------------SET--------------------------
    
    public void setDsDuAn(DuAn[] dsDuAn){
        this.dsDuAn = dsDuAn;
    }

    public void addDuAn(DuAn duAn){
        this.dsDuAn = Arrays.copyOf(this.dsDuAn, this.dsDuAn.length + 1);
        this.dsDuAn[this.dsDuAn.length - 1] = duAn;
    }

//    public void removeDuAn(String id){
//        for(int i=0; i<this.dsDuAn.length; i++){
//            if(this.dsDuAn[i].getIdDuAn().equals(id)){
//                this.dsDuAn[i].setIsDelete(true);
//                break;
//            }
//        }
//    }

    public int getSoLuongDuAn(){
        int count = 0;
        for(DuAn da : this.dsDuAn){
            if(!da.getIsDelete()){
                count++;
            }
        }
        return count;
    }

    public void printDsDuAn(){
        System.out.println("---------------------------------------");
        boolean check = false;
        for(DuAn da : this.dsDuAn) {
            if(!da.getIsDelete()){
                check = true;
            }
        }
        if(!check){
            System.out.println("Danh sách dự án đang hoạt đông: Không có");
        }
        else {
            System.out.println("Danh sách dự án đang hoạt đông:");
            int i = 0;
            for (DuAn da : this.dsDuAn) {
                if (!da.getIsDelete()) {
                    System.out.println("Dự án thứ " + (i + 1) + ": " + da.getNameDuAn() + ". ID: " + da.getIdDuAn());
                }
            }
        }
    }

    public DuAn getDuAnById(String id){
        for(int i=0; i<this.dsDuAn.length; i++){
            if(this.dsDuAn[i].getIdDuAn().equals(id)){
                return this.dsDuAn[i];
            }
        }
        return null;
    }

}
