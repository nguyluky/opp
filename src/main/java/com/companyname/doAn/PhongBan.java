package com.companyname.doAn;

import java.util.Arrays;
import java.util.Scanner;

public class PhongBan {
    private String namePhongBan;
    private String idPhongBan; 
    private int soLuongNhanVien;
    private NhanVien dsNhanVien[];
    private DuAn dsDuAn[];
    private boolean isDelete;

    public PhongBan(){}

    //----------GET--------------
    public String getNamePhongBan(){
        return this.namePhongBan;
    }

    public String getIdPhongBan(){
        return this.idPhongBan;
    }

    public int getSoLuongNhanVien(){
        return this.soLuongNhanVien;
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

    public void setSoLuongNhanVien(int sl){
        this.soLuongNhanVien = sl;
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

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên phòng ban:");
        String name = sc.nextLine();
        this.namePhongBan = name;
        System.out.println("Nhập id phòng ban:");
        String id = sc.nextLine();
        this.idPhongBan = id;
        System.out.println("Nhập số lượng nhân viên phòng ban:");
        int sl = Integer.parseInt(sc.nextLine());
        this.soLuongNhanVien = sl;
        this.dsNhanVien = new NhanVien[sl];
        for(int i=0; i<sl; i++){
            this.dsNhanVien[i] = new NhanVien();
            this.dsNhanVien[i].nhap();
        }
    }

    public void printDsNhanVien(){
        int i=1;
        for(NhanVien nv : this.dsNhanVien){
            System.out.println("Nhân viên thứ " + i + ": " + nv.getName());
            i++;
        }
    }

    public void printDsDuAn(){
        int i=1;
        for(DuAn da : this.dsDuAn){
            System.out.println("Dự án thứ " + i + ": " + da.getNameDuAn());
            i++;
        }
    }

    public void addNhanVien(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng nhân viên muốn thêm vào phòng ban " + this.namePhongBan + ":");
        int sl = Integer.parseInt(sc.nextLine());
        
        QuanLyNhanVien qlnv = QuanLyNhanVien.getInstance();
        qlnv.printDanhSachIdNhanVien();

        for(int i=0; i<sl; i++){
            while(true){
                System.out.println("Nhập id nhân viên thứ " + (i+1) + "muốn thêm:");
                String id = sc.nextLine();
                for(NhanVien nv : qlnv.getDanhSachNhanVien()){
                    if(nv.getId() == id){
                        for(NhanVien nvPhongBan : this.dsNhanVien){
                            if(nvPhongBan.getId() == id){
                                System.out.println("Nhân viên này đã tồn tại trong phong ban");
                                return;
                            }
                        }
                        this.dsNhanVien[this.dsNhanVien.length - 1] = new NhanVien();
                        this.dsNhanVien[this.dsNhanVien.length - 1] = nv;
                        return;
                    }
                }
                System.out.println("Id nhân viên không tồn tại trong công ty! Vui lòng nhập lại");
            }
        }
    }

    public void deleteNhanVien(){
        Scanner sc = new Scanner(System.in);
        printDsNhanVien();
        System.out.println("Nhập số lượng nhân viên muốn đuổi khỏi phòng ban " + this.namePhongBan + ":");
        int sl = Integer.parseInt(sc.nextLine());
        
        int j=0;
        while(j<sl){
            NhanVien newNv[] = new NhanVien[this.dsNhanVien.length - 1];
            String id;
            boolean check = true;
            while(check){
                id = sc.nextLine();
                for(NhanVien nv : this.dsNhanVien){
                    if(nv.getId() == id){
                        check = false;
                        break;
                    }
                }
                if(check) System.out.println("Id không tồn tại! Nhập lại!");
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

    public void addDuAn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng dự án muốn thêm vào phòng ban:");
        int sl = Integer.parseInt(sc.nextLine());
        for(int i=0; i<sl; i++){
            this.dsDuAn = Arrays.copyOf(this.dsDuAn, this.dsDuAn.length + 1);
            this.dsDuAn[this.dsDuAn.length - 1] = new DuAn();
            this.dsDuAn[this.dsDuAn.length - 1].nhap();
        }
    }

    public void deleteDuAn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng dự án muốn bỏ khỏi phòng ban:");
        int sl = Integer.parseInt(sc.nextLine());
        if(this.dsDuAn.length < sl){
            System.out.println("Lỗi, Số dự án muốn xóa không hợp lý");
            return;
        }
        QuanLyDuAn qlda = QuanLyDuAn.getInstance();
        qlda.printDanhSachIdDuAn();
        int j=0;
        while(j<sl){
            System.out.println("Nhập id dự án muốn bỏ");
            String id = sc.nextLine();
            boolean check = false;
            for(DuAn da : this.dsDuAn){
                if(da.getIdDuAn() == id){
                    check = true;
                }
            }
            if(!check){
                System.out.println("Id dự án không tồn tại trong phòng ban");
                return;
            }
            DuAn newDa[] = new DuAn[this.dsDuAn.length -1];
            int k=0;
            for(DuAn da : this.dsDuAn){
                if(da.getIdDuAn() != id){
                    newDa[k] = da;
                    k++;
                }
            }
            this.dsDuAn = newDa;
            
        }
    }
}
