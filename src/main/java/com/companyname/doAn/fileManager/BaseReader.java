package com.companyname.doAn.fileManager;

import java.io.FileNotFoundException;

public interface BaseReader<T> {
    abstract T[] read() throws FileNotFoundException;
}
