package kerra.math;

import java.util.Arrays;

public class Matrix<E extends Number> implements IMatrix {

    private Double[][] matrix;

    @org.jetbrains.annotations.Contract(pure = true)
    public Matrix(Double[][] matrix) {
        this.matrix = matrix;
    }



    /**
     * Adds the specified matrix to this matrix.
     *
     * @param M the matrix to be added
     */
    public void add(IMatrix M) {
        for (int y = 0; y<matrix.length; y++)
            for (int x = 0; x<matrix[y].length; x++)
                matrix[y][x] += (Double) M.getMatrix()[y][x];
    }



    /**
     * Subtracts the specified matrix from this matrix
     *
     * @param M the matrix to be subtracted
     */
    public void subtract(IMatrix M){
        for (int y = 0; y<matrix.length; y++)
            for (int x = 0; x<matrix[y].length; x++)
                matrix[y][x] -= (Double) M.getMatrix()[y][x];
    }



    /**
     * Multiplies the specified matrix with this matrix.
     *
     * @param M the matrix to be multiplied with
     */
    public void multiply(IMatrix M) {
        Double[][] m2 = (Double[][]) M.getMatrix();
        Double[][] m1 = (Double[][]) emptyClone(new Double[matrix.length][m2[0].length]);

        for (int y=0; y<m1.length; y++)
            for (int x=0; x<m1[y].length; x++)
                for (int tr=0; tr<matrix[0].length; tr++)
                    m1[y][x] += matrix[y][tr] * m2[tr][x];
        setMatrix(m1);
    }



    /**
     * Multiplies this matrix with the specified scalar.
     *
     * @param scalar    the scalar to be multiplied with
     */
    public void multiply(Number scalar) {
        for (int y = 0; y<matrix.length; y++)
            for (int x = 0; x<matrix[y].length; x++)
                matrix[y][x] *= (Double) scalar;
    }



    /**
     * Divides this matrix with the specified scalar.
     * The result will be rounded.
     *
     * @param scalar    the scalar to be divided with
     */
    public void divide(Number scalar) {
        for (int y = 0; y<matrix.length; y++)
            for (int x = 0; x<matrix[y].length; x++)
                matrix[y][x] = matrix[y][x] / (Double) scalar;
    }



    /**
     * Transposes this matrix.
     */
    public void transpose() {
        Double[][] m = new Double[matrix[0].length][matrix.length];
        for (int y=0; y<matrix.length; y++)
            for (int x=0; x<matrix[y].length; x++)
                m[x][y] = matrix[y][x];
        setMatrix(m);
    }



    /**
     * Creates and returns an empty clone of the given {@code long[][]} array.
     *
     * @param matrix    the 2d-array to be cloned
     * @return          the emptied clone
     */
    @org.jetbrains.annotations.Contract(pure = true)
    public Double[][] emptyClone(Number[][] matrix) {
        Double[][] m = new Double[matrix.length][matrix[0].length];
        Arrays.stream(m).forEach(i -> Arrays.fill(i, Double.valueOf(0)));
        return m;
    }



    /**
     * Overwrites the currently stored {@code long[][]} array.
     *
     * @param matrix    the 2d-array to be stored
     */
    public void setMatrix(Number[][] matrix) {
        this.matrix = (Double[][]) matrix;
    }



    /**
     * Returns the stored {@code long[][]}} array.
     *
     * @return  the stored 2d-array
     */
    @org.jetbrains.annotations.Contract(pure = true)
    public Double[][] getMatrix() {
        return this.matrix;
    }



    /**
     * Returns a {@code String} representation of this matrix using whitespaces and line separators.
     *
     * @return  a string representation
     */
    @Override
    public String toString() {
        StringBuilder mat = new StringBuilder();

        for (int y=0; y<matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                mat.append(matrix[y][x]);
                if (x < matrix[0].length - 1) mat.append(" ");
            }
            mat.append(System.getProperty("line.separator"));
        }
        return mat.toString();
    }
}
