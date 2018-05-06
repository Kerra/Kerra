package kerra.neural.network;

import kerra.neural.func.IActivationFunction;
import kerra.neural.func.ReLu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FFNeuronTest {

    private FFNeuron neuron;
    private INeuron[] target;
    private double input = 10;
    private double bias = 1;
    private double[] weights = {1};
    private IActivationFunction func;

    @BeforeEach
    void setUp() {
        this.neuron = new FFNeuron(weights);
        this.target = new INeuron[]{neuron};
        this.func = new ReLu();
    }

    @Test
    void feedForward() {
        neuron.input(input);
        neuron.feedForward(target);
        assertEquals(2*input, neuron.getValue());
    }

    @Test
    void input() {
        neuron.input(input);
        assertEquals(input, neuron.getValue());
    }

    @Test
    void sumConnections() {
        assertEquals(1, neuron.sumConnections());
    }

    @Test
    void getValue() {
        assertEquals(0, neuron.getValue());
        input();
    }

    @Test
    void setBias() {
        neuron.setBias(bias);
        assertEquals(bias, neuron.getBias());
    }

    @Test
    void getBias() {
        neuron.setBias(bias);
        assertEquals(bias, neuron.getBias());
    }

    @Test
    void setActivationFunction() {
        neuron.setActivationFunction(func);
        neuron.input(-10);
        assertEquals(0, neuron.getValue());
    }

    @Test
    void testToString() {
        assertEquals(String.valueOf(weights[0]), neuron.toString());
    }
}