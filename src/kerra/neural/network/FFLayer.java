package kerra.neural.network;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class FFLayer extends ALayer {


    public FFLayer(int size) {
        this.neurons = new FFNeuron[size];
        Arrays.setAll(neurons, i -> new FFNeuron());
    }


    public FFLayer(@NotNull double[][] weights) {
        this.neurons = new FFNeuron[weights.length];
        Arrays.setAll(neurons, i -> new FFNeuron(weights[i]));
    }
}
