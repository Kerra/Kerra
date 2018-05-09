package kerra.math;

import kerra.util.Benchmark;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatrixDoubleTest {

    private Benchmark timer;
    private MatrixDouble matrix;
    private double[][] mat1 = {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}};
    private double[][] mat2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    @BeforeEach
    void setUp() {
        this.matrix = new MatrixDouble(mat1);
        this.timer = new Benchmark();
    }

    @Test
    void add() {
        matrix.add(mat1);
        System.out.println(matrix.toString());
    }

    @Test
    void subtract() {
        matrix.subtract(mat1);
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
        matrix.setMatrix(MatrixDouble.emptify(mat1.length, mat1[0].length));
        System.out.println(matrix.toString());
    }

    @Test
    void getMatrix() {
        matrix.setMatrix(matrix.getMatrix());
        System.out.println(matrix.toString());
    }

    @Test
    void benchmark() {
        double[][] mat = new double[64][64];
        for (int y=0; y<mat.length; y++) for (int x=0; x<mat[0].length; x++) mat[y][x] = Math.random();
        int x = 100_000;
        benchmarkAdding(mat, x);
        benchmarkSubtracting(mat, x);
        benchmarkMultiply(mat, x);
    }


    private void benchmarkAdding(double[][] m, int x) {
        timer.reset();
        for (int i=0; i<x; i++) m = MatrixDouble.add(m, m);
        timer.print(x);
    }

    private void benchmarkSubtracting(double[][] m, int x) {
        timer.reset();
        for (int i=0; i<x; i++) m = MatrixDouble.subtract(m, m);
        timer.print(x);
    }

    private void benchmarkMultiply(double[][] m, int x) {
        timer.reset();
        for (int i=0; i<x; i++) m = MatrixDouble.multiply(m, m);
        timer.print(x);
    }
}