package com.companyname.doAn;

import com.companyname.doAn.fileManager.NhanVienReaderWriter;
import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.type.NhanSu;
import com.companyname.doAn.type.NhanVien;

public class test {
    public static void main(String[] args) {
        QuanLyNhanSu quanLyNhanSu = QuanLyNhanSu.getInstance();

        NhanVien nv1 = new NhanVien("1", "Nguyen Van A", "01/01/1990", "Ha Noi", 2024, 0, 1,3_000_000, false);
        NhanVien nv2 = new NhanVien("2", "Nguyen Van B", "01/01/1990", "Ha Noi", 2024, 0, 1,3_000_000, false);
        NhanVien nv3 = new NhanVien("3", "Nguyen Van C", "01/01/1990", "Ha Noi", 2024, 0, 1,3_000_000, false);

        quanLyNhanSu.addNhanSu(nv1);
        quanLyNhanSu.addNhanSu(nv2);
        quanLyNhanSu.addNhanSu(nv3);

        quanLyNhanSu.printDsNhanSuDangLam();

        NhanVienReaderWriter nhanVienReaderWriter = new NhanVienReaderWriter("data/");

        try {
            nhanVienReaderWriter.save(quanLyNhanSu.getNhanViens());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
