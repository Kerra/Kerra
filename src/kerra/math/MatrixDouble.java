package kerra.math;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * This class implements various methods to realize simple operations with matrices
 */
public class MatrixDouble {

    private double[][] matrix;

    public MatrixDouble(@NotNull Number[][] matrix) {
        this(Convert.toDouble(matrix));
    }

    public MatrixDouble(@NotNull double[][] matrix) {
        this.matrix = matrix;
    }


    public static double[][] add(@NotNull Number[][] m1, @NotNull Number[][] m2) {
        return add(Convert.toDouble(m1), Convert.toDouble(m2));
    }
    public static double[][] add(@NotNull double[][] m1, @NotNull double[][] m2) {
        for (int y=0; y<m1.length; y++)
            for (int x=0; x<m1[0].length; x++)
                m1[y][x] += m2[y][x];
        return m1;
    }

    public void add(@NotNull Number[][] m) { add(Convert.toDouble(m)); }
    public void add(@NotNull double[][] m) { matrix = add(matrix, m); }



    public static double[][] subtract(@NotNull Number[][] m1, @NotNull Number[][] m2) {
        return subtract(Convert.toDouble(m1), Convert.toDouble(m2));
    }
    public static double[][] subtract(@NotNull double[][] m1, @NotNull double[][] m2) {
        for (int y=0; y<m1.length; y++)
            for (int x=0; x<m1[0].length; x++)
                m1[y][x] -= m2[y][x];
        return m1;
    }

    public void subtract(@NotNull Number[][] m) { subtract(Convert.toDouble(m)); }
    public void subtract(@NotNull double[][] m) { matrix = subtract(matrix, m); }



    public static double[][] multiply(@NotNull Number[][] m1, @NotNull Number[][] m2) {
        return multiply(Convert.toDouble(m1), Convert.toDouble(m2));
    }
    public static double[][] multiply(@NotNull double[][] m1, @NotNull double[][] m2) {
        double[][] newM = emptify(m1.length, m2[0].length);
        for (int y=0; y<m1.length; y++)
            for (int x=0; x<m2[0].length; x++)
                for (int k=0; k<m2.length; k++)
                    newM[y][x] += m1[y][k] * m2[k][x];
        return newM;
    }

    public void multiply(@NotNull Number[][] m) { multiply(Convert.toDouble(m)); }
    public void multiply(@NotNull double[][] m) {    matrix = multiply(matrix, m); }


    public static double[][] multiply(@NotNull Number[][] matrix, @NotNull Number scalar) {
        return multiply(Convert.toDouble(matrix), Convert.toDouble(scalar));
    }
    public static double[][] multiply(@NotNull double[][] matrix, double scalar) {
        for (int y=0; y<matrix.length; y++)
            for (int x=0; x<matrix[0].length; x++)
                matrix[y][x] *= scalar;
        return matrix;
    }

    public void multiply(@NotNull Number scalar) { multiply(scalar.doubleValue()); }
    public void multiply(double scalar) { matrix = multiply(matrix, scalar); }



    public static double[][] divide(@NotNull Number[][] matrix, @NotNull Number scalar) {
        return divide(Convert.toDouble(matrix), Convert.toDouble(scalar));
    }
    public static double[][] divide(@NotNull double[][] matrix, double scalar) {
        for (int y = 0; y < matrix.length; y++)
            for (int x = 0; x < matrix[0].length; x++)
                matrix[y][x] /= scalar;
        return matrix;
    }

    public void divide(@NotNull Number scalar) { divide(scalar.doubleValue()); }
    public void divide(double scalar) { matrix = divide(matrix, scalar); }


    public double[][] transpose(@NotNull Number[][] matrix) { return transpose(Convert.toDouble(matrix)); }
    public double[][] transpose(@NotNull double[][] matrix) {
        double[][] m = emptify(matrix[0].length, matrix.length);
        for (int y=0; y<matrix.length; y++)
            for (int x=0; x<matrix[0].length; x++)
                m[x][y] = matrix[y][x];
        return m;
    }

    public void transpose() { matrix = transpose(matrix); }



    public static double[][] emptify(int height, int width) {
        double[][] m = new double[height][width];
        for (double[] aM : m) Arrays.fill(aM, 0);
        return m;
    }



    public void setMatrix(@NotNull Number[][] matrix) { setMatrix(Convert.toDouble(matrix)); }
    public void setMatrix(@NotNull double[][] matrix) {
        this.matrix = matrix;
    }



    public double[][] getMatrix() {
        return this.matrix;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (double[] row : matrix) {
            for (int x = 0; x < matrix[0].length - 1; x++) s.append(row[x]).append(" ");
            s.append(row[matrix[0].length - 1]);
            s.append(System.getProperty("line.separator"));
        }
        return s.toString();
    }
}
