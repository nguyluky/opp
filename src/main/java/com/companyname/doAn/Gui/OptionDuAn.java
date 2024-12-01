package com.companyname.doAn.Gui;

import com.companyname.doAn.type.DuAn;
import com.companyname.doAn.type.NhanSu;

import static com.companyname.doAn.Gui.StaticScanner.*;

public class OptionDuAn {
    public OptionDuAn(){}

    public void themNhanSu(DuAn currentDuAn){ //thêm nhân sự vào dự án
        System.out.print("Nhập số lượng nhân sự muốn thêm vào dự án: ");
        int slNhanSu;
        while(true){
            try {
                slNhanSu = Integer.parseInt(sc.nextLine());
                if(slNhanSu>=0){
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
        qlns.printDsNhanSu();
        System.out.println("---------------------------------------");
        for(int i=0; i<slNhanSu; i++){
            System.out.printf("Nhập ID nhân sự " + (i+1) + " muốn thêm vào dự án: ");
            String idNhanSu = sc.nextLine();
            if(qlns.getNhanSuById(idNhanSu) != null && !qlns.getNhanSuById(idNhanSu).getIsDelete()){
                boolean check = false;
                //nếu đã tồn tại nhân sự  thi bao loi
                for(NhanSu ns : currentDuAn.getDsNhanSu()){
                    if(ns.equals(qlns.getNhanSuById(idNhanSu))){
                        System.out.println("---------------------------------------");
                        System.out.println("Nhân sự này đã tồn tại trong dự án");
                        check = true;
                    }
                }
                if(check) continue;
                currentDuAn.addNhanSu(qlns.getNhanSuById(idNhanSu));
                System.out.println("---------------------------------------");
                System.out.println("Thêm nhân sự thành công");
            }
            else{
                //nếu ID không tồn tại, bỏ qua nhập ID tiếp theo
                System.out.println("---------------------------------------");
                System.out.println("ID không tồn tại trong công ty");
            }
        }


    }

    public void xoaNhanSu(DuAn currentDuAn){ // xóa nhân viên khỏi dự án
        System.out.print("Nhập số lượng nhân viên muốn xóa khỏi dự án: ");
        int slNhanSu;
        //kiểm tra nhập đúng số >0 thì dừng
        while(true){
            try {
                slNhanSu = Integer.parseInt(sc.nextLine());
                if(slNhanSu>0){
                    break;
                }
                else{
                    System.out.println("Nhập số âm là lỗi. Thoát");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        }

        for(int i=0; i<slNhanSu; i++){
            System.out.printf("Nhập ID nhân viên thứ: " + (i+1) + " muốn xóa khỏi dự án: ");
            String idNhanSu = sc.nextLine();
            //nếu ID không tồn tại, bỏ qua
            if(currentDuAn.getNhanSuByID(idNhanSu) == null || currentDuAn.getNhanSuByID(idNhanSu).getIsDelete()){
                System.out.println("ID nhân viên không tồn tại trong dự án");
            }
            else{
                currentDuAn.removeNhanSu(idNhanSu);
            }
        }
    }
}
