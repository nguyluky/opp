package com.companyname.doAn.type;

public class TruongPhong extends NhanSu {
    private  final String chuVu = "Truong Phong";
    private final int soNgayduocphepnghi = 3;

    public TruongPhong(String id, String name,String phone,String diaChi,double namVaolam, String heSothidua,int kinhNghiem,double heSophucap, int soNgaynghi) {
        super(id, name, phone, diaChi, soNgaynghi, heSothidua, soNgaynghi, kinhNghiem, soNgaynghi);
    }

    @Override
    public double bonusChucVu() {
        return this.luongCoBan() * 1.25;
    }
    @Override
    public String getChucVu() {
        return chuVu;
    }
    @Override
    public int getSoNgayDuocPhepNghi() {
        return soNgayduocphepnghi;
    }
    @Override
    public double luongCoBan() {
        return 4_000_000;
    }
    @Override
    public double tinhLuong() {
        return luongCoBan() + ( bonusChucVu() + bonusMoneyHeSoThiDua() + getPhuCapThamNien()) - (getSoNgayDuocPhepNghi() - getSoNgayNghi()) * 300_000;
    }

   
}
