package com.companyname.doAn.type;

import java.util.Arrays;


public class PhongBan {
    private String namePhongBan;
    private String idPhongBan;
    private NhanVien dsNhanVien[];
    private DuAn dsDuAn[];
    private boolean isDelete;

    public PhongBan(String name, String idPhongBan){
        this.namePhongBan = name;
        this.idPhongBan = idPhongBan;
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

    public NhanSu[] getNhanSu(){
        return this.dsNhanVien;
    }

    public void addDuAn(DuAn da){
        this.dsDuAn = Arrays.copyOf(this.dsDuAn, this.dsDuAn.length + 1);
        this.dsDuAn[this.dsDuAn.length - 1] = da;
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

    public DuAn[] getDuAn(){
        return this.dsDuAn;
    }
}
