package com.companyname.doAn.fileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.companyname.doAn.type.KhenThuong;
import com.companyname.doAn.type.KyLuat;
import com.companyname.doAn.type.NhanVien;

public class NhanVienReaderWriter extends NhanSuReaderWriter<NhanVien> {

    public NhanVienReaderWriter(String folder) {
        super(NhanVien.class, folder + "NhanViens.txt");
    }
}
