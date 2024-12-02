package com.companyname.doAn.Gui;

import com.companyname.doAn.Gui.Screen.ScreenOption;

public class OptionMenu extends ScreenOption {
    public OptionMenu() {
        super("HOME", new String[] {
            "1. Quản lý dự án",
            "2. Quản lý phòng ban",
            "3. Quản lý nhân sự",
            "0. Thoát chương trình"
        }, 50);
    }

    @Override
    public void show(Display display) {
        this.printOption();

        int choice = getChoice(display.sc);

        processOption(display, choice);
    }

    @Override
    public void processOption(Display display, int choice) {
        switch (choice) {
            case 0:
                display.back();
                break;
            case 1:
                display.setOptionMenu(new OptionQuanLyDuAn());
                break;
            // case 2:
            //     display.setOptionMenu(new OptionQuanLyPhongBan());
            //     break;
            // case 3:
            //     display.setOptionMenu(new OptionQuanLyNhanSu());
            //     break;
            // case 4:

            //     System.exit(0);

            //     break;
        }
    }

    

    // @Override
    // public void show() {
    //     boolean check = true;
    //     ShowOption.clearScreen();
    //     while (check) {       
    //         System.out.println("---------------------------------------");
    //         System.out.println("                HOME                   ");
    //         System.out.println("---------------------------------------");

    //         System.out.println("1: Quản lý dự án");
    //         System.out.println("2: Quản lý phòng ban");
    //         System.out.println("3: Quản lý nhân sự");
    //         System.out.println("0: Thoát chương trình");
    //         System.out.print("Chọn chức năng quản lý: ");
    //         int choice = Integer.parseInt(sc.nextLine());
    //         ShowOption.clearScreen();
    //         switch (choice) {
    //             case 1:
    //                 chucNangQuanLyDuAn();
    //                 break;
    //             case 2:
    //                 chucNangQuanLyPhongBan();
    //                 break;
    //             case 3:
    //                 chucNangQuanLyNhanSu();
    //                 break;
    //             case 0:
    //                 return;
    //             default:
    //                 System.out.println("Không hợp lệ! Thoát");
    //         }
    //     }
    // }

    // public void chucNangQuanLyDuAn() {
    //     boolean check = true;
    //     this.clearScreen();
    //     while (check) {
    //         System.out.println("---------------------------------------");
    //         System.out.println("             QUẢN LÝ DỰ ÁN             ");
    //         System.out.println("---------------------------------------");
    //         System.out.println("1: Xem danh sách toàn bộ dự án");
    //         System.out.println("2: Thêm dự án");
    //         System.out.println("3: Xóa dự án");
    //         System.out.println("4: Chức năng đối với dự án cụ thể. Cần nhập ID dự án");
    //         System.out.println("0: Quay lại menu trước");
    //         System.out.print("Chọn chức năng: ");
    //         int choice;
    //         while (true) {
    //             try {
    //                 choice = Integer.parseInt(sc.nextLine());
    //                 if (choice > 4 || choice < 0) {
    //                     System.out.println("Cần chọn chức năng hợp lệ");
    //                 } else
    //                     break;
    //             } catch (NumberFormatException e) {
    //                 System.out.println("Cần chọn chức năng hợp lệ");
    //             }
    //         }
    //         this.clearScreen();
    //         switch (choice) {
    //             case 1:
    //                 qlda.printDsDuAn();
    //                 break;
    //             case 2:
    //                 optionQuanLyDuAn.themDuAn();
    //                 break;
    //             case 3:
    //                 optionQuanLyDuAn.xoaDuAn();
    //                 break;
    //             case 4:
    //                 optionQuanLyDuAn.show();
    //                 break;
    //             case 0:
    //                 // show();
    //                 return;
    //             default:
    //                 System.out.println("Cần nhập lựa chọn hợp lý");
    //                 break;
    //         }
    //     }
    // }

    // public void chucNangQuanLyPhongBan() {
    //     ShowOption.clearScreen();
    //     while (true) {


    //         ShowOption.printOption("QUẢN LÝ PHÒNG BAN", new String[] {
    //             "1: Xem danh sách toàn bộ phòng ban",
    //             "2: Thêm phòng ban",
    //             "3: Xóa phòng ban",
    //             "4: Chuyển nhân viên",
    //             "5: Chức năng đối với phòng ban cụ thể. Cần nhập ID phòng ban",
    //             "0: Quay lại menu trước"
    //         });
            
    //         int choice;
            
    //         while (true) {
    //             try {
    //                 choice = Integer.parseInt(sc.nextLine());
    //                 if (choice < 0 || choice > 5) {
    //                     System.out.println("Can chon chuc nang hop le");
    //                 } else
    //                     break;
    //             } catch (NumberFormatException e) {
    //                 System.out.println("Can chon chuc nang hop le");
    //             }
    //         }

    //         ShowOption.clearScreen();
    //         switch (choice) {
    //             case 1:
    //                 qlpb.printDsPhongBan();
    //                 break;
    //             case 2:
    //                 optionQuanLyPhongBan.themPhongBan();
    //                 break;
    //             case 3:
    //                 optionQuanLyPhongBan.xoaPhongBan();
    //                 break;
    //             case 4:
    //                 optionQuanLyPhongBan.moveNhanVien();
    //                 break;
    //             case 5:
    //                 optionQuanLyPhongBan.show();
    //                 break;
    //             case 0:
    //                 return;
    //         }
    //     }

    // }

    // public void chucNangQuanLyNhanSu() {
    //     ShowOption.clearScreen();
    //     while (true) {
                
    //         System.out.println("---------------------------------------");
    //         System.out.println("             QUẢN LÝ NHÂN SỰ           ");
    //         System.out.println("---------------------------------------");

    //         System.out.println("1: Xem danh sách nhân sự");
    //         System.out.println("2: Thêm nhân sự");
    //         System.out.println("3: Xóa nhân sự");
    //         System.out.println("4: Chuc nang doi voi nhan su cu the");
    //         System.out.println("0: Quay lại menu trước");
    //         System.out.print("Chọn chức năng: ");
    //         int choice;
    //         while (true) {
    //             try {
    //                 choice = Integer.parseInt(sc.nextLine());
    //                 if (choice > 4) {
    //                     System.out.println("Vui lòng nhập đúng lựa chọn");
    //                 } else {
    //                     break;
    //                 }
    //             } catch (NumberFormatException e) {
    //                 System.out.println("Vui lòng nhập số");
    //             }
    //         }
    //         ShowOption.clearScreen();

    //         switch (choice) {
    //             case 1:
    //                 qlns.printDsNhanSu();
    //                 break;
    //             case 2:
    //                 optionQuanLyNhanSu.themNhanSu();
    //                 break;
    //             case 3:
    //                 optionQuanLyNhanSu.xoaNhanSu();
    //                 break;
    //             case 4:
    //                 optionQuanLyNhanSu.show();
    //             case 0:
    //                 return;
    //         }
    //     }
    // }
}
