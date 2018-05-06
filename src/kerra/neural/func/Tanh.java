package kerra.neural.func;

/**
 * This class implements the tanh activation function: <br>
 * {@code tanh(x)}
 */
public class Tanh implements IActivationFunction {

    /**
     * Applies the {@code tanh} activation function the specified value.
     *
     * @param x the value to have the function applied
     * @return  the value with applied function
     */
    public double f(double x) {
        return Math.tanh(x);
    }
}
