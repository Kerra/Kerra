package kerra.neural.learning;

import org.jetbrains.annotations.NotNull;

class Individual implements Comparable<Individual> {

    private int age;
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

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    /**
     * Compares this individuals fitness with the specified individuals fitness for order.
     * Returns a negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.

     * @param o the object to be compared.
     * @return  a negative integer, zero, or a positive integer as this object
     *          is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(@NotNull Individual o) {
        return Double.compare(fitness, o.fitness);
    }

    public String toString() {
        return weights.toString() + "\t" + fitness;
    }
}
