package com.companyname.doAn;

import com.companyname.doAn.fileManager.NhanVienReaderWriter;
import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.type.NhanVien;

public class mainTest {
    public static void main(String[] args) {
        System.out.println("Hello World");
        QuanLyNhanSu ql = new QuanLyNhanSu();

        NhanVien nv = new NhanVien("1", "Nguyen Van A", "01/01/1990", "Ha Noi", 10000000, "0123456789", 1, 1, 1, true);
        NhanVien nv2 = new NhanVien("2", "Nguyen Van B", "01/01/1990", "Ha Noi", 10000000, "0123456789", 1, 1, 1, true);
        NhanVien nv3 = new NhanVien("3", "Nguyen Van C", "01/01/1990", "Ha Noi", 10000000, "0123456789", 1, 1, 1, true);
        NhanVien nv4 = new NhanVien("4", "Nguyen Van D", "01/01/1990", "Ha Noi", 10000000, "0123456789", 1, 1, 1, true);

        ql.addNhanSu(nv);
        ql.addNhanSu(nv2);
        ql.addNhanSu(nv3);
        ql.addNhanSu(nv4);


        NhanVienReaderWriter nvRW = new NhanVienReaderWriter("./save/");

        try {
            nvRW.save(ql.getNhanViens());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
