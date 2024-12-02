package com.companyname.doAn.ql;

import java.util.Arrays;

import com.companyname.doAn.Gui.Screen.Screen;
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

    public DuAn[] getDsDuAn(){
        return this.dsDuAn;
    }
    public void setDsDuAn(DuAn[] dsDuAn){
        this.dsDuAn = dsDuAn;
    }

//    public void removeDuAn(String id){
//        for(int i=0; i<this.dsDuAn.length; i++){
//            if(this.dsDuAn[i].getIdDuAn().equals(id)){
//                this.dsDuAn[i].setIsDelete(true);
//                break;
//            }
//        }
//    }

//    public int getSoLuongDuAn(){
//        int count = 0;
//        for(DuAn da : this.dsDuAn){
//            if(!da.getIsDelete()){
//                count++;
//            }
//        }
//        return count;
//    }

    public void addDuAn(DuAn duAn){
        this.dsDuAn = Arrays.copyOf(this.dsDuAn, this.dsDuAn.length + 1);
        this.dsDuAn[this.dsDuAn.length - 1] = duAn;
    }

    public DuAn getDuAnById(String id){
        for(int i=0; i<this.dsDuAn.length; i++){
            if(this.dsDuAn[i].getIdDuAn().equals(id)){
                return this.dsDuAn[i];
            }
        }
        return null;
    }

    public DuAn getDuAnByName(String name){
        for(DuAn da : this.dsDuAn){
            if(da.getNameDuAn().equals(name)){
                return da;
            }
        }
        return null;
    }

    public void printDsDuAn(){
        System.out.println("---------------------------------------");
//        ShowOption.clearScreen();

        System.out.println("Danh sách dự án đã dừng hoạt động:");
        int j=1;
        for(DuAn duAn : this.dsDuAn){
            if(duAn.getIsDelete()){
                System.out.println("Dự án thứ " + j + ": " + duAn.getNameDuAn() + ". ID: " + duAn.getIdDuAn());
                j++;
            }
        }
        if(j==1){
            System.out.println("Không có dự án nào");
        }
        System.out.println("Danh sách dự án đang hoạt động:");
        int k=1;
        for(DuAn duAn : this.dsDuAn){
            if(!duAn.getIsDelete()){
                System.out.println("Dự án thứ " + k + ": " + duAn.getNameDuAn() + ". ID: " + duAn.getIdDuAn());
                k++;
            }
        }
        if(k==1){
            System.out.println("Không có dự án nào");
        }
    }

    @Override
    public String toString() {
        
        return "QuanLyDuAn{" +
                "dsDuAn=" + Arrays.toString(dsDuAn) +
                '}';
    }

}
