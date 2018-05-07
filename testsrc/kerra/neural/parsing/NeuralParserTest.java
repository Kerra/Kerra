package kerra.neural.parsing;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NeuralParserTest {

    private String path = System.getProperty("user.dir") + "\\testsrc\\kerra\\neural\\parsing\\";
    private String parseWeights = path + "parseWeights";
    private String saveWeights = path + "saveWeights";
    private String parseBias = path + "parseBias";
    private String saveBias = path + "saveBias";
    private double[][][] weights = {{{1, 1}, {2, 2}, {3, 3}}, {{10, 10}, {20, 20}, {30, 30}}};
    private double[] bias = {1, 2, 3};

    @Test
    void parseWeights() throws IOException {
        double[][][] read = NeuralParser.parseWeights(parseWeights);
        assertEquals(Arrays.deepToString(weights), Arrays.deepToString(read));
    }

    @Test
    void saveWeights() throws IOException {
        NeuralParser.saveWeights(saveWeights, weights);
        double[][][] read = NeuralParser.parseWeights(saveWeights);
        assertEquals(Arrays.deepToString(weights), Arrays.deepToString(read));
    }

    @Test
    void parseBias() throws IOException {
        double[] read = NeuralParser.parseBias(parseBias);
        assertEquals(Arrays.toString(bias), Arrays.toString(read));
    }

    @Test
    void saveBias() throws IOException {
        NeuralParser.saveBias(saveBias, bias);
        double[] read = NeuralParser.parseBias(saveBias);
        assertEquals(Arrays.toString(bias), Arrays.toString(read));
    }
}