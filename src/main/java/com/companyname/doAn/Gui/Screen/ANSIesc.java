package com.companyname.doAn.Gui.Screen;

import org.jline.terminal.Cursor;

public enum ANSIesc {
    CURSOR_UP("\033[1A"),
    CURSOR_DOWN("\033[1B"),
    CURSOR_FORWARD("\033[1C"),
    CURSOR_BACK("\033[1D"),
    CURSOR_NEXT_LINE("\033[1E"),
    CURSOR_PREVIOUS_LINE("\033[1F"),
    CURSOR_HORIZONTAL_ABSOLUTE("\033[1G"),
    CURSOR_HOME("\033[0;0H"),
    CLEAR_LINE("\033[2K"),
    ;

    private final String text;

    /**
     * @param text
     */
    ANSIesc(final String text) {
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
