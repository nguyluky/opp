package com.companyname.doAn.type;

import java.util.Arrays;

public class DuAn {
    private String nameDuAn;
    private String idDuAn;
    private NhanVien dsNhanVien[];
    private boolean isDelete = false;

    public DuAn(){};

    public DuAn(String nameDuAn, String idDuAn, NhanVien dsNhanVien[], boolean isDelete){
        this.nameDuAn = nameDuAn;
        this.idDuAn = idDuAn;
        this.dsNhanVien = dsNhanVien;
        this.isDelete = isDelete;
    }
    
    //--------------GET-------------------------------------
    public String getNameDuAn(){
        return this.nameDuAn;
    }

    public String getIdDuAn(){
        return this.idDuAn;
    }

    public NhanVien[] getDsNhanVienDuAn(){
        return this.dsNhanVien;
    }

    public boolean getIsDelete(){
        return this.isDelete;
    }
    //--------------------------------------------------------

    //----------------------SET-----------------------------
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

    // ========================================================
    public String toString(){
        return this.nameDuAn + ";" + this.idDuAn + ";" + this.dsNhanVien.length;
    }
    
    public void addNhanVien(NhanVien nv){
        this.dsNhanVien = Arrays.copyOf(this.dsNhanVien, this.dsNhanVien.length + 1);
        this.dsNhanVien[this.dsNhanVien.length - 1] = nv;
    }

    public void removeNhanVien(String id){
        NhanVien newNv[] = new NhanVien[this.dsNhanVien.length - 1];
        int k=0;
        for(NhanVien nv : this.dsNhanVien){
            if(nv.getId() != id){
                newNv[k] = nv;
                k++;
            }
        }
        this.dsNhanVien = newNv;
    }

     public void printDsNhanVienDuAn(){
        if(this.dsNhanVien.length == 0){
            System.out.println("Không có nhân viên nào!");
            return;
        }
        System.out.println("Danh sách nhân viên của dự án " + this.nameDuAn + ":");
        for(int i=0; i<this.dsNhanVien.length; i++){
            System.out.println("Nhân viên " + (i+1) + ":");
            System.out.println(this.dsNhanVien[i].getName());
        }
    }

    // //--------------------------------------------------------------------

    // public void printDanhSachNhanVienDuAn(){
    //     if(dsNhanVien.length == 0){
    //         System.out.println("Không có nhân viên nào!");
    //         return;
    //     }
    //     System.out.println("Danh sách nhân viên của dự án " + this.nameDuAn + ":");
    //     for(int i=0; i<this.dsNhanVien.length; i++){
    //         System.out.println("Nhân viên " + (i+1) + ":");
    //         System.out.println(this.dsNhanVien[i].getName());
    //     }
    // }

    // public void addNhanVien(int sl){
    //     Scanner sc = new Scanner(System.in);
    //     QuanLyNhanVien qlnv = QuanLyNhanVien.getInstance();
    //     if(sl>qlnv.getSoLuongNhanVien()){
    //         System.out.println("Số lượng nhân viên muốn thêm vào dự án không hợp lý");
    //     }
    //     else{
    //         for(int i=0; i<sl; i++){
    //             this.dsNhanVien = Arrays.copyOf(this.dsNhanVien, this.dsNhanVien.length + 1);
    //             this.dsNhanVien[this.dsNhanVien.length - 1] = new NhanVien();
    //             System.out.println("Nhập id nhân viên thứ " + i + " muốn thêm:");
    //             String id = sc.nextLine();
    //             NhanVien nv = qlnv.getNhanVienById(id);
    //             if(nv == null){
    //                 System.out.println("Id nhân viên không tồn tại! Nhập lại");
    //                 i--;
    //             }
    //             else this.dsNhanVien[this.dsNhanVien.length - 1] = nv;
    //         }
    //     }
    // }

    // public void deleteNhanVien(){
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Nhập số lượng nhân viên muốn đuổi:");
    //     int sl = Integer.parseInt(sc.nextLine());
    //     printDanhSachNhanVienDuAn();
    //     int j=0;
    //     while(j<sl){
    //         NhanVien newNv[] = new NhanVien[this.dsNhanVien.length - 1];
    //         boolean check = true;
    //         String id="";
    //         while(check){
    //             System.out.println("Nhập id nhân viên muốn đuổi:");
    //             id = sc.nextLine();
    //             for(NhanVien nv : this.dsNhanVien){
    //                 if(nv.getId() == id){
    //                     check = false;
    //                 }
    //             }
    //             if(check) System.out.println("Id nhân viên không tồn tại! Nhập lại:");
    //         }
    //         int k=0;
    //         for(NhanVien nv : this.dsNhanVien){
    //             if(nv.getId() != id){
    //                 newNv[k] = nv;
    //                 k++;
    //             }
    //         }
    //         this.dsNhanVien = newNv;
    //         j++;
    //     }
    // }
}
