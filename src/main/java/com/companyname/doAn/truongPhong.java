package com.companyname.doAn;


import java.time.LocalDate;

public class truongPhong extends nhanSu {
    private int kinhNghiem;
    private double heSophucap;
    private double phuCapthamnien;
    private int soNgaynghi;
    private  final String  chuVu = "Truong Phong";
    private final int soNgayduocphepnghi = 3;

    @Override
    double bonusChucvu() {
        return luongCoban()*2.25 + luongCoban() *getHeSophucap();
    }

    @Override
    double luongCoban() {
        return 4000000;
    }

    @Override
    double bonusMoneyhesothidua() {
        switch (getHeSothidua()) {  //switch expression
            case "A" : {return luongCoban() * 3.5;}
            case "B" : {return luongCoban() * 2.5;}
            case "C" : {return luongCoban() * 1.5;}
            case "D" : {return luongCoban() * 1;}
            case "E" : {return luongCoban();}
            default : {return 0;}
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

    public truongPhong() {
    }

    public truongPhong(String id, String name, String phone, String diaChi, int namVaolam, int kinhNghiem, double phuCapthamnien, int soNgaynghi) {
        super(id, name, phone, diaChi, namVaolam);
        this.kinhNghiem = kinhNghiem;

        this.phuCapthamnien = phuCapthamnien;
        this.soNgaynghi = soNgaynghi;
    }

    public int getKinhNghiem() {
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

    public void setHeSophucap(double heSophucap) {
        this.heSophucap = heSophucap;
    }

    public double getPhuCapthamnien() {
        return getKinhNghiem() * luongCoban()/100;
    }

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

    public void nhap(){
        super.nhap();
//        System.out.println("He so phuc cap :");
//        setHeSophucap(Double.parseDouble(sc.nextLine()));
        System.out.println("So ngay nghi :");
        setSoNgaynghi(Integer.parseInt(sc.nextLine()));
    }

    @Override
    public String toString() {
        return super.toString() + "\t\tKinh nghiem  :"+getKinhNghiem()+ "\t\tHe so phu cap  :" + getHeSophucap() +
                "\t\tChuc vu  :" + getChuVu() + "\t\t So ngay nghi  :" +getSoNgaynghi() +
                "\t\tTong tien luong :" +tienLuong();
    }
    public void xuat(){
        System.out.println(toString());
    }
}
