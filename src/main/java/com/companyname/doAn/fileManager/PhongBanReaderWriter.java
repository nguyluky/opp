package com.companyname.doAn.fileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.type.NhanSu;
import com.companyname.doAn.type.NhanVien;
import com.companyname.doAn.type.PhongBan;
import com.companyname.doAn.type.TruongPhong;


public class PhongBanReaderWriter implements BaseReader<PhongBan> , BaseWriter<PhongBan> {
    
    private final String FILE_NAME = "PhongBans.txt";
    private String filePath;
    File file;
    Scanner sc;

    public String getFILE_NAME() {
        return FILE_NAME;
    }

    public PhongBanReaderWriter(String folder) {
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

    public PhongBan[] read() throws FileNotFoundException {
        sc = new Scanner(file);

        PhongBan[] phongBan = new PhongBan[0];

        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] arr = BaseReader.split(data);

            if (arr.length != 4) {
                System.err.println("Invalid data: " + data);
                System.exit(-1);
            }

            phongBan = Arrays.copyOf(phongBan, phongBan.length + 1);
            phongBan[phongBan.length - 1] = new PhongBan(arr[0], arr[1], Boolean.parseBoolean(arr[2]));
        }

        return phongBan;
    }

    public void save(PhongBan[] phongBans) throws IOException{

        FileWriter fw = new FileWriter(this.file);
        
        for (PhongBan pb: phongBans) {
            
            NhanVien[] dsNhanVien = pb.getDsNhanVien();
            String []listNhanVien = new String[dsNhanVien.length - 1];

            for (int i = 0; i < dsNhanVien.length; i++) {
                listNhanVien[i] = dsNhanVien[i].getId();
            }

            String[] data = {
                pb.getIdPhongBan(),
                pb.getNamePhongBan(),
                String.join(",", listNhanVien),
                pb.isDelete() + ""
            };

            for (int i = 0; i < data.length ; i++) {
                data[i] = BaseWriter.escape(data[i]);
            }
            

            fw.write(String.join(this.separated, data) + "\n");
        }

        fw.close();
    }

}
