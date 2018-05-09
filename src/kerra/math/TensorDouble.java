package kerra.math;

import org.jetbrains.annotations.NotNull;

public class TensorDouble {

    private double[][][] tensor;

    public TensorDouble(@NotNull double[][][] tensor) {
        this.tensor = tensor;
    }


    public void setTensor(@NotNull double[][][] tensor) {
        this.tensor = tensor;
    }


    @NotNull
    public double[][][] getTensor() {
        return this.tensor;
    }
}
