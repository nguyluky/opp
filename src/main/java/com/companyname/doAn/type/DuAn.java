package com.companyname.doAn.type;

import java.util.Arrays;

import com.companyname.doAn.Gui.ShowOption;

public class DuAn {
    private String nameDuAn;
    private String idDuAn;
    private NhanSu[] dsNhanSu;
    private boolean isDelete;

    public DuAn(){}

    public DuAn(String nameDuAn, String idDuAn){
        this(nameDuAn, idDuAn, false);
    }

    // HÀM DÙNG ĐỂ ĐỌC FILE
    public DuAn(String nameDuAn, String idDuAn, boolean isDelete) {
        this.nameDuAn = nameDuAn;
        this.idDuAn = idDuAn;
        this.dsNhanSu = new NhanSu[0];
        this.isDelete = isDelete;
    }
    
    //--------------GET-------------------------------------
    public String getNameDuAn(){
        return this.nameDuAn;
    }

    public String getIdDuAn(){
        return this.idDuAn;
    }

    public NhanSu[] getDsNhanSu(){
        return this.dsNhanSu;
    }

    public boolean getIsDelete(){
        return this.isDelete;
    }

    //----------------------SET-----------------------------
    public void setNameDuAn(String nameDuAn){
        this.nameDuAn = nameDuAn;
    }

    public void setIdDuAn(String idDuAn){
        this.idDuAn = idDuAn;
    }

    public void setDsNhanSu(NhanSu[] array){
        this.dsNhanSu = array;
    }

    public void setIsDelete(boolean tmp){
        this.isDelete = tmp;
    }

    // ========================================================
    
    public void addNhanSu(NhanSu ns){
        this.dsNhanSu = Arrays.copyOf(this.dsNhanSu, this.dsNhanSu.length + 1);
        this.dsNhanSu[this.dsNhanSu.length - 1] = ns;
    }

    public void removeNhanSu(String id){
        NhanSu[] newNv = new NhanSu[this.dsNhanSu.length - 1];
        int k=0;
        for(NhanSu nv : this.dsNhanSu){
            if(!nv.getId().equals(id)){
                newNv[k] = nv;
                k++;
            }
        }
        this.dsNhanSu = newNv;
    }

     public void printDsNhanSu(){
        // System.out.println("---------------------------------------");
        ShowOption.clearScreen();

        System.out.println("Danh sách nhân sự của dự án: " + this.dsNhanSu.length);
        int i=1;
        for(NhanSu ns : this.dsNhanSu) {
            if (!ns.getIsDelete()) {
                System.out.println("Nhân sự thứ " + i + ": " + ns.getName() + ". ID: " + ns.getId());
            }
        }
    }

    public NhanSu getNhanSuByID(String id){
        for(NhanSu nv : this.getDsNhanSu()){
            if(nv.getId().equals(id)){
                return nv;
            }
        }
        return null;
    }
    
    public void printThongTinCoBan(){
        // System.out.println("---------------------------------------");
        ShowOption.clearScreen();

        System.out.println("Tên: " + this.nameDuAn);
        System.out.println("ID: " + this.idDuAn);
        if(this.dsNhanSu.length == 0) {
            System.out.println("Danh sách nhân sự đang tham gia: Không có nhân sự nào");
        }
        else{
            System.out.println("Danh sách nhân sự đang tham gia: ");
            int i=1;
            for(NhanSu ns : this.dsNhanSu){
                if(!ns.getIsDelete()){
                    if(ns instanceof NhanVien) {
                        System.out.println("Nhân sự thứ " + i + ": " + ns.getName() + ". ID: " + ns.getId() + ". Loại: Nhân viên");
                    }
                    else{
                        System.out.println("Nhân sự thứ " + i + ": " + ns.getName() + ". ID: " + ns.getId() + ". Loại: Trưởng phòng");
                    }
                    i++;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Dự án{" +
                "nameDuAn='" + nameDuAn + '\'' +
                ", idDuAn='" + idDuAn + '\'' +
                ", dsNhanSu=" + Arrays.toString(dsNhanSu) +
                ", isDelete=" + isDelete +
                '}';
    }
}
