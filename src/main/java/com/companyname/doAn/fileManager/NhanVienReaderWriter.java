package com.companyname.doAn.fileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.companyname.doAn.type.NhanVien;

public class NhanVienReaderWriter implements BaseReader<NhanVien>, BaseWriter<NhanVien> {

    private final String FILE_NAME = "NhanViens.txt";

    private String filePath;
    File file;
    Scanner sc;

    public String getFILE_NAME() {
        return FILE_NAME;
    }

    NhanVienReaderWriter(String folder) {
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
        sc = new Scanner(file);

        NhanVien[] nhanVienS = new NhanVien[0];

        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] arr = BaseReader.split(data);
            nhanVienS = Arrays.copyOf(nhanVienS, nhanVienS.length + 1);
            nhanVienS[nhanVienS.length] = new NhanVien(arr[0], arr[1], arr[2], arr[3],
                    Double.parseDouble(arr[4]), arr[5], Integer.parseInt(arr[6]), Double.parseDouble(arr[7]),
                    Integer.parseInt(arr[8]), Boolean.parseBoolean(arr[9]));
        }

        sc.close();
        return nhanVienS;
    }

    public void save(NhanVien[] dNhanViens) throws IOException {

        FileWriter fw = new FileWriter(this.file);

        for (NhanVien nv: dNhanViens) {
            String[] data = {
                nv.getId(),
                nv.getName(),
                nv.getPhone(),
                nv.getDaiChi(),
                nv.getNamVaoLam() + "",
                nv.getHeSoThiDua(),
                nv.getKingNghiep() + "",
                nv.getHeSoPhucLoi() + "",
                nv.getSoNgayNghi() + "",
                nv.isDelete() + ""
            };

            for (int i = 0; i < data.length ; i++) {
                data[i] = BaseWriter.escape(data[i]);
            }

            String line = String.join(this.separated, data);

            fw.append(line + "\n");
        }

        fw.close();
    }
    
}
