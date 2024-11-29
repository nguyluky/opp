package com.companyname.doAn.Gui;

import java.util.Scanner;
import com.companyname.doAn.ql.QuanLyNhanSu;
import com.companyname.doAn.type.DuAn;

public class OptionDuAn {
    public OptionDuAn(){}
    Scanner sc = StaticScanner.sc;
    QuanLyNhanSu qlns = QuanLyNhanSu.getInstance();

    public void themNhanVien(DuAn currentDuAn){ //thêm nhân viên vào dự án
        System.out.print("Nhập số lượng nhân viên muốn thêm vào dự án: ");
        int slNhanVien;
        while(true){
            try {
                slNhanVien = Integer.parseInt(sc.nextLine());
                if(slNhanVien>=0){
                    break;
                }
                else{
                    System.out.println("Vui lòng nhập số dương");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        }
        //in ra id nhân viên để người dùng biết id nào để mà thêm vào dự án
        //một nhân viên có thể tham gia nhiều dự án nên không cần kiểm tra lỗi
        currentDuAn.printDsNhanVienDuAn();

        for(int i=0; i<slNhanVien; i++){
            System.out.printf("Nhập ID nhân viên " + (i+1) + "muốn thêm vào dự án: ");
            String idNhanVien = sc.nextLine();
            if(qlns.getNhanVienById(idNhanVien) != null){
                currentDuAn.addNhanVien(qlns.getNhanVienById(idNhanVien));
            }
            else{
                //nếu ID không tồn tại, bỏ qua nhập ID tiếp theo
                System.out.println("ID không tồn tại trong công ty");
            }
        }


    }

    public void xoaNhanVien(DuAn currentDuAn){ // xóa nhân viên khỏi dự án
        System.out.print("Nhập số lượng nhân viên muốn xóa khỏi dự án: ");
        int slNhanVien;
        //kiểm tra nhập đúng số >0 thì dừng
        while(true){
            try {
                slNhanVien = Integer.parseInt(sc.nextLine());
                if(slNhanVien>0){
                    break;
                }
                else{
                    System.out.println("Nhập số âm là lỗi. Thoát");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        }

        for(int i=0; i<slNhanVien; i++){
            System.out.printf("Nhập ID nhân viên thứ: " + (i+1) + " muốn xóa khỏi dự án: ");
            String idNhanVien = sc.nextLine();
            //nếu ID không tồn tại, bỏ qua
            if(currentDuAn.getNhanVienByID(idNhanVien) == null || currentDuAn.getNhanVienByID(idNhanVien).getIsDelete()){
                System.out.println("ID nhân viên không tồn tại trong dự án");
            }
            else{
                currentDuAn.removeNhanVien(idNhanVien);
            }
        }
    }

    public void doiTenDuAn(DuAn currentDuAn){
        System.out.print("Nhập tên mới cho dự án: ");
        String newName = sc.nextLine();
        currentDuAn.setNameDuAn(newName);
        System.out.print("Thêm thành công");
    }
}
