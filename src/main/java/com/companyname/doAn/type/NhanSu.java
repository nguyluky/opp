package com.companyname.doAn.type;


public abstract class NhanSu  {
    private String id;
    private String name;
    private String phone;
    private String daiChi;
    private int namVaoLam;
    private String heSoThiDua;
    private int heSoPhuLoi;
    private int kingNghiep;
    private int soNgayNghi;
    private boolean isDelete = false;

    public NhanSu() {};

    public NhanSu(String id, String name, String phone, String daiChi, int namVaoLam, String heSoThiDua, int heSoPhuLoi, int kingNghiep, int soNgayNghi) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.daiChi = daiChi;
        this.namVaoLam = namVaoLam;
        this.heSoThiDua = heSoThiDua;
        this.heSoPhuLoi = heSoPhuLoi;
        this.kingNghiep = kingNghiep;
        this.soNgayNghi = soNgayNghi;
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
    public String getDaiChi() {
        return daiChi;
    }
    public void setDaiChi(String daiChi) {
        this.daiChi = daiChi;
    }
    public int getNamVaoLam() {
        return namVaoLam;
    }
    public void setNamVaoLam(int namVaoLam) {
        this.namVaoLam = namVaoLam;
    }
    public String getHeSoThiDua() {
        return heSoThiDua;
    }
    public void setHeSoThiDua(String heSoThiDua) {
        this.heSoThiDua = heSoThiDua;
    }
    public int getHeSoPhucLoi() {
        return heSoPhuLoi;
    }
    public void setHeSoPhuLoi(int heSoPhuCap) {
        this.heSoPhuLoi = heSoPhuCap;
    }
    public int getKingNghiep() {
        return kingNghiep;
    }
    public void setKingNghiep(int kingNghiep) {
        this.kingNghiep = kingNghiep;
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    public int getHeSoPhuLoi() {
        return heSoPhuLoi;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    //---------------------------------//

    public abstract double tinhLuong();
    public abstract double luongCoBan();
    public abstract double bonusChucVu();
    public abstract String getChucVu();
    public abstract int getSoNgayDuocPhepNghi();

    //---------------------------------//
    public String toString() {
        return "NhanVie[" + "id=" + id + ", name=" + name + ", phone=" + phone + ", daiChi=" + daiChi + ", namVaoLam=" + namVaoLam + ", heSoThiDua=" + heSoThiDua + ", heSoPhuCap=" + heSoPhuLoi + ", kingNghiep=" + kingNghiep + "]";
    }

    public static double convertHeSoThiDua(String heSoThiDua) {
        if (heSoThiDua.equals("A")) {
            return 1.0;
        } else if (heSoThiDua.equals("B")) {
            return 0.75;
        } else if (heSoThiDua.equals("C")) {
            return 0.5;
        } else if (heSoThiDua.equals("D")) {
            return 0.25;
        } else if (heSoThiDua.equals("E")) {
            return -0.5;
        }
        return 0;
    }

    public double getPhuCapThamNien() {
        return this.kingNghiep * luongCoBan() / 100;
    }

    public double bonusMoneyHeSoThiDua() {
        return this.luongCoBan() * this.getHeSoPhucLoi() + NhanSu.convertHeSoThiDua(this.getHeSoThiDua());
    }


}