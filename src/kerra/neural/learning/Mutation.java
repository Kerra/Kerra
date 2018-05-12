package kerra.neural.learning;

import kerra.util.ArraysUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Mutation {

    /**
     * Swaps two randomly generated indexes in the specified array.
     *
     * @param code  the array to have positions swapped
     */
    public static void swap(@NotNull double[] code) {
        int point1 = (int) (Math.random()*code.length);
        int point2 = (int) (Math.random()*code.length);
        ArraysUtil.swap(code, point1, point2);
    }


    /**
     * Scrambles the specified array between two randomly generated indexes.
     *
     * @param code  the array to be randomly scrambled
     */
    public static void scramble(@NotNull double[] code) {
        int[] points = {(int) (Math.random()*code.length), (int) (Math.random()*code.length)};
        Arrays.sort(points);
        ArraysUtil.shuffle(code, points[0], points[1]);
    }


    /**
     * Inverts the specified array between two randomly generated indexes.
     *
     * @param code  the array to be randomly inverted
     */
    public static void invert(@NotNull double[] code) {
        int[] points = {(int) (Math.random()*code.length), (int) (Math.random()*code.length)};
        Arrays.sort(points);
        ArraysUtil.invert(code, points[0], points[1]);
    }


    /**
     * Resets a random index in the specified array to a random value in between the given {@code min, max}.
     *
     * @param code  the array to be randomly reset
     * @param min   the minimal acceptable value
     * @param max   the maximal acceptable value
     */
    public static void reset(@NotNull double[] code, double min, double max) {
        int point = (int) (Math.random()*code.length);
        double value = min + Math.random()*(max - min);
        code[point] = value;
    }


    /**
     * Mutates a random index in the specified array between the specified boundary.
     *
     * @param code      the array to be randomly mutated
     * @param boundary  the boundary of the mutation
     */
    public static void mutate(@NotNull double[] code, double boundary) {
        int point = (int) (Math.random() * code.length);
        double value = 2 * Math.random()*boundary - boundary;
        code[point] += value;
    }
}
