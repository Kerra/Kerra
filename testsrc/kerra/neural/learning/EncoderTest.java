package kerra.neural.learning;

import kerra.util.Benchmark;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class EncoderTest {

    private Benchmark bench = new Benchmark();

    private double[][][] tensor = { {{0.11, 0.12}, {0.21, 0.22}},
                                    {{1.11, 1.12}, {1.21, 1.22}},
                                    {{2.11, 2.12}, {2.21, 2.22}},
                                    {{3.11, 3.12}, {3.21, 3.22}}};

    private double[][][] t = new double[256][256][256];

    @Test
    void encode() {

        double[] code = Encoder.encode(tensor);
        System.out.println(Arrays.toString(code));
    }

    @Test
    void benchmark() {
        System.out.println("Tensor size: \t" + t.length + " x "  + t[0].length + " x " + t[0][0].length);

        for (double[][] z : t) for (double[] y : z) Arrays.fill(y, 1);
        int x = 200;
        double[] code;

        System.out.println("Number of runs: " + x);

        bench.reset();
        for (int i=0; i<x; i++) code = Encoder.encode(t);
        long time = bench.benchmark(x);

        System.out.println("Performance: \t" + time/1000000 + " ms / Encode");
    }
}