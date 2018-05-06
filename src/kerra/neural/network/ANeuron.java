package kerra.neural.network;

import kerra.neural.func.IActivationFunction;
import org.jetbrains.annotations.NotNull;

public abstract class ANeuron implements INeuron {

    double bias, value;
    double[] weights;
    IActivationFunction func;



    public ANeuron() {}


    /**
     * Creates a new neuron with specified weights for connections.
     *
     * @param weights   the weights to be used
     */
    public ANeuron(@NotNull double[] weights) {
        this.weights = weights;
        this.bias = 0;
        this.value = 0;
    }



    /**
     * Feeds the specified value into the neuron.
     *
     * @param input the value to be added
     */
    @Override
    public void input(double input) {
        this.value += input;
    }



    /**
     * Orders the neuron to send its value to the specified targets.
     * Must be implemented by child class.
     *
     * @param targets   the neurons of the next layer
     */
    public abstract void feedForward(@NotNull INeuron[] targets);

    
    
    /**
     * Returns the sum of all weights of the neuron.
     *
     * @return the amount of weights
     */
    public int sumConnections() {
        return weights.length;
    }

    
    
    /**
     * Returns the value with applied activation function currently stored in the neuron.
     * Must be implemented by child class.
     *
     * @return the value currently stored
     */
    @Override
    public abstract double getValue();

    
    
    /**
     * Stores the given bias into the neuron.
     *
     * @param bias the bias to be stored
     */
    public void setBias(double bias) {
        this.bias = bias;
    }



    /**
     * Returns the previously stored bias or {@code 0}.
     *
     * @return the stored bias
     */
    public double getBias() {
        return this.bias;
    }



    /**
     * Stores the given activation function into the neuron.
     *
     * @param func  the activation function to be stored
     */
    public void setActivationFunction(@NotNull IActivationFunction func) {
        this.func = func;
    }



    /**
     * Returns a string representation of the neuron.
     *
     * @return string representation
     */
    @NotNull
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (weights != null) for (double w : weights) s.append(w).append(" ");
        return s.toString().trim();
    }
}
