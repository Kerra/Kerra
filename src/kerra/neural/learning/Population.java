package kerra.neural.learning;

import kerra.neural.network.ANetwork;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Population {

    private boolean generational;
    private Individual[] population;
    private ANetwork neuralNet;


    /**
     * Creates a new population based on specified model. Allowed model specifications are:<br>
     * <ul>
     *      <li> {@code "steady.state"} : two off-springs for each generation replacing two individuals.
     *           This model is also known as <b>Incremental Genetic Algorithm</b>. </li>
     *
     *      <li> {@code "generational"} : {@code n} (population size) off-springs will be generated and
     *      replace the entire population. </li>
     * </ul>
     *
     * @param model the model to be used
     * @throws IllegalArgumentException if the specified model does not match any of the a
     *                                  bove mentioned specifications
     */
    public Population(@NotNull String model) {
        switch (model) {
            case "steady.state": generational = false;
            case "generational": generational = true;
            default: throw new IllegalArgumentException("Unknown model.");
        }
    }


    public void setInitialPopulation(@NotNull Individual[] population) {
        this.population = population;
    }


    @NotNull
    public Individual[] getPopulation() {
        return population;
    }


    public boolean isGenerational() {
        return generational;
    }
}
