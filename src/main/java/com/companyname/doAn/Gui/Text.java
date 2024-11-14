package com.companyname.doAn.Gui;

public class Text extends Element {



    protected Text(String id, int height, int width, int top, int left) {
        super(id, height, width, top, left);
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
        
    }


    public class TextBuilder {
    
        private String id, text;
        private int height, width, top, left;

        public TextBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public TextBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public TextBuilder setHeight(int height) {
            this.height = height;
            return this;
        }
    }
}
