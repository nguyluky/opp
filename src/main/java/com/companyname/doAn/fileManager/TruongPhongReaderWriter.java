package com.companyname.doAn.fileManager;

import com.companyname.doAn.type.TruongPhong;

public class TruongPhongReaderWriter extends NhanSuReaderWriter<TruongPhong> {
    public TruongPhongReaderWriter(String folder) {
        super(TruongPhong.class, folder + "TruongPhongs.txt");
    }

}
