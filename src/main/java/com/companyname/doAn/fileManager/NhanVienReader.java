package com.companyname.doAn.fileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import com.companyname.doAn.type.NhanVien;

public class NhanVienReader implements BaseReader<NhanVien> {

    private final String FILE_NAME = "NhanViens.txt";

    private String filePath;
    File file;
    Scanner sc;

    public String getFILE_NAME() {
        return FILE_NAME;
    }

    NhanVienReader(String folder) {
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

    public NhanVien[] read() throws FileNotFoundException {
//        sc = new Scanner(file);
//
//        NhanVien[] nhanVienS = new NhanVien[0];
//
//        while (sc.hasNextLine()) {
//            String data = sc.nextLine();
//            String[] arr = data.split(" ");
//            nhanVienS = Arrays.copyOf(nhanVienS, nhanVienS.length + 1);
//            nhanVienS[nhanVienS.length] = new NhanVien(arr[0], arr[1], arr[2], arr[3],
//                    Double.parseDouble(arr[4]), arr[5], Integer.parseInt(arr[6]), Double.parseDouble(arr[7]),
//                    Integer.parseInt(arr[8]));
//        }
//
//        return nhanVienS;
        return new NhanVien[0]; //hieu them de chạy main, co the xoa
    }
    
}
