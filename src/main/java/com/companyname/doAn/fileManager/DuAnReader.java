package com.companyname.doAn.fileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.companyname.doAn.type.DuAn;

public class DuAnReader implements BaseReader<DuAn> {

    private final String FILE_NAME = "DuAns.txt";
    private String filePath;
    File file;
    Scanner sc;

    DuAnReader(String folder) {
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

    public DuAn[] read() throws FileNotFoundException {
        sc = new Scanner(file);

        DuAn[] duAn = new DuAn[0];
        
        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] arr = data.split(" ");
            
        }

        return duAn;
        
    }
    
}
