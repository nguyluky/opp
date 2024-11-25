package com.companyname.doAn.Gui;
import java.util.Arrays;
import java.util.Scanner;

import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyNhanVien;
import com.companyname.doAn.ql.QuanLyPhongBan;
import com.companyname.doAn.type.DuAn;
import com.companyname.doAn.type.PhongBan;
import com.companyname.doAn.type.NhanVien;

public class OptionPhongBan {
    public OptionPhongBan(){}

    public void themDuAn(PhongBan currentPhongBan){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số dự án muốn thêm");
        int slDa;
        try {
            slDa = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số");
            return;
        }
        if(slDa<0){
            System.out.println("Nhập số âm là lỗi. Thoát");
            return;
        }

        DuAn dsDuAn[] = new DuAn[slDa];

        for(int i=0; i<slDa; i++){
            System.out.printf("Nhập tên dự án thứ " + (i+1) + ": ");
            String nameDuAn = sc.nextLine();
            System.out.printf("Nhập id dự án: "  + (i+1) + ": ");
            String idDuAn = sc.nextLine();
            System.out.printf("Nhập số lượng nhân viên dự án: "  + (i+1) + ": ");
            int slNhanVien;
            try {
                slNhanVien = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
                return;
            }
            if(slNhanVien<0){
                System.out.println("Nhập lỗi. Thoát");
                return;
            }

            NhanVien dsNhanVien[] = new NhanVien[slNhanVien];
            QuanLyNhanVien qlnv = QuanLyNhanVien.getInstance();

            for(int j=0; j<slNhanVien; j++){
                System.out.printf("%d","Nhập id nhân viên thứ " + (j + 1) + " muốn thêm vào dự án:");
                String idNhanVien = sc.nextLine();
                NhanVien nv = qlnv.getNhanVienById(idNhanVien);
                if(nv != null){
                    dsNhanVien[j] = nv;
                    System.out.println("Thêm thành công");
                }
                else{
                    System.out.println("Id nhân viên không tồn tại");
                    j--;
                }
            }
            dsDuAn[i] = new DuAn(nameDuAn, idDuAn, dsNhanVien, false);
            QuanLyDuAn qlda = QuanLyDuAn.getInstance();
            qlda.addDuAn(dsDuAn[i]);
        }

        currentPhongBan.setDsDuAn(dsDuAn);
    }

    public void xoaDuAn(PhongBan currentPhongBan){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập số lượng dự án muốn xóa khỏi phòng ban này: ");
        int slDuAn;
        try {
            slDuAn = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
             System.out.println("Lỗi! Cần nhập số. Thoát");
             return;
        }
        if(slDuAn < 0 || slDuAn > currentPhongBan.getDsDuAn().length){
            System.out.println("Nhập số không phù hợp! Thoát");
            return;
        }
        for(int i=0; i<slDuAn; i++){
            System.out.println("Nhập id dự án thứ " + (i+1) + " muốn xóa khỏi phòng ban này");
            String idDuAn = sc.nextLine();
            boolean checkDeleteStatus;
            for(DuAn duan : currentPhongBan.getDsDuAn()){
                checkDeleteStatus = false;
                if(duan.getIdDuAn().equals(idDuAn)){
                    duan.setIsDelete(true);
                    System.out.println("Xóa thành công!");
                    checkDeleteStatus = true;
                    break;
                }
                if(!checkDeleteStatus){
                    System.out.println("Id dự án không tồn tại!");
                }   
            }
        }
    }

    public void themNhanVien(PhongBan currentPhongBan){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập số lượng nhân viên muốn thêm vào phòng ban này: ");
        int slNhanVien; 
        try {
           slNhanVien = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi! Cần nhập số. Thoát");
            return;
        }
        if(slNhanVien<0){
            System.out.println("Nhập lỗi. Thoát");
        }

        for(int i=0; i<slNhanVien; i++){
            String idNhanVien = sc.nextLine();
            QuanLyPhongBan qlpb = QuanLyPhongBan.getInstance();
            QuanLyNhanVien qlnv = QuanLyNhanVien.getInstance();

            if(qlnv.getNhanVienById(idNhanVien) == null){
                System.out.println("Id nhân viên không tồn tại. Quay lại menu trước");
                return;
            }

            boolean checkTonTaiOPhongBanKhac = false;
            PhongBan phongbanTmp = null;
            for(PhongBan pb : qlpb.getDsPhongBan()){
                for(NhanVien nv : pb.getDsNhanVien()){
                    if(nv.getId().equals(idNhanVien)){
                        checkTonTaiOPhongBanKhac = true;
                        break;
                    } 
                }
                if(checkTonTaiOPhongBanKhac){
                    phongbanTmp = pb;
                    break;
                };
            }
            if(checkTonTaiOPhongBanKhac){
                System.out.println("Nhân viên có id " + idNhanVien + " đang tồn tại ở phòng ban khác");
                System.out.println("Chọn lựa chọn:");
                System.out.println("1: Tiếp tục đổi nhân viên từ phòng ban cũ sang phòng ban này");
                System.out.println("2: Hủy. Quay lại menu trước");
                int choiceNext = Integer.parseInt(sc.nextLine());
                switch (choiceNext) {
                    case 1:
                        phongbanTmp.removeNhanVien(idNhanVien);
                        break;
                    case 2:
                        System.out.println("Quay lại menu trước");
                        return;
                    default:
                        System.out.println("Nhập sai lựa chọn. Quay lại menu trước");
                        return;
                }
            }
            currentPhongBan.addNhanVien(qlnv.getNhanVienById(idNhanVien));
        }
    }

    public void xoaNhanVien(PhongBan currentPhongBan){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập số lượng nhân viên muốn xóa khỏi phòng ban này: ");
        int slNhanVien; 
        try {
           slNhanVien = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi! Cần nhập số. Quay lại menu trước");
            return;
        }
        if(slNhanVien<0){
            System.out.println("Nhập lỗi. Quay lại menu trước");
        }
       
        for(int i=0; i<slNhanVien; i++){
            String idNhanVien = sc.nextLine();
             //kiểm tra id nhân viên có tồn tại trong công ty hay không
            QuanLyNhanVien qlnv = QuanLyNhanVien.getInstance();
            if(qlnv.getNhanVienById(idNhanVien) != null){
                if(currentPhongBan.getNhanVienById(idNhanVien) != null){
                    currentPhongBan.removeNhanVien(idNhanVien);
                }
                else System.out.println("ID nhân viên không tồn tại trong phòng ban này");
            }
            else{
                System.out.println("Id nhân viên không tồn tại. Quay lại menu trước");
                return;
            }
        }
    }
}
