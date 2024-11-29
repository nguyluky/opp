package com.companyname.doAn.Gui;
import static com.companyname.doAn.Gui.StaticScanner.sc;

public class ChucNangQuanLyTruongPhong implements ShowOption{
    OptionQuanLyTruongPhong optionQuanLyTruongPhong = new OptionQuanLyTruongPhong();

    public ChucNangQuanLyTruongPhong() {}

    @Override
    public void show() {
        System.out.println("1: Xem thông tin trưởng phòng bằng ID");
        System.out.println("2: Thay đổi trưởng phòng trong phạm vi phòng ban");
        int choice;
        while(true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if(choice > 3 || choice < 0){
                    System.out.println("Vui lòng chọn lựa chọn hợp lý");
                }
                else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên dương");
            }
        }
        switch(choice) {
            case 1:
                optionQuanLyTruongPhong.show();
        }
    }
}
