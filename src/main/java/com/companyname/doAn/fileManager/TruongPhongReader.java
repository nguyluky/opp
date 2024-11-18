package com.companyname.doAn.fileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import com.companyname.doAn.type.TruongPhong;

public class TruongPhongReader implements BaseReader<TruongPhong> {

    private final String FILE_NAME = "TruongPhongs.txt";
    private String filePath;
    File file;
    Scanner sc;

    public String getFILE_NAME() {
        return FILE_NAME;
    }

    TruongPhongReader(String folder) {
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

        TruongPhong[] truongPhong = new TruongPhong[0];

        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] arr = data.split(" ");
            truongPhong = Arrays.copyOf(truongPhong, truongPhong.length + 1);
            truongPhong[truongPhong.length] = new TruongPhong(arr[0], arr[1], arr[2], arr[3],
                    Double.parseDouble(arr[4]), arr[5], Integer.parseInt(arr[6]), Double.parseDouble(arr[7]),
                    Integer.parseInt(arr[8]));
        }

        return truongPhong;
    }

}
