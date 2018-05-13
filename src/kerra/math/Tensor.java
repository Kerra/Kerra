package kerra.math;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Tensor {


    /**
     * Creates a new randomized copy of the specified tensor filled with random values in range {@code [min, max)}.
     *
     * @param tensor    the tensor to be copied and randomized
     * @param min       the minimal value (inclusive)
     * @param max       the maximal value (exclusive);
     * @return  the randomized copy of the tensor
     */
    public static double[][][] randomize(@NotNull double[][][] tensor, double min, double max) {
        double[][][] w = new double[tensor.length][][];

        for (int z = 0; z < w.length; z++) {
            w[z] = new double[tensor[z].length][];

            for (int y = 0; y < w[z].length; y++) {
                w[z][y] = new double[tensor[z][y].length];

                for (int x = 0; x < w[z][y].length; x++)
                    w[z][y][x] = (max-min) * Math.random() + min;
            }
        }
        return w;
    }
}
