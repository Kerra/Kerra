package kerra.math;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

import static java.util.Arrays.setAll;

public class Convert {


    /**
     * Converts the specified {@code Number} to a {@code byte} calling {@link Number#byteValue()}.
     *
     * @param number    the number to be converted
     * @return  the converted value
     */
    public static byte toByte(@NotNull Number number) {
        return number.byteValue();
    }

    /**
     * Converts the specified {@code Number} array to a new {@code byte} array.
     *
     * @param array the array to be converted
     * @return  the converted array
     */
    public static byte[] toByte(@NotNull Number[] array) {
        byte[] mat = new byte[array.length];
        for (int x=0; x<mat.length; x++) mat[x] = toByte(array[x]);
        return mat;
    }

    /**
     * Converts the specified {@code Number} matrix to a new {@code byte} matrix.
     *
     * @param matrix    the matrix to be converted
     * @return  the converted matrix
     */
    public static byte[][] toByte(@NotNull Number[][] matrix) {
        byte[][] mat = new byte[matrix.length][];
        setAll(mat, y -> toByte(matrix[y]));
        return mat;
    }

    /**
     * Converts the specified {@code Number} tensor to a new {@code byte} tensor.
     *
     * @param tensor    the tensor to be converted
     * @return  the converted tensor
     */
    public static byte[][][] toByte(@NotNull Number[][][] tensor) {
        byte[][][] mat = new byte[tensor.length][][];
        setAll(mat, z -> toByte(tensor[z]));
        return mat;
    }



    /**
     * Converts the specified {@code Number} to a {@code short} calling {@link Number#shortValue()}.
     *
     * @param number    the number to be converted
     * @return  the converted value
     */
    public static short toShort(@NotNull Number number) {
        return number.shortValue();
    }

    /**
     * Converts the specified {@code Number} array to a new {@code short} array.
     *
     * @param array the array to be converted
     * @return  the converted array
     */
    public static short[] toShort(@NotNull Number[] array) {
        short[] mat = new short[array.length];
        for (int x=0; x<mat.length; x++) mat[x] = toShort(array[x]);
        return mat;
    }

    /**
     * Converts the specified {@code Number} matrix to a new {@code short} matrix.
     *
     * @param matrix    the matrix to be converted
     * @return  the converted matrix
     */
    public static short[][] toShort(@NotNull Number[][] matrix) {
        short[][] mat = new short[matrix.length][];
        setAll(mat, y -> toShort(matrix[y]));
        return mat;
    }

    /**
     * Converts the specified {@code Number} tensor to a new {@code short} tensor.
     *
     * @param tensor    the tensor to be converted
     * @return  the converted tensor
     */
    public static short[][][] toShort(@NotNull Number[][][] tensor) {
        short[][][] mat = new short[tensor.length][][];
        setAll(mat, z -> toShort(tensor[z]));
        return mat;
    }



    /**
     * Converts the specified {@code Number} to a {@code int} calling {@link Number#intValue()}.
     *
     * @param number    the number to be converted
     * @return  the converted value
     */
    public static int toInt(@NotNull Number number) {
        return number.intValue();
    }

    /**
     * Converts the specified {@code Number} array to a new {@code int} array.
     *
     * @param array the array to be converted
     * @return  the converted array
     */
    public static int[] toInt(@NotNull Number[] array) {
        int[] mat = new int[array.length];
        setAll(mat, x -> toByte(array[x]));
        return mat;
    }

    /**
     * Converts the specified {@code Number} matrix to a new {@code int} matrix.
     *
     * @param matrix    the matrix to be converted
     * @return  the converted matrix
     */
    public static int[][] toInt(@NotNull Number[][] matrix) {
        int[][] mat = new int[matrix.length][];
        setAll(mat, y -> toByte(matrix[y]));
        return mat;
    }

    /**
     * Converts the specified {@code Number} tensor to a new {@code float} tensor.
     *
     * @param tensor    the tensor to be converted
     * @return  the converted tensor
     */
    public static int[][][] toInt(@NotNull Number[][][] tensor) {
        int[][][] mat = new int[tensor.length][][];
        setAll(mat, z -> toByte(tensor[z]));
        return mat;
    }



    /**
     * Converts the specified {@code Number} to a {@code long} calling {@link Number#longValue()}.
     *
     * @param number    the number to be converted
     * @return  the converted value
     */
    public static long toLong(@NotNull Number number) {
        return number.longValue();
    }

    /**
     * Converts the specified {@code Number} array to a new {@code long} array.
     *
     * @param array the array to be converted
     * @return  the converted array
     */
    public static long[] toLong(@NotNull Number[] array) {
        long[] mat = new long[array.length];
        setAll(mat, x -> toLong(array[x]));
        return mat;
    }

    /**
     * Converts the specified {@code Number} matrix to a new {@code long} matrix.
     *
     * @param matrix    the matrix to be converted
     * @return  the converted matrix
     */
    public static long[][] toLong(@NotNull Number[][] matrix) {
        long[][] mat = new long[matrix.length][];
        setAll(mat, y -> toLong(matrix[y]));
        return mat;
    }

    /**
     * Converts the specified {@code Number} tensor to a new {@code long} tensor.
     *
     * @param tensor    the tensor to be converted
     * @return  the converted tensor
     */
    public static long[][][] toLong(@NotNull Number[][][] tensor) {
        long[][][] mat = new long[tensor.length][][];
        setAll(mat, z -> toLong(tensor[z]));
        return mat;
    }




    /**
     * Converts the specified {@code Number} to a {@code float} calling {@link Number#floatValue()}.
     *
     * @param number    the number to be converted
     * @return  the converted value
     */
    public static float toFloat(@NotNull Number number) {
        return number.floatValue();
    }

    /**
     * Converts the specified {@code Number} array to a new {@code float} array.
     *
     * @param array the array to be converted
     * @return  the converted array
     */
    public static float[] toFloat(@NotNull Number[] array) {
        float[] mat = new float[array.length];
        for (int x=0; x<mat.length; x++) mat[x] = toFloat(array[x]);
        return mat;
    }

    /**
     * Converts the specified {@code Number} matrix to a new {@code float} matrix.
     *
     * @param matrix    the matrix to be converted
     * @return  the converted matrix
     */
    public static float[][] toFloat(@NotNull Number[][] matrix) {
        float[][] mat = new float[matrix.length][];
        setAll(mat, y -> toFloat(matrix[y]));
        return mat;
    }

    /**
     * Converts the specified {@code Number} tensor to a new {@code float} tensor.
     *
     * @param tensor    the tensor to be converted
     * @return  the converted tensor
     */
    public static float[][][] toFloat(@NotNull Number[][][] tensor) {
        float[][][] mat = new float[tensor.length][][];
        setAll(mat, z -> toFloat(tensor[z]));
        return mat;
    }



    /**
     * Converts the specified {@code Number} to a {@code double} calling {@link Number#doubleValue()}.
     *
     * @param number    the number to be converted
     * @return  the converted value
     */
    public static double toDouble(@NotNull Number number) {
        return number.doubleValue();
    }

    /**
     * Converts the specified {@code Number} array to a new {@code double} array.
     *
     * @param array the array to be converted
     * @return  the converted array
     */
    public static double[] toDouble(@NotNull Number[] array) {
        double[] mat = new double[array.length];
        setAll(mat, i -> toDouble(array[i]));
        return mat;
    }

    /**
     * Converts the specified {@code Number} matrix to a new {@code double} matrix.
     *
     * @param matrix    the matrix to be converted
     * @return  the converted matrix
     */
    public static double[][] toDouble(@NotNull Number[][] matrix) {
        double[][] mat = new double[matrix.length][];
        setAll(mat, i -> toDouble(matrix[i]));
        return mat;
    }

    /**
     * Converts the specified {@code Number} tensor to a new {@code double} tensor.
     *
     * @param tensor    the tensor to be converted
     * @return  the converted tensor
     */
    public static double[][][] toDouble(@NotNull Number[][][] tensor) {
        double[][][] mat = new double[tensor.length][][];
        setAll(mat, i -> toDouble(tensor[i]));
        return mat;
    }






    /**
     * Converts the specified {@code String} to a {@code char}
     * using the first character. (therefore {@code index == 0})
     *
     * @param string    the array to be converted
     * @return  the converted array
     */
    public static char toChar(@NotNull String string) {
        return string.charAt(0);
    }

    /**
     * Converts the specified {@code String} array to a new {@code char} array
     * using the first character in each entry. (therefore {@code index == 0})
     *
     * @param array the array to be converted
     * @return  the converted array
     */
    public static char[] toChar(@NotNull String[] array) {
        char[] mat = new char[array.length];
        for (int x=0; x<mat.length; x++) mat[x] = toChar(array[x]);
        return mat;
    }

    /**
     * Converts the specified {@code String} matrix to a new {@code char} matrix
     * using the first character in each entry. (therefore {@code index == 0})
     *
     * @param matrix    the matrix to be converted
     * @return  the converted matrix
     */
    public static char[][] toChar(@NotNull String[][] matrix) {
        char[][] mat = new char[matrix.length][];
        for (int y=0; y<mat.length; y++) mat[y] = toChar(matrix[y]);
        return mat;
    }

    /**
     * Converts the specified {@code String} tensor to a new {@code char} tensor
     * using the first character in each entry. (therefore {@code index == 0})
     *
     * @param tensor    the tensor to be converted
     * @return  the converted tensor
     */
    public static char[][][] toChar(@NotNull String[][][] tensor) {
        char[][][] mat = new char[tensor.length][][];
        for (int z=0; z<mat.length; z++) mat[z] = toChar(tensor[z]);
        return mat;
    }



    public static boolean toBoolean(@NotNull Object object, Object TRUE) {
        return object == TRUE;
    }

    /**
     * Converts the specified array to a new {@code boolean} array according to the specified {@code true} value.
     *
     * @param array the array to be converted
     * @param TRUE  the value representing {@code true}
     * @return  the converted array
     */
    public static boolean[] toBoolean(@NotNull Object[] array, Object TRUE) {
        boolean[] mat = new boolean[array.length];
        for (int x=0; x<array.length; x++) mat[x] = toBoolean(array[x], TRUE);
        return mat;
    }

    /**
     * Converts the specified matrix to a new {@code boolean} matrix according to the specified {@code true} value.
     *
     * @param matrix    the matrix to be converted
     * @param TRUE      the value representing {@code true}
     * @return  the converted matrix
     */
    public static boolean[][] toBoolean(@NotNull Object[][] matrix, Object TRUE) {
        boolean[][] mat = new boolean[matrix.length][];
        setAll(mat, y -> toBoolean(matrix[y], TRUE));
        return mat;
    }

    /**
     * Converts the specified tensor to a new {@code boolean} tensor according to the specified {@code true} value.
     *
     * @param tensor    the tensor to be converted
     * @param TRUE      the value representing {@code true}
     * @return  the converted tensor
     */
    public static boolean[][][] toBoolean(@NotNull Object[][][] tensor, Object TRUE) {
        boolean[][][] mat = new boolean[tensor.length][][];
        setAll(mat, z -> toBoolean(tensor[z], TRUE));
        return mat;
    }
}
