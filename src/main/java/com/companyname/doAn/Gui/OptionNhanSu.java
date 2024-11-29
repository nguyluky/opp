package com.companyname.doAn.Gui;

import com.companyname.doAn.type.KhenThuong;
import com.companyname.doAn.type.KyLuat;
import com.companyname.doAn.type.NhanSu;

import java.util.Arrays;

import static com.companyname.doAn.Gui.StaticScanner.sc;

public class OptionNhanSu {
    public OptionNhanSu(){}

    public void kyLuat(NhanSu currentNhanSu){
        System.out.print("Nhap so lan ky luat: ");
        int sl;
        while(true){
            try {
                sl = Integer.parseInt(sc.nextLine());
                if(sl<0){
                    System.out.println("Can nhap so nguyen duong");
                }
                else break;
            }catch (NumberFormatException e){
                System.out.println("Can nhap so nguyen duong");
            }
        }
        KyLuat[] dsKyLuat = currentNhanSu.getDsKyLuat();
        for(int i=0; i<sl; i++){
            dsKyLuat = Arrays.copyOf(currentNhanSu.getDsKyLuat(), currentNhanSu.getDsKyLuat().length+1);
            System.out.print("Nhap ly do: ");
            String lyDo = sc.nextLine();
            System.out.print("Nhap tien phat: ");
            int tienPhat = Integer.parseInt(sc.nextLine());
            dsKyLuat[dsKyLuat.length-1] = new KyLuat(lyDo, tienPhat);
        }
        currentNhanSu.setDsKyLuat(dsKyLuat);
    }

    public void khenThuong(NhanSu currentNhanSu){
        System.out.print("Nhap so lan khen thuong: ");
        int sl;
        while(true){
            try {
                sl = Integer.parseInt(sc.nextLine());
                if(sl<0){
                    System.out.println("Can nhap so nguyen duong");
                }
                else break;
            }catch (NumberFormatException e){
                System.out.println("Can nhap so nguyen duong");
            }
        }
        KhenThuong[] dsKhenThuong = currentNhanSu.getDsKhenThuong();
        for(int i=0; i<sl; i++){
            dsKhenThuong = Arrays.copyOf(currentNhanSu.getDsKhenThuong(), currentNhanSu.getDsKhenThuong().length+1);
            System.out.print("Nhap ly do: ");
            String lyDo = sc.nextLine();
            System.out.print("Nhap tien thuong: ");
            int tienThuong = Integer.parseInt(sc.nextLine());
            dsKhenThuong[dsKhenThuong.length-1] = new KhenThuong(lyDo, tienThuong);
        }
        currentNhanSu.setDsKhenThuong(dsKhenThuong);
    }

    public void printTinhTrangKhenThuong(NhanSu currentNhanSu){
        int i=0;
        System.out.println("So lan khen thuong: " + currentNhanSu.getDsKhenThuong().length);
        for(KhenThuong kt : currentNhanSu.getDsKhenThuong()){
            System.out.println("Lan " + i+1 + ": " + kt.getLyDo() + ". Tien thuong: " + kt.getTienThuong());
            i++;
        }
    }

    public void printTinhTrangKyLuat(NhanSu currentNhanSu){
        int i=0;
        System.out.println("So lan ky luat: " + currentNhanSu.getDsKyLuat().length);
        for(KyLuat kl : currentNhanSu.getDsKyLuat()){
            System.out.println("Lan " + i+1 + ": " + kl.getLyDo() + ". Tien thuong: " + kl.getTienPhat());
            i++;
        }
    }
}
