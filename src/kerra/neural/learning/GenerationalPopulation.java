package kerra.neural.learning;

import kerra.math.Tensor;
import kerra.neural.network.ANetwork;
import kerra.neural.parsing.NeuralParser;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public abstract class GenerationalPopulation {

    protected Individual[] population;
    protected ANetwork neuralNet;
    protected IFitnessFunction fitness;
    protected double[] inputs;

    public GenerationalPopulation() {}


    public final void initialize(int size) {
        this.population = new Individual[size];
        double[][][] weights;
        for (int i=0; i<size; i++) {
            weights = Tensor.randomize(neuralNet.getWeights(), -1, 1);
            population[i] = new Individual(weights);
        }
    }


    public final void run() {
        double fitness, outputs[];
        for (Individual individual : population) {
            this.neuralNet.setWeights(individual.getWeights());
            outputs = this.neuralNet.input(inputs);
            fitness = this.fitness.func(outputs);
            individual.setFitness(fitness);
        }
        evolve();
    }


    protected abstract void evolve();


    public void saveGeneration(@NotNull String pathToFile) throws IOException {
        String file;
        for (int i=0; i<size(); i++) {
            file = pathToFile + "_" + i;
            NeuralParser.saveWeights(file, population[i].getWeights());
        }
    }


    public void loadGeneration(@NotNull String[] pathToFile) throws IOException {
        this.population = new Individual[pathToFile.length];
        double[][][] weights;
        for (int i=0; i<population.length; i++) {
            weights = NeuralParser.parseWeights(pathToFile[i]);
            population[i] = new Individual(weights);
        }
    }


    public void setPopulation(@NotNull Individual[] population) {
        this.population = population;
    }

    public void setNeuralNet(@NotNull ANetwork neuralNet) {
        this.neuralNet = neuralNet;
    }

    public void setFitness(@NotNull IFitnessFunction fitness) {
        this.fitness = fitness;
    }

    public void setInputs(@NotNull double[] inputs) {
        this.inputs = inputs;
    }

    public int size() {
        return this.population.length;
    }
}
