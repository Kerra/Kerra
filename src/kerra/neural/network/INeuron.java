package kerra.neural.network;

import org.jetbrains.annotations.NotNull;

public interface INeuron {

    /**
     * Feeds the specified value into the neuron.
     *
     * @param input the value to be added
     */
    public void input(double input);



    /**
     * Returns the value with applied activation function, if existing, currently stored in the neuron.
     *
     * @return the value currently stored
     */
    public double getValue();



    /**
     * Returns a String representation of the neuron.
     *
     * @return String representation
     */
    @NotNull
    @Override
    public String toString();
}
