package com.companyname.doAn;

import java.io.File;

import com.companyname.doAn.fileManager.DuAnReaderWriter;
import com.companyname.doAn.fileManager.FileManager;
import com.companyname.doAn.fileManager.NhanVienReaderWriter;
import com.companyname.doAn.fileManager.PhongBanReaderWriter;
import com.companyname.doAn.fileManager.TruongPhongReaderWriter;
import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.ql.QuanLyPhongBan;
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
        QuanLyPhongBan quanLyPhongBan = QuanLyPhongBan.getInstance();

        NhanVien nv1 = new NhanVien("1", "Nguyen Van A", "0123456789", "Ha Noi", 2020, 0, 0, 3000000, new KyLuat[0], new KhenThuong[0], false);
        NhanVien nv2 = new NhanVien("2", "Nguyen Van B", "0123456789", "Ha Noi", 2020, 0, 0, 3000000, new KyLuat[0], new KhenThuong[0], false);
        NhanVien nv3 = new NhanVien("3", "Nguyen Van C", "0123456789", "Ha Noi", 2020, 0, 0, 3000000, new KyLuat[0], new KhenThuong[0], false);

        TruongPhong tp1 = new TruongPhong("4", "Nguyen Van D", "0123456789", "Ha Noi", 2020, 0, 0, 3000000, new KyLuat[0], new KhenThuong[0], false);
        TruongPhong tp2 = new TruongPhong("5", "Nguyen Van E", "0123456789", "Ha Noi", 2020, 0, 0, 3000000, new KyLuat[0], new KhenThuong[0], false);
        TruongPhong tp3 = new TruongPhong("6", "Nguyen Van F", "0123456789", "Ha Noi", 2020, 0, 0, 3000000, new KyLuat[0], new KhenThuong[0], false);

        DuAn duAn1 = new DuAn("1", "Du An 1",  false);
        DuAn duAn2 = new DuAn("2", "Du An 2",  false);
        DuAn duAn3 = new DuAn("3", "Du An 2",  false);

        PhongBan phongBan1 = new PhongBan("hehe", "1", false);
        phongBan1.addNhanVien(nv1);
        phongBan1.addNhanVien(nv2);
        phongBan1.addDuAn(duAn2);
        phongBan1.addDuAn(duAn1);

        quanLyPhongBan.addPhongBan(phongBan1);

        duAn1.addNhanSu(tp3);
        duAn1.addNhanSu(nv1);

        duAn2.addNhanSu(tp1);
        duAn2.addNhanSu(nv2);


        quanLyDuAn.addDuAn(duAn1);
        quanLyDuAn.addDuAn(duAn2);
        quanLyDuAn.addDuAn(duAn3);

        quanLyNhanSu.addNhanSu(nv1);
        quanLyNhanSu.addNhanSu(nv2);
        quanLyNhanSu.addNhanSu(nv3);

        quanLyNhanSu.addNhanSu(tp1);
        quanLyNhanSu.addNhanSu(tp2);
        quanLyNhanSu.addNhanSu(tp3);

        try {
            FileManager fileManager = new FileManager();
            fileManager.write();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileManager fileManager = new FileManager();
            fileManager.read();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // try {
        //     for (NhanVien nv: nhanVienReaderWriter.read()) {
        //         System.out.println(nv);
        //     }
        //     for (TruongPhong tp: truongPhongReaderWriter.read()) {
        //         System.out.println(tp);
        //     }

        //     for (DuAn da: duAnReaderWriter.read()) {
        //         System.out.println(da);
        //         for (NhanSu a: da.getDsNhanSu()) {
        //             System.out.println(a);
        //         }
        //     }

        //     for (PhongBan pb: phongBanReaderWriter.read()) {
        //         System.out.println(pb);
        //         for (NhanSu a: pb.getDsNhanVien()) {
        //             System.out.println(a);
        //         }

        //         for (DuAn a: pb.getDsDuAn()) {
        //             System.out.println(a);
        //         }
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        try {
            System.out.println("Phong Ban");
            for (PhongBan pb: quanLyPhongBan.getDsPhongBan()) {
                System.out.println(pb);
                System.out.println("Nhan Vien");
                for (NhanSu ns: pb.getDsNhanVien()) {
                    System.out.println(ns);
                }
                System.out.println("Du An");
                for (DuAn da: pb.getDsDuAn()) {
                    System.out.println(da);
                }
            }   

            System.out.println("Du An");
            for (DuAn da: quanLyDuAn.getDsDuAn()) {
                System.out.println(da);
            }

            System.out.println("Nhan Vien");
            for (NhanVien nv: quanLyNhanSu.getNhanViens()) {
                System.out.println(nv);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
