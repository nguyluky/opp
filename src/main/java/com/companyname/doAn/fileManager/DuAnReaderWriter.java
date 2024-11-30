package com.companyname.doAn.fileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.type.DuAn;
import com.companyname.doAn.type.NhanSu;
import com.companyname.doAn.type.NhanVien;

public class DuAnReaderWriter implements BaseReader<DuAn>, BaseWriter<DuAn> {

    private final String FILE_NAME = "DuAns.txt";
    private String filePath;
    File file;
    Scanner sc;

    public DuAnReaderWriter(String folder) {
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

    private NhanSu[] getDsNhanVien(String text) {
        QuanLyNhanSu qLyNhanSu = QuanLyNhanSu.getInstance();
        String []listId = text.split(",");
        NhanSu []listNhanViens = new NhanSu[listId.length];
        int i = 0;
        for (String nvId : listId) {
            listNhanViens[i] = qLyNhanSu.getNhanSuById(nvId);
            i++;
        }
        return listNhanViens;
    }

    public DuAn[] read() throws FileNotFoundException {
        sc = new Scanner(file);

        DuAn[] duAn = new DuAn[0];

        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] arr = BaseReader.split(data);
            duAn = Arrays.copyOf(duAn, duAn.length + 1);
            duAn[duAn.length - 1] = new DuAn(
                arr[0],
                arr[1],
                Boolean.parseBoolean(arr[2])
            );

            NhanSu[] dsNhanSu = getDsNhanVien(arr[3]);
            duAn[duAn.length - 1].setDsNhanSu(dsNhanSu);
        }

        return duAn;
    }
    
    @Override
    public void save(DuAn[] data) throws IOException {
        FileWriter writer = new FileWriter(file);

        for (DuAn duAn : data) {
            NhanSu[] nhanViens = duAn.getDsNhanSu();
            String []listIdNhanVien = new String[nhanViens.length];

            for (int i = 0; i < nhanViens.length; i++) {
                listIdNhanVien[i] = nhanViens[i].getId();
            }

            String[] dataSave = {
                duAn.getIdDuAn(),
                duAn.getNameDuAn(),
                duAn.getIsDelete() + "",
                String.join(",", listIdNhanVien)
            };

            for (int i = 0; i < dataSave.length ; i++) {
                dataSave[i] = BaseWriter.escape(dataSave[i]);
            }

            writer.write(String.join(this.separated, dataSave) + "\n");
        }

        writer.close();
    }
}