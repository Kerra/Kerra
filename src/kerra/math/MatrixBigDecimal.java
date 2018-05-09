package kerra.math;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Arrays;

public class MatrixBigDecimal {

    private BigDecimal[][] matrix;

    public MatrixBigDecimal(@NotNull Number[][] matrix) {
        this(Convert.toBigDecimal(matrix));
    }

    public MatrixBigDecimal(@NotNull BigDecimal[][] matrix) {
        this.matrix = matrix;
    }

    public static BigDecimal[][] add(@NotNull Number[][] m1, @NotNull Number[][] m2) {
        return add(Convert.toBigDecimal(m1), Convert.toBigDecimal(m2));
    }
    public static BigDecimal[][] add(@NotNull BigDecimal[][] m1, @NotNull BigDecimal[][] m2) {
        for (int y=0; y<m1.length; y++)
            for (int x=0; x<m1[0].length; x++)
                m1[y][x] = m1[y][x].add(m2[y][x]);
        return m1;
    }

    public void add(@NotNull Number[][] m) { add(Convert.toBigDecimal(m)); }
    public void add(@NotNull BigDecimal[][] m) { matrix = add(matrix, m); }



    public static BigDecimal[][] subtract(@NotNull Number[][] m1, @NotNull Number[][] m2) {
        return subtract(Convert.toBigDecimal(m1), Convert.toBigDecimal(m2));
    }
    public static BigDecimal[][] subtract(@NotNull BigDecimal[][] m1, @NotNull BigDecimal[][] m2) {
        for (int y=0; y<m1.length; y++)
            for (int x=0; x<m1[0].length; x++)
                m1[y][x] = m1[y][x].subtract(m2[y][x]);
        return m1;
    }

    public void subtract(@NotNull Number[][] m) { subtract(Convert.toBigDecimal(m)); }
    public void subtract(@NotNull BigDecimal[][] m) { matrix = subtract(matrix, m); }



    public static BigDecimal[][] multiply(@NotNull Number[][] m1, @NotNull Number[][] m2) {
        return multiply(Convert.toBigDecimal(m1), Convert.toBigDecimal(m2));
    }
    public static BigDecimal[][] multiply(@NotNull BigDecimal[][] m1, @NotNull BigDecimal[][] m2) {
        BigDecimal[][] newM = emptify(m1.length, m2[0].length);
        for (int y=0; y<m1.length; y++)
            for (int x=0; x<m2[0].length; x++)
                for (int k=0; k<m2.length; k++)
                    newM[y][x] = newM[y][x].add(m1[y][k]).multiply(m2[k][x]);
        return newM;
    }

    public void multiply(@NotNull Number[][] m) { multiply(Convert.toBigDecimal(m)); }
    public void multiply(@NotNull BigDecimal[][] m) { matrix = multiply(matrix, m); }


    public static BigDecimal[][] multiply(@NotNull Number[][] matrix, @NotNull Number scalar) {
        return multiply(Convert.toBigDecimal(matrix), Convert.toBigDecimal(scalar));
    }
    public static BigDecimal[][] multiply(@NotNull BigDecimal[][] matrix, BigDecimal scalar) {
        for (int y=0; y<matrix.length; y++)
            for (int x=0; x<matrix[0].length; x++)
                matrix[y][x] = matrix[y][x].multiply(scalar);
        return matrix;
    }

    public void multiply(@NotNull Number scalar) { multiply(scalar.doubleValue()); }
    public void multiply(double scalar) { matrix = multiply(matrix, scalar); }



    public static BigDecimal[][] divide(@NotNull Number[][] matrix, @NotNull Number scalar) {
        return divide(Convert.toBigDecimal(matrix), Convert.toBigDecimal(scalar));
    }
    public static BigDecimal[][] divide(@NotNull BigDecimal[][] matrix, BigDecimal scalar) {
        for (int y = 0; y < matrix.length; y++)
            for (int x = 0; x < matrix[0].length; x++)
                matrix[y][x] = matrix[y][x].divide(scalar);
        return matrix;
    }

    public void divide(@NotNull Number scalar) { divide(scalar.doubleValue()); }
    public void divide(double scalar) { matrix = divide(matrix, scalar); }


    public BigDecimal[][] transpose(@NotNull Number[][] matrix) { return transpose(Convert.toBigDecimal(matrix)); }
    public BigDecimal[][] transpose(@NotNull BigDecimal[][] matrix) {
        BigDecimal[][] m = emptify(matrix[0].length, matrix.length);
        for (int y=0; y<matrix.length; y++)
            for (int x=0; x<matrix[0].length; x++)
                m[x][y] = matrix[y][x];
        return m;
    }

    public void transpose() { matrix = transpose(matrix); }



    public static BigDecimal[][] emptify(int height, int width) {
        BigDecimal[][] m = new BigDecimal[height][width];
        for (BigDecimal[] aM : m) Arrays.fill(aM, new BigDecimal(0));
        return m;
    }



    public void setMatrix(@NotNull Number[][] matrix) { setMatrix(Convert.toBigDecimal(matrix)); }
    public void setMatrix(@NotNull BigDecimal[][] matrix) {
        this.matrix = matrix;
    }



    public BigDecimal[][] getMatrix() {
        return this.matrix;
    }



    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (BigDecimal[] row : matrix) {
            for (int x = 0; x < matrix[0].length - 1; x++) s.append(row[x]).append(" ");
            s.append(row[matrix[0].length - 1]);
            s.append(System.getProperty("line.separator"));
        }
        return s.toString();
    }
}
