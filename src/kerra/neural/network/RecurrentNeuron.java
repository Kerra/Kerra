package kerra.neural.network;

import org.jetbrains.annotations.NotNull;

public class RecurrentNeuron extends ANeuron {

    /**
     * Orders the neuron to send its value to the specified targets.
     * Must be implemented by child class.
     *
     * @param targets the neurons of the next layer
     */
    @Override
    public void feedForward(@NotNull INeuron[] targets) {

    }

    /**
     * Returns the value with applied activation function currently stored in the neuron.
     * Must be implemented by child class.
     *
     * @return the value currently stored
     */
    @Override
    public double getValue() {
        return 0;
    }
}
