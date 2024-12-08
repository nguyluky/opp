package com.companyname.doAn.fileManager;

import java.util.Arrays;

import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.type.DuAn;
import com.companyname.doAn.type.NhanSu;

public class DuAnReaderWriter extends FileReaderWriter<DuAn> {

    public DuAnReaderWriter(String folder) {
        super(DuAn.class, folder + "DuAns.txt");
    }

    @Override
    String valueToString(String fieldName, Object value) {

        if (fieldName == "NhanSu") {
            NhanSu[] ns = (NhanSu[]) value;

            String[] ids = new String[ns.length];
            for (int i = 0; i < ns.length; i++) {
                ids[i] = ns[i].getId();
            }

            return String.join(",", ids);
        }

        return null;
    }
    
    @Override
    Object stringToValue(Class fieldType, String value)  {
        if (fieldType == NhanSu[].class) {
            NhanSu[] nhanSus = new NhanSu[0];
            for (String id: value.split(",")) {
                NhanSu nhanSu = QuanLyNhanSu.getInstance().getNhanSuById(id);
                if (nhanSu != null) {
                    nhanSus = Arrays.copyOf(nhanSus, nhanSus.length + 1);
                    nhanSus[nhanSus.length - 1] = nhanSu;
                }
            }
            return nhanSus;
        }

        return super.stringToValue(fieldType, value);
    }
}