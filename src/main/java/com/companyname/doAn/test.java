package com.companyname.doAn;

import com.companyname.doAn.fileManager.FileManager;
import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.ql.QuanLyPhongBan;
import com.companyname.doAn.type.*;
import java.util.Random;

public class test {

    public static NhanVien taoNhanVienNgauNhien() {
        Random rand = new Random();
        String id = "NV" + rand.nextInt(1000);
        String ho = "Nguyen";
        String ten = "Van " + (char) (rand.nextInt(26) + 'A');
        String phone = "09" + (rand.nextInt(90000000) + 10000000);
        String diaChi = "Dia chi " + rand.nextInt(100);
        int namVaoLam = 2000 + rand.nextInt(23);
        int soNgayNghi = rand.nextInt(5);
        int kinhNghiem = rand.nextInt(20);
        int luongCoBan = 3000000 + rand.nextInt(2000000);
        KyLuat[] dsKyLuat = new KyLuat[0];
        KhenThuong[] dsKhenThuong = new KhenThuong[0];
        NhanVien nv = new NhanVien(id, ho, ten, phone, diaChi, namVaoLam, soNgayNghi, kinhNghiem, luongCoBan, dsKyLuat, dsKhenThuong);
        QuanLyNhanSu.getInstance().addNhanSu(nv);
        return nv;
        }

    public static PhongBan taoPhongBanNgauNhien() {
        Random rand = new Random();
        String idPhongBan = "PB" + rand.nextInt(100);
        String namePhongBan = "Phong " + (char) (rand.nextInt(26) + 'A');
        TruongPhong truongPhong = taoTruongPhongNgauNhien();
        NhanVien[] dsNhanVien = new NhanVien[0];
        TruongPhong[] dsTruongPhong = {truongPhong};

        // Chọn ngẫu nhiên các dự án từ QuanLyDuAn để thêm vào phòng ban
        DuAn[] allDuAn = QuanLyDuAn.getInstance().getDsDuAn();
        int soDuAn = rand.nextInt(allDuAn.length + 1);
        DuAn[] dsDuAn = new DuAn[soDuAn];
        for (int i = 0; i < soDuAn; i++) {
            dsDuAn[i] = allDuAn[rand.nextInt(allDuAn.length)];
        }

        boolean isDelete = false;
        PhongBan pb = new PhongBan(namePhongBan, idPhongBan, dsNhanVien, dsTruongPhong, dsDuAn, isDelete);
        QuanLyPhongBan.getInstance().addPhongBan(pb);
        return pb;
    }

    public static TruongPhong taoTruongPhongNgauNhien() {
        Random rand = new Random();
        String id = "TP" + rand.nextInt(1000);
        String ho = "Nguyen";
        String ten = "Van " + (char) (rand.nextInt(26) + 'A');
        String phone = "09" + (rand.nextInt(90000000) + 10000000);
        String diaChi = "Dia chi " + rand.nextInt(100);
        int namVaoLam = 2000 + rand.nextInt(23);
        int kinhNghiem = rand.nextInt(20);
        KyLuat[] dsKyLuat = new KyLuat[0];
        KhenThuong[] dsKhenThuong = new KhenThuong[0];

        TruongPhong t = new TruongPhong(id, ho, ten, phone, diaChi, namVaoLam, 0, dsKyLuat, dsKhenThuong, kinhNghiem);
        QuanLyNhanSu.getInstance().addNhanSu(t);
        return t;
    }

    public static DuAn taoDuAnNgauNhienVaThemNhanVien() {
        Random rand = new Random();
        String idDuAn = "DA" + rand.nextInt(1000);
        String nameDuAn = "Du An " + (char) (rand.nextInt(26) + 'A');
        DuAn duAn = new DuAn(nameDuAn, idDuAn);

        QuanLyNhanSu qlns = QuanLyNhanSu.getInstance();
        NhanSu[] dsNhanSu = qlns.getDsNhanSu();
        int soNhanSu = rand.nextInt(dsNhanSu.length + 1);

        for (int i = 0; i < soNhanSu; i++) {
            duAn.addNhanSu(dsNhanSu[i]);
        }

        QuanLyDuAn.getInstance().addDuAn(duAn);
        return duAn;
    }


    static void testSave() {
        for (int i = 0; i < 10; i++) {
            taoNhanVienNgauNhien();
        }

        for (int i = 0; i < 10; i++) {
            taoDuAnNgauNhienVaThemNhanVien();
        }

        for (int i = 0; i < 10; i++) {
            taoPhongBanNgauNhien();
        }

        FileManager fileManager = new FileManager();
        try {
            fileManager.write();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void testLoad() {
        try {

            FileManager fileManager = new FileManager();
            fileManager.read();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        // testLoad();
        testSave();
        
    }
}
