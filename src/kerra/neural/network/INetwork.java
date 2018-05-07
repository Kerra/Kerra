package kerra.neural.network;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public interface INetwork {

    /**
     * Feeds the specified inputs into the network. The calculation should be done here.
     *
     * @param inputs    the inputs to be fed into the network
     * @return  the calculated outputs
     */
    @NotNull
    public double[] feed(@NotNull double[] inputs);



    /**
     * Returns the sum of all layers of the network.
     *
     * @return  the amount of layers
     */
    public int sumLayers();



    /**
     * Returns the sum of all neurons of every layer of the network.
     *
     * @return  the amount of neurons
     */
    public int sumNeurons();



    /**
     * Returns the sum of all connections of every neuron of every layer of the network.
     *
     * @return the amount of connections
     */
    public int sumConnections();



    /**
     * Generates new weights for the current network according to previous weight sizes.
     */
    public void generateWeights();



    /**
     * Replaces the current weights with the specified weight file.
     *
     * @param weights   the new weights to be used
     */
    public void setWeights(@NotNull double[][][] weights);



    /**
     * Returns the current weight file.
     *
     * @return  the current weights
     */
    @Contract(pure = true)
    public double[][][] getWeights();



    /**
     * Loads the weights from the specified file into the network.
     *
     * @param pathToWeights the file to be loaded
     * @throws IOException  if the specified path or file is invalid
     */
    public void loadWeights(@NotNull String pathToWeights) throws IOException;



    /**
     * Saves the current weights into the specified file.
     *
     * @param pathToWeights the place/file to save the weights
     * @throws IOException  if the specified path or file is invalid
     */
    public void saveWeights(@NotNull String pathToWeights) throws IOException;



    /**
     * Loads the bias from the specified file into the network.
     *
     * @param pathToBias    the file to be loaded
     * @throws IOException  if the specified path or file is invalid
     */
    public void loadBias(@NotNull String pathToBias) throws IOException;



    /**
     * Saves the current bias into the specified file.
     *
     * @param pathToBias    the place/file to save the bias
     * @throws IOException  if the specified path or file is invalid
     */
    public void saveBias(@NotNull String pathToBias) throws IOException;


    /**
     * Returns a String representation of the network.
     *
     * @return  String representation
     */
    @NotNull
    @Override
    public String toString();
}
