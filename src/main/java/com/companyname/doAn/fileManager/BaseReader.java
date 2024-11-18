package com.companyname.doAn.fileManager;

import java.io.FileNotFoundException;
import java.util.Arrays;

public interface BaseReader<T> {
    public final String separated = ";";

    abstract T[] read() throws FileNotFoundException;
    public static String[] split(String text) {
        text = text.trim() + ";";
        String[] relut = new String[0];
        String buff = "";

        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == '"') {
                int start = i;
                int end = i;
                for (int j = i + 1; j < text.length(); j++) {
                    if (text.charAt(j) == '"') {
                        end = j;
                        break;
                    }
                }

                if (end == i) {
                    System.err.println("Error: Invalid format at " + i + " in " + text + "!");
                    System.exit(-1);
                }

                String tem = text.substring(start, end + 1);
                if (tem.equals("\"\"")) {
                    buff += "\"";
                } else {
                    buff += tem.substring(1, tem.length() - 1);
                }

                i = end;
                continue;
            }
            
            if (text.charAt(i) == ';') {
                relut = Arrays.copyOf(relut, relut.length + 1);
                relut[relut.length - 1] = buff;
                buff = "";
                continue;
            }

            buff += text.charAt(i);
        }

        return relut;
    }
}
