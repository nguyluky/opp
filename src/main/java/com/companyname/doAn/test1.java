package com.companyname.doAn;

import java.lang.reflect.Field;

import com.companyname.doAn.type.TruongPhong;

public class test1 {
    public static void main(String[] args) {
        Field[] a = TruongPhong.class.getDeclaredFields();
        for (Field b : a) {
            System.out.println(b.getName());
            String geterName = capitalize(b.getName());

            
        }
    }    

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
