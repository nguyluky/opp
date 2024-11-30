package com.companyname.doAn.fileManager;

import com.companyname.doAn.ql.QuanLyNhanSu;

public class FileManager {
    private static FileManager instance = null;


    // TODO: Implement FileManager
    private static final String FOLDER_PATH = "";

    public static FileManager getInstance() {
        return instance;
    }

    private FileManager() {
    }

    public void loadQuanLyNhanSu() {
//        QuanLyNhanSu qlns = QuanLyNhanSu.getInstance();
//
//        NhanVienReader nhanVienReader = new NhanVienReader(FOLDER_PATH);
//        GiamDocReader giamDocReader = new GiamDocReader(FOLDER_PATH);
//        TruongPhongReader truongPhongReader = new TruongPhongReader(FOLDER_PATH);
//
//        try {
//            qlns.setNhanViens(nhanVienReader.read());
//            qlns.setGiamDocs(giamDocReader.read());
//            qlns.setTruongPhongs(truongPhongReader.read());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
    }

    public void read() {

        this.loadQuanLyNhanSu();
    }
}
