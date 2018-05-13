package testsrc.adderNetwork;

import kerra.neural.learning.IFitnessFunction;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Fitness implements IFitnessFunction {

    private double sum = 0;

    public Fitness(@NotNull double[] inputs) {
        this.sum = Arrays.stream(inputs).sum();
    }

    @Override
    public double func(@NotNull double[] outputs) {
        if (outputs.length != 1) throw new UnsupportedOperationException("Unexpected outputs.length");
        return 1/Math.abs(sum - outputs[0]);
    }
}
