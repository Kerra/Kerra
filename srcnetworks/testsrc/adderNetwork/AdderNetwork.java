package testsrc.adderNetwork;

import kerra.neural.network.FFNetwork;

import java.io.IOException;
import java.util.Arrays;

public class AdderNetwork {

    private FFNetwork neuralNet;
    private Fitness fitness;
    private Population population = new Population();
    private int[] size = {2, 1};
    private double[] inputs = new double[size[0]];


    public void start() throws IOException {
        neuralNet = new FFNetwork(size);
        Arrays.setAll(inputs, i -> 100*Math.random());
        fitness = new Fitness(inputs);
        population.setNeuralNet(neuralNet);
        population.setFitness(fitness);
        population.setInputs(inputs);
        population.initialize(10_000);
        for (int i=0; i<200; i++) population.run();
        population.saveGeneration(System.getProperty("user.dir") + "\\test");
    }

    public static void main(String[] args) throws IOException {
        new AdderNetwork().start();
    }
}
