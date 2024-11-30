package com.companyname.doAn.Gui;

import com.companyname.doAn.type.DuAn;
import static com.companyname.doAn.Gui.ShareIntance.*;

public class OptionDuAn {
    public OptionDuAn(){}

    public void themNhanSu(DuAn currentDuAn){ //thêm nhân viên vào dự án
        System.out.print("Nhập số lượng nhân viên muốn thêm vào dự án: ");
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
            System.out.printf("Nhập ID nhân viên " + (i+1) + " muốn thêm vào dự án: ");
            String idNhanSu = sc.nextLine();
            if(qlns.getNhanSuById(idNhanSu) != null){
                currentDuAn.addNhanSu(qlns.getNhanSuById(idNhanSu));
            }
            else{
                //nếu ID không tồn tại, bỏ qua nhập ID tiếp theo
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
