package com.companyname.doAn.type;


import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyPhongBan;

public abstract class NhanSu  {
    private String id;
    private String name;
    private String phone;
    private String diaChi;
    private int namVaoLam;
    private int soNgayNghi;
    private KyLuat dsKyLuat[];
    private KhenThuong dsKhenThuong[];
    private int kinhNghiem;
    private boolean isDelete = false;

    public NhanSu() {};

    public NhanSu(String id, String name, String phone, String diaChi, int namVaoLam, int soNgayNghi, KyLuat[] dsKyLuat, KhenThuong[] dsKhenThuong, int kinhNghiem) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.diaChi = diaChi;
        this.namVaoLam = namVaoLam;
        this.soNgayNghi = soNgayNghi;
        this.dsKyLuat = dsKyLuat;
        this.dsKhenThuong = dsKhenThuong;
        this.kinhNghiem = kinhNghiem;
        this.isDelete = false;
    }

    public NhanSu(String id, String name, String phone, String diaChi, int namVaoLam, int kinhNghiem) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.diaChi = diaChi;
        this.namVaoLam = namVaoLam;
        this.soNgayNghi = 0;
        this.dsKyLuat = new KyLuat[0];
        this.dsKhenThuong = new KhenThuong[0];
        this.kinhNghiem = kinhNghiem;
        this.isDelete = false;
    }

    //---------------------------------//

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public int getNamVaoLam() {
        return namVaoLam;
    }
    public void setNamVaoLam(int namVaoLam) {
        this.namVaoLam = namVaoLam;
    }
    public int getKinhNghiem() {
        return kinhNghiem;
    }
    public void setKinhNghiem(int kinhNghiem) {
        this.kinhNghiem = kinhNghiem;
    }
    public int getSoNgayNghi() {
        return soNgayNghi;
    }
    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }
//    public int getHeSoPhuLoi() {
//        return heSoPhuLoi;
//    }
    public boolean getIsDelete() {
        return isDelete;
    }
    public void setDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
    public KyLuat[] getDsKyLuat() {
        return this.dsKyLuat;
    }
    public void setDsKyLuat(KyLuat[] dsKyLuat) {
        this.dsKyLuat = dsKyLuat;
    }
    public KhenThuong[] getDsKhenThuong() {
        return this.dsKhenThuong;
    }
    public void setDsKhenThuong(KhenThuong[] dsKhenThuong) {
        this.dsKhenThuong = dsKhenThuong;
    }


//    ---------------------------------

    public abstract double tinhLuong();
    public abstract int getLuongCoBan();
    public abstract double getLuongMem();
    public abstract double getBonusChucVu();
    public abstract String getChucVu();
    public abstract int getSoNgayNghiToiDa();
    public abstract int getTienKyLuat();
    public abstract int getTienKhenThuong();
    public abstract void printThongTinCoBan();

//    ---------------------------------
    public String toString() {
        return "NhanVien[" + "id=" + id + ", name=" + name + ", phone=" + phone + ", daiChi=" + diaChi + ", namVaoLam=" + namVaoLam + "]";
    }

    public void printTinhTrangKyLuat(){
        System.out.println("Số lần kỷ luật: " + this.dsKyLuat.length);
        int i=1;
        for(KyLuat kl : this.dsKyLuat){
            System.out.println("Lần " + i + ": " + kl.getLyDo() + ". Nội dung: " + kl.getTienPhat());
        }
    }

    public void printTinhTrangKhenThuong(){
        System.out.println("Số lần khen thưởng: " + this.dsKhenThuong.length);
        int i=1;
        for(KhenThuong kt : this.dsKhenThuong){
            System.out.println("Lần " + i + ": " + kt.getLyDo() + ". Nội dung: " + kt.getTienThuong());
        }
    }

}