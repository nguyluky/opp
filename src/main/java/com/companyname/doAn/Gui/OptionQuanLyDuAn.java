package com.companyname.doAn.Gui;

import com.companyname.doAn.Gui.Screen.ScreenOption;
import com.companyname.doAn.Gui.Screen.ScreenOptionTable;
import com.companyname.doAn.Gui.Screen.ScreenTable;
import com.companyname.doAn.ql.QuanLyDuAn;
import com.companyname.doAn.type.DuAn;

public class OptionQuanLyDuAn extends ScreenOption {



    public OptionQuanLyDuAn() {
        super("QUẢN LÝ DỰ ÁN", new String[] {
            "1: Xem danh sách toàn bộ dự án",
            "2: Thêm dự án",
            "3: Xóa dự án",
            "4: Chức năng đối với dự án cụ thể. Cần nhập ID dự án",
            "0: Quay lại menu trước",
        }, 50);
    }

    @Override
    public void processOption(Display display, int choice) {
        switch (choice) {
            case 0:
                display.back();
                break;

            case 1:
                display.setOptionMenu(new TableQuanLyDuAn());
                break;
            
            case 4:
                display.setOptionMenu(new OptionTableQuanLyDuAn());
                break;
        }
    }
    

    public class TableQuanLyDuAn extends ScreenTable {
        public TableQuanLyDuAn() {
            super(new String[] {
                "ID",
                "Tên dự án",
                "Sl nhân sự",
                "is Delete",
            });
        }

        @Override
        public String[][] getDataStrings() {

            QuanLyDuAn qlda = QuanLyDuAn.getInstance();
            DuAn[] dsDuAn = qlda.getDsDuAn();

            String[][] data = new String[dsDuAn.length][this.title.length];

            for (int i = 0; i < dsDuAn.length; i++) {
                data[i][0] = dsDuAn[i].getIdDuAn();
                data[i][1] = dsDuAn[i].getNameDuAn();
                data[i][2] = Integer.toString(dsDuAn[i].getDsNhanSu().length);
                data[i][3] = dsDuAn[i].getIsDelete() ? "X" : "";
            }

            return data;
        }    
    }

    
    public class OptionTableQuanLyDuAn extends ScreenOptionTable {
        
        public OptionTableQuanLyDuAn() {
            super(new String[] {
                "1: Xem chi tiết dự án",
                "2: Thêm nhân sự",
                "3: Xóa nhân sự",
                "4: Xóa dự án",
                "0: Quay lại",
            }, new TableQuanLyDuAn());
        }
        
        @Override
        public void processOption(Display display, int choice) {
            switch (choice) {
                case 0:
                    display.back();
                    break;
            
                default:
                    break;
            }

        }
    }

    

}

// import com.companyname.doAn.type.DuAn;
// import static com.companyname.doAn.Gui.StaticScanner.*;


// public class OptionQuanLyDuAn implements Screen{
//     public OptionQuanLyDuAn(){}


//     public void themDuAn(){
//         System.out.print("Nhap so du an muon them: ");
//         int slDa;
//         while(true){
//             try {
//                 slDa = Integer.parseInt(sc.nextLine());
//                 if(slDa<0){
//                     System.out.println("Nhap so nguyen duong");
//                 }
//                 else{
//                     break;
//                 }
//             } catch (NumberFormatException e) {
//                 System.out.println("Nhap so nguyen duong");
//             }
//         }

//         for(int i=0; i<slDa; i++){
//             System.out.println("---------------------------------------");
// //        ShowOption.clearScreen();

//             String nameDuAn;
//             while(true) {
//                 System.out.print("Nhập tên dự án thứ " + (i + 1) + ": ");
//                 nameDuAn = sc.nextLine();
//                 if (qlda.getDuAnByName(nameDuAn) != null) {
//                     System.out.println("Tên dự án đã tồn tại");
//                 }
//                 else break;
//             }
//             String idDuAn;
//             while(true) {
//                 System.out.print("Nhập ID dự án thứ " + (i + 1) + ": ");
//                 idDuAn = sc.nextLine();
//                 if (qlda.getDuAnById(idDuAn) != null) {
//                     System.out.println("ID dự án đã tồn tại");
//                 }
//                 else break;
//             }
//             //tạo đối tượng dự án
//             DuAn currentDuAn = new DuAn(nameDuAn, idDuAn);

//             System.out.println("---------------------------------------");
// //        ShowOption.clearScreen();

//             System.out.println("1: Thêm nhân sự");
//             System.out.println("2: Không làm gì hết. Tiếp tục tạo dự án mới nếu có");
//             System.out.println("0: Thoát. Dừng việc tạo. Quay lại menu trước");
//             System.out.print("Chọn chức năng: ");
//             int choice;
//             while (true) {
//                 try {
//                     choice = Integer.parseInt(sc.nextLine());
//                     if (choice > 2 || choice < 0) {
//                         System.out.println("Chọn lựa chọn chưa hợp lý");
//                     } else {
//                         break;
//                     }
//                 } catch (NumberFormatException e) {
//                     System.out.println("Chọn lựa chọn chưa hợp lý");
//                 }
//             }
//             switch (choice) {
//                 case 1:
//                     optionDuAn.themNhanSu(currentDuAn);
//                     break;
//                 case 2:
//                     break;
//                 case 0:
//                     optionMenu.chucNangQuanLyDuAn();
//                     return;
//             }
//             qlda.addDuAn(currentDuAn);
//         }
//     }

//     public void xoaDuAn(){
//         qlda.printDsDuAn();

//         System.out.print("Nhap so du an muon xoa: ");
//         int slDa;
//         while(true){
//             try {
//                 slDa = Integer.parseInt(sc.nextLine());
//                 if(slDa<0){
//                     System.out.println("Vui long nhap so nguyen duong");
//                 }
//                 else{
//                     break;
//                 }
//             } catch (NumberFormatException e) {
//                 System.out.println("Vui long nhap so nguyen duong");
//             }
//         }

//         for(int i=0; i<slDa; i++){
//             System.out.print("Nhap ID du an thu " + (i+1) + " muon xoa: ");
//             String idDuAn = sc.nextLine();
//             DuAn da = qlda.getDuAnById(idDuAn);
//             if(da!=null && !da.getIsDelete()){
//                 da.setIsDelete(true);
//                 System.out.println("---------------------------------------");
// //        ShowOption.clearScreen();

//                 System.out.println("Xóa dự án thành công");
//             }
//             else{
//                 System.out.println("ID dự án không tồn tại");
//             }
//         }
//     }

//     @Override
//     public void show(){
//         while (true) {
            
//             System.out.println("---------------------------------------");
//             System.out.println("             QUẢN LÝ DỰ ÁN             ");
//             System.out.println("---------------------------------------");

//             qlda.printDsDuAn();

//             System.out.println("---------------------------------------");

//             System.out.print("Nhập ID dự án: ");
//             String idDuAn = sc.nextLine();
//             if(qlda.getDuAnById(idDuAn) == null){
//                 System.out.println("---------------------------------------");

//                 System.out.println("ID dự án không tồn tại");
//                 return;
//             }
//             if(qlda.getDuAnById(idDuAn).getIsDelete()){
//                 qlda.getDuAnById(idDuAn).printThongTinCoBan();
//                 return;
//             }
//             DuAn currentDuAn = qlda.getDuAnById(idDuAn);

//             System.out.println("1: Thêm nhân sự");
//             System.out.println("2: Xóa nhân sự");
//             System.out.println("3: Thông tin cơ bản");
//             System.out.println("0: Quay lại menu trước");
//             System.out.print("Chon chuc nang: ");
//             int choice;
//             while(true){
//                 try {
//                     choice = Integer.parseInt(sc.nextLine());
//                     if(choice > 3 || choice < 0){
//                         System.out.println("Can chon chuc nang hop le");
//                     }
//                     else break;
//                 }catch(NumberFormatException e){
//                     System.out.println("Can chon chuc nang hop le");
//                 }
//             }

//            Screen.clearScreen();


//             switch (choice) {
//                 case 1:
//                     optionDuAn.themNhanSu(currentDuAn);
//                     break;
//                 case 2:
//                     optionDuAn.xoaNhanSu(currentDuAn);
//                     break;
//                 case 3:
//                     currentDuAn.printThongTinCoBan();
//                     break;
//                 case 0:
//                     return;
//             }
//         }


//     }
// }
