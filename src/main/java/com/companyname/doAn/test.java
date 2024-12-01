package com.companyname.doAn;

import com.companyname.doAn.fileManager.FileManager;
import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.ql.QuanLyPhongBan;
import com.companyname.doAn.type.*;

public class test {
    public static void main(String[] args) {
        QuanLyNhanSu quanLyNhanSu = QuanLyNhanSu.getInstance();
        QuanLyDuAn quanLyDuAn = QuanLyDuAn.getInstance();
        QuanLyPhongBan quanLyPhongBan = QuanLyPhongBan.getInstance();

        for (int i = 0; i < 10; i++) {
            NhanVien nv = new NhanVien(String.valueOf(i), "Nguyen Van " + i, "012345678" + i, "Ha Noi", 2020 + i, 0, 0, 3000000, new KyLuat[0], new KhenThuong[0], false);
            quanLyNhanSu.addNhanSu(nv);
        }

        for (int i = 0; i < 10; i++) {
            DuAn da = new DuAn("Du An " + i, String.valueOf(i),  false);

            for (int j = 0; j < 10; j++) {
                NhanVien nv = new NhanVien("a" + String.valueOf(j) + String.valueOf(i), "Nguyen Van " + (i + j), "012345678" + (i + j), "Ha Noi", 2020 + j, 0, 0, 3000000, new KyLuat[0], new KhenThuong[0], false);
                da.addNhanSu(nv);
                quanLyNhanSu.addNhanSu(nv);
            }


            quanLyDuAn.addDuAn(da);


        }

        for (int i = 0; i < 10; i++) {
            PhongBan pb = new PhongBan("Phong Ban " + i, String.valueOf(i), false);
            TruongPhong tp = new TruongPhong( "tp" + String.valueOf(i), "Nguyen Van " + (i + "pt"), "012345678" + (i + 10), "Ha Noi", 2020 + i, 0, 0, 3000000, new KyLuat[0], new KhenThuong[0], false);
            pb.setTruongPhong(tp);
            quanLyNhanSu.addNhanSu(tp);
            quanLyPhongBan.addPhongBan(pb);
        }

        try {
            FileManager fileManager = new FileManager();
            fileManager.write();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // try {
        //     FileManager fileManager = new FileManager();
        //     fileManager.read();
        // }
        // catch (Exception e) {
        //     e.printStackTrace();
        // }

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

        // try {
        //     System.out.println("Phong Ban");
        //     for (PhongBan pb: quanLyPhongBan.getDsPhongBan()) {
        //         System.out.println(pb);
        //         System.out.println(pb.getTruongPhong());
        //         System.out.println("Nhan Vien");
        //         for (NhanSu ns: pb.getDsNhanVien()) {
        //             System.out.println(ns);
        //         }
        //         System.out.println("Du An");
        //         for (DuAn da: pb.getDsDuAn()) {
        //             System.out.println(da);
        //         }
        //     }   

        //     System.out.println("Du An");
        //     for (DuAn da: quanLyDuAn.getDsDuAn()) {
        //         System.out.println(da);
        //     }

        //     System.out.println("Nhan Vien");
        //     for (NhanVien nv: quanLyNhanSu.getNhanViens()) {
        //         System.out.println(nv);
        //     }



        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

    }
}
