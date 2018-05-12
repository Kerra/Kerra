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


    /**
     * Performs an efficient Fisher-Yates shuffling on the specified array between the two given indexes.
     *
     * @param array the array to be shuffled
     */
    public static void shuffle(@NotNull double[] array, int start, int stop) {
        int index;
        for (int i = stop-1; i > start; i--) {
            index = start + (int) (Math.random() *(i-start+1));
            swap(array, index, i);
        }
    }


    public static void invert(@NotNull double[] array) {
        invert(array, 0, array.length);
    }


    public static void invert(@NotNull double[] array, int start, int stop) {
        int length = (stop-start) / 2;
        double temp;
        for (int i=0; i<length; i++) swap(array, start + i, stop - i - 1);
    }


    public static void swap(@NotNull double[] array, int index1, int index2) {
        double temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
