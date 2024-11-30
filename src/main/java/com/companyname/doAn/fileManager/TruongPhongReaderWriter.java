package com.companyname.doAn.fileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.companyname.doAn.type.TruongPhong;

public class TruongPhongReaderWriter implements BaseReader<TruongPhong>, BaseWriter<TruongPhong> {

    private final String FILE_NAME = "TruongPhongs.txt";
    private String filePath;
    File file;
    Scanner sc;

    TruongPhongReaderWriter(String folder) {
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

    public TruongPhong[] read() throws FileNotFoundException {
        sc = new Scanner(file);

        TruongPhong[] truongPhongs = new TruongPhong[0];

        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] arr = BaseReader.split(data);
            truongPhongs = Arrays.copyOf(truongPhongs, truongPhongs.length + 1);
            truongPhongs[truongPhongs.length - 1] = new TruongPhong(
                arr[0],
                arr[1],
                arr[2],
                arr[3],
                Integer.parseInt(arr[4]),
                Integer.parseInt(arr[5]),
                Integer.parseInt(arr[6]),
                Integer.parseInt(arr[7]),
                Boolean.parseBoolean(arr[8])
            );
        }

        return truongPhongs;
    }

    @Override
    public void save(TruongPhong[] data) throws IOException {
        FileWriter writer = new FileWriter(file);

        for (TruongPhong truongPhong : data) {
            String[] dataSave = {
                truongPhong.getId(),
                truongPhong.getName(),
                truongPhong.getPhone(),
                truongPhong.getDiaChi(),
                truongPhong.getNamVaoLam() + "",
                truongPhong.getSoNgayNghi() + "",
                truongPhong.getKinhNghiem() + "",
                truongPhong.getLuongCoBan() + "",
                truongPhong.getIsDelete() + ""
            };

            for (int i = 0; i < dataSave.length; i++) {
                dataSave[i] = BaseWriter.escape(dataSave[i]);
            }

            writer.write(String.join(this.separated, dataSave) + "\n");
        }

        writer.close();
    }

}
