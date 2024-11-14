package com.companyname.doAn;

import java.util.Arrays;

public class DsNhanSu {
    
    private NhanSu[] nhanSus = new NhanSu[0];
    private DsNhanSu instance;
    public DsNhanSu getInstance() {
        return instance;
    }

    public DsNhanSu() {}

    public void addNhanSu(NhanSu nhanSu) {
        this.nhanSus = Arrays.copyOf(this.nhanSus, this.nhanSus.length + 1);
        this.nhanSus[this.nhanSus.length - 1] = nhanSu;
    }

    public void removeNhanSu(String id) {

        for (int i = 0; i < this.nhanSus.length; i++) {
            if (this.nhanSus[i].getId().equals(id)) {
                for (int j = i; j < this.nhanSus.length - 1; j++) {
                    this.nhanSus[j] = this.nhanSus[j + 1];
                }
                this.nhanSus = Arrays.copyOf(this.nhanSus, this.nhanSus.length - 1);
                break;
            }
        }
    }

    public NhanSu[] getNhanSus() {
        return this.nhanSus;
    }

    public NhanVien[] getNhanViens() {
        NhanVien[] nhanViens = new NhanVien[0];
        for (NhanSu nhanSu : this.nhanSus) {
            if (nhanSu instanceof NhanVien) {
                nhanViens = Arrays.copyOf(nhanViens, nhanViens.length + 1);
                nhanViens[nhanViens.length - 1] = (NhanVien) nhanSu;
            }
        }
        return nhanViens;
    }

    public NhanSu getNhanSuById(String id) {
        for (NhanSu nhanSu : this.nhanSus) {
            if (nhanSu.getId().equals(id)) {
                return nhanSu;
            }
        }
        return null;
    }

    public GiamDoc[] getGiamDocs() {
        GiamDoc[] giamDocs = new GiamDoc[0];
        for (NhanSu nhanSu : this.nhanSus) {
            if (nhanSu instanceof GiamDoc) {
                giamDocs = Arrays.copyOf(giamDocs, giamDocs.length + 1);
                giamDocs[giamDocs.length - 1] = (GiamDoc) nhanSu;
            }
        }
        return giamDocs;
    }

    public TruongPhong[] getTruongPhongs() {
        TruongPhong[] truongPhongs = new TruongPhong[0];
        for (NhanSu nhanSu : this.nhanSus) {
            if (nhanSu instanceof TruongPhong) {
                truongPhongs = Arrays.copyOf(truongPhongs, truongPhongs.length + 1);
                truongPhongs[truongPhongs.length - 1] = (TruongPhong) nhanSu;
            }
        }
        return truongPhongs;
    }

    
}
