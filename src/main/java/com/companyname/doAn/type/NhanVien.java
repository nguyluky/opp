
package com.companyname.doAn.type;

public class NhanVien extends NhanSu {
    
    private final String chuVu = "Nhan Vien";
    private final int soNgayduocphepnghi = 2;


    public NhanVien() {
    }

    public NhanVien(
        String id,
        String name,
        String phone,
        String diaChi,
        double namVaolam,
        String heSothidua,
        int kinhNghiem,
        double heSophucap,
        int soNgaynghi,
        boolean isDelete
    ) {
        super(id, name, phone, diaChi, soNgaynghi, heSothidua, soNgaynghi, kinhNghiem, soNgaynghi, isDelete);
    }

    public String toString(){
        return super.getName() + ";" + super.getId() + ";" + super.getPhone();
    }

    @Override
    public double bonusChucVu() {
        return this.luongCoBan() * 0.25;
    }

    @Override
    public String getChucVu() {
        return chuVu;
    }

    @Override
    public double luongCoBan() {
        return 3_000_000;
    }

    @Override
    public int getSoNgayDuocPhepNghi() {
        return soNgayduocphepnghi;
    }

    @Override
    public double tinhLuong() {
       return luongCoBan() + ( bonusChucVu() + bonusMoneyHeSoThiDua() + getPhuCapThamNien()) - (getSoNgayDuocPhepNghi() - getSoNgayNghi()) * 100000;
    }
}
