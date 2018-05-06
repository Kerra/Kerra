package kerra.neural.network;

import org.jetbrains.annotations.NotNull;

public class Connection {

    private double weight;
    private INeuron target;

    public Connection(@NotNull INeuron target, double weight) {
        this.target = target;
        this.weight = weight;
    }

    public void input(double input) {
        target.input(weight * input);
    }
}
