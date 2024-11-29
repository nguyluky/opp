package com.companyname.doAn.Gui;

import com.companyname.doAn.ql.QuanLyPhongBan;
import com.companyname.doAn.ql.QuanLyTruongPhong;

import static com.companyname.doAn.Gui.StaticScanner.sc;

public class OptionQuanLyTruongPhong implements ShowOption{
    QuanLyTruongPhong qltp = QuanLyTruongPhong.getInstance();
    QuanLyPhongBan qlpb = QuanLyPhongBan.getInstance();


    public OptionQuanLyTruongPhong() {}

    public void thayDoiTruongPhong(){
        System.out.println("Nhập ID trưởng phòng muốn thay đổi: ");
        String id = sc.nextLine();
        if(qltp.getTruongPhongById(id) != null){
           qltp.getTruongPhongById(id).getPhongBan().printDsNhanVienPhongBan();
           System.out.println("Chọn ID nhân viên làm trưởng phòng mới");

        }
        else{
            System.out.println("ID không tồn tại. Quay lại menu trước");
        }
    }

    @Override
    public void show(){
        qltp.printDsTruongPhong();
        System.out.println("Nhập ID trưởng phòng: ");
        String id = sc.nextLine();
        if(qltp.getTruongPhongById(id) != null){
            qltp.getTruongPhongById(id).printThongTinCoBan();
        }
        else{
            System.out.println("ID không tồn tại. Quay lại menu trước");
        }
    }
}
