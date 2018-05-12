package kerra.util;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class ArraysP {


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
            index = random.nextInt(i+1) + start;
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
