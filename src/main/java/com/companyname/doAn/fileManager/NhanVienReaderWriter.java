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

    String klToString(KyLuat[] kl) {

        String[] klStr = new String[0];

        int i = 0;
        for (KyLuat k: kl) {
            if (k == null) {
                continue;
            }
            klStr = Arrays.copyOf(klStr, klStr.length + 1);
            klStr[i] = k.toString();
            i++;
        }
        return String.join("|", klStr);
    }

    KyLuat[] StringToKls(String klStr) {
        String[] klStrs = klStr.split("\\|");
        KyLuat[] kls = new KyLuat[0];

        for (int i = 0; i < klStrs.length; i++) {
            if (klStrs[i].equals("")) {
                continue;
            }
            kls = Arrays.copyOf(kls, kls.length + 1);
            String[] kl = klStrs[i].split("-");
            kls[i] = new KyLuat(kl[0], Integer.parseInt(kl[1]));
        }

        return kls;
    }

    String ktToString(KhenThuong[] kt) {
        String[] ktStr = new String[0];

        int i = 0;
        for (KhenThuong k: kt) {
            if (k == null) {
                continue;
            }
            ktStr = Arrays.copyOf(ktStr, ktStr.length + 1);
            ktStr[i] = k.toString();
            i++;
        }
        return String.join("|", ktStr);
    }

    KhenThuong[] StringToKts(String ktStr) {
        String[] ktStrs = ktStr.split("\\|");
        KhenThuong[] kts = new KhenThuong[0];

        for (int i = 0; i < ktStrs.length; i++) {
            if (ktStrs[i].equals("")) {
                continue;
            }
            kts = Arrays.copyOf(kts, kts.length + 1);
            String[] kt = ktStrs[i].split("-");
            kts[i] = new KhenThuong(kt[0], Integer.parseInt(kt[1]));
        }

        return kts;
    }

    public NhanVien[] read() throws FileNotFoundException {
        sc = new Scanner(file);

        NhanVien[] nhanVienS = new NhanVien[0];

        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            if (data.equals("")) {
                continue;
            }
            String[] arr = BaseReader.split(data);

            if (arr.length < 11) {
                System.err.println("File " + FILE_NAME + " is corrupted");
                System.exit(-1);
            }

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
                    StringToKls(arr[8]),
                    StringToKts(arr[9]),
                    Boolean.parseBoolean(arr[10]));

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
                klToString(nv.getDsKyLuat()),
                ktToString(nv.getDsKhenThuong()),
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
