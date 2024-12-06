
package com.companyname.doAn.type;

import com.companyname.doAn.ql.QuanLyPhongBan;

import static com.companyname.doAn.Gui.StaticScanner.qlda;

public class NhanVien extends NhanSu {
    private final String chucVu = "Nhan Vien";
    private int luongCoBan = 3000000;
    private final int soNgayNghiToiDa = 2;


    public NhanVien() {
    }

    public NhanVien(String id, String ho, String ten, String phone, String diaChi, int namVaolam, int kinhNghiem) {
        super(id, ho, ten, phone, diaChi, namVaolam, kinhNghiem);
    }

    // THIS
    public NhanVien(
        String id,
        String ho,
        String ten,
        String phone,
        String diaChi,
        int namVaoLam,
        int soNgayNghi,
        int kinhNghiem,
        int luongCoBan,
        KyLuat[] dsKyLuat,
        KhenThuong[] dsKhenThuong
    )
    {
        super(id, ho, ten, phone, diaChi, namVaoLam, kinhNghiem);
        this.setSoNgayNghi(soNgayNghi);
        this.luongCoBan = luongCoBan;
        this.setDsKyLuat(dsKyLuat);
        this.setDsKhenThuong(dsKhenThuong);
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

    public void setLuongCoBan(int luongCoBan) {
        this.luongCoBan = luongCoBan;
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
        System.out.println("---------------------------------------");
//        ShowOption.clearScreen();

        System.out.println("Họ và tên: " + super.getHo() + " " + super.getTen());
        System.out.println("ID: " + super.getId());
        System.out.println("Số điện thoại: " + super.getPhone());
        System.out.println("Địa chỉ: " + super.getDiaChi());
        System.out.println("Năm vào làm: " + super.getNamVaoLam());
        System.out.println("Kinh nghiệm: " + super.getKinhNghiem());
        System.out.println("Lương tháng: " + this.tinhLuong());
        System.out.println("Loại: Nhân viên");
        QuanLyPhongBan qlpb = QuanLyPhongBan.getInstance();
        boolean checkFindPhongBan = false;
        for(PhongBan pb : qlpb.getDsPhongBan()){
            for(NhanSu ns : pb.getDsNhanVien()){
                if(ns.getId().equals(super.getId())){
                    System.out.println("Phòng ban: " + pb.getNamePhongBan());
                    checkFindPhongBan = true;
                    break;
                }
            }
            if(checkFindPhongBan) break;
        }
        if(!checkFindPhongBan) System.out.println("Phòng ban: Chưa có");

        System.out.println("Danh sách dự án tham gia: ");
        boolean checkFindDuAn = false;
        int i=1;
        for(DuAn da : qlda.getDsDuAn()){
            if(!da.getIsDelete()) {
                for (NhanSu ns : da.getDsNhanSu()) {
                    if (ns.getId().equals(super.getId())) {
                        System.out.println("Dự án thứ " + i + ": " + da.getNameDuAn() + ". ID: " + da.getIdDuAn());
                        i++;
                        checkFindDuAn = true;
                        break;
                    }
                }
            }
        }
        if(!checkFindDuAn)  System.out.println("Không có");
    }
}
