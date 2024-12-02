package com.companyname.doAn.Gui.Screen;

import com.companyname.doAn.Gui.Display;

public abstract class ScreenTable extends Screen {

    protected String[] title;
    protected int maxRow = 10;
    protected int page = 0;

    protected int totalLen = 0;

    public ScreenTable() {
        super();
    }

    public ScreenTable(String[] title) {
        super();
        this.title = title; 
    }

    public void printTable(String[][] data) {

        int[] max = new int[this.title.length];

        for (int i = 0; i < this.title.length; i++) {
            max[i] = this.title[i].length() + 4;
            for (int j = 0; j < data.length; j++) {
                if (data[j][i].length() > max[i]) {
                    max[i] = data[j][i].length() + 4;
                }
            }
        }

        totalLen = 0;
        for (int i = 0; i < this.title.length; i++) {
            totalLen += max[i];
        }
        totalLen += this.title.length - 1;

        System.out.print("╔");
        for (int i = 0; i < this.title.length; i++) {
            System.out.print("═".repeat(max[i]));
            if (i != this.title.length - 1) {
                System.out.print("╦");
            }
        }
        System.out.println("╗");

        for (int i = 0; i < title.length; i++) {

            String textStyle = this.colorText(this.centerText(title[i], max[i]), FG_COLOR.YELLOW, BG_COLOR.NONE);
            System.out.print("║" + textStyle);
            if (i == this.title.length - 1) {
                System.out.println("║");
            }
        }

        if (data.length == 0) {
            System.out.print("╠");
            for (int i = 0; i < this.title.length; i++) {
                System.out.print("═".repeat(max[i]));
                if (i != this.title.length - 1) {
                    System.out.print("╩");
                }
            }
            System.out.println("╣");

            System.out.println("║" + this.colorText(this.centerText("Không có dữ liệu", totalLen), FG_COLOR.RED, BG_COLOR.NONE) + "║");
            System.out.println("╚" + "═".repeat(totalLen) + "╝");
            return;
        }  
        System.out.print("╠");
        for (int i = 0; i < this.title.length; i++) {
            System.out.print("═".repeat(max[i]));
            if (i != this.title.length - 1) {
                System.out.print("╬");
            }
        }
        System.out.println("╣");

        for (int i = maxRow * page; i < Math.min(data.length, maxRow * (page + 1)); i++) {
            for (int j = 0; j < data[i].length; j++) {
                String textStyle = "  " + this.colorText(this.leftText(data[i][j], max[j] - 2), FG_COLOR.WHITE, BG_COLOR.NONE);
                System.out.print("║" + textStyle);
                if (j == data[i].length - 1) {
                    System.out.println("║");
                }
            }
        }

        System.out.println("╚" + "═".repeat(totalLen) + "╝");
    }

    public void nextPage() {
        if (this.page < this.maxRow / 10) {
            this.page++;
        }
    }

    public void prevPage() {
        if (this.page > 0) {
            this.page--;
        }
    }

    public abstract String[][] getDataStrings();

    void printPage(String[][] data) {
        if (data.length > maxRow) {
            int totalPage = data.length / maxRow;
            if (data.length % maxRow != 0) {
                totalPage++;
            }
            System.out.println("Trang " + (page + 1) + "/" + (totalPage));
        }
    }

    @Override
    public void show(Display display) {
        String[][] data = this.getDataStrings();
        while (true) {
            
            // clearScreen
            System.out.print("\033[H\033[2J");

            this.printTable(data);
            this.printPage(data);
            System.out.println("1: Trang trước");
            System.out.println("2: Trang sau");
            System.out.println("0: Quay lại");

            int choice = this.getChoice(display.sc, 0, 3);

            if (choice == 1) {
                this.prevPage();
            } else if (choice == 2) {
                this.nextPage();
            } else {
                display.back();
                return;
            }
        }
    }
}
