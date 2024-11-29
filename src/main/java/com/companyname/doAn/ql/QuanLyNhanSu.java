package com.companyname.doAn.ql;

import java.util.Arrays;

import com.companyname.doAn.type.GiamDoc;
import com.companyname.doAn.type.NhanSu;
import com.companyname.doAn.type.NhanVien;
import com.companyname.doAn.type.TruongPhong;

public class QuanLyNhanSu {
    private NhanSu dsNhanSu[];
    private static QuanLyNhanSu instance = null;

    public static QuanLyNhanSu getInstance(){
        if(instance == null){
            instance = new QuanLyNhanSu();
        }
        return instance;
    }

    public QuanLyNhanSu(){
        instance = this;
        this.dsNhanSu = new NhanSu[0];
    }

    public void addNhanSu(NhanSu nhanSu) {
        this.dsNhanSu = Arrays.copyOf(this.dsNhanSu, this.dsNhanSu.length + 1);
        this.dsNhanSu[this.dsNhanSu.length - 1] = nhanSu;
    }

    public void removeNhanSu(String id) {
        for (int i = 0; i < this.dsNhanSu.length; i++) {
            if (this.dsNhanSu[i].getId().equals(id)) {
                this.dsNhanSu[i] = this.dsNhanSu[this.dsNhanSu.length - 1];
                break;
            }
        }

        this.dsNhanSu[this.dsNhanSu.length - 1].setDelete(true);
    }

    public NhanSu[] getDsNhanSu() {
        NhanSu newNhanSus[] = new NhanSu[0];
        for (NhanSu nhanSu : this.dsNhanSu) {
            if (!nhanSu.getIsDelete()) {
                newNhanSus = Arrays.copyOf(newNhanSus, newNhanSus.length + 1);
                newNhanSus[newNhanSus.length - 1] = nhanSu;
            }
        }
        return newNhanSus;
    }

    public NhanVien[] getDsNhanVien() {
        NhanVien[] nhanViens = new NhanVien[0];
        for (NhanSu nhanSu : this.dsNhanSu) {
            if (nhanSu instanceof NhanVien && !nhanSu.getIsDelete()) {
                nhanViens = Arrays.copyOf(nhanViens, nhanViens.length + 1);
                nhanViens[nhanViens.length - 1] = (NhanVien) nhanSu;
            }
        }
        return nhanViens;
    }

    public NhanSu getNhanSuById(String id) {
        for (NhanSu nhanSu : this.dsNhanSu) {
            if (nhanSu.getId().equals(id)) {
                return nhanSu;
            }
        }
        return null;
    }

    public GiamDoc[] getGiamDocs() {
        GiamDoc[] giamDocs = new GiamDoc[0];
        for (NhanSu nhanSu : this.dsNhanSu) {
            if (nhanSu instanceof GiamDoc && !nhanSu.getIsDelete()) {
                giamDocs = Arrays.copyOf(giamDocs, giamDocs.length + 1);
                giamDocs[giamDocs.length - 1] = (GiamDoc) nhanSu;
            }
        }
        return giamDocs;
    }

    public TruongPhong[] getTruongPhongs() {
        TruongPhong[] truongPhongs = new TruongPhong[0];
        for (NhanSu nhanSu : this.dsNhanSu) {
            if (nhanSu instanceof TruongPhong && !nhanSu.getIsDelete()) {
                truongPhongs = Arrays.copyOf(truongPhongs, truongPhongs.length + 1);
                truongPhongs[truongPhongs.length - 1] = (TruongPhong) nhanSu;
            }
        }
        return truongPhongs;
    }

    public void setNhanViens(NhanVien[] nhanViens) {
        for (NhanVien nhanVien : nhanViens) {
            this.addNhanSu(nhanVien);
        }
    }

    public void setGiamDocs(GiamDoc[] giamDocs) {
        for (GiamDoc giamDoc : giamDocs) {
            this.addNhanSu(giamDoc);
        }
    }

    public void setTruongPhongs(TruongPhong[] truongPhongs) {
        for (TruongPhong truongPhong : truongPhongs) {
            this.addNhanSu(truongPhong);
        }
    }


    public void pirntDsNhanSuDangLam(){
        int i=1;
        System.out.println("Danh sách nhân sự đang làm:");
        for(NhanSu ns : this.getDsNhanSu()){
            if(ns.getIsDelete()) {
                System.out.println("Nhân sự thứ " + i + " :" + ns.getName() + ". Mã: " + ns.getId());
                i++;
            }
        }
    }
    public void pirntDsNhanSuDaNghi(){
        int i=1;
        System.out.println("Danh sách nhân sự đã nghỉ:");
        for(NhanSu ns : this.getDsNhanSu()){
            if(!ns.getIsDelete()) {
                System.out.println("Nhân sự thứ " + i + " :" + ns.getName() + ". Mã: " + ns.getId());
                i++;
            }
        }
    }
}
