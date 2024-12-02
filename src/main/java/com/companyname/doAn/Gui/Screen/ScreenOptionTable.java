package com.companyname.doAn.Gui.Screen;

import com.companyname.doAn.Gui.Display;

public abstract class ScreenOptionTable extends ScreenOption {

    ScreenTable table;
    public ScreenOptionTable(String[] options, ScreenTable table) {
        super("", options);
        this.table = table;
    }

    @Override
    public void show(Display display) {
        table.printTable(table.getDataStrings());
        this.minWith = table.totalLen - 2;
        this.calulateMaxWidth();
        super.show(display);
    }

}
