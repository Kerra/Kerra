package kerra.neural.learning;

import kerra.util.Benchmark;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CrossoverTest {

    private Benchmark bench = new Benchmark();
    private double[] code1 = new double[40];
    private double[] code2 = new double[40];

    @BeforeEach
    void setUp() {
        Arrays.fill(code1, 1);
        Arrays.fill(code2, 2);
    }

    @Test
    void onePoint() {
        double[] code = Crossover.onePoint(code1, code2);
        System.out.println(Arrays.toString(code1));
        System.out.println(Arrays.toString(code));
        System.out.println(Arrays.toString(code2));
    }

    @Test
    void twoPoint() {
        double[] code = Crossover.twoPoint(code1, code2);
        System.out.println(Arrays.toString(code1));
        System.out.println(Arrays.toString(code));
        System.out.println(Arrays.toString(code2));
    }

    @Test
    void multiPoint() {
        double[] code = Crossover.multiPoint(code1, code2);
        System.out.println(Arrays.toString(code1));
        System.out.println(Arrays.toString(code));
        System.out.println(Arrays.toString(code2));
    }

    @Test
    void uniform() {
        double[] code = Crossover.uniform(code1, code2);
        System.out.println(Arrays.toString(code1));
        System.out.println(Arrays.toString(code));
        System.out.println(Arrays.toString(code2));
    }

    @Test
    void wholeArithmetic() {
        double[][] code = Crossover.wholeArithmetic(code1, code2, 0.3);
        System.out.println(Arrays.toString(code1));
        System.out.println(Arrays.toString(code[0]));
        System.out.println(Arrays.toString(code2) + "\n");

        System.out.println(Arrays.toString(code1));
        System.out.println(Arrays.toString(code[1]));
        System.out.println(Arrays.toString(code2));
    }

    @Test
    void benchmark() {
        double[] code1 = new double[8192];
        double[] code2 = new double[8192];
        Arrays.setAll(code1, i -> Math.random());
        Arrays.setAll(code2, i -> Math.random());
        int x = 100_000;
        System.out.println("Code length: \t" + code1.length + "\nRuns to do: \t" + x);
        bench1(code1, code2, x);
        bench2(code1, code2, x);
        bench3(code1, code2, x);
        bench4(code1, code2, x);
        bench5(code1, code2, x);
    }

    private void bench1(double[] code1, double[] code2, int x) {
        System.out.println("Crossover.onePoint() :");
        bench.reset();
        for (int i=0; i<x; i++) Crossover.onePoint(code1, code2);
        bench.print(x);
    }

    private void bench2(double[] code1, double[] code2, int x) {
        System.out.println("Crossover.twoPoint() :");
        bench.reset();
        for (int i=0; i<x; i++) Crossover.twoPoint(code1, code2);
        bench.print(x);
    }


    private void bench3(double[] code1, double[] code2, int x) {
        System.out.println("Crossover.multiPoint() :");
        bench.reset();
        for (int i=0; i<x; i++) Crossover.multiPoint(code1, code2);
        bench.print(x);
    }

    private void bench4(double[] code1, double[] code2, int x) {
        System.out.println("Crossover.uniform() :");
        bench.reset();
        for (int i=0; i<x; i++) Crossover.uniform(code1, code2);
        bench.print(x);
    }

    private void bench5(double[] code1, double[] code2, int x) {
        System.out.println("Crossover.wholeArithmetic() :");
        bench.reset();
        for (int i=0; i<x; i++) Crossover.wholeArithmetic(code1, code2, 0.25);
        bench.print(x);
    }
}