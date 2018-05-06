package kerra.neural.network;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FFLayerTest {

    private FFLayer layer;
    private double[][] weights = {{1}};
    private double[] inputs = {1};

    @BeforeEach
    void setUp() {
        this.layer = new FFLayer(weights);
    }

    @Test
    void feedForward() {
        layer.input(inputs);
        layer.feedForward(layer);
        for (int i=0; i<weights.length; i++) assertEquals(2*inputs[i], layer.getValues()[i]);
    }

    @Test
    void sumNeurons() {
        assertEquals(weights.length, layer.sumNeurons());
    }

    @Test
    void getNeurons() {
        assertEquals(weights.length, layer.getNeurons().length);
    }

    @Test
    void getValues() {
        for (int i=0; i<weights.length; i++) assertEquals(0, layer.getValues()[i]);

        layer.input(inputs);
        for (int i=0; i<weights.length; i++) assertEquals(inputs[i], layer.getValues()[i]);
    }

    @Test
    void testToString() {
        assertEquals(String.valueOf(weights[0][0]), layer.toString());
    }
}