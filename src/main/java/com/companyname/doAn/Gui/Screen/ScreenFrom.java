package com.companyname.doAn.Gui.Screen;

import com.companyname.doAn.Gui.Display;

public abstract class ScreenFrom extends Screen {
    public abstract class FromElement<T> {
        public String label;
        private T value;

        public T getValue() {
            return value;
        }

        public abstract String checkValid(String value);
        public abstract T parseValue(String value);
        
        public FromElement(String label) {
            this.label = label;
        }

        public void show(Display display) {

            while (true) {
                
                System.out.println(label);
                String a = display.sc.nextLine();
                String check = checkValid(a);
                if (check != null) {
                    System.out.print(ANSIesc.CURSOR_UP);
                    System.out.print(ANSIesc.CLEAR_LINE);
                    System.out.println(check);

                } else {
                    value = parseValue(a);
                }
            }
        }
    }       


}
