package kerra.neural.func;

/**
 * This class implements the ReLu activation function: <br>
 * {@code max(0, x)}
 */
public class ReLu implements IActivationFunction{

    /**
     * Applies the {@code ReLu} activation function the specified value.
     *
     * @param x the value to have the function applied
     * @return  the value with applied function
     */
    public double f(double x) {
        return Math.max(0, x);
    }
}
