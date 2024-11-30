package com.companyname.doAn.type;

public class KhenThuong {
    private String lyDo;
    private int tienThuong;
    public KhenThuong(String lyDo, int tienThuong) {
        this.lyDo = lyDo;
        this.tienThuong = tienThuong;
    }

    public String getLyDo(){
        return this.lyDo;
    }

    public int getTienThuong(){
        return this.tienThuong;
    }

    public void setLyDo(String lyDo){
        this.lyDo = lyDo;
    }

    public void setTienThuong(int tienThuong){
        this.tienThuong = tienThuong;
    }

    // Không đồng vào nha
    public String toString(){
        return this.lyDo + "-" + this.tienThuong;
    }
}
