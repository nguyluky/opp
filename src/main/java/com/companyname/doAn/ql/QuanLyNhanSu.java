package com.companyname.doAn.ql;

import java.util.Arrays;

import com.companyname.doAn.Gui.ShowOption;
import com.companyname.doAn.type.NhanSu;
import com.companyname.doAn.type.NhanVien;
import com.companyname.doAn.type.TruongPhong;

public class QuanLyNhanSu {
    private NhanSu dsNhanSu[];
    private static QuanLyNhanSu instance = null;

    public static QuanLyNhanSu getInstance(){
        if(instance == null){
            instance = new QuanLyNhanSu();
        }
        return instance;
    }

    public QuanLyNhanSu(){
        this.dsNhanSu = new NhanSu[0];
    }

    public void addNhanSu(NhanSu nhanSu) {
        this.dsNhanSu = Arrays.copyOf(this.dsNhanSu, this.dsNhanSu.length + 1);
        this.dsNhanSu[this.dsNhanSu.length - 1] = nhanSu;
    }

    public void removeNhanSu(String id) {
        for (int i = 0; i < this.dsNhanSu.length; i++) {
            if (this.dsNhanSu[i].getId().equals(id)) {
                this.dsNhanSu[i] = this.dsNhanSu[this.dsNhanSu.length - 1];
                break;
            }
        }

        this.dsNhanSu[this.dsNhanSu.length - 1].setDelete(true);
    }

    public NhanSu[] getDsNhanSu() {
        return dsNhanSu;
    }

    public NhanVien[] getNhanViens() {
        NhanVien[] nhanViens = new NhanVien[0];
        for (NhanSu nhanSu : this.dsNhanSu) {
            if (nhanSu instanceof NhanVien) {
                nhanViens = Arrays.copyOf(nhanViens, nhanViens.length + 1);
                nhanViens[nhanViens.length - 1] = (NhanVien) nhanSu;
            }
        }
        return nhanViens;
    }

    public NhanSu getNhanSuById(String id) {
        for (NhanSu nhanSu : this.dsNhanSu) {
            if (nhanSu.getId().equals(id)) {
                return nhanSu;
            }
        }
        return null;
    }


    public TruongPhong[] getTruongPhongs() {
        TruongPhong[] truongPhongs = new TruongPhong[0];
        for (NhanSu nhanSu : this.dsNhanSu ) {
            if (nhanSu instanceof TruongPhong && !nhanSu.getIsDelete()) {
                truongPhongs = Arrays.copyOf(truongPhongs, truongPhongs.length + 1);
                truongPhongs[truongPhongs.length - 1] = (TruongPhong) nhanSu;
            }
        }
        return truongPhongs;
    }

    public void setNhanViens(NhanVien[] nhanViens) {
        for (NhanVien nhanVien : nhanViens) {
            this.addNhanSu(nhanVien);
        }
    }



    public void setTruongPhongs(TruongPhong[] truongPhongs) {
        for (TruongPhong truongPhong : truongPhongs) {
            this.addNhanSu(truongPhong);
        }
    }

    public NhanVien getNhanVienById(String id) {
        for (NhanVien nhanVien : this.getNhanViens()) {
            if (nhanVien.getId().equals(id)) {
                return nhanVien;
            }
        }
        return null;
    }

//    public void printDsNhanSuDangLam(){
//        // System.out.println("---------------------------------------");
        // ShowOption.clearScreen();

//        boolean check = false;
//        for(NhanSu ns : this.dsNhanSu){
//            if(!ns.getIsDelete()) check = true;
//        }
//        if(!check){
//            System.out.println("Không có nhân viên nào");
//            return;
//        }
//        System.out.println("Danh sách nhân sự đang làm việc:");
//        int i = 1;
//        for(NhanSu nhanSu : this.dsNhanSu){
//            if(!nhanSu.getIsDelete()){
//                if(nhanSu instanceof NhanVien){
//                    System.out.println("Nhân sự thứ " + i + ": " + nhanSu.getName() + ". ID: " + nhanSu.getId() + ". Chức vụ: Nhân viên");
//                }
//                else{
//                    System.out.println("Nhân sự thứ " + i + ": " + nhanSu.getName() +  ". ID: " + nhanSu.getId() + ". Chức vụ: Trưởng phòng");
//                }
//            }
//        }
//    }
//
//    public void printDsNhanSuDaNghi(){
//        // System.out.println("---------------------------------------");
        // ShowOption.clearScreen();

//        boolean check = false;
//        for(NhanSu ns : this.dsNhanSu){
//            if(ns.getIsDelete()) check = true;
//        }
//        if(!check){
//            System.out.println("Không có nhân viên nào");
//            return;
//        }
//        int i = 1;
//        for(NhanSu nhanSu : this.dsNhanSu){
//            if(nhanSu.getIsDelete()){
//                if(nhanSu instanceof NhanVien){
//                    System.out.println("Nhân sự thứ " + i + ": " + nhanSu.getName() + nhanSu.getId() + "Chức vụ: Nhân viên");
//                }
//                else{
//                    System.out.println("Nhân sự thứ " + i + ": " + nhanSu.getName() + nhanSu.getId() + "Chức vụ: Trưởng phòng");
//                }
//            }
//        }
//
//    }
//
//    public void printDsNhanVienDangLam(){
//        // System.out.println("---------------------------------------");
        // ShowOption.clearScreen();

//        boolean check = false;
//        for(NhanVien nv : this.getNhanViens()){
//            if(!nv.getIsDelete()) check = true;
//        }
//        if(!check){
//            System.out.println("Không có nhân viên nào");
//            return;
//        }
//        System.out.println("Danh sách nhân viên đang làm việc:");
//        int i = 1;
//        for(NhanVien nv : this.getNhanViens()){
//            if(!nv.getIsDelete()){
//                System.out.println("Nhân sự thứ " + i + ": " + nv.getName() + ". ID: " + nv.getId());
//            }
//        }
//    }

    public void printDsNhanSu(){
        // System.out.println("---------------------------------------");
        ShowOption.clearScreen();

        System.out.println("Danh sách nhan su da nghi lam:");
        int i=1;
        for(NhanSu ns : this.dsNhanSu){
            if(ns.getIsDelete()){
                System.out.println("Nhân sự thứ " + i + ": " + ns.getName() + ". ID: " + ns.getId());
                i++;
            }
        }
        if(i==1) System.out.println("Không có nhân sự nào");

        System.out.println("Danh sách nhan su đang làm việc:");
        int j=1;
        for(NhanSu ns : this.dsNhanSu){
            if(!ns.getIsDelete()){
                System.out.println("Nhân sự thứ " + j + ": " + ns.getName() + ". ID: " + ns.getId());
                j++;
            }
        }
        if(j==1) System.out.println("Không có nhân sự nào");
    }

    @Override
    public String toString() {
        return "QuanLyNhanSu{" +
                "dsNhanSu=" + Arrays.toString(dsNhanSu) +
                '}';
    }
}
