package kerra.math;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * This class implements various methods to realize simple operations with matrices
 */
public class MatrixDouble {

    private double[][] matrix;

    public MatrixDouble(@NotNull double[][] matrix) {
        this.matrix = matrix;
    }

    public MatrixDouble(@NotNull Number[][] matrix) {
        this(Convert.toDouble(matrix));
    }



    public static double[][] add(@NotNull Number[][] m1, @NotNull Number[][] m2) {
        return add(Convert.toDouble(m1), Convert.toDouble(m2));
    }

    public static double[][] add(@NotNull double[][] m1, @NotNull double[][] m2) {
        MatrixDouble m = new MatrixDouble(m1);
        m.add(m2);
        return m.getMatrix();
    }

    public void add(@NotNull Number[][] m) { add(Convert.toDouble(m)); }
    public void add(@NotNull double[][] m) {
        for (int y=0; y<matrix.length; y++)
            for (int x=0; x<matrix[0].length; x++)
                matrix[y][x] += m[y][x];
    }



    public static double[][] subtract(@NotNull Number[][] m1, @NotNull Number[][] m2) {
        return subtract(Convert.toDouble(m1), Convert.toDouble(m2));
    }

    public static double[][] subtract(@NotNull double[][] m1, @NotNull double[][] m2) {
        MatrixDouble m = new MatrixDouble(m1);
        m.subtract(m2);
        return m.getMatrix();
    }

    public void subtract(@NotNull Number[][] m) { subtract(Convert.toDouble(m)); }
    public void subtract(@NotNull double[][] m) {
        for (int y=0; y<matrix.length; y++)
            for (int x=0; x<matrix[0].length; x++)
                matrix[y][x] -= m[y][x];
    }



    public static double[][] multiply(@NotNull Number[][] m1, @NotNull Number[][] m2) {
        return multiply(Convert.toDouble(m1), Convert.toDouble(m2));
    }
    public static double[][] multiply(@NotNull double[][] m1, @NotNull double[][] m2) {
        MatrixDouble m = new MatrixDouble(m1);
        m.multiply(m2);
        return m.getMatrix();
    }

    public void multiply(@NotNull Number[][] m) { multiply(Convert.toDouble(m)); }
    public void multiply(@NotNull double[][] m) {
        double[][] newM = emptify(matrix.length, m[0].length);
        for (int y=0; y<matrix.length; y++)
            for (int x=0; x<m[0].length; x++)
                for (int k=0; k<m.length; k++)
                    newM[y][x] += matrix[y][k] * m[k][x];
        matrix = newM;
    }


    public static double[][] multiply(@NotNull Number[][] matrix, @NotNull Number scalar) {
        return multiply(Convert.toDouble(matrix), Convert.toDouble(scalar));
    }
    public static double[][] multiply(@NotNull double[][] matrix, double scalar) {
        MatrixDouble m = new MatrixDouble(matrix);
        m.multiply(scalar);
        return m.getMatrix();
    }

    public void multiply(@NotNull Number scalar) { multiply(scalar.doubleValue()); }
    public void multiply(double scalar) {
        for (int y=0; y<matrix.length; y++)
            for (int x=0; x<matrix[0].length; x++)
                matrix[y][x] *= scalar;
    }



    public static double[][] divide(@NotNull Number[][] matrix, @NotNull Number scalar) {
        return divide(Convert.toDouble(matrix), Convert.toDouble(scalar));
    }
    public static double[][] divide(@NotNull double[][] matrix, double scalar) {
        MatrixDouble m = new MatrixDouble(matrix);
        m.divide(scalar);
        return m.getMatrix();
    }

    public void divide(@NotNull Number scalar) { divide(scalar.doubleValue()); }
    public void divide(double scalar) {
        for (int y = 0; y < matrix.length; y++)
            for (int x = 0; x < matrix[0].length; x++)
                matrix[y][x] /= scalar;
    }


    public double[][] transpose(@NotNull Number[][] matrix) { return transpose(Convert.toDouble(matrix)); }
    public double[][] transpose(@NotNull double[][] matrix) {
        MatrixDouble m = new MatrixDouble(matrix);
        m.transpose();
        return m.getMatrix();
    }

    public void transpose() {
        double[][] newM = emptify(matrix[0].length, matrix.length);
        for (int y=0; y<matrix.length; y++)
            for (int x=0; x<matrix[0].length; x++)
                newM[x][y] = matrix[y][x];
        matrix = newM;
    }



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
