package com.companyname.doAn;

import com.companyname.doAn.fileManager.DuAnReaderWriter;
import com.companyname.doAn.fileManager.NhanVienReaderWriter;
import com.companyname.doAn.fileManager.TruongPhongReaderWriter;
import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.type.DuAn;
import com.companyname.doAn.type.KhenThuong;
import com.companyname.doAn.type.KyLuat;
import com.companyname.doAn.type.NhanSu;
import com.companyname.doAn.type.NhanVien;
import com.companyname.doAn.type.PhongBan;
import com.companyname.doAn.type.TruongPhong;

public class test {
    public static void main(String[] args) {
        QuanLyNhanSu quanLyNhanSu = QuanLyNhanSu.getInstance();
        QuanLyDuAn quanLyDuAn = QuanLyDuAn.getInstance();

        NhanVienReaderWriter nhanVienReaderWriter = new NhanVienReaderWriter("data/");
        TruongPhongReaderWriter truongPhongReaderWriter = new TruongPhongReaderWriter("data/");
        DuAnReaderWriter duAnReaderWriter = new DuAnReaderWriter("data/");

        NhanVien nv1 = new NhanVien("1", "Nguyen Van A", "0123456789", "Ha Noi", 2020, 0, 0, 3000000, new KyLuat[0], new KhenThuong[0], false);
        NhanVien nv2 = new NhanVien("2", "Nguyen Van B", "0123456789", "Ha Noi", 2020, 0, 0, 3000000, new KyLuat[0], new KhenThuong[0], false);
        NhanVien nv3 = new NhanVien("3", "Nguyen Van C", "0123456789", "Ha Noi", 2020, 0, 0, 3000000, new KyLuat[0], new KhenThuong[0], false);

        TruongPhong tp1 = new TruongPhong("4", "Nguyen Van D", "0123456789", "Ha Noi", 2020, 0, 0, 3000000, new KyLuat[0], new KhenThuong[0], false);
        TruongPhong tp2 = new TruongPhong("5", "Nguyen Van E", "0123456789", "Ha Noi", 2020, 0, 0, 3000000, new KyLuat[0], new KhenThuong[0], false);
        TruongPhong tp3 = new TruongPhong("6", "Nguyen Van F", "0123456789", "Ha Noi", 2020, 0, 0, 3000000, new KyLuat[0], new KhenThuong[0], false);

        DuAn duAn1 = new DuAn("1", "Du An 1",  false);
        DuAn duAn2 = new DuAn("2", "Du An 2",  false);

        PhongBan phongBan1 = new PhongBan("1", "Phong Ban 1", "Ha Noi", 2020, 0, 0, 3000000, new KyLuat[0], new KhenThuong[0], false);
        

        duAn1.addNhanSu(tp3);
        duAn1.addNhanSu(nv1);

        duAn2.addNhanSu(tp1);
        duAn2.addNhanSu(nv2);


        quanLyDuAn.addDuAn(duAn1);

        quanLyNhanSu.addNhanSu(nv1);
        quanLyNhanSu.addNhanSu(nv2);
        quanLyNhanSu.addNhanSu(nv3);

        quanLyNhanSu.addNhanSu(tp1);
        quanLyNhanSu.addNhanSu(tp2);
        quanLyNhanSu.addNhanSu(tp3);



        try {
            nhanVienReaderWriter.save(quanLyNhanSu.getNhanViens());
            truongPhongReaderWriter.save(quanLyNhanSu.getTruongPhongs());
            duAnReaderWriter.save(quanLyDuAn.getDsDuAn());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            for (NhanVien nv: nhanVienReaderWriter.read()) {
                System.out.println(nv);
            }
            for (TruongPhong tp: truongPhongReaderWriter.read()) {
                System.out.println(tp);
            }

            for (DuAn da: duAnReaderWriter.read()) {
                System.out.println(da);
                for (NhanSu a: da.getDsNhanSu()) {
                    System.out.println(a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
