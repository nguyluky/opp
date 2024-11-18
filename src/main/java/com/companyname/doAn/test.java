package com.companyname.doAn;

import com.companyname.doAn.fileManager.BaseReader;
import com.companyname.doAn.fileManager.BaseWriter;

public class test {
    public static void main(String[] args) {

        String[] inputArr = {
            "12345",
            "dhe\";hjef",
            "\"",
        };

        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = BaseWriter.escape(inputArr[i]);
        }

        System.out.println(String.join(BaseReader.separated, inputArr));

        String[] arr = BaseReader.split(String.join(BaseReader.separated, inputArr));

        for (String s : arr) {
            System.out.print(s + " ");
        }
    }
}
