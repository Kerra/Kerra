package kerra.neural.learning;

import org.jetbrains.annotations.NotNull;

class Individual {

    private final double[][][] weights;
    private double fitness;

    public Individual(@NotNull double[][][] weights) {
        this.weights = weights;
    }

    @NotNull
    public double[][][] getWeights() {
        return this.weights;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getFitness() {
        return this.fitness;
    }
}
