package kerra.neural.network;

import kerra.neural.func.IActivationFunction;
import kerra.neural.parsing.NeuralParser;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Arrays;


/**
 * This class realizes a <i>deep feed forward</i> network.
 * Such a network may be created using following constructors:<br>
 *     {@link #FFNetwork(int[] size)}<br>
 *     {@link #FFNetwork(double[][][] weights)}<br>
 *     {@link #FFNetwork(double[][][] weights, double[] bias)}<br>
 * <br>
 * Unless the bias is given using {@link #setBias(double[] bias)}, values of {@code 0} are applied.
 * Unless activation functions using {@link #setActivationFunction(IActivationFunction[])} are given,
 * no function will be applied, thus resulting in a completely linear calculation.<br>
 * This class is a member of the <b>kerra Framework</b> at {@code https://github.com/kerra}.
 *
 * @author Julius Oeftiger (https://github.com/kerra)
 *
 */
public class FFNetwork extends ANetwork {


    public FFNetwork(@NotNull int[] size) {
        super(size);
    }

    public FFNetwork(@NotNull double[][][] weights) {
        super(weights);
    }

    public FFNetwork(@NotNull double[][][] weights, double[] bias) {
        super(weights, bias);
    }

    public FFNetwork(@NotNull String pathToWeights) throws IOException {
        super(pathToWeights);
    }

    public FFNetwork(@NotNull String pathToWeights, @NotNull String pathToBias) throws IOException {
        super(pathToWeights, pathToBias);
    }



    @Override
    void initialize() {
        for (int i=0; i<sumLayers()-1; i++) layers[i] = new FFLayer(weights[i]);
        int last = sumLayers()-1;
        layers[last] = new FFLayer(weights[last-1][0].length);
    }



    /**
     * Feeds the specified inputs into the network. The calculation should be done here.
     *
     * @param inputs the inputs to be fed into the network
     * @return the calculated outputs
     */
    @NotNull
    @Override
    public double[] feed(@NotNull double[] inputs) {
        layers[0].input(inputs);
        for (int i=0; i<sumLayers()-1; i++) layers[i].feedForward(layers[i+1]);
        return layers[sumLayers()-1].getValues();
    }



    /**
     * Generates new weights for the current network according to previous weight sizes.
     */
    @Override
    public void generateWeights() {
        for (double[][] l : weights) for (double[] n : l) Arrays.setAll(n, c -> 2 * Math.random() - Math.nextDown(1.0));
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
        layers = new ALayer[weights.length];
        setWeights(weights);
    }
}
