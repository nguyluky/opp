package com.companyname.doAn.ql;

import java.util.Arrays;
import com.companyname.doAn.type.DuAn;

public class QuanLyDuAn {
    private DuAn dsDuAn[];
    private static QuanLyDuAn instance;

    public static QuanLyDuAn getInstance() {
        return instance;
    }

    public QuanLyDuAn(){
        this.dsDuAn = new DuAn[0];
    };

    //--------------GET-----------------------------

    public DuAn[] getDsDuAn(){
        return this.dsDuAn;
    }
    // ---------------------------------------------
    //---------------SET--------------------------
    
    public void setDsDuAn(DuAn dsDuAn[]){
        this.dsDuAn = dsDuAn;
    }

    //----------------------------------------------


    public void addDuAn(DuAn duAn){
        this.dsDuAn = Arrays.copyOf(this.dsDuAn, this.dsDuAn.length + 1);
        this.dsDuAn[this.dsDuAn.length - 1] = duAn;
    }

    public void removeDuAn(String id){
        for(int i=0; i<this.dsDuAn.length; i++){
            if(this.dsDuAn[i].getIdDuAn().equals(id)){
                this.dsDuAn[i].setIsDelete(true);
                break;
            }
        }
    }

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
        for(int i=0; i<this.dsDuAn.length; i++){
            System.out.println("Dự án thứ nhất " + (i+1) + ":" + this.dsDuAn[i].getNameDuAn());
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
    // // ---------------------------------------------

}
