package com.companyname.doAn.type;

import java.util.Arrays;


public class PhongBan {
    private String namePhongBan;
    private String idPhongBan;
    private NhanVien dsNhanVien[];
    private TruongPhong truongPhong;
    private DuAn dsDuAn[];
    private boolean isDelete;

    public PhongBan(String name, String idPhongBan, boolean isDelete){
        this.namePhongBan = name;
        this.idPhongBan = idPhongBan;
        this.dsNhanVien = new NhanVien[0];
        this.dsDuAn = new DuAn[0];
        this.isDelete = isDelete;
        // this.truongPhong = truongPhong;
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

    public boolean isDelete(){
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
    
    //--------------------------

    public void printThongTinPhongBan(){
        System.out.println("Tên: " + this.namePhongBan);
        System.out.println("ID: " + this.idPhongBan);
        System.out.println("Số lượng nhân viên: " + this.dsNhanVien.length);
        System.out.println("Số lượng dự án: " + this.dsDuAn.length);
    }

    public void printDsNhanVienPhongBan(){
        for(int i=0; i<this.dsNhanVien.length; i++){
            System.out.println("Nhân viên thứ " + i + " :");
            System.out.println(this.dsNhanVien[i].getName() + ";" + this.dsNhanVien[i].getId());
        }        
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
        this.dsDuAn[this.dsDuAn.length - 1].setIsDelete(true);
    }

    public NhanVien getNhanVienById(String id){
        for(NhanVien nv : this.getDsNhanVien()){
            if(nv.getId().equals(id)){
                return nv;
            }
        }
        return null;
    }



    public TruongPhong getTruongPhong() {
        return truongPhong;
    }



    public void setTruongPhong(TruongPhong truongPhong) {
        this.truongPhong = truongPhong;
    }

    public void setDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
}
