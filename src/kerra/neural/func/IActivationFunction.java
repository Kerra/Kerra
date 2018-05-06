package kerra.neural.func;

/**
 * This interface allows creating activation functions for neural networks.
 * Each function must be callable using {@link #f(double x)}
 */
public interface IActivationFunction {

    /**
     * Applies a specific activation function the specified value.
     *
     * @param x the value to have the function applied
     * @return  the value with applied function
     */
    public double f(double x);
}
