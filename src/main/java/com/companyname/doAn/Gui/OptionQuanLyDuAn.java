package com.companyname.doAn.Gui;

import com.companyname.doAn.type.DuAn;
import static com.companyname.doAn.Gui.ShareIntance.*;


public class OptionQuanLyDuAn implements ShowOption{
    public OptionQuanLyDuAn(){}


    public void themDuAn(){
        System.out.print("Nhap so du an muon them: ");
        int slDa;
        while(true){
            try {
                slDa = Integer.parseInt(sc.nextLine());
                if(slDa<0){
                    System.out.println("Nhap so nguyen duong");
                }
                else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhap so nguyen duong");
            }
        }

        for(int i=0; i<slDa; i++){
            System.out.println("---------------------------------------");
            System.out.print("Nhập tên dự án thứ " + (i+1) + ": ");
            String nameDuAn = sc.nextLine();
            System.out.print("Nhập ID dự án thứ " + (i+1) + ": ");
            String idDuAn = sc.nextLine();
            if(qlda.getDuAnById(idDuAn) != null){
                System.out.println("ID dự án đã tồn tại. Bỏ qua, tiếp tục tạo nếu có");
            }
            else {
                //tạo đối tượng dự án
                DuAn currentDuAn = new DuAn(nameDuAn, idDuAn);

                System.out.println("---------------------------------------");
                System.out.println("1: Thêm nhân sự");
                System.out.println("2: Xóa nhân sự");
                System.out.println("3: Không làm gì hết. Tiếp tục tạo dự mới nếu có");
                System.out.println("0: Thoát. Dừng việc tạo. Quay lại menu trước");
                System.out.print("Chọn chức năng: ");
                int choice;
                while (true) {
                    try {
                        choice = Integer.parseInt(sc.nextLine());
                        if (choice > 3 || choice < 0) {
                            System.out.println("Chọn lựa chọn chưa hợp lý");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Chọn lựa chọn chưa hợp lý");
                    }
                }
                switch (choice) {
                    case 1:
                        optionDuAn.themNhanSu(currentDuAn);
                        break;
                    case 2:
                        optionDuAn.xoaNhanSu(currentDuAn);
                        break;
                    case 3:
                        break;
                    case 0:
                        optionMenu.chucNangQuanLyDuAn();
                        return;
                }
                qlda.addDuAn(currentDuAn);
            }
        }
    }

    public void xoaDuAn(){
        qlda.printDsDuAn();

        System.out.print("Nhap so du an muon xoa: ");
        int slDa;
        while(true){
            try {
                slDa = Integer.parseInt(sc.nextLine());
                if(slDa<0){
                    System.out.println("Vui long nhap so nguyen duong");
                }
                else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen duong");
            }
        }

        for(int i=0; i<slDa; i++){
            System.out.print("Nhap ID du an thu " + (i+1) + " muon xoa: ");
            String idDuAn = sc.nextLine();
            DuAn da = qlda.getDuAnById(idDuAn);
            if(da!=null && !da.getIsDelete()){
                da.setIsDelete(true);
                System.out.println("---------------------------------------");
                System.out.println("Xóa dự án thành công");
            }
            else{
                System.out.println("ID dự án không tồn tại");
            }
        }
    }

    @Override
    public void show(){
        System.out.println("---------------------------------------");
        qlda.printDsDuAn();
        System.out.print("Nhập ID dự án: ");
        String idDuAn = sc.nextLine();
        if(qlda.getDuAnById(idDuAn) == null){
            System.out.println("---------------------------------------");
            System.out.println("ID dự án không tồn tại");
            return;
        }
        DuAn currentDuAn = qlda.getDuAnById(idDuAn);

        System.out.println("1: Thêm nhân sự");
        System.out.println("2: Xóa nhân sự");
        System.out.println("3: Danh sách nhân sự đang làm");
        System.out.println("4: Thông tin cơ bản");
        System.out.println("0: Quay lại menu trước");
        System.out.print("Chon chuc nang: ");
        int choice;
        while(true){
            try {
                choice = Integer.parseInt(sc.nextLine());
                if(choice > 4 || choice < 0){
                    System.out.println("Can chon chuc nang hop le");
                }
                else break;
            }catch(NumberFormatException e){
                System.out.println("Can chon chuc nang hop le");
            }
        }
        switch (choice) {
            case 1:
                optionDuAn.themNhanSu(currentDuAn);
                optionMenu.chucNangQuanLyDuAn();
                break;
            case 2:
                optionDuAn.xoaNhanSu(currentDuAn);
                optionMenu.chucNangQuanLyDuAn();
                break;
            case 3:
                currentDuAn.printDsNhanSuDuAn();
                optionMenu.chucNangQuanLyDuAn();
                break;
            case 4:
                currentDuAn.printThongTinCoBan();
                optionMenu.chucNangQuanLyDuAn();
                break;
            case 0:
                optionMenu.chucNangQuanLyDuAn();
                break;
        }
    }
}
