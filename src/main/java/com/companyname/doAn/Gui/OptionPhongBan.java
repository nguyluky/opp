package com.companyname.doAn.Gui;

import com.companyname.doAn.type.*;
import static com.companyname.doAn.Gui.ShareIntance.*;
import java.util.Scanner;

public class OptionPhongBan implements ShowOption{
    public OptionPhongBan(){}

    public void themDuAn(PhongBan currentPhongBan){
        System.out.println("Nhập số dự án muốn thêm");
        int slDa;
        while(true){
            try {
                slDa = Integer.parseInt(sc.nextLine());
                if(slDa<0){
                    System.out.println("Nhập số âm là lỗi");
                }
                else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        }

        DuAn[] dsDuAn = new DuAn[slDa];

        for(int i=0; i<slDa; i++){
            System.out.printf("Nhập tên dự án thứ " + (i+1) + ": ");
            String nameDuAn = sc.nextLine();
            System.out.printf("Nhập id dự án: "  + (i+1) + ": ");
            String idDuAn = sc.nextLine();
            System.out.printf("Nhập số lượng nhân viên dự án: "  + (i+1) + ": ");
            int slNhanVien;
            while(true) {
                try {
                    slNhanVien = Integer.parseInt(sc.nextLine());
                    if (slNhanVien < 0) {
                        System.out.println("Can nhap so nguyen duong");
                    }
                    else break;
                } catch (NumberFormatException e) {
                    System.out.println("Can nhap so nguyen duong");
                }
            }

            NhanVien[] dsNhanVien = new NhanVien[slNhanVien];

            for(int j=0; j<slNhanVien; j++){
                System.out.print("Nhập ID nhân viên thứ " + (j + 1) + " muốn thêm vào dự án:");
                String idNhanVien = sc.nextLine();
                NhanVien nv = qlns.getNhanVienById(idNhanVien);
                if(nv != null){
                    dsNhanVien[j] = nv;
                    System.out.println("Thêm thành công");
                }
                else{
                    System.out.println("Id nhân viên không tồn tại");
                    j--;
                }
            }
            dsDuAn[i] = new DuAn(nameDuAn, idDuAn);
            dsDuAn[i].setDsNhanSu(dsNhanVien);

            qlda.addDuAn(dsDuAn[i]);
            currentPhongBan.addDuAn(dsDuAn[i]);
        }
    }

    public void xoaDuAn(PhongBan currentPhongBan){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng dự án muốn xóa khỏi phòng ban này: ");
        int slDuAn;
        while(true){
            try {
                slDuAn = Integer.parseInt(sc.nextLine());
                if(slDuAn < 0 || slDuAn > currentPhongBan.getDsDuAn().length){
                    System.out.println("Nhap so khong hop le");
                }
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Nhap so khong hop le");
            }
        }

        currentPhongBan.printDsDuAn();
        for(int i=0; i<slDuAn; i++){
            System.out.println("Nhập id dự án thứ " + (i+1) + " muốn xóa khỏi phòng ban này");
            String idDuAn = sc.nextLine();
            if(currentPhongBan.getDuAnById(idDuAn) == null || currentPhongBan.getDuAnById(idDuAn).getIsDelete()) {
                System.out.print("Du an khong ton tai");
            }
            else{
                currentPhongBan.removeDuAn(idDuAn);
            }
        }
    }

    public void themNhanVien(PhongBan currentPhongBan){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng nhân viên muốn thêm vào phòng ban này: ");
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
            System.out.print("Nhap ID nhan vien: ");
            String idNhanVien = sc.nextLine();
            if(qlns.getNhanVienById(idNhanVien) == null){
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
                }
            }
            if(checkTonTaiOPhongBanKhac){
                System.out.println("Nhân viên có id " + idNhanVien + " đang tồn tại ở phòng ban khác");
                System.out.println("1: Tiếp tục đổi nhân viên từ phòng ban cũ sang phòng ban này");
                System.out.println("2: Hủy");
                System.out.print("Chọn lựa chọn: ");
                int choiceNext;
                while(true){
                    try {
                        choiceNext = Integer.parseInt(sc.nextLine());
                        if(choiceNext > 2 || choiceNext < 1){
                            System.out.println("Can chon lua chon hop ly");
                        }
                        else break;
                    } catch (NumberFormatException e) {
                        System.out.println("Can chon lua chon hop ly");
                    }
                }
                switch (choiceNext) {
                    case 1:
                        phongbanTmp.removeNhanVien(idNhanVien);
                        break;
                    case 2:
                        return;
                }
            }
            currentPhongBan.addNhanVien(qlns.getNhanVienById(idNhanVien));
        }
    }

    public void xoaNhanVien(PhongBan currentPhongBan){
        System.out.print("Nhập số lượng nhân viên muốn xóa khỏi phòng ban này: ");
        int slNhanVien;
        try {
           slNhanVien = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Can nhap so nguyen duong");
            return;
        }
        if(slNhanVien<0){
            System.out.println("Can nhap so nguyen duong");
        }


        for(int i=0; i<slNhanVien; i++){
            String idNhanVien = sc.nextLine();
             //kiểm tra id nhân viên có tồn tại trong công ty hay không
            if(qlns.getNhanVienById(idNhanVien) == null || qlns.getNhanVienById(idNhanVien).getIsDelete()){
                System.out.println("Id nhân viên không tồn tại. Bo qua");
            }
            else{
                if(currentPhongBan.getNhanVienById(idNhanVien) != null){
                    currentPhongBan.removeNhanVien(idNhanVien);
                }
                else System.out.println("ID nhân viên không tồn tại trong phòng ban này");
            }
        }
    }

    @Override
    public void show(){
        optionQuanLyDuAn.show();
    }

    public void thayDoiTruongPhong(PhongBan currentPhongBan){
        if(currentPhongBan.getDsNhanVien().length==0){
            System.out.println("Phong ban chua co nhan vien. Can them nhan vien");
            return;
        }
//        else {
//            TruongPhong oldTruongPhong = null;
//            for (NhanSu ns : qlns.getDsNhanSu()) {
//                if (ns instanceof TruongPhong) {
//                    if (((TruongPhong) ns).getPhongBan().getIdPhongBan().equals(currentPhongBan.getIdPhongBan())) {
//                        oldTruongPhong = (TruongPhong) ns;
//                    }
//                }
//            }
//            //in ID nhan vien trong phong ban
//            currentPhongBan.printDsNhanVienPhongBan();
//            //neu phong ban co truong phong
//            if (oldTruongPhong != null) {
//                System.out.print("Nhap ID nhan vien thay the: ");
//                String id = sc.nextLine();
//                if (currentPhongBan.getNhanVienById(id) != null && !currentPhongBan.getNhanVienById(id).getIsDelete()) {
//                    NhanVien tmpNhanVien = currentPhongBan.getNhanVienById(id);
//                    //xoa nhan vien va truong phong ra khoi qlns để dễ hiểu
//                    qlns.removeNhanSu(oldTruongPhong.getId());
//                    qlns.removeNhanSu(tmpNhanVien.getId());
//                    currentPhongBan.removeNhanVien(tmpNhanVien.getId());
//
//                    //chuyen truong phong thanh nhan vien
//                    NhanVien newNv = new NhanVien(oldTruongPhong.getId(), oldTruongPhong.getName(), oldTruongPhong.getPhone(), oldTruongPhong.getDiaChi(), oldTruongPhong.getNamVaoLam(), oldTruongPhong.getKinhNghiem());
//                    qlns.addNhanSu(newNv);
//                    currentPhongBan.addNhanVien(newNv);
//
//                    //chuyen nhan vien thanh truong phong
//                    TruongPhong newTp = new TruongPhong(tmpNhanVien.getId(), tmpNhanVien.getName(), tmpNhanVien.getPhone(), tmpNhanVien.getDiaChi(), tmpNhanVien.getNamVaoLam(), tmpNhanVien.getKinhNghiem(), currentPhongBan);
//                    qlns.addNhanSu(newTp);
//                }
//            }
//            //neu phong ban chua co truong phong
//            else {
//                System.out.print("Chua co truong phong, nhap ID nhan vien lam truong phong: ");
//                String id = sc.nextLine();
//                if (currentPhongBan.getNhanVienById(id) != null && !currentPhongBan.getNhanVienById(id).getIsDelete()) {
//                    NhanVien tmpNhanVien = currentPhongBan.getNhanVienById(id);
//                    //xoa nhan vien ra khoi qlns để dễ hiểu
//                    qlns.removeNhanSu(tmpNhanVien.getId());
//                    currentPhongBan.removeNhanVien(tmpNhanVien.getId());
//                    //chuyen nhan vien thanh truong phong
//                    TruongPhong newTp = new TruongPhong(tmpNhanVien.getId(), tmpNhanVien.getName(), tmpNhanVien.getPhone(), tmpNhanVien.getDiaChi(), tmpNhanVien.getNamVaoLam(), tmpNhanVien.getKinhNghiem(), currentPhongBan);
//                    qlns.addNhanSu(newTp);
//                } else {
//                    System.out.println("ID khong ton tai");
//                }
//            }
//        }
        System.out.println("ID truong phong hien tai: " + currentPhongBan.getTruongPhong().getId());
        currentPhongBan.printDsNhanVienPhongBan();
        TruongPhong oldTruongPhong = null;
        for (NhanSu ns : qlns.getDsNhanSu()) {
            if (ns instanceof TruongPhong) {
                if (((TruongPhong) ns).getPhongBan().getIdPhongBan().equals(currentPhongBan.getIdPhongBan())) {
                    oldTruongPhong = (TruongPhong) ns;
                }
            }
        }
        if(oldTruongPhong == null){
            System.out.println("Phong ban chua co truong phong");
            System.out.print("Nhap ID nhan vien se lam truong phong: ");
            String id = sc.nextLine();
            if(currentPhongBan.getNhanVienById(id) == null || currentPhongBan.getNhanVienById(id).getIsDelete()){
                System.out.println("ID nhan vien khong ton tai trong phong ban nay");
                return;
            }

        }
    }
}
