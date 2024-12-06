package com.companyname.doAn.type;

import java.util.Arrays;

import static com.companyname.doAn.Gui.StaticScanner.qlns;


public class PhongBan {
    private String namePhongBan;
    private String idPhongBan;
    private NhanVien[] dsNhanVien;
    private TruongPhong[] truongPhong;
    private DuAn[] dsDuAn;
    private boolean isDelete;

    // Dùng để đọc ghi file
    public PhongBan(String name, String id, NhanVien[] dsNhanVien, TruongPhong[] truongPhong, DuAn[] dsDuAn, boolean isDelete) {
        this.namePhongBan = name;
        this.idPhongBan = id;
        this.dsNhanVien = dsNhanVien;
        this.truongPhong = truongPhong;
        this.dsDuAn = dsDuAn;
        this.isDelete = isDelete;
    }

    public PhongBan(String name, String id){
        this(name, id, false);
    }

    public PhongBan(String name, String id, boolean isDelete){
        this.namePhongBan = name;
        this.idPhongBan = id;
        this.dsNhanVien = new NhanVien[0];
        this.truongPhong = new TruongPhong[0];
        this.dsDuAn = new DuAn[0];
        this.isDelete = isDelete;
    }

    //----------GET--------------
    public TruongPhong[] getDsTruongPhong(){
        return this.truongPhong;
    }

    public String getNamePhongBan(){
        return this.namePhongBan;
    }

    public String getIdPhongBan(){
        return this.idPhongBan;
    }

    public NhanVien[] getDsNhanVien(){
        return this.dsNhanVien;
    }

    public DuAn[] getDsDuAn(){
        return this.dsDuAn;
    }

    public boolean getIsDelete(){
       return this.isDelete;
    }

    //----------------SET------------
    public void setDsTruongPhong(TruongPhong[] tp){
        this.truongPhong = tp;
    }

    public void setNamePhongBan(String name){
        this.namePhongBan = name;
    }

    public void setIdPhongBan(String id){
        this.idPhongBan = id;
    }

    public void setDsNhanVien(NhanVien dsnv[]){
        this.dsNhanVien = dsnv;
    }

    public void setDsDuAn(DuAn dsda[]){
        this.dsDuAn = dsda;
    }

    public void setIsDelete(boolean status){
        this.isDelete = status;
    }


    public void printThongTinPhongBan(){
        System.out.println("Tên: " + this.namePhongBan);
        System.out.println("ID: " + this.idPhongBan);
        if(this.truongPhong.length == 0) System.out.println("Trưởng phòng: Chưa có");
        else{
            int index = -1;
            for(int i=0; i<this.truongPhong.length; i++){
                if(!this.truongPhong[i].getIsDelete()){
                    index = i;
                    break;
                }
            }
            if(index != -1){
                System.out.println("Trưởng phòng: " + this.truongPhong[index].getHo() +" "+ this.truongPhong[index].getTen() + ". ID: " + this.truongPhong[index].getId());
            }
            else System.out.println("Trưởng phòng: Chưa có");
        }
        System.out.println("Số lượng nhân viên đang làm: " + this.dsNhanVien.length);
        int i=1;
        for(NhanVien nv : this.dsNhanVien){
            if(!nv.getIsDelete()) {
                System.out.println("Nhân viên thứ " + i + ": " + nv.getHo()+" "+nv.getTen() + ". ID: " + nv.getId());
                i++;
            }
        }
        System.out.println("Số lượng dự án: " + this.dsDuAn.length);
        if(this.dsDuAn.length > 0) {
            System.out.println("Danh sách dự án đã dừng hoạt động:");
            boolean checkOff = false;
            int j=1;
            for (DuAn da : this.dsDuAn) {
                if (da.getIsDelete()) {
                    System.out.println("Dự án thứ " + j + ": " + da.getNameDuAn() + ". ID: " + da.getIdDuAn());
                    j++;
                    checkOff = true;
                }
            }
            if(!checkOff) {
                System.out.println("Không có");
            }
            System.out.println("Danh sách dự án đang hoạt động:");
            boolean checkOn = false;
            int k=1;
            for (DuAn da : this.dsDuAn) {
                if (!da.getIsDelete()) {
                    System.out.println("Dự án thứ " + k + ": " + da.getNameDuAn() + ". ID: " + da.getIdDuAn());
                    k++;
                    checkOn = true;
                }
            }
            if(!checkOn) {
                System.out.println("Không có");
            }
        }
    }

    public void printDsNhanSu(){
        System.out.println("-----------------------------------");
        if(this.truongPhong.length == 0) System.out.println("Trưởng phòng: Chưa có");
        else{
            int index = -1;
            for(int i=0; i<this.truongPhong.length; i++){
                if(!this.truongPhong[i].getIsDelete()){
                    index = i;
                    break;
                }
            }
            if(index != -1){
                System.out.println("Trưởng phòng: " + this.truongPhong[index].getHo()+" "+this.truongPhong[index].getTen() + ". ID: " + this.truongPhong[index].getId());
            }
            else System.out.println("Trưởng phòng: Chưa có");
        }
        System.out.println("Danh sach nhan vien: " + this.dsNhanVien.length);
        int i=1;
        for(NhanVien nv : this.dsNhanVien){
            if(!nv.getIsDelete()){
                System.out.print("Nhân viên thứ " + i + " : ");
                System.out.println(nv.getHo()+" "+nv.getTen() + ". ID: " + nv.getId());
                i++;
            }
        }
    }

    public void addNhanVien(NhanVien nv){
        this.dsNhanVien = Arrays.copyOf(this.dsNhanVien, this.dsNhanVien.length + 1);
        this.dsNhanVien[this.dsNhanVien.length - 1] = nv;
    }

    public void removeNhanVien(String id){
        for(int i=0; i<this.dsNhanVien.length; i++){
            if(this.dsNhanVien[i].getId().equals(id)){
                this.dsNhanVien[i] = this.dsNhanVien[this.dsNhanVien.length - 1];
                break;
            }
        }
        this.dsNhanVien = Arrays.copyOf(this.dsNhanVien, this.dsNhanVien.length - 1);
    }

    public void printDsDuAn(){
        int i=0;
        for(DuAn da : this.dsDuAn) {
            if (!da.getIsDelete()) {
                System.out.println("Dự án thứ " + i+1 + " :");
                System.out.println(da.getNameDuAn() + ". ID: " + da.getIdDuAn());
                i++;
            }
        }
        if(i==0) System.out.println("Khong co du an");
    }

    public void addDuAn(DuAn da){
        this.dsDuAn = Arrays.copyOf(this.dsDuAn, this.dsDuAn.length + 1);
        this.dsDuAn[this.dsDuAn.length - 1] = da;
    }

    public void removeDuAn(String id){
        for(int i=0; i<this.dsDuAn.length; i++){
            if(this.dsDuAn[i].getIdDuAn().equals(id)){
                this.dsDuAn[i].setIsDelete(true);
                break;
            }
        }
    }

    public NhanVien getNhanVienById(String id){
        for(NhanVien nv : this.getDsNhanVien()){
            if(nv.getId().equals(id)){
                return nv;
            }
        }
        return null;
    }

    public DuAn getDuAnById(String id){
        for(DuAn da : this.getDsDuAn()){
            if(da.getIdDuAn().equals(id)){
                return da;
            }
        }
        return null;
    }

    public void changeTruongPhong(TruongPhong newTruongPhong){
        //nếu mảng danh sách truong phong la 0
        if(this.getDsTruongPhong().length == 0){
            TruongPhong[] tmpDs = Arrays.copyOf(this.truongPhong, this.truongPhong.length + 1);
            tmpDs[tmpDs.length - 1] = newTruongPhong;
            this.setDsTruongPhong(tmpDs);
            return;
        }
        //nếu all danh sách trường phòng đều nghỉ việc isDelete: true
        int index = -1;
        for(int i = 0; i<this.getDsTruongPhong().length; i++){
            if(!this.getDsTruongPhong()[i].getIsDelete()){
                index = i;
                break;
            }
        }
        if(index == -1){
            TruongPhong[] tmpDs = Arrays.copyOf(this.truongPhong, this.truongPhong.length + 1);
            tmpDs[tmpDs.length - 1] = newTruongPhong;
            this.setDsTruongPhong(tmpDs);
            return;
        }
        // nếu có trưởng phòng cũ thì chuyển đổi
        for(int i=0; i<qlns.getDsNhanSu().length; i++){
            if(qlns.getDsNhanSu()[i].getId().equals(this.truongPhong[index].getId())) {
                //chuyển trưởng phòng cũ thành nhân viên mới
                NhanVien newNv = new NhanVien(this.truongPhong[index].getId(),this.truongPhong[index].getHo(),this.truongPhong[index].getTen(),this.truongPhong[index].getPhone(),this.truongPhong[index].getDiaChi(),this.truongPhong[index].getNamVaoLam(),this.truongPhong[index].getKinhNghiem());
                newNv.setDsKhenThuong(this.truongPhong[index].getDsKhenThuong());
                newNv.setDsKyLuat(this.truongPhong[index].getDsKyLuat());
                qlns.getDsNhanSu()[i] = newNv;
                this.addNhanVien(newNv);
            }
        }
        //set trưởng phòng mới
        TruongPhong[] tmpDs = Arrays.copyOf(this.truongPhong, this.truongPhong.length + 1);
        tmpDs[tmpDs.length - 1] = newTruongPhong;
        this.setDsTruongPhong(tmpDs);
    }
}
