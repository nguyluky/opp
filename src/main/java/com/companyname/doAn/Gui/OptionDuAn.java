package com.companyname.doAn.Gui;

import java.util.Scanner;

import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.ql.QuanLyNhanVien;
import com.companyname.doAn.type.DuAn;
import com.companyname.doAn.type.NhanVien;

public class OptionDuAn {
    public OptionDuAn(){}
    Scanner sc = StaticScanner.sc;
    QuanLyDuAn qlda = QuanLyDuAn.getInstance();
    QuanLyNhanVien qlnv = QuanLyNhanVien.getInstance();

    public void themNhanVien(DuAn currentDuAn){ //thêm nhân viên vào dự án
        System.out.printf("Nhập số lượng nhân viên muốn thêm vào dự án: ");
        int slNhanVien;

        //nhập đến khi nào nhập số > 0
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
            if(qlnv.getNhanVienById(idNhanVien) != null){
                currentDuAn.addNhanVien(qlnv.getNhanVienById(idNhanVien));
            }
            else{
                //nếu ID không tồn tại, bỏ qua nhập ID tiếp theo
                System.out.println("ID không tồn tại trong công ty");
            }
        }


    }

    public void xoaNhanVien(DuAn currentDuAn){ // xóa nhân viên khỏi dự án
        System.out.printf("Nhập số lượng nhân viên muốn xóa khỏi dự án: ");
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
            if(currentDuAn.getNhanVienByID(idNhanVien) != null){ // nếu ID nhân viên tồn tại trong công ty
                currentDuAn.removeNhanVien(idNhanVien);
            }
            else{
                //nếu ID không tồn tại, bỏ qua 
                System.out.println("ID nhân viên không tồn tại trong dự án");
            }
        }
    }

    public void doiTenDuAn(DuAn currentDuAn){
        System.out.printf("Nhập tên mới cho dự án: ");
        String newName = sc.nextLine();
        currentDuAn.setNameDuAn(newName);
        System.out.printf("Thêm thành công");
    }
}
