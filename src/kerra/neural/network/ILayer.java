package kerra.neural.network;

import org.jetbrains.annotations.NotNull;

public interface ILayer {

    /**
     * Returns the sum of all neurons of the layer.
     *
     * @return the amount of neurons
     */
    public int sumNeurons();



    /**
     * Returns the sum of all connections of every neuron of the layer.
     *
     * @return the amount of connections
     */
    public int sumConnections();



    /**
     * Returns the neurons of the layer.
     *
     * @return  the neurons stored
     */
    @NotNull
    public INeuron[] getNeurons();



    /**
     * Returns the values currently stored in each neuron of the layer.
     *
     * @return the values currently stored
     */
    @NotNull
    public double[] getValues();



    /**
     * Returns a String representation of the layer.
     *
     * @return String representation
     */
    @NotNull
    @Override
    public String toString();
}
