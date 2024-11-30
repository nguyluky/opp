package com.companyname.doAn.fileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import com.companyname.doAn.type.KhenThuong;


public class KhenThuongReaderWriter implements BaseReader<KhenThuong>, BaseWriter<KhenThuong> {

    private final String FILE_NAME = "KhenThuongs.txt";
    private String filePath;
    File file;
    Scanner sc;

    KhenThuongReaderWriter(String folder) {
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

    public KhenThuong[] read() throws FileNotFoundException {
        sc = new Scanner(file);

        KhenThuong[] khenThuong = new KhenThuong[0];

        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] arr = BaseReader.split(data);
            khenThuong = Arrays.copyOf(khenThuong, khenThuong.length + 1);
            khenThuong[khenThuong.length - 1] = new KhenThuong(
                    arr[0],
                    Integer.parseInt(arr[1]));
        }

        return khenThuong;
    }

    @Override
    public void save(KhenThuong[] data) throws IOException {
        FileWriter writer = new FileWriter(file);

        for (KhenThuong khenThuong : data) {
            String[] dataSave = {
                    khenThuong.getLyDo(),
                    khenThuong.getTienThuong() + ""
            };

            for (int i = 0; i < dataSave.length; i++) {
                dataSave[i] = BaseWriter.escape(dataSave[i]);
            }

            writer.write(String.join(this.separated, dataSave) + "\n");
        }

        writer.close();
    }
}
