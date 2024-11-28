package com.companyname.doAn.fileManager;

import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.ql.QuanLyPhongBan;
import com.companyname.doAn.type.DuAn;
import com.companyname.doAn.type.PhongBan;

public class FileManager {
    private static FileManager instance = null;

    QuanLyNhanSu qlns;
    NhanVienReaderWriter nhanVienReader;
    GiamDocReaderWriter giamDocReader;
    TruongPhongReaderWriter truongPhongReader;

    // TODO: Implement FileManager
    private static final String FOLDER_PATH = "./save/";

    public static FileManager getInstance() {
        return instance;
    }

    public FileManager() {
        qlns = QuanLyNhanSu.getInstance();
        nhanVienReader = new NhanVienReaderWriter(FOLDER_PATH);
        giamDocReader = new GiamDocReaderWriter(FOLDER_PATH);
        truongPhongReader = new TruongPhongReaderWriter(FOLDER_PATH);
    }

    public void loadQuanLyNhanSu() {
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

        DuAnReaderWriter duAnReader = new DuAnReaderWriter(FOLDER_PATH);

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
        PhongBanReaderWriter phongBanReader = new PhongBanReaderWriter(FOLDER_PATH);
        QuanLyPhongBan qlpb = new QuanLyPhongBan();
        try {
            PhongBan[] dPhongBans = phongBanReader.read();
            qlpb.setDsPhongBan(dPhongBans);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void read() {
        this.loadQuanLyNhanSu();
        this.loadQuanLyDuAn();
        this.loadQuanLyPhongBan();
    }
}
