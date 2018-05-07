package kerra.neural.parsing;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * This class implements various methods to save and parse files for neural networks.
 * Currently it features saving and loading of weight and bias files using following example methods:<br>
 * - {@link #parseWeights(String)}<br>
 * - {@link #saveWeights(String, double[][][])}<br>
 * - {@link #parseBias(String)}<br>
 * - {@link #saveBias(String, double[])}<br>
 *
 * This class is a member of the <b>kerra Framework</b> at {@code https://github.com/kerra}.
 *
 * @author Julius Oeftiger (https://github.com/kerra)
 */
public class NeuralParser {


    /**
     * Parses neural weight files with following syntax: <br>
     * - {@code \n} for new Layer<br>
     * - {@code \t} for new Neuron<br>
     * - {@code \s} for new Weight<br>
     * No checking is done towards this. The responsibility lies with the user.
     *
     * @param pathToWeights filename to load.
     * @throws FileNotFoundException  if invalid filename
     */
    public static double[][][] parseWeights(String pathToWeights) throws FileNotFoundException {
        String file = new java.util.Scanner(new File(pathToWeights)).useDelimiter("\\A").next();

        String[] layers = file.split(System.getProperty("line.separator"));

        String[][] neurons = new String[layers.length][];
        for (int i=0; i<layers.length; i++)
            neurons[i] = layers[i].split("\\t");

        double[][][] weights = new double[layers.length][][];
        String[][][] weightsString = new String[layers.length][][];

        for (int i=0; i<neurons.length; i++) {

            weightsString[i] = new String[neurons[i].length][];
            weights[i] = new double[neurons[i].length][];
            for (int j=0; j<neurons[i].length; j++) {
                weightsString[i][j] = neurons[i][j].split("\\s");
                weights[i][j] = new double[weightsString[i][j].length];
                for (int k=0; k<weightsString[i][j].length; k++)
                    weights[i][j][k] = Double.valueOf(weightsString[i][j][k]);
            }
        }
        return weights;
    }



    /**
     * Stores the specified weight file into the specified file by converting it to a {@code String}
     * and calling {@link #saveBias(String, String)}.
     *
     * @param pathToWeights the place/file to save the weights
     * @param weights       the weight file to be saved
     * @throws IOException if the specified path or file is invalid
     */
    public static void saveWeights(@NotNull String pathToWeights, @NotNull double[][][] weights) throws IOException {
        StringBuilder net = new StringBuilder();
        for (int i=0; i<weights.length; i++) {
            for (int j = 0; j < weights[i].length; j++) {
                for (int k = 0; k < weights[i][j].length; k++) {
                    net.append(weights[i][j][k]);
                    if (k != weights[i][j].length - 1) net.append(" ");
                }
                if (j != weights[i].length - 1) net.append("\t");
            }
            if (i != weights.length - 1) net.append(System.getProperty("line.separator"));
        }
        saveWeights(pathToWeights, net.toString());
    }



    /**
     * Stores the specified weights-string into the specified file.
     *
     * @param pathToWeights the place/file to save the weights
     * @param weights       the weights-string to be saved
     * @throws IOException if the specified path or file is invalid
     */
    public static void saveWeights(@NotNull String pathToWeights, @NotNull String weights) throws IOException {
        FileWriter fw = new FileWriter(new File(pathToWeights));
        fw.write(weights);
        fw.close();
    }



    /**
     * Parses neural bias files with following syntax: <br>
     * - {@code \s} for new bias<br>
     * No checking is done towards this. The responsibility lies with the user.
     *
     * @param pathToBias    filename to load.
     * @throws FileNotFoundException  if invalid filename
     */
    public static double[] parseBias(@NotNull String pathToBias) throws FileNotFoundException {
        String file = new java.util.Scanner(new File(pathToBias)).useDelimiter("\\A").next();
        String[] b = file.split(" ");

        return Arrays.stream(b).mapToDouble(Double::valueOf).toArray();
    }



    /**
     * Saves the specified bias into the specified file by converting it to a {@code String}
     * and calling {@link #saveBias(String, String)}.
     *
     * @param pathToBias    the place/file to save the bias
     * @param bias          the bias to be saved
     * @throws IOException  if the specified path or file is invalid
     */
    public static void saveBias(@NotNull String pathToBias, double[] bias) throws IOException {
        String s = Arrays.stream(bias).mapToObj(b -> b + " ").collect(Collectors.joining()).trim();
        saveBias(pathToBias, s);
    }



    /**
     * Saves the specified bias-string into the specified file.
     *
     * @param pathToBias    the place/file to save the bias
     * @param bias          the bias-string to be saved
     * @throws IOException  if the specified path or file is invalid
     */
    public static void saveBias(@NotNull String pathToBias, @NotNull String bias) throws IOException {
        FileWriter fw = new FileWriter(new File(pathToBias));
        fw.write(bias);
        fw.close();
    }
}
