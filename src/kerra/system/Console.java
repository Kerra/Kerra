package kerra.system;

import java.io.IOException;

public class Console {

    /**
     * TODO: Not working.
     */
    public static void clear(int b) {
        System.out.print("\033[H\033[2J");
    }
}
