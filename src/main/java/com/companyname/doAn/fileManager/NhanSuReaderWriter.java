package com.companyname.doAn.fileManager;

import java.util.Arrays;

import com.companyname.doAn.type.KhenThuong;
import com.companyname.doAn.type.KyLuat;
import com.companyname.doAn.type.NhanSu;
import com.companyname.doAn.type.NhanVien;

public abstract class NhanSuReaderWriter<T extends NhanSu> extends FileReaderWriter<T> {
    public NhanSuReaderWriter(Class<T> clazz, String filePath) {
        super(clazz, filePath);
    }

    String klToString(KyLuat[] kl) {

        String[] klStr = new String[0];

        int i = 0;
        for (KyLuat k: kl) {
            if (k == null) {
                continue;
            }
            klStr = Arrays.copyOf(klStr, klStr.length + 1);
            klStr[i] = k.toString();
            i++;
        }
        return String.join("|", klStr);
    }

    String ktToString(KhenThuong[] kt) {
        String[] ktStr = new String[0];

        int i = 0;
        for (KhenThuong k: kt) {
            if (k == null) {
                continue;
            }
            ktStr = Arrays.copyOf(ktStr, ktStr.length + 1);
            ktStr[i] = k.toString();
            i++;
        }
        return String.join("|", ktStr);
    }

    KyLuat[] StringToKls(String klStr) {
        String[] klStrs = klStr.split("\\|");
        KyLuat[] kls = new KyLuat[0];

        for (int i = 0; i < klStrs.length; i++) {
            if (klStrs[i].equals("")) {
                continue;
            }
            kls = Arrays.copyOf(kls, kls.length + 1);
            String[] kl = klStrs[i].split("-");
            kls[i] = new KyLuat(kl[0], Integer.parseInt(kl[1]));
        }

        return kls;
    }

    KhenThuong[] StringToKts(String ktStr) {
        String[] ktStrs = ktStr.split("\\|");
        KhenThuong[] kts = new KhenThuong[0];

        for (int i = 0; i < ktStrs.length; i++) {
            if (ktStrs[i].equals("")) {
                continue;
            }
            kts = Arrays.copyOf(kts, kts.length + 1);
            String[] kt = ktStrs[i].split("-");
            kts[i] = new KhenThuong(kt[0], Integer.parseInt(kt[1]));
        }

        return kts;
    }


    @Override
    String valueToString(String fieldName, Object value) {
        if (value instanceof KyLuat[]) {
            KyLuat[] dKyLuats = (KyLuat[]) value;
            return this.klToString(dKyLuats);
        }
        if (value instanceof KhenThuong[]) {
            return this.ktToString((KhenThuong[]) value);
        }
        return null;
    }

    @Override
    Object stringToValue(Class fieldType, String value) {
        if (fieldType == KyLuat[].class) {
            return StringToKls(value);
        }
        if (fieldType == KhenThuong[].class) {
            return StringToKts(value);
        }
        return super.stringToValue(fieldType, value);
    }


}
