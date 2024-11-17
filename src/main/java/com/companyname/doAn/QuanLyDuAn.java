package com.companyname.doAn;

import java.util.Arrays;
import java.util.Scanner;

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

    public DuAn[] getDanhSachDuAn(){
        return this.dsDuAn;
    }



    // ---------------------------------------------


    public void addDuAn(DuAn duAn){
        this.dsDuAn = Arrays.copyOf(this.dsDuAn, this.dsDuAn.length + 1);
        this.dsDuAn[this.dsDuAn.length - 1] = duAn;
    }

    public void removeDuAn(String id){
        for(int i=0; i<this.dsDuAn.length; i++){
            if(this.dsDuAn[i].getIdDuAn().equals(id)){
                this.dsDuAn[i] = this.dsDuAn[this.dsDuAn.length - 1];
                break;
            }
        }

        this.dsDuAn[this.dsDuAn.length - 1].setIsDelete(true);
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

    // ---------------------------------------------

    public void printDanhSachIdDuAn(){
        for(int i=0; i<this.dsDuAn.length; i++){
            System.out.println("Id của dự án thứ " + (i+1) + ":" + this.dsDuAn[i].getNameDuAn());
        }
    }

    public void addDuAn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng dự án muốn thêm");
        int sl = Integer.parseInt(sc.nextLine());
        for(int i=0; i<sl; i++){
            this.dsDuAn = Arrays.copyOf(this.dsDuAn, this.dsDuAn.length + 1);
            this.dsDuAn[this.dsDuAn.length - 1] = new DuAn();
            this.dsDuAn[this.dsDuAn.length - 1].nhap();
        }
    }

    public void deleteDuAn(String idDuAn){
        printDanhSachIdDuAn();
        for(DuAn da : this.dsDuAn){
            if(da.getIdDuAn() == idDuAn){
                da.setIsDelete(true);
            }
        }
    }
}
