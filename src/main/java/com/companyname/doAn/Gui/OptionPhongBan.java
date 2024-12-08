package com.companyname.doAn.Gui;

import com.companyname.doAn.type.*;

import static com.companyname.doAn.Gui.StaticScanner.*;

public class OptionPhongBan{
    public OptionPhongBan(){}

    public void themDuAn(PhongBan currentPhongBan){
        System.out.println("-----------------------------------");
        int slDa;
        while(true){
            try {
                System.out.print("Nhập số dự án muốn thêm: ");
                slDa = Integer.parseInt(sc.nextLine());
                if(slDa<0 && slDa<qlda.getDsDuAn().length){
                    System.out.println("Nhập số nguyên dương");
                }
                else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        }
        qlda.printDsDuAn();
        for(int i = 0; i < slDa; i++){
            System.out.print("Nhập ID dự án thứ" + (i+1) + " muốn thêm vào phòng ban: ");
            String id = sc.nextLine().trim();
            if(qlda.getDuAnById(id) == null || qlda.getDuAnById(id).getIsDelete()){
                System.out.println("-----------------------------------");
                System.out.println("ID dự án không tồn tại");
                break;
            }
            for(DuAn da : currentPhongBan.getDsDuAn()){
                if(da.getIdDuAn().equals(id)){
                    System.out.println("-----------------------------------");
                    System.out.println("Dự án đang hoạt động trong phòng ban này");
                    break;
                }
            }
            boolean checkExistOther = false;
            for(PhongBan pb : qlpb.getDsPhongBan()){
                for(DuAn da : pb.getDsDuAn()){
                    if(da.getIdDuAn().equals(id)){
                        System.out.println("-----------------------------------");
                        System.out.println("Dự án đã thuộc phòng ban khác");
                        checkExistOther = true;
                        break;
                    }
                }
                if(checkExistOther) break;
            }
            currentPhongBan.addDuAn(qlda.getDuAnById(id));
            System.out.println("-----------------------------------");
            System.out.println("Thêm thành công");
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
            System.out.println("Phòng ban chưa có nhân viên. Cần thêm nhân viên");
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
        TruongPhong newTruongPhong = new TruongPhong(oldNv.getId(), oldNv.getHo(), oldNv.getTen(), oldNv.getPhone(), oldNv.getDiaChi(), oldNv.getNamVaoLam(), oldNv.getKinhNghiem());
        newTruongPhong.setDsKyLuat(oldNv.getDsKyLuat());
        newTruongPhong.setDsKhenThuong(oldNv.getDsKhenThuong());
        newTruongPhong.setSoNgayNghi(oldNv.getSoNgayNghi());

        currentPhongBan.changeTruongPhong(newTruongPhong);
    }
}
