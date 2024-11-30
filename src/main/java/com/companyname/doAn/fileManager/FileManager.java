package com.companyname.doAn.fileManager;

import java.io.FileNotFoundException;

import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.ql.QuanLyPhongBan;
import com.companyname.doAn.type.NhanVien;
import com.companyname.doAn.type.PhongBan;
import com.companyname.doAn.type.TruongPhong;

public class FileManager {
    private static FileManager instance = null;

    // TODO: Implement FileManager
    private static final String FOLDER_PATH = "data/";

    NhanVienReaderWriter nhanVienReaderWriter = new NhanVienReaderWriter(FOLDER_PATH);
    DuAnReaderWriter duAnReaderWriter = new DuAnReaderWriter(FOLDER_PATH);
    PhongBanReaderWriter phongBanReaderWriter = new PhongBanReaderWriter(FOLDER_PATH);
    TruongPhongReaderWriter truongPhongReaderWriter = new TruongPhongReaderWriter(FOLDER_PATH);

    public static FileManager getInstance() {
        return instance;
    }

    private FileManager() {
        
    }

    public void loadQuanLyNhanSu() throws FileNotFoundException {
        QuanLyNhanSu quanLyNhanSu = QuanLyNhanSu.getInstance();

        for (NhanVien nv: nhanVienReaderWriter.read()) {
            quanLyNhanSu.addNhanSu(nv);
        }

        for (TruongPhong tp: truongPhongReaderWriter.read()) {
            quanLyNhanSu.addNhanSu(tp);
        }
    }

    public void loadDuAn() throws FileNotFoundException {
        QuanLyDuAn quanLyDuAn = QuanLyDuAn.getInstance();

        for (var da: duAnReaderWriter.read()) {
            quanLyDuAn.addDuAn(da);
        }

    }

    public void loadPhongBan() throws FileNotFoundException {
        QuanLyPhongBan quanLyPhongBan = QuanLyPhongBan.getInstance();

        for (PhongBan pb: phongBanReaderWriter.read()) {
            quanLyPhongBan.addPhongBan(pb);
        }
    }



    public void read() throws FileNotFoundException {

        this.loadQuanLyNhanSu();
        this.loadDuAn();
        this.loadPhongBan();

    }
}
