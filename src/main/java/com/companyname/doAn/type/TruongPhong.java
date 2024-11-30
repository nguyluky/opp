package com.companyname.doAn.type;

public class TruongPhong extends NhanSu {
    private  final String chucVu = "Truong Phong";
    private int luongCoBan = 4000000;
    private final int soNgayNghiToiDa = 3;

    public TruongPhong() {}

    public TruongPhong(String id, String name, String phone, String diaChi, int namVaoLam, int soNgayNghi, KyLuat[] dsKyLuat, KhenThuong[] dsKhenThuong, int kinhNghiem) {
        super(id, name, phone, diaChi, namVaoLam, soNgayNghi, dsKyLuat, dsKhenThuong, kinhNghiem);
    }

    public TruongPhong(String id, String name, String phone, String diaChi, int namVaolam, int kinhNghiem) {
        super(id, name, phone, diaChi, namVaolam, kinhNghiem);
    }

    public TruongPhong(
        String id,
        String name,
        String phone,
        String diaChi,
        int namVaoLam,
        int soNgayNghi,
        int kinhNghiem,
        int luongCoBan,
        boolean isDelete
    ) {
        super(id, name, phone, diaChi, namVaoLam, soNgayNghi, kinhNghiem, isDelete);
        this.luongCoBan = luongCoBan;
    }

    @Override
    public double getBonusChucVu() {
        return this.luongCoBan * 1.25;
    }
    @Override
    public String getChucVu() {
        return chucVu;
    }
    @Override
    public int getSoNgayNghiToiDa() {
        return soNgayNghiToiDa;
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

    public void printThongTinCoBan(){
        System.out.println("Tên: " + super.getName());
        System.out.println("ID: " + super.getId());
        System.out.println("Số điện thoại: " + super.getPhone());
        System.out.println("Địa chỉ: " + super.getDiaChi());
        System.out.println("Năm vào làm: " + super.getNamVaoLam());
        System.out.println("Kinh nghiệm: " + super.getKinhNghiem());
        System.out.println("Lương tháng: " + this.tinhLuong());
    }
}
