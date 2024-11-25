package com.companyname.doAn.fileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.type.DuAn;
import com.companyname.doAn.type.NhanVien;

public class DuAnReader implements BaseReader<DuAn> {

    private final String FILE_NAME = "DuAns.txt";
    private String filePath;
    File file;
    Scanner sc;

    DuAnReader(String folder) {
        this.filePath = folder + FILE_NAME;
        file = new File(this.filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String[] getDsNhanVienID(String text) {
        return new String[0];
    }

    public DuAn[] read() throws FileNotFoundException {
        sc = new Scanner(file);

        DuAn[] duAn = new DuAn[0];

        NhanVien[] nhanViens = QuanLyNhanSu.getInstance().getNhanViens();
        
        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] arr = data.split(" ");
            duAn = Arrays.copyOf(duAn, duAn.length + 1);
            NhanVien []arrtem = new NhanVien[0];
            duAn[duAn.length - 1] = new DuAn(arr[0], arr[1], arrtem , Boolean.parseBoolean(arr[2]));

            String[] dsNhanVienID = getDsNhanVienID(arr[3]);
            for (String id : dsNhanVienID) {
                for (NhanVien nv: nhanViens) {
                    if (nv.getId() == id) duAn[duAn.length - 1].addNhanVien(nv);
                }
            }
        }

        return duAn;
    }
    
    public void save() {

    }
}
