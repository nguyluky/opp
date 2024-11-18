package com.companyname.doAn.fileManager;

public interface BaseWriter {
    abstract void addField(String name,  String value);
    abstract void render();
}
