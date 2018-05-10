package kerra.neural.learning;

import org.jetbrains.annotations.NotNull;



public interface IFitnessFunction {

    public double func(@NotNull double[] outputs);
}
