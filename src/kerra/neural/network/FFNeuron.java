package kerra.neural.network;

import org.jetbrains.annotations.NotNull;

public class FFNeuron extends ANeuron {


    public FFNeuron() {}

    public FFNeuron(@NotNull double[] weights) {
        super(weights);
    }


    /**
     * Returns the value with applied activation function currently stored in the neuron.
     * Must be implemented by child class.
     *
     * @return the value currently stored
     */
    @Override
    public double getValue() {
        this.value += bias;
        if (func != null) this.value = func.f(value);
        return value;
    }



    /**
     * Orders the neuron to send its value along all connections.
     *
     * @param targets   the neurons of the next layer.
     *                  must be of same length as the current weights
     * @throws  ArrayIndexOutOfBoundsException if {@code targets.length != weights.length}
     */
    @Override
    public void feedForward(@NotNull INeuron[] targets) {
        for (int i=0; i<targets.length; i++) targets[i].input(getValue() * weights[i]);
    }
}
