package com.companyname.doAn.Gui;

import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.type.DuAn;
import com.companyname.doAn.type.NhanVien;
import java.util.Scanner;

public class OptionQuanLyDuAn {
    public OptionQuanLyDuAn(){}

    public void themDuAn(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập tên dự án: ");
        String nameDuAn = sc.nextLine();
        System.out.printf("Nhập id dự án: ");
        String idDuAn = sc.nextLine();
        System.out.printf("Nhập số lượng nhân viên dự án: ");
        int slNhanVien = Integer.parseInt(sc.nextLine());
        if(slNhanVien<0){
            System.out.println("Nhập lỗi!");
            return;
        }
        NhanVien dsNhanVien[] = new NhanVien[slNhanVien];
        QuanLyNhanSu qlnv = QuanLyNhanSu.getInstance();

        for(int i=0; i<slNhanVien; i++){
            System.out.printf("%d","Nhập id nhân viên thứ " + (i + 1) + " muốn thêm vào dự án:");
            String idNhanVien = sc.nextLine();
            NhanVien nv = qlnv.getNhanVienById(idNhanVien);
            if(nv != null){
                dsNhanVien[i] = nv;
                System.out.println("Thêm thành công");
            }
            else{
                System.out.println("Id nhân viên không tồn tại");
                i--;
            }
        }
        QuanLyDuAn qlda = QuanLyDuAn.getInstance();
        qlda.addDuAn(new DuAn(nameDuAn, idDuAn, dsNhanVien, false));
    }

    public void xoaDuAn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id dự án muốn xóa");
        String idDuAn = sc.nextLine();
        QuanLyDuAn qlda = QuanLyDuAn.getInstance();
        DuAn da = qlda.getDuAnById(idDuAn);
        if(da!=null){
            da.setIsDelete(true);
        }
        else{
            System.out.println("Id dự án không tồn tại");
        }
    }

    public void getThongTinDuAnById(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập id dự án muốn lấy thông tin:");
        String idDuAn = sc.nextLine();
        QuanLyDuAn qlda = QuanLyDuAn.getInstance();
        DuAn da = qlda.getDuAnById(idDuAn);
        if(da!=null){
            System.out.println(da);
        }
        else{
            System.out.println("Id dự án không tồn tại");
        }
    }

}
