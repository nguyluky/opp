package com.companyname.doAn.type;

public class KyLuat {
    private String lyDo;
    private int tienPhat;

    public KyLuat(String lyDo, int tienPhat){
        this.lyDo = lyDo;
        this.tienPhat = tienPhat;
    }

    public String getLyDo(){
        return this.lyDo;
    }

    public int getTienPhat(){
        return this.tienPhat;
    }

    public void setLyDo(String lyDo){
        this.lyDo = lyDo;
    }

    public void setTienPhat(int tienPhat){
        this.tienPhat = tienPhat;
    }
}
