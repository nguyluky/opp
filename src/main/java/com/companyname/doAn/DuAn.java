package com.companyname.doAn;

import java.util.Arrays;
import java.util.Scanner;

public class DuAn{
    private String nameDuAn;
    private String idDuAn;
    private NhanVien dsNhanVien[];
    private int soLuongNhanVien;
    private boolean isDelete = false;

    public DuAn(){};

    public DuAn(String nameDuAn, String idDuAn, String namePhongBan, int soLuongNhanVien){
        this.nameDuAn = nameDuAn;
        this.idDuAn = idDuAn;
        this.soLuongNhanVien = soLuongNhanVien;
        this.dsNhanVien = new NhanVien[this.soLuongNhanVien];
    }
    
    //--------------GET-------------------------------------
    public String getNameDuAn(){
        return this.nameDuAn;
    }

    public String getIdDuAn(){
        return this.idDuAn;
    }

    public int getSoLuongNhanVien(){
        return this.soLuongNhanVien;
    }

    public void getIsDelete(){
        System.out.println(this.isDelete);
    }

    public NhanVien[] getArrayNhanVienDuAn(){
        return this.dsNhanVien;
    }
    //--------------------------------------------------------

    //----------------------SET-----------------------------

    public void setArrayNhanVienDuAn(NhanVien array[]){
        this.dsNhanVien = array;
    }

    public void setNameDuAn(String nameDuAn){
        this.nameDuAn = nameDuAn;
    }

    public void setIdDuAn(String idDuAn){
        this.idDuAn = idDuAn;
    }

    public void setDsNhanVien (NhanVien array[]){
        this.dsNhanVien = array;
    }

    public void setIsDelete(boolean tmp){
        this.isDelete = tmp;
    }

    public void setSoLuongNhanVien(int sl){
        this.soLuongNhanVien = sl;
    }

    //--------------------------------------------------------------------
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên dự án:");
        String name = sc.nextLine();
        this.nameDuAn = name;
        System.out.println("Nhập id dự án:");
        String id = sc.nextLine();
        this.idDuAn = id;
        System.out.println("Nhập số lượng nhân viên trong dự án:");
        int sl = Integer.parseInt(sc.nextLine());
        this.soLuongNhanVien = sl;
        this.dsNhanVien = new NhanVien[sl];

        QuanLyNhanVien qlnv = QuanLyNhanVien.getInstance();
        qlnv.printDanhSachIdNhanVien(); // in ra danh sách tất cả nhân viên công ty
        for(int i=0; i<sl; i++){
            this.dsNhanVien[i] = new NhanVien();
            addNhanVien(sl);
        }
    }

    public void printDanhSachNhanVienDuAn(){
        if(dsNhanVien.length == 0){
            System.out.println("Không có nhân viên nào!");
            return;
        }
        System.out.println("Danh sách nhân viên của dự án " + this.nameDuAn + ":");
        for(int i=0; i<this.dsNhanVien.length; i++){
            System.out.println("Nhân viên " + (i+1) + ":");
            System.out.println(this.dsNhanVien[i].getName());
        }
    }

    public void addNhanVien(int sl){
        Scanner sc = new Scanner(System.in);
        QuanLyNhanVien qlnv = QuanLyNhanVien.getInstance();
        if(sl>qlnv.getSoLuongNhanVien()){
            System.out.println("Số lượng nhân viên muốn thêm vào dự án không hợp lý");
        }
        else{
            for(int i=0; i<sl; i++){
                this.dsNhanVien = Arrays.copyOf(this.dsNhanVien, this.dsNhanVien.length + 1);
                this.dsNhanVien[this.dsNhanVien.length - 1] = new NhanVien();
                System.out.println("Nhập id nhân viên thứ " + i + " muốn thêm:");
                String id = sc.nextLine();
                NhanVien nv = qlnv.getNhanVienById(id);
                if(nv == null){
                    System.out.println("Id nhân viên không tồn tại! Nhập lại");
                    i--;
                }
                else this.dsNhanVien[this.dsNhanVien.length - 1] = nv;
            }
        }
    }

    public void deleteNhanVien(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng nhân viên muốn đuổi:");
        int sl = Integer.parseInt(sc.nextLine());
        printDanhSachNhanVienDuAn();
        int j=0;
        while(j<sl){
            NhanVien newNv[] = new NhanVien[this.dsNhanVien.length - 1];
            boolean check = true;
            String id="";
            while(check){
                System.out.println("Nhập id nhân viên muốn đuổi:");
                id = sc.nextLine();
                for(NhanVien nv : this.dsNhanVien){
                    if(nv.getId() == id){
                        check = false;
                    }
                }
                if(check) System.out.println("Id nhân viên không tồn tại! Nhập lại:");
            }
            int k=0;
            for(NhanVien nv : this.dsNhanVien){
                if(nv.getId() != id){
                    newNv[k] = nv;
                    k++;
                }
            }
            this.dsNhanVien = newNv;
            j++;
        }
    }
}
