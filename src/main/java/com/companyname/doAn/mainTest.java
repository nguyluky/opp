package com.companyname.doAn;

import com.companyname.doAn.fileManager.FileManager;
import com.companyname.doAn.fileManager.NhanVienReaderWriter;
import com.companyname.doAn.fileManager.PhongBanReaderWriter;
import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.ql.QuanLyPhongBan;
import com.companyname.doAn.type.DuAn;
import com.companyname.doAn.type.NhanSu;
import com.companyname.doAn.type.NhanVien;
import com.companyname.doAn.type.PhongBan;

public class mainTest {
    public static void main(String[] args) {
        // System.out.println("Hello World");
        QuanLyNhanSu ql = QuanLyNhanSu.getInstance();
        QuanLyPhongBan qlpb = QuanLyPhongBan.getInstance();
        QuanLyDuAn qAn = QuanLyDuAn.getInstance();


        // NhanVien nv = new NhanVien("1", "Nguyen Van A", "01/01/1990", "Ha Noi", 10000000, "0123456789", 1, 1, 1, true);
        // NhanVien nv2 = new NhanVien("2", "Nguyen Van B", "01/01/1990", "Ha Noi", 10000000, "0123456789", 1, 1, 1, true);
        // NhanVien nv3 = new NhanVien("3", "Nguyen Van C", "01/01/1990", "Ha Noi", 10000000, "0123456789", 1, 1, 1, true);
        // NhanVien nv4 = new NhanVien("4", "Nguyen Van D", "01/01/1990", "Ha Noi", 10000000, "0123456789", 1, 1, 1, true);

        // ql.addNhanSu(nv);
        // ql.addNhanSu(nv2);
        // ql.addNhanSu(nv3);
        // ql.addNhanSu(nv4);


        // NhanVienReaderWriter nvRW = new NhanVienReaderWriter("./save/");
        // PhongBanReaderWriter pbRW = new PhongBanReaderWriter("./save/");

        FileManager fm = new FileManager();
        fm.read();

        for (NhanSu a : ql.getNhanSus()) {
            System.out.println(a);
        }

        for (PhongBan a : qlpb.getDsPhongBan()) {
            System.out.println(a);
        }

        for (DuAn a : qAn.getDsDuAn()) {
            System.out.println(a);
        }

        // try {
        //     PhongBan[] phongBans = pbRW.read();
        //     for (PhongBan pb : phongBans) {
        //         System.err.println(pb);
        //         qlpb.addPhongBan(pb);
        //     }
        // }
        // catch (Exception e) {
        //     e.printStackTrace();
        // }

        // for (int i = 0; i < 10; i++) {
        //     PhongBan pb = new PhongBan(String.valueOf(i), "Phong " + i, false);
        //     qlpb.addPhongBan(pb);
        // }
        

        // try {
        //     NhanVien[] nhanViens = nvRW.read();
        //     for (NhanVien nv : nhanViens) {
        //         System.err.println(nv);
        //         ql.addNhanSu(nv);
        //     }

        // }
        // catch (Exception e) {
        //     e.printStackTrace();
        // }

        // try {
        //     pbRW.save(qlpb.getDsPhongBan());
        // }
        // catch (Exception e) {
        //     e.printStackTrace();
        // }

        // try {
        //     nvRW.save(ql.getNhanViens());
        // }
        // catch (Exception e) {
        //     e.printStackTrace();
        // }
        


    }
}
