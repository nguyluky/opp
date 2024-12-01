package com.companyname.doAn.fileManager;

import com.companyname.doAn.type.PhongBan;
import com.companyname.doAn.type.TruongPhong;

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
        NhanVien[] listNhanViens = new NhanVien[0];
        int i = 0;
        for (String nvId : listId) {
            if (nvId.equals("")) {
                continue;
            }
            listNhanViens = Arrays.copyOf(listNhanViens, listNhanViens.length + 1);
            listNhanViens[i] = (NhanVien) qLyNhanSu.getNhanSuById(nvId);
            i++;
        }
        return listNhanViens;
    }

    private DuAn[] getDsDuAn(String text) {
        QuanLyDuAn qLyDuAn = QuanLyDuAn.getInstance();
        String[] listId = text.split(",");
        DuAn[] listDuAns = new DuAn[0];
        int i = 0;
        for (String daId : listId) {
            if (daId.equals("")) {
                continue;
            }
            listDuAns = Arrays.copyOf(listDuAns, listDuAns.length + 1);
            listDuAns[i] = qLyDuAn.getDuAnById(daId);
            i++;
        }
        return listDuAns;
    }

    @Override
    public PhongBan[] read() throws FileNotFoundException {
        sc = new Scanner(file);
        QuanLyNhanSu qLyNhanSu = QuanLyNhanSu.getInstance();

        PhongBan[] phongBan = new PhongBan[0];

        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] arr = BaseReader.split(data);
            phongBan = Arrays.copyOf(phongBan, phongBan.length + 1);
            phongBan[phongBan.length - 1] = new PhongBan(
                arr[0],
                arr[1],
                Boolean.parseBoolean(arr[5])
            );

            NhanVien[] dsNhanVien = getDsNhanVien(arr[2]);
            phongBan[phongBan.length - 1].setDsNhanVien(dsNhanVien);

            DuAn[] dsDuAn = getDsDuAn(arr[3]);
            phongBan[phongBan.length - 1].setDsDuAn(dsDuAn);

            if (!arr[4].equals("")) {
                // System.out.println(arr[4]);
                phongBan[phongBan.length - 1].setTruongPhong((TruongPhong) (qLyNhanSu.getNhanSuById(arr[4])));
            }
        

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

            String truongPhongId = "";

            if (phongBan.getTruongPhong() != null) {
                truongPhongId = phongBan.getTruongPhong().getId();
            }

            String[] dataSave = {
                phongBan.getNamePhongBan(),
                phongBan.getIdPhongBan(),
                String.join(",", listIdNhanVien),
                String.join(",", listIdDuAn),
                truongPhongId,
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
