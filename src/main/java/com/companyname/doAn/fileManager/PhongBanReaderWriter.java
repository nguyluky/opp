package com.companyname.doAn.fileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.type.NhanSu;
import com.companyname.doAn.type.PhongBan;
import com.companyname.doAn.type.TruongPhong;


public class PhongBanReaderWriter implements BaseReader<PhongBan> , BaseWriter<PhongBan> {
    
    private final String FILE_NAME = "TruongPhongs.txt";
    private String filePath;
    File file;
    Scanner sc;

    public String getFILE_NAME() {
        return FILE_NAME;
    }

    PhongBanReaderWriter(String folder) {
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

        QuanLyNhanSu qlns = QuanLyNhanSu.getInstance();

        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] arr = BaseReader.split(data);
            phongBan = Arrays.copyOf(phongBan, phongBan.length + 1);

            TruongPhong tp = (TruongPhong) qlns.getNhanSuById(arr[2]);
            phongBan[phongBan.length] = new PhongBan(arr[0], arr[1], tp);
        }

        return phongBan;
    }

    public void save(PhongBan[] phongBans) throws IOException{

        FileWriter fw = new FileWriter(this.file);
        
        for (PhongBan pb: phongBans) {
            String[] data = {
                pb.getIdPhongBan(),
                pb.getNamePhongBan(),
                pb.getTruongPhong().getId(),
                "",
                pb.isDelete() + ""
            };



            for (NhanSu ns: pb.getNhanSu()) {
                data[3] += ns.getId() + ",";
            }

            data[3] = data[3].substring(0, data[3].length() - 1);

            for (int i = 0; i < data.length ; i++) {
                data[i] = BaseWriter.escape(data[i]);
            }
            

            fw.write(String.join(",", data) + "\n");
        }

        fw.close();
    }

}
