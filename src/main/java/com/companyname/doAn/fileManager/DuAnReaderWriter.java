package com.companyname.doAn.fileManager;

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
    
}