package com.companyname.doAn.fileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.companyname.doAn.type.GiamDoc;

public class GiamDocReader implements BaseReader<GiamDoc> {

    private final String FILE_NAME = "GiamDocs.txt";
    private String filePath;
    File file;
    Scanner sc;

    GiamDocReader(String folder) {
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

    public GiamDoc[] read() throws FileNotFoundException {
        sc = new Scanner(file);

        GiamDoc[] giamDoc = new GiamDoc[0];
        
        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] arr = BaseReader.split(data);
            giamDoc = new GiamDoc[1];
            giamDoc[0] = new GiamDoc(arr[0], arr[1], arr[2], arr[3], Double.parseDouble(arr[4]), arr[5], Integer.parseInt(arr[6]), Double.parseDouble(arr[7]), Integer.parseInt(arr[8]), Boolean.parseBoolean(arr[9]));
        }

        return giamDoc;
        
    }

}
