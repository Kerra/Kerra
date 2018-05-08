package kerra.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MatrixDoubleTest {

    private MatrixDouble matrix;
    private double[][] mat = {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}};
    private double[][] mat2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

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

    @Test
    void benchmark() {
        double[][] mat = new double[8192][8192];
        for (int y=0; y<mat.length; y++) for (int x=0; x<mat[0].length; x++) mat[y][x] = Math.random();
        int x = 100000000;
        benchmarkAdding(mat, x);
        benchmarkSubtracting(mat, x);
        benchmarkMultiply(mat, x);
    }


    private void benchmarkAdding(double[][] m, int x) {
        long start = System.nanoTime();
        for (int i=0; i<x; i++) mat = MatrixDouble.add(mat, mat);
        long end = System.nanoTime();
        long result = (end-start)/x;
        System.out.println("Adding average time: " + result + " ns");
    }

    private void benchmarkSubtracting(double[][] m, int x) {
        long start = System.nanoTime();
        for (int i=0; i<x; i++) mat = MatrixDouble.subtract(mat, mat);
        long end = System.nanoTime();
        long result = (end-start)/x;
        System.out.println("Subtracting average time: " + result + " ns");
    }

    private void benchmarkMultiply(double[][] m, int x) {
        long start = System.nanoTime();
        for (int i=0; i<x; i++) mat = MatrixDouble.multiply(mat, mat);
        long end = System.nanoTime();
        long result = (end-start)/x;
        System.out.println("Multiplying average time: " + result + " ns");
    }
}