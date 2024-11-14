package com.companyname.doAn;

import java.util.Scanner;
import java.time.LocalDate;

public class GiamDoc extends NhanSu {
    private int kinhNghiem = -1;
    private double phuCapthamnien = -1;
    private int soNgaynghi;
    private  final String  chuVu = "Giam Doc";
    private final int soNgayduocphepnghi = 3;



    @Override
    double bonusChucvu() {
        return luongCoban()*2.25 + luongCoban() *getHeSophucap();
    }

    @Override
    double luongCoban() {
        return 5000000;
    }

    @Override
    double bonusMoneyhesothidua() {
        switch (getHeSothidua()) {  //switch expression
            case "A": return luongCoban() * 3.5;
            case "B": return luongCoban() * 2.5;
            case "C": return luongCoban() * 1.5;
            case "D": return luongCoban() * 1;
            case "E": return luongCoban();
            default: return 0;
        }
    }

    @Override
    double tienLuong() {
        double d =0;
        if(getSoNgayduocphepnghi() - getSoNgaynghi()>0){
            d = (getSoNgayduocphepnghi() - getSoNgaynghi());
        }else{
            d = -(getSoNgayduocphepnghi() - getSoNgaynghi());
        }

        return (luongCoban() + bonusChucvu() + bonusMoneyhesothidua() + getPhuCapthamnien()) - (d*300000)  ;
    }

    public GiamDoc() {
    }

    public GiamDoc(String id, String name, String phone, String diaChi, int namVaolam, int kinhNghiem, double phuCapthamnien, int soNgaynghi) {
        super(id, name, phone, diaChi, namVaolam);
        this.kinhNghiem = kinhNghiem;
        this.phuCapthamnien = phuCapthamnien;
        this.soNgaynghi = soNgaynghi;
    }

    public int getKinhNghiem() {
        if (this.kinhNghiem != 0) {
            return this.kinhNghiem;
        }

        LocalDate year = LocalDate.now();
        int y = year.getYear();
        return y - super.getNamVaolam();
    }

    public void setKinhNghiem(int kinhNghiem) {
        this.kinhNghiem = kinhNghiem;
    }

    public double getHeSophucap() {
        if(getKinhNghiem() < 3){
            return 1.25;
        } else if (getKinhNghiem() < 5) {
            return 1.5;
        } else if(getKinhNghiem() < 10){
            return 2.0;
        } else if (getKinhNghiem() <= 15) {
            return 2.5;
        }else return 3.0;
    }

    public double getPhuCapthamnien() {
        return getKinhNghiem() * luongCoban()/100;
    }

//    là sao tạo sao lưu vào biến là gì vậy
    public void setPhuCapthamnien(double phuCapthamnien) {
        this.phuCapthamnien = phuCapthamnien;
    }

    public int getSoNgaynghi() {
        return soNgaynghi;
    }

    public void setSoNgaynghi(int soNgaynghi) {
        this.soNgaynghi = soNgaynghi;
    }

    public String getChuVu() {
        return chuVu;
    }

    public int getSoNgayduocphepnghi() {
        return soNgayduocphepnghi;
    }

    public void nhap(Scanner sc){
        super.nhap(sc);
        System.out.println("So ngay nghi :");
        setSoNgaynghi(Integer.parseInt(sc.nextLine()));
    }

    @Override
    public String toString() {
        return super.toString() + "\nKinh nghiem  :"+getKinhNghiem()+ "\nHe so phu cap  :" + getHeSophucap() +
                "\nChuc vu  :" + getChuVu() + "\n So ngay nghi  :" +getSoNgaynghi() +
                "\nTong tien luong :" +tienLuong();
    }
    public void xuat(){
        System.out.println(toString());
    }
}
