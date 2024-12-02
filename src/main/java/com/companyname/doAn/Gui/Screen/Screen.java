package com.companyname.doAn.Gui.Screen;

import java.util.Scanner;

import com.companyname.doAn.Gui.Display;

public abstract class Screen {

    public enum FG_COLOR {
        BLACK("\033[30m"),
        RED("\033[31m"),
        GREEN("\033[32m"),
        YELLOW("\033[33m"),
        BLUE("\033[34m"),
        MAGENTA("\033[35m"),
        CYAN("\033[36m"),
        WHITE("\033[37m"),
        RESET("\033[0m"),
        NONE(""),
        ;

        private final String text;

        /**
         * @param text
         */
        FG_COLOR(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }

    public enum BG_COLOR {
        BLACK("\033[40m"),
        RED("\033[41m"),
        GREEN("\033[42m"),
        YELLOW("\033[43m"),
        BLUE("\033[44m"),
        MAGENTA("\033[45m"),
        CYAN("\033[46m"),
        WHITE("\033[47m"),
        RESET("\033[0m"),
        NONE(""),

        ;

        private final String text;

        /**
         * @param text
         */
        BG_COLOR(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }

    public enum DECORATION {
        BOLD("\033[1m"),
        UNDERLINE("\033[4m"),
        REVERSE("\033[7m"),
        RESET("\033[0m"),
        ;

        private final String text;

        /**
         * @param text
         */
        DECORATION(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }

    public abstract void show(Display display);

    public Screen(){}

    void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    protected String leftText(String text, int width) {
        return text + " ".repeat(width - text.length());
    }

    protected String rightText(String text, int width) {
        return " ".repeat(width - text.length()) + text;
    }

    protected String centerText(String text, int width) {
        int left = (width - text.length()) / 2;
        int right = width - text.length() - left;
        return " ".repeat(left) + text + " ".repeat(right);
    }

    protected String colorText(String text, FG_COLOR fgColor, BG_COLOR bgColor) {
        return "" + fgColor + bgColor + text + FG_COLOR.RESET + BG_COLOR.RESET;
    }


    protected String decorateText(String text, DECORATION decoration) {
        return "" + decoration + text + DECORATION.RESET;
    }

    protected int getChoice(Scanner sc, int min, int max) {
        boolean first = false;
        while (true) {
            System.out.print(ANSIesc.CLEAR_LINE);
            System.out.print(">>> Chọn chức năng: ");
            
            String choice = sc.nextLine();
            try {
                int choiceInt = Integer.parseInt(choice);
                if (choiceInt >= min && choiceInt < max) {
                    return choiceInt;
                }
                System.out.print(ANSIesc.CURSOR_UP);
                if (first) {
                    System.out.print(ANSIesc.CURSOR_UP);
                }
                first = true;
                System.out.print(ANSIesc.CLEAR_LINE);
                String messString = ">>> Lựa chọn không hợp lệ!!!!<<<";
                messString = colorText(messString, FG_COLOR.RED, BG_COLOR.NONE);
                messString = decorateText(messString, DECORATION.BOLD);
                System.out.println(messString);
                continue;
            } catch (NumberFormatException e) {
                System.out.print(ANSIesc.CURSOR_UP);
                if (first) {
                    System.out.print(ANSIesc.CURSOR_UP);
                }
                first = true;
                System.out.print(ANSIesc.CLEAR_LINE);
                String messString = ">>> Nhập phải là xố!!!!<<<";
                messString = colorText(messString, FG_COLOR.RED, BG_COLOR.NONE);
                messString = decorateText(messString, DECORATION.BOLD);
                System.out.println(messString);
                continue;
            }
        }
    }

}
