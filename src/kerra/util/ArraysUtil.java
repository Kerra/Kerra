package kerra.util;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class ArraysUtil {

    /**
     * Performs an efficient Fisher-Yates shuffling on the specified array.
     *
     * @param array the array to be shuffled
     */
    public static void shuffle(@NotNull double[] array) {
        shuffle(array, 0, array.length);
    }


    public static void shuffle(@NotNull double[] array, int start, int stop) {
        int index;
        double temp;
        Random random = new Random();
        for (int i = stop-1; i > start; i--) {
            index = random.nextInt(i-start+1) + start;
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }


    public static void invert(@NotNull double[] array) {
        invert(array, 0, array.length);
    }


    public static void invert(@NotNull double[] array, int start, int stop) {
        int length = (stop-start) / 2;
        double temp;
        for (int i=0; i<length; i++) {
            temp = array[start + i];
            array[start + i] = array[stop-1-i];
            array[stop-1-i] = temp;
        }
    }
}
