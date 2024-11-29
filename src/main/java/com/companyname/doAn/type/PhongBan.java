package com.companyname.doAn.type;

import com.companyname.doAn.ql.QuanLyNhanSu;

import java.util.Arrays;


public class PhongBan {
    private String namePhongBan;
    private String idPhongBan;
    private NhanVien dsNhanVien[];
    private DuAn dsDuAn[];
    private boolean isDelete;

    public PhongBan(String name, String id, NhanVien dsNhanVien[], DuAn dsDuAn[]){
        this.namePhongBan = name;
        this.idPhongBan = id;
        this.dsNhanVien = dsNhanVien;
        this.dsDuAn = dsDuAn;
        this.isDelete = false;
    }

    public PhongBan(String name, String id){
        this.namePhongBan = name;
        this.idPhongBan = id;
        this.dsNhanVien = new NhanVien[0];
        this.dsDuAn = new DuAn[0];
        this.isDelete = false;
    }

    //----------GET--------------
    public String getNamePhongBan(){
        return this.namePhongBan;
    }

    public String getIdPhongBan(){
        return this.idPhongBan;
    }

    public NhanVien[] getDsNhanVien(){
        return this.dsNhanVien;
    }

    public DuAn[] getDsDuAn(){
        return this.dsDuAn;
    }

    public boolean getIsDelete(){
       return this.isDelete;
    }
    //--------------------------

    //----------------SET------------
    public void setNamePhongBan(String name){
        this.namePhongBan = name;
    }

    public void setIdPhongBan(String id){
        this.idPhongBan = id;
    }

    public void setDsNhanVien(NhanVien dsnv[]){
        this.dsNhanVien = dsnv;
    }

    public void setDsDuAn(DuAn dsda[]){
        this.dsDuAn = dsda;
    }

    public void setIsDelete(boolean status){
        this.isDelete = status;
    }
    //--------------------------

    public void printThongTinPhongBan(){
        System.out.println("Tên: " + this.namePhongBan);
        System.out.println("ID: " + this.idPhongBan);
        System.out.println("Số lượng nhân viên: " + this.dsNhanVien.length);
        System.out.println("Số lượng dự án: " + this.dsDuAn.length);
    }

    public void printDsNhanVienPhongBan(){
        int i=0;
        for(NhanVien nv : this.dsNhanVien){
            if(!nv.getIsDelete()){
                System.out.println("Nhân viên thứ " + i+1 + " :");
                System.out.println(nv.getName() + ". ID: " + nv.getId());
                i++;
            }
        }
        if(i==0) System.out.println("Khong co nhan vien");
    }

    public void addNhanVien(NhanVien nv){
        this.dsNhanVien = Arrays.copyOf(this.dsNhanVien, this.dsNhanVien.length + 1);
        this.dsNhanVien[this.dsNhanVien.length - 1] = nv;
    }

    public void removeNhanVien(String id){
        for(int i=0; i<this.dsNhanVien.length; i++){
            if(this.dsNhanVien[i].getId().equals(id)){
                this.dsNhanVien[i] = this.dsNhanVien[this.dsNhanVien.length - 1];
                break;
            }
        }
        this.dsNhanVien = Arrays.copyOf(this.dsNhanVien, this.dsNhanVien.length - 1);
    }

    public void printDsDuAn(){
        for(int i=0; i<this.dsDuAn.length; i++){
            System.out.println("Dự án thứ " + i + " :");
            System.out.println(this.dsDuAn[i].getNameDuAn() + ";" + this.dsDuAn[i].getIdDuAn());
        }
    }

    public void addDuAn(DuAn da){
        this.dsDuAn = Arrays.copyOf(this.dsDuAn, this.dsDuAn.length + 1);
        this.dsDuAn[this.dsDuAn.length - 1] = da;
    }

    public void removeDuAn(String id){
        for(int i=0; i<this.dsDuAn.length; i++){
            if(this.dsDuAn[i].getIdDuAn().equals(id)){
                this.dsDuAn[i].setIsDelete(true);
                break;
            }
        }
    }

    public NhanVien getNhanVienById(String id){
        for(NhanVien nv : this.getDsNhanVien()){
            if(nv.getId().equals(id)){
                return nv;
            }
        }
        return null;
    }

    public DuAn getDuAnById(String id){
        for(DuAn da : this.getDsDuAn()){
            if(da.getIdDuAn().equals(id)){
                return da;
            }
        }
        return null;
    }

    public void printDsNhanSu(){
        TruongPhong tmpTruongPhong = null;
        QuanLyNhanSu qlns = new QuanLyNhanSu();
        for(NhanSu ns : qlns.getDsNhanSu()){
            if(ns instanceof TruongPhong){
                if(((TruongPhong) ns).getPhongBan().getIdPhongBan().equals(this.idPhongBan)){
                    tmpTruongPhong = (TruongPhong) ns;
                }
            }
        }
        if(tmpTruongPhong != null && !tmpTruongPhong.getIsDelete()){
            System.out.println("Truong phong: " + tmpTruongPhong.getName() + ". ID: " + tmpTruongPhong.getId());
        }
        else  System.out.println("Truong phong: chua co");
        int i=0;
        for(NhanVien nv : this.getDsNhanVien()){
            if(!nv.getIsDelete()){
                System.out.println("Nhân viên thứ " + i+1 + " :");
                System.out.println(nv.getName() + ". ID: " + nv.getId());
                i++;
            }
        }
        if(i==0) System.out.println("Khong co nhan vien");
        System.out.println("---------------------------------------------");
    }
}
