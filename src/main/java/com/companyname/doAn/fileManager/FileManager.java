package com.companyname.doAn.fileManager;

import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.type.DuAn;

public class FileManager {
    private static FileManager instance = null;

    // TODO: Implement FileManager
    private static final String FOLDER_PATH = "./data";

    public static FileManager getInstance() {
        return instance;
    }

    private FileManager() {
    }

    public void loadQuanLyNhanSu() {
        QuanLyNhanSu qlns = QuanLyNhanSu.getInstance();

        NhanVienReaderWriter nhanVienReader = new NhanVienReaderWriter(FOLDER_PATH);
        GiamDocReader giamDocReader = new GiamDocReader(FOLDER_PATH);
        TruongPhongReader truongPhongReader = new TruongPhongReader(FOLDER_PATH);

        try {
            qlns.setNhanViens(nhanVienReader.read());
            qlns.setGiamDocs(giamDocReader.read());
            qlns.setTruongPhongs(truongPhongReader.read());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        
    }

    public void loadQuanLyDuAn() {
        QuanLyDuAn qla = new QuanLyDuAn();

        DuAnReader duAnReader = new DuAnReader(FOLDER_PATH);

        try {
            DuAn[] duAn = duAnReader.read();
            for(DuAn du: duAn) {
                qla.addDuAn(du);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    
    public void loadQuanLyPhongBan() {

    }

    public void read() {
        this.loadQuanLyNhanSu();
        this.loadQuanLyDuAn();
        this.loadQuanLyPhongBan();
    }
}
