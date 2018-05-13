package kerra.neural.learning;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class ParentSelection {

    /**
     * In this roulette sampling, we select a random points and match it against the total fitness
     * of the specified population. Thus choosing a fitter parent is more likely.<br>
     * <b>WARNING: Negative fitness values do NOT work!</b>
     *
     * @param population    the population to choose a parent from
     * @return  the chosen parent
     */
    @NotNull
    public static Individual roulette(@NotNull Individual[] population) {
        double totalFitness = Arrays.stream(population).mapToDouble(Individual::getFitness).sum();
        double random = Math.random() * totalFitness;

        return roll(population, random);
    }


    /**
     * In this stochastic universal sampling, we select two random points, from which one is exactly
     * {@code population.length/2} far away. Thus returning 2 parents in one single step, in which the
     * chance of one parent having a high fitness is very likely.<br>
     * <b>WARNING: Negative fitness values do NOT work!</b>
     *
     * @param population    the population to choose a parent from
     * @return  the chosen parents
     */
    @NotNull
    public static Individual[] stochasticUniversalSampling(@NotNull Individual[] population) {
        double totalFitness = Arrays.stream(population).mapToDouble(Individual::getFitness).sum();
        double point1 = Math.random() * totalFitness;
        double point2 = (point1 < totalFitness/2) ? point1 + totalFitness/2 : point1 - totalFitness/2;

        Individual[] parents = new Individual[2];
        parents[0] = roll(population, point1);
        parents[1] = roll(population, point2);

        return parents;
    }


    /**
     * In this tournament selection, we select a random ({@code population.length/2}) amount of individuals
     * from the specified population to return the fittest individual.
     *
     * @param population    the population to choose a parent from
     * @return  the chosen parent
     */
    @NotNull
    public static Individual tournament(@NotNull Individual[] population) {
        int number = 1+ (int) (Math.random() * population.length)/2;
        Individual[] tournament = new Individual[number];
        Arrays.setAll(tournament, i -> population[(int) (Math.random()*population.length)]);
        Arrays.sort(tournament);

        return tournament[tournament.length-1];
    }


    /**
     * Returns a random Individual out of the specified population.
     *
     * @param population    the population to choose a parent from
     * @return  the chosen prent
     */
    @NotNull
    public static Individual random(@NotNull Individual[] population) {
        int pos = (int) (Math.random()*population.length);
        return population[pos];
    }


    /**
     * Returns the rolled individual according to the rolled fitness area.
     */
    @NotNull
    private static Individual roll(@NotNull Individual[] population, double random) {
        double select = 0;
        for (Individual i : population) {
            select += i.getFitness();
            if (select > random) return i;
        }
        throw new IllegalStateException("Something bad happened...");
    }
}
