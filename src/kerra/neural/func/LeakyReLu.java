package kerra.neural.func;

/**
 * This class implements the leaky ReLu activation function: <br>
 * {@code max(0.01, x)}
 */
public class LeakyReLu implements IActivationFunction {

    /**
     * Applies the {@code leaky ReLu} activation function the specified value.
     *
     * @param x the value to have the function applied
     * @return  the value with applied function
     */
    public double f(double x) {
        return Math.max(0.01, x);
    }
}
