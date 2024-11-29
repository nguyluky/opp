
package com.companyname.doAn.type;

import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyPhongBan;

public class NhanVien extends NhanSu {
    private final String chucVu = "Nhan Vien";
    private final int luongCoBan = 3000000;
    private final int soNgayNghiToiDa = 2;


    public NhanVien() {
    }

    public NhanVien(String id, String name, String phone, String diaChi, int namVaolam, int kinhNghiem) {
        super(id, name, phone, diaChi, namVaolam, kinhNghiem);
    }

    public String toString(){
        return super.getName() + ";" + super.getId() + ";" + super.getPhone();
    }

    @Override
    public double getBonusChucVu() {
        return this.luongCoBan * 0.25;
    }

    @Override
    public String getChucVu() {
        return chucVu;
    }

    @Override
    public int getLuongCoBan() {
        return this.luongCoBan;
    }

    @Override
    public int getSoNgayNghiToiDa() {
        return this.soNgayNghiToiDa;
    }

    @Override
    public int getTienKyLuat(){
        int sum = 0;
        if(super.getDsKyLuat().length > 0){
            for(KyLuat kl : super.getDsKyLuat()){
                sum += kl.getTienPhat();
            }
        }
        return sum + ((getSoNgayNghi() - this.soNgayNghiToiDa) * 100000);
    }

    @Override
    public int getTienKhenThuong(){
        int sum = 0;
        if(super.getDsKhenThuong().length > 0){
            for(KhenThuong kt : super.getDsKhenThuong()){
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

    public void printThongTinCoBan(){
        System.out.println("Tên: " + super.getName());
        System.out.println("ID: " + super.getId());
        System.out.println("Số điện thoại: " + super.getPhone());
        System.out.println("Địa chỉ: " + super.getDiaChi());
        System.out.println("Năm vào làm: " + super.getNamVaoLam());
        System.out.println("Kinh nghiệm: " + super.getKinhNghiem());
        System.out.println("Lương tháng: " + this.tinhLuong());
        System.out.printf("Phòng ban: ");
        QuanLyPhongBan qlpb = QuanLyPhongBan.getInstance();
        boolean checkFind = false;
        for(PhongBan pb : qlpb.getDsPhongBan()){
            for(NhanSu ns : pb.getDsNhanVien()){
                if(ns.getId().equals(super.getId())){
                    System.out.println("Phòng ban: " + pb.getNamePhongBan());
                    checkFind = true;
                    break;
                }
            }
            if(checkFind) break;
        }
        System.out.println("Dự án đang tham gia: ");
        QuanLyDuAn qlda = QuanLyDuAn.getInstance();
        int i=1;
        for(DuAn da : qlda.getDsDuAn()){
            for(NhanSu ns : da.getDsNhanVienDuAn()){
                if(ns.getId().equals(super.getId())){
                    System.out.println("Dự án thứ " + i +": " + da.getNameDuAn());
                    i++;
                    break;
                }
            }
        }
    }
}
