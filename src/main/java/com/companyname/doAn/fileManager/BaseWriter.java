package com.companyname.doAn.fileManager;

import java.io.IOException;

public interface BaseWriter<T> {
    abstract void save(T[] data) throws IOException;
    public static String escape(String text) {

        if (text.equals("")) {
            return "";
        }

        if (text == "\"") {
            return "\"\"";
        }

        return "\"" + text.replace("\"", "\"\"") + "\"";
    }
}