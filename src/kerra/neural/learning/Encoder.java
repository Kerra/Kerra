package kerra.neural.learning;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Encoder {


    /**
     * Encodes the given tensor into an array going through every entry (depth).
     *
     * @param tensor    the tensor to be encoded
     * @return  the encoded array
     */
    @NotNull
    @Contract(pure = true)
    public static double[] encode(@NotNull double[][][] tensor) {
        int length = Arrays.stream(tensor).flatMap(Arrays::stream).mapToInt(y -> y.length).sum();

        double[] encoded = new double[length];
        int i=0;
        for (double[][] z : tensor) for (double[] y : z)
            for (int x = 0; x < y.length; x++, i++)
                encoded[i] = y[x];

        return encoded;
    }
}
