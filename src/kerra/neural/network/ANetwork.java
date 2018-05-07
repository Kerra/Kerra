package kerra.neural.network;

import kerra.neural.func.IActivationFunction;
import kerra.neural.parsing.NeuralParser;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Arrays;

public abstract class ANetwork implements INetwork {

    ALayer[] layers;
    double bias[], weights[][][];


    public ANetwork(@NotNull int[] size) {
        weights = new double[size.length-1][][];
        Arrays.setAll(weights, i -> new double[size[i]][size[i + 1]]);
        this.layers = new ALayer[size.length];
        generateWeights();
        initialize();
    }


    @Contract(pure = true)
    public ANetwork(@NotNull double[][][] weights) {
        this(weights, null);
    }



    @Contract(pure = true)
    public ANetwork(@NotNull double[][][] weights, @Nullable double[] bias) {
        this.weights = weights;
        if (bias == null) {
            bias = new double[weights.length - 1];
            Arrays.fill(bias, 0);
        }
        this.bias = bias;
        layers = new ALayer[weights.length];
        initialize();
    }



    public ANetwork(@NotNull String pathToWEights) throws IOException {
        this(pathToWEights, null);
    }

    public ANetwork(@NotNull String pathToWeights, @Nullable String pathToBias) throws IOException {
        loadWeights(pathToWeights);
        if (pathToBias != null) loadBias(pathToBias);
    }


    /**
     * Initializes the network. Sets everything up.
     */
    abstract void initialize();



    /**
     * Feeds the specified inputs into the network. The calculation should be done here.
     *
     * @param inputs the inputs to be fed into the network
     * @return the calculated outputs
     */
    @NotNull
    @Override
    public abstract double[] feed(@NotNull double[] inputs);



    /**
     * Returns the sum of all layers of the network.
     *
     * @return the amount of layers
     */
    @Override
    public int sumLayers() {
        return layers.length;
    }



    /**
     * Returns the sum of all neurons of every layer of the network.
     *
     * @return the amount of neurons
     */
    @Override
    public int sumNeurons() {
        return Arrays.stream(layers).mapToInt(ALayer::sumNeurons).sum();
    }



    /**
     * Returns the sum of all connections of every neuron of every layer of the network.
     *
     * @return the amount of connections
     */
    @Override
    public int sumConnections() {
        return Arrays.stream(layers).mapToInt(ALayer::sumConnections).sum();
    }



    /**
     * Generates new weights for the current network according to previous weight sizes.
     */
    @Override
    public abstract void generateWeights();



    /**
     * Replaces the current weights with the specified weight file.
     *
     * @param weights the new weights to be used
     */
    @Contract(pure = true)
    @Override
    public void setWeights(@NotNull double[][][] weights) {
        this.weights = weights;
        this.layers = new ALayer[weights.length+1];
        initialize();
    }



    /**
     * Returns the current weight file.
     *
     * @return the current weights
     */
    @Contract(pure = true)
    @Override
    public double[][][] getWeights() {
        return this.weights;
    }



    /**
     * Replaces the current bias with the specified value.
     * The bias will be applied to layers of following <b>indices</b>:<br>
     *      - {@code 1} to {@code length-1}
     *
     * @param bias  the new bias to be used
     */
    @Contract(pure = true)
    public void setBias(@NotNull double[] bias) {
        this.bias = bias;
        for (int i=1; i<sumLayers(); i++) for (ANeuron n : layers[i].getNeurons()) n.setBias(bias[i-1]);
    }



    /**
     * Returns the current bias.
     *
     * @return the current bias
     */
    @Contract(pure = true)
    public double[] getBias() {
        return this.bias;
    }



    /**
     * The activation function will be given to layers of following <b>indices</b>:<br>
     * - {@code 1} to {@code length-1}
     *
     * @param iafs  the activation functions to use
     */
    public void setActivationFunction(@NotNull IActivationFunction[] iafs) {
        for (int i=1; i<sumLayers(); i++) for (ANeuron n : layers[i].getNeurons()) n.setActivationFunction(iafs[i-1]);
    }



    /**
     * Loads the weights from the specified file into the network.
     *
     * @param pathToWeights the file to be loaded
     * @throws IOException if the specified path or file is invalid
     */
    @Override
    public void loadWeights(@NotNull String pathToWeights) throws IOException {
        double[][][] weights = NeuralParser.parseWeights(pathToWeights);
        setWeights(weights);
    }



    /**
     * Stores the current weights into the specified file.
     *
     * @param pathToWeights the place/file to save the weights
     * @throws IOException if the specified path or file is invalid
     */
    @Override
    public void saveWeights(@NotNull String pathToWeights) throws IOException {
        NeuralParser.saveWeights(pathToWeights, weights);
    }



    /**
     * Loads the bias from the specified file into the network.
     *
     * @param pathToBias    the file to be loaded
     * @throws IOException  if the specified path or file is invalid
     */
    @Override
    public void loadBias(@NotNull String pathToBias) throws IOException {
        double[] bias = NeuralParser.parseBias(pathToBias);
        setBias(bias);
    }



    /**
     * Saves the current bias into the specified file.
     *
     * @param pathToBias    the place/file to save the bias
     * @throws IOException  if the specified path or file is invalid
     */
    @Override
    public void saveBias(@NotNull String pathToBias) throws IOException {
        NeuralParser.saveBias(pathToBias, bias);
    }



    /**
     * Returns a String representation of the network.
     *
     * @return  String representation
     */
    @NotNull
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (ALayer l : layers) s.append(l.toString()).append(System.getProperty("line.separator"));
        return s.toString().trim();
    }
}
