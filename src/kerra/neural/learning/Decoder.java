package kerra.neural.learning;

import org.jetbrains.annotations.NotNull;

public class Decoder {


    /**
     * Decodes the specified code into the given tensor.
     *
     * @param code      the code to be decoded
     * @param tensor    the tensor to be have the code decoded into
     * @return  the decoded tensor
     * @throws ArrayIndexOutOfBoundsException if the code has not enough entries to fill the tensor
     */
    @NotNull
    public static double[][][] decode(@NotNull double[] code, @NotNull double[][][] tensor) {
        for (int z=0, i=0; z<tensor.length; z++)
            for (int y=0; y<tensor[z].length; y++)
                for (int x=0; x<tensor[z][y].length; x++, i++)
                    tensor[z][y][x] = code[i];
        return tensor;
    }
}
