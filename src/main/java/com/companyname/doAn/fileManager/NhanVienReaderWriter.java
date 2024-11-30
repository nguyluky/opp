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

    public NhanVienReaderWriter(String folder) {
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

            NhanVien newNhanVien = new NhanVien(
                    arr[0],
                    arr[1],
                    arr[2],
                    arr[3],
                    Integer.parseInt(arr[4]),
                    Integer.parseInt(arr[5]),
                    Integer.parseInt(arr[6]),
                    Integer.parseInt(arr[7]),
                    Boolean.parseBoolean(arr[8]));

            nhanVienS[nhanVienS.length - 1] = newNhanVien;
        }
        return nhanVienS;
    }

    @Override
    public void save(NhanVien[] data) throws IOException {
        FileWriter writer = new FileWriter(file);

        for (NhanVien nv: data) {
            String dataSave[] = {
                nv.getId(),
                nv.getName(),
                nv.getPhone(),
                nv.getDiaChi(),
                nv.getNamVaoLam() + "",
                nv.getSoNgayNghi() + "",
                nv.getKinhNghiem() + "",
                nv.getLuongCoBan() + "",
                nv.getIsDelete() + ""
            };

            for (int i = 0; i < dataSave.length ; i++) {
                dataSave[i] = BaseWriter.escape(dataSave[i]);
            }

            writer.write(String.join(this.separated, dataSave) + "\n");
        }

        writer.close();
    }
}
