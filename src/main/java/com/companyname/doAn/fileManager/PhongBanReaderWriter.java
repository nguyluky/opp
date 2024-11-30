package com.companyname.doAn.fileManager;

import com.companyname.doAn.type.PhongBan;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.type.DuAn;
import com.companyname.doAn.type.NhanVien;

public class PhongBanReaderWriter implements BaseReader<PhongBan>, BaseWriter<PhongBan> {
    private final String FILE_NAME = "PhongBans.txt";
    private String filePath;
    File file;
    Scanner sc;

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

    private NhanVien[] getDsNhanVien(String text) {
        QuanLyNhanSu qLyNhanSu = QuanLyNhanSu.getInstance();
        String[] listId = text.split(",");
        NhanVien[] listNhanViens = new NhanVien[listId.length];
        int i = 0;
        for (String nvId : listId) {
            listNhanViens[i] = (NhanVien) qLyNhanSu.getNhanSuById(nvId);
            i++;
        }
        return listNhanViens;
    }

    private DuAn[] getDsDuAn(String text) {
        QuanLyDuAn qLyDuAn = QuanLyDuAn.getInstance();
        String[] listId = text.split(",");
        DuAn[] listDuAns = new DuAn[listId.length];
        int i = 0;
        for (String daId : listId) {
            listDuAns[i] = qLyDuAn.getDuAnById(daId);
            i++;
        }
        return listDuAns;
    }

    @Override
    public PhongBan[] read() throws FileNotFoundException {
        sc = new Scanner(file);

        PhongBan[] phongBan = new PhongBan[0];

        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] arr = BaseReader.split(data);
            phongBan = Arrays.copyOf(phongBan, phongBan.length + 1);
            phongBan[phongBan.length - 1] = new PhongBan(
                arr[0],
                arr[1],
                Boolean.parseBoolean(arr[4])
            );

            NhanVien[] dsNhanVien = getDsNhanVien(arr[2]);
            phongBan[phongBan.length - 1].setDsNhanVien(dsNhanVien);

            DuAn[] dsDuAn = getDsDuAn(arr[3]);
            phongBan[phongBan.length - 1].setDsDuAn(dsDuAn);
        }

        return phongBan;
    }

    @Override
    public void save(PhongBan[] data) throws IOException {
        FileWriter writer = new FileWriter(file);

        for (PhongBan phongBan : data) {
            NhanVien[] nhanViens = phongBan.getDsNhanVien();
            String[] listIdNhanVien = new String[nhanViens.length];

            for (int i = 0; i < nhanViens.length; i++) {
                listIdNhanVien[i] = nhanViens[i].getId();
            }

            DuAn[] duAns = phongBan.getDsDuAn();
            String[] listIdDuAn = new String[duAns.length];

            for (int i = 0; i < duAns.length; i++) {
                listIdDuAn[i] = duAns[i].getIdDuAn();
            }

            String[] dataSave = {
                phongBan.getNamePhongBan(),
                phongBan.getIdPhongBan(),
                String.join(",", listIdNhanVien),
                String.join(",", listIdDuAn),
                phongBan.getIsDelete() + ""
            };

            for (int i = 0; i < dataSave.length; i++) {
                dataSave[i] = BaseWriter.escape(dataSave[i]);
            }

            writer.write(String.join(this.separated, dataSave) + "\n");
        }

        writer.close();
    }
}   
