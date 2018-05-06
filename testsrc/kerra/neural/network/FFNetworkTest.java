package kerra.neural.network;

import kerra.neural.func.IActivationFunction;
import kerra.neural.func.Sigmoid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class FFNetworkTest {

    private int[] size;
    private double[] inputs;
    private double[] bias;
    private IActivationFunction[] iafs;
    private FFNetwork net;


    @BeforeEach
    void setUp() {
        this.size = new int[256];
        Arrays.fill(size, 19);
        inputs = new double[size[0]];
        Arrays.fill(inputs, 1);
        bias = new double[size.length-1];
        Arrays.fill(bias, 1);
        iafs = new IActivationFunction[size.length-1];
        Arrays.fill(iafs, new Sigmoid());

        this.net = new FFNetwork(size);
        net.setActivationFunction(iafs);
    }

    @Test
    void feed() {
        System.out.println(Arrays.toString(net.feed(inputs)));
    }

    @Test
    void generateWeights() {
    }

    @Test
    void loadWeights() {
    }

    @Test
    void sumLayers() {
    }

    @Test
    void sumNeurons() {
    }

    @Test
    void sumConnections() {
    }

    @Test
    void setWeights() {
    }

    @Test
    void getWeights() {
    }

    @Test
    void setBias() {
        net.setBias(bias);
        feed();
    }

    @Test
    void getBias() {
    }

    @Test
    void storeWeights() {
    }

    @Test
    void testToString() {
        //System.out.println(net.toString());
    }

    @Test
    void benchmark() {
        int x = 1000;
        long start = System.nanoTime();
        for (int i=0; i<x; i++) net.feed(inputs);
        long end = System.nanoTime();
        long result = (end-start)/x/1000;
        System.out.println("average time: " + result + " \u00B5s");
    }
}