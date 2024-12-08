package com.companyname.doAn.fileManager;

import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.type.DuAn;
import com.companyname.doAn.type.NhanVien;
import com.companyname.doAn.type.PhongBan;
import com.companyname.doAn.type.TruongPhong;

import java.util.Arrays;

public class PhongBanReaderWriter extends FileReaderWriter<PhongBan> {
    public PhongBanReaderWriter(String folder) {
        super(PhongBan.class, folder + "PhongBans.txt");
    }

    @Override
    String valueToString(String fieldName, Object value) {
        if (value == null) return "";
        switch (fieldName) {
            case "dsNhanVien": {
                NhanVien[] nvs = (NhanVien[]) value;
                String[] ids = new String[nvs.length];
                for (int i =0; i< nvs.length; i++) {
                    ids[i] = nvs[i].getId();
                }
                return String.join(",", ids);
            }
            case "truongPhong": {
                TruongPhong[] tps = (TruongPhong[]) value;
                String[] ids = new String[tps.length];
                for (int i = 0; i < tps.length; i++) {
                    ids[i] = tps[i].getId();
                }
                return String.join(",", ids);
            }
            case "dsDuAn": {
                DuAn[] ans = (DuAn[]) value;
                String[] ids = new String[ans.length];
                for (int i = 0; i < ans.length; i++) {
                    ids[i] = ans[i].getIdDuAn();
                }

                return String.join(",", ids);
            }
        }

        return null;
    }


    @Override
    Object stringToValue(Class fieldType, String value) {
        if (fieldType == NhanVien[].class) {
            String[] ids = value.split(",");

            NhanVien[] nhanViens = new NhanVien[0];
            for (String id: ids) {
                NhanVien nv = QuanLyNhanSu.getInstance().getNhanVienById(id);
                if (nv != null) {
                    nhanViens = Arrays.copyOf(nhanViens, nhanViens.length + 1);
                    nhanViens[nhanViens.length - 1] = nv;
                }
            }
            return nhanViens;
        }
        if (fieldType == TruongPhong[].class) {
            String[] ids = value.split(",");

            TruongPhong[] tps = new TruongPhong[0];
            for (String id: ids) {
                TruongPhong nv = (TruongPhong) QuanLyNhanSu.getInstance().getNhanSuById(id);
                if (nv != null) {
                    tps = Arrays.copyOf(tps, tps.length + 1);
                    tps[tps.length - 1] = nv;
                }
            }
            return tps;
        }
        if (fieldType == DuAn[].class) {
            String[] ids = value.split(",");

            DuAn[] duAns = new DuAn[0];

            for(String id: ids) {
                DuAn duAn = QuanLyDuAn.getInstance().getDuAnById(id);
                if (duAn != null) {
                    duAns = Arrays.copyOf(duAns, duAns.length + 1);
                    duAns[duAns.length-1] = duAn;
                }
            }

            return duAns;
        }

        return super.stringToValue(fieldType, value);
    }
    
}   
