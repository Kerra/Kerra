package kerra.neural.func;

/**
 * This class implements the sigmoid activation function: <br>
 * {@code 1/(1+e^x)}
 */
public class Sigmoid implements IActivationFunction{

    /**
     * Applies the {@code sigmoid} activation function the specified value.
     *
     * @param x the value to have the function applied
     * @return  the value with applied function
     */
    public double f(double x) {
        return 1 / ( 1 + Math.pow( Math.E, x ) );
    }
}
