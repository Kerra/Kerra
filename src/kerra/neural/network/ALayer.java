package kerra.neural.network;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public abstract class ALayer implements ILayer {

    ANeuron[] neurons;


    /**
     * Orders the layer to order each of its neurons to send their values to the specified target.
     *
     * @param target   the neurons of the next layer
     */
    public void feedForward(@NotNull ILayer target){
        for (ANeuron n : neurons) n.feedForward(target.getNeurons());
    }



    /**
     * Feeds the specified values into the layer.
     *
     * @param inputs the values to sent to each neuron
     */
    public void input(@NotNull double[] inputs) {
        for (int i=0; i<neurons.length; i++) neurons[i].input(inputs[i]);
    }



    /**
     * Returns the sum of all neurons of the layer.
     *
     * @return the amount of neurons
     */
    @Override
    public int sumNeurons() {
        return neurons.length;
    }



    /**
     * Returns the sum of all connections of every neuron of the layer.
     *
     * @return the amount of connections
     */
    @Override
    public int sumConnections() {
        return Arrays.stream(neurons).mapToInt(ANeuron::sumConnections).sum();
    }



    /**
     * Returns the neurons of the layer.
     *
     * @return the neurons stored
     */
    @NotNull
    @Override
    public ANeuron[] getNeurons() {
        return this.neurons;
    }



    /**
     * Returns the values currently stored in each neuron of the layer.
     *
     * @return the values currently stored
     */
    @NotNull
    @Override
    public double[] getValues() {
        double[] values = new double[sumNeurons()];
        for (int i=0; i<values.length; i++) values[i] = neurons[i].getValue();
        return values;
    }



    /**
     * Returns a string representation of the layer.
     *
     * @return string representation
     */
    @NotNull
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (ANeuron n : neurons) s.append(n.toString()).append("\t");
        // s.delete(s.length() - 1, s.length());
        return s.toString().trim();
    }
}
