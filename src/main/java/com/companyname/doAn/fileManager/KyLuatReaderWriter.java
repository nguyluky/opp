package com.companyname.doAn.fileManager;

import com.companyname.doAn.type.KyLuat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class KyLuatReaderWriter implements BaseReader<KyLuat>, BaseWriter<KyLuat> {

    private final String FILE_NAME = "KyLuats.txt";
    private String filePath;
    File file;
    Scanner sc;

    KyLuatReaderWriter(String folder) {
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

    public KyLuat[] read() throws FileNotFoundException {
        sc = new Scanner(file);

        KyLuat[] kyLuat = new KyLuat[0];

        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] arr = BaseReader.split(data);
            kyLuat = Arrays.copyOf(kyLuat, kyLuat.length + 1);
            kyLuat[kyLuat.length - 1] = new KyLuat(
                    arr[0],
                    Integer.parseInt(arr[1]));
        }

        return kyLuat;
    }

    @Override
    public void save(KyLuat[] data) throws IOException {
        FileWriter writer = new FileWriter(file);

        for (KyLuat kyLuat : data) {
            String[] dataSave = {
                    kyLuat.getLyDo(),
                    kyLuat.getTienPhat() + ""
            };

            for (int i = 0; i < dataSave.length; i++) {
                dataSave[i] = BaseWriter.escape(dataSave[i]);
            }

            writer.write(String.join(this.separated, dataSave) + "\n");
        }

        writer.close();
    }
}
