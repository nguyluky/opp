package com.companyname.doAn;
import java.util.Scanner;
import java.util.Arrays;

public class QuanLyPhongBan {
    private int soLuongPhongBan;
    private PhongBan dsPhongBan[];

    public QuanLyPhongBan(){}

    public QuanLyPhongBan(int soLuongPhongBan, PhongBan dsPhongBan[]){
        this.soLuongPhongBan = soLuongPhongBan;
        this.dsPhongBan = dsPhongBan;
    }

    //-----GET---------
    public int getSoLuongPhongBan(){
        return this.soLuongPhongBan;
    }

    public PhongBan[] getDanhSachPhngBan(){
        return this.dsPhongBan;
    }   
    //-----------------
    //-----SET------------
    public void setSoLuongPhongBan(int sl){
        this.soLuongPhongBan = sl;
    }

    public void setDanhSachPhongBan(PhongBan dsPhongBan[]){
        this.dsPhongBan = dsPhongBan;
    }
    //---------------------
    public void printDanhSachIdPhongBan(){
        for(int i=0; i<this.dsPhongBan.length; i++){
            System.out.println("Id phòng ban thứ " + (i+1) + " :");
            System.out.println(this.dsPhongBan[i].getIdPhongBan());
        }
    }

    public void addPhongBan(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng phòng ban muốn thêm:");
        int sl = Integer.parseInt(sc.nextLine());
        for(int i=0; i<sl; i++){
            this.dsPhongBan = Arrays.copyOf(this.dsPhongBan, this.dsPhongBan.length + 1);
            this.dsPhongBan[this.dsPhongBan.length - 1] = new PhongBan();
            this.dsPhongBan[this.dsPhongBan.length - 1].nhap();
        }
    }

    public void deletePhongBan(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng phòng ban muốn xóa:");
        int sl = Integer.parseInt(sc.nextLine());
        printDanhSachIdPhongBan();
        for(int i=0; i<sl; i++){
            System.out.println("Nhập id phòng ban muốn xóa");
            String id = sc.nextLine();
            boolean check = false;
            for(PhongBan pb : this.dsPhongBan){
                if(pb.getIdPhongBan() == id){
                    check = true;
                    return;
                }
            }
            if(!check){
                System.out.println("Id phòng ban không tồn tại trong công ty");
                return;
            }
            for(PhongBan pb : this.dsPhongBan){
                if(pb.getIdPhongBan() == id){
                    pb.setIsDelete(true);
                    return;
                }
            }
        }
    }
}

