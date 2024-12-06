package com.companyname.doAn.fileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.FormatterClosedException;
import java.util.Scanner;

import javax.annotation.processing.FilerException;

import com.companyname.doAn.type.NhanVien;
import com.companyname.doAn.type.TruongPhong;

public abstract class FileReaderWriter<T> implements BaseReader<T>, BaseWriter<T> {

    protected String filePath;
    Field[] fields;
    Class<T> clazz;
    File file;
    Scanner sc;

    FileReaderWriter(Class<T> clazz, String filePath) {
        this.clazz = clazz;
        this.fields = new Field[0];
        this.getAllFields();
        this.filePath = filePath;
        file = new File(this.filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public T[] read() throws FileNotFoundException {
        sc = new Scanner(file);
        
        T[] li = (T[]) Array.newInstance(this.clazz, 0);
        try {
            Constructor<T> constructor = this.clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            while (sc.hasNextLine()) {


                T instance = constructor.newInstance();

                String data = sc.nextLine();
                String[] arr = BaseReader.split(data);

                if (fields.length != arr.length) {
                    throw new IllegalArgumentException("Mismatch between fields and values.");
                }
    
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    field.setAccessible(true); // Allow access to private fields
                    Object data_ = stringToValue(fields[i].getType(), arr[i]);
                    field.set(instance, data_); // Set field value
                }
                li = Arrays.copyOf(li , li.length + 1);
                li[li.length - 1] = instance;
            }
                
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return li;
    }

    @Override
    public void save(T[] data) throws IOException{
        FileWriter writer = new FileWriter(file);
        for (T row: data) {
            try {
                String line = instanceToString(row);
                writer.write(line + "\n");

            } 
            catch (IllegalAccessException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        writer.close();
    }

    void getAllFields() {
        Class class1 = clazz;
        while (class1 != null) {
            // System.out.println("Class: " + class1.getName());
            Field[] fields = class1.getDeclaredFields();
            for (Field field : fields) {
                this.fields = Arrays.copyOf(this.fields, this.fields.length + 1);
                field.setAccessible(true);
                this.fields[this.fields.length - 1] = field;
            }
            class1 = class1.getSuperclass();
        }
    }

    public String instanceToString(T instance) throws IllegalAccessException {

        String[] arrStrings = new String[fields.length];


        for(int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            Object value = field.get(instance);
            String valueString = valueToString(field.getName(), value);
            if (valueString == null) {
                if (value != null) valueString = value.toString();
                else valueString = "";
            }

            arrStrings[i] = valueString;
        }

        for (int i = 0; i < arrStrings.length; i++) {
            arrStrings[i] = BaseWriter.escape(arrStrings[i]);
        }

        return String.join(BaseReader.separated, arrStrings);
    }
    abstract String valueToString(String fieldName, Object value);
    Object stringToValue(Class fieldType, String value) {

        if ( int.class == fieldType) {
            return Integer.parseInt(value);
        }
        if (fieldType == String.class) {
            return value;
        }
        if (fieldType == double.class) {
            return Double.parseDouble(value);
        }
        if (fieldType == boolean.class) {
            return Boolean.parseBoolean(value);
        }

        return null;
    }
}
