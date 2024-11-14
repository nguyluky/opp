package com.companyname.doAn.Gui;

public abstract class Element {
    int height, width, top, left;
    String id;

    public Element(String id,int height, int width, int top, int left) {    
        this.id = id;
        this.height = height; 
        this.width = width; 
        this.top = top; 
        this.left = left;
    }

    public abstract void render();
    public abstract void update();
    public abstract void remove();
}
