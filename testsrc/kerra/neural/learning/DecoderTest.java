package kerra.neural.learning;

        import kerra.util.Benchmark;
        import org.junit.jupiter.api.Test;

        import java.util.Arrays;

class DecoderTest {

    private Benchmark bench = new Benchmark();

    private double[] code = {   0.11, 0.12, 0.21, 0.22, 1.11, 1.12, 1.21, 1.22,
            2.11, 2.12, 2.21, 2.22, 3.11, 3.12, 3.21, 3.22};

    private double[][][] tensor = new double[4][2][2];

    private double[][][] t = new double[256][256][256];
    private double[] c = new double[t.length * t[0].length * t[0][0].length];

    @Test
    void decode() {
        double[][][] tensor = Decoder.decode(code, this.tensor);
        for (double[][] z : tensor) System.out.println(Arrays.deepToString(z));
    }

    @Test
    void benchmark() {
        System.out.println("Tensor size: \t" + t.length + " x "  + t[0].length + " x " + t[0][0].length);

        Arrays.fill(c, 1);
        int x = 200;
        double[][][] tensor;

        System.out.println("Number of runs: " + x);

        bench.reset();
        for (int i=0; i<x; i++) tensor = Decoder.decode(c, t);
        long time = bench.benchmark(x);

        System.out.println("Performance: \t" + time/1000000 + " ms / Decode");
    }
}