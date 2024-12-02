package com.companyname.doAn.Gui;

import com.companyname.doAn.type.*;

import static com.companyname.doAn.Gui.StaticScanner.*;

public class OptionPhongBan{
    public OptionPhongBan(){}

    public void themDuAn(PhongBan currentPhongBan){
        System.out.println("-----------------------------------");
        System.out.print("Nhập số dự án muốn thêm: ");
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
            String nameDuAn;
            while(true){
                System.out.printf("Nhập tên dự án thứ " + (i+1) + ": ");
                nameDuAn = sc.nextLine().trim();
                if(qlda.getDuAnByName(nameDuAn) != null){
                    System.out.println("-----------------------------------");
                    System.out.println("Tên dự án đã tồn tại");
                }
                else break;
            }
            String idDuAn;
            while (true) {
                System.out.printf("Nhập id dự án: " + (i + 1) + ": ");
                idDuAn = sc.nextLine().trim();
                if(qlda.getDuAnById(idDuAn) != null){
                    System.out.println("-----------------------------------");
                    System.out.println("ID dự án đã tồn tại");
                }
                else break;
            }
            System.out.printf("Nhập số lượng nhân sự dự án: "  + (i+1) + ": ");
            int slNhanSu;
            while(true) {
                try {
                    slNhanSu = Integer.parseInt(sc.nextLine());
                    if (slNhanSu < 0) {
                        System.out.println("Cần nhập số nguyên dương");
                    }
                    else break;
                } catch (NumberFormatException e) {
                    System.out.println("Cần nhập số nguyên dương");
                }
            }

            NhanSu[] dsNhanSu = new NhanSu[slNhanSu];

            qlns.printDsNhanSu();
            for(int j=0; j<slNhanSu; j++){
                System.out.println("---------------------------------------");
                System.out.print("Nhập ID nhân sự thứ " + (j + 1) + " muốn thêm vào dự án: ");
                String idNhanSu = sc.nextLine().trim();
                NhanSu ns = qlns.getNhanSuById(idNhanSu);
                if(ns != null && !ns.getIsDelete()){
                    dsNhanSu[j] = ns;
                    System.out.println("---------------------------------------");
                    System.out.println("Thêm thành công");
                }
                else{
                    System.out.println("---------------------------------------");
                    System.out.println("ID nhân sự không tồn tại");
                    j--;
                }
            }
            dsDuAn[i] = new DuAn(nameDuAn, idDuAn);
            dsDuAn[i].setDsNhanSu(dsNhanSu);

            qlda.addDuAn(dsDuAn[i]);
            currentPhongBan.addDuAn(dsDuAn[i]);
        }
    }

    public void xoaDuAn(PhongBan currentPhongBan){
        System.out.print("Nhập số lượng dự án muốn xóa khỏi phòng ban này: ");
        int slDuAn;
        while(true){
            try {
                slDuAn = Integer.parseInt(sc.nextLine());
                if(slDuAn < 0 || slDuAn > currentPhongBan.getDsDuAn().length){
                    System.out.println("Cần nhập số hợp lệ");
                }
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Cần nhập số hợp lệ");
            }
        }
    if(slDuAn==0) return;
        currentPhongBan.printDsDuAn();
        for(int i=0; i<slDuAn; i++){
            System.out.println("Nhập id dự án thứ " + (i+1) + " muốn xóa khỏi phòng ban này");
            String idDuAn = sc.nextLine().trim();
            if(currentPhongBan.getDuAnById(idDuAn) == null || currentPhongBan.getDuAnById(idDuAn).getIsDelete()) {
                System.out.print("Dự án không tồn tại");
            }
            else{
                currentPhongBan.removeDuAn(idDuAn);
            }
        }
    }

    public void themNhanVien(PhongBan currentPhongBan){
        System.out.print("Nhập số lượng nhân viên muốn thêm vào phòng ban này: ");
        int slNhanVien;
        while(true) {
            try {
                slNhanVien = Integer.parseInt(sc.nextLine());
                if (slNhanVien < 0) {
                    System.out.println("Cần nhập số nguyên dương");
                }
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Cần nhập số nguyên dương");
            }
        }

        qlns.printDsNhanSu();
        for(int i=0; i<slNhanVien; i++){
            System.out.println("---------------------------------------");
            System.out.print("Nhập ID nhân viên thứ " + (i+1) + ": ");
            String idNhanVien = sc.nextLine().trim();
            if(qlns.getNhanVienById(idNhanVien) == null || qlns.getNhanVienById(idNhanVien).getIsDelete()){
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
                if(phongbanTmp.equals(currentPhongBan)){
                    System.out.println("ID nhân viên đã tồn tại trong phòng ban này");
                    return;
                }
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
                        currentPhongBan.addNhanVien(qlns.getNhanVienById(idNhanVien));
                        break;
                    case 2:
                        return;
                }
            }
            else{
                currentPhongBan.addNhanVien(qlns.getNhanVienById(idNhanVien));
                System.out.println("---------------------------------------");
                System.out.println("Thêm nhân viên thành công");
            }
        }
    }

    public void xoaNhanVien(PhongBan currentPhongBan){
        System.out.print("Nhập số lượng nhân viên muốn xóa khỏi phòng ban này: ");
        int slNhanVien;
        while(true) {
            try {
                slNhanVien = Integer.parseInt(sc.nextLine());
                if (slNhanVien < 0 || slNhanVien > currentPhongBan.getDsNhanVien().length) {
                    System.out.println("Cần nhập số hợp lệ");
                }
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Cần nhập số hợp lệ");
            }
        }
        if(slNhanVien==0) return;

        for(int i=0; i<slNhanVien; i++){
            currentPhongBan.printDsNhanSu();
            System.out.print("-----------------------------------");
            System.out.print("Nhập ID nhân viên muốn xóa: ");
            String idNhanVien = sc.nextLine().trim();
             //kiểm tra id nhân viên có tồn tại trong công ty hay không
            if(currentPhongBan.getNhanVienById(idNhanVien) == null || currentPhongBan.getNhanVienById(idNhanVien).getIsDelete()){
                System.out.println("Id nhân viên không tồn tại");
            }
            else{
                System.out.print("-----------------------------------");
                System.out.print("Xóa thành công");
                currentPhongBan.removeNhanVien(idNhanVien);
            }
        }
    }

    public void thayDoiTruongPhong(PhongBan currentPhongBan){
        if(currentPhongBan.getDsNhanVien().length==0){
            System.out.println("Phong ban chua co nhan vien. Can them nhan vien");
            return;
        }

        currentPhongBan.printDsNhanSu();
        System.out.print("Nhap ID nhan vien se lam truong phong: ");
        String id = sc.nextLine().trim();
        NhanVien oldNv = currentPhongBan.getNhanVienById(id);
        if(oldNv == null || oldNv.getIsDelete()){
            System.out.println("ID nhan vien khong ton tai trong phong ban nay");
            return;
        }
        TruongPhong newTruongPhong = new TruongPhong(oldNv.getId(), oldNv.getName(), oldNv.getPhone(), oldNv.getDiaChi(), oldNv.getNamVaoLam(), oldNv.getKinhNghiem());
        newTruongPhong.setDsKyLuat(oldNv.getDsKyLuat());
        newTruongPhong.setDsKhenThuong(oldNv.getDsKhenThuong());
        TruongPhong oldTruongPhong = currentPhongBan.getTruongPhong();
//        if(oldTruongPhong.getIsDelete()){
//
//
//
//            oldTruongPhong=null;
//        }

        if(oldTruongPhong == null){
            System.out.println("Phòng ban chưa có trưởng phòng. ID nhân viên vừa nhập sẽ làm trưởng phòng");
            int index=0;
            for(int k=0; k<qlns.getDsNhanSu().length; k++){
                if(qlns.getDsNhanSu()[k].equals(oldNv)){
                    index = k;
                    break;
                }
            }
            qlns.getDsNhanSu()[index] = newTruongPhong;
            currentPhongBan.setTruongPhong(newTruongPhong);
            currentPhongBan.removeNhanVien(id);
            System.out.println("-----------------------------------");
            System.out.println("Thay đổi thành công");
        }
        else{
            System.out.println("-----------------------------------");
            System.out.println("ID truong phong hien tai: " + currentPhongBan.getTruongPhong().getId());
            NhanVien newNv = new NhanVien(oldTruongPhong.getId(),oldTruongPhong.getName(),oldTruongPhong.getPhone(),oldTruongPhong.getDiaChi(),oldTruongPhong.getNamVaoLam(),oldTruongPhong.getKinhNghiem());
            newNv.setDsKhenThuong(oldTruongPhong.getDsKhenThuong());
            newNv.setDsKyLuat(oldTruongPhong.getDsKyLuat());

            for(int j=0; j<qlns.getDsNhanSu().length; j++){
                if(qlns.getDsNhanSu()[j].equals(oldNv)) {
                    qlns.getDsNhanSu()[j] = newTruongPhong;
                }
                if(qlns.getDsNhanSu()[j].equals(oldTruongPhong)){
                    qlns.getDsNhanSu()[j] = newNv;
                }

            }

            currentPhongBan.setTruongPhong(newTruongPhong);
            currentPhongBan.addNhanVien(newNv);
            currentPhongBan.removeNhanVien(oldNv.getId());

            System.out.println("ID truong phong moi: " + currentPhongBan.getTruongPhong().getId());
        }
    }
}
