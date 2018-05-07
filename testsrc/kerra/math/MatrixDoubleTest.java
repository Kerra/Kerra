package kerra.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatrixDoubleTest {

    private MatrixDouble matrix;
    private double[][] mat = {{1, 2}, {3, 4}, {5, 6}};
    private double[][] mat2 = {{1, 2, 3}, {4, 5, 6}};

    @BeforeEach
    void setUp() {
        this.matrix = new MatrixDouble(mat);
    }

    @Test
    void add() {
        matrix.add(mat);
        System.out.println(matrix.toString());
    }

    @Test
    void subtract() {
        matrix.subtract(mat);
        System.out.println(matrix.toString());
    }

    @Test
    void multiply() {
        matrix.multiply(mat2);
        System.out.println(matrix.toString());
    }

    @Test
    void multiply1() {
        matrix.multiply(10);
        System.out.println(matrix.toString());
    }

    @Test
    void divide() {
        matrix.divide(10);
        System.out.println(matrix.toString());
    }

    @Test
    void transpose() {
        matrix.transpose();
        System.out.println(matrix.toString());
    }

    @Test
    void emptyMatrix() {
        matrix.setMatrix(MatrixDouble.emptify(mat.length, mat[0].length));
        System.out.println(matrix.toString());
    }

    @Test
    void getMatrix() {
        matrix.setMatrix(matrix.getMatrix());
        System.out.println(matrix.toString());
    }
}