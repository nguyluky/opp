package com.companyname.doAn.type;

public class GiamDoc extends NhanSu {

    private  final String  chucVu = "Giam Doc";
    private final int luongCoBan = 5000000;
    private final int soNgayNghiToiDa = 3;

    public GiamDoc() {
    }

    public GiamDoc(String id, String name, String phone, String diaChi, int namVaolam) {
        super(id, name, phone, diaChi, namVaolam);
    }

    @Override
    public double getBonusChucVu() {
        return this.luongCoBan * 2.25;
    }

    @Override
    public String getChucVu() {
        return chucVu;
    }

    @Override
    public int getSoNgayNghiToiDa() {
        return this.soNgayNghiToiDa;
    }

    @Override
    public int getLuongCoBan() {
        return this.luongCoBan;
    }

    @Override
    public int getTienKyLuat(){
        int sum = 0;
        if(super.getDsKyLuat().length > 0) {
            for (KyLuat kl : super.getDsKyLuat()) {
                sum += kl.getTienPhat();
            }
        }
        return sum + ((getSoNgayNghi() - this.soNgayNghiToiDa) * 100000);
    }

    @Override
    public int getTienKhenThuong(){
        int sum = 0;
        if(super.getDsKhenThuong().length > 0) {
            for (KhenThuong kt : super.getDsKhenThuong()) {
                sum += kt.getTienThuong();
            }
        }
        return sum;
    }

    @Override
    public double getLuongMem(){
        return getTienKhenThuong() - getTienKyLuat() + getBonusChucVu();
    }

    @Override
    public double tinhLuong() {
        return luongCoBan + getLuongMem();
    }
    
}
