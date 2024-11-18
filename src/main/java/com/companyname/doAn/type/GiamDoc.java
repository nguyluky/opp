package com.companyname.doAn.type;

public class GiamDoc extends NhanSu {

    private  final String  chuVu = "Giam Doc";
    private final int soNgayduocphepnghi = 3;

    public GiamDoc() {
    }

    public GiamDoc(String id, String name,String phone,String diaChi,double namVaolam, String heSothidua,int kinhNghiem,double heSophucap, int soNgaynghi) {
        super(id, name, phone, diaChi, soNgaynghi, heSothidua, soNgaynghi, kinhNghiem, soNgaynghi);
    }

    @Override
    public double bonusChucVu() {
        return this.luongCoBan() * 2.25;
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
        return 5_000_000;
    }

    @Override
    public double tinhLuong() {
       return luongCoBan() + ( bonusChucVu() + bonusMoneyHeSoThiDua() + getPhuCapThamNien()) - (getSoNgayDuocPhepNghi() - getSoNgayNghi()) * 400_000;
    }
    
}
