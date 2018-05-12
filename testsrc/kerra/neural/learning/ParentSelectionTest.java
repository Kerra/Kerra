package kerra.neural.learning;

import kerra.util.Benchmark;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ParentSelectionTest {

    private Benchmark bench = new Benchmark();
    private double[][][] weights = {{{1}}};
    private Individual[] population = new Individual[50];


    @BeforeEach
    void setUp() {
        Arrays.setAll(population, i -> new Individual(weights));
        for (int i=0; i<population.length; i++) population[i].setFitness(i);
    }

    @Test
    void roulette() {
        Individual parent = ParentSelection.roulette(population);
        System.out.println(parent);
    }

    @Test
    void stochasticUniversalSampling() {
        Individual[] parents = ParentSelection.stochasticUniversalSampling(population);
        for (Individual i : parents) System.out.println(i);
    }

    @Test
    void tournament() {
        Individual parent = ParentSelection.tournament(population);
        System.out.println(parent);
    }

    @Test
    void random() {
        Individual parent = ParentSelection.random(population);
        System.out.println(parent);
    }

    @Test
    void benchmark() {
        Individual[] p = new Individual[2048];
        Arrays.setAll(p, i -> new Individual(weights));
        for (int i=0; i<p.length; i++) p[i].setFitness(i);

        int x = 100_000;
        bench1(x, p);
        bench2(x, p);
        bench3(x, p);
        bench4(x, p);
    }

    private void bench1(int x, Individual[] p) {
        System.out.print("ParentSelection.roulette:\t");
        bench.reset();
        for (int i=0; i<x; i++) ParentSelection.roulette(p);
        bench.print(x);
    }

    private void bench2(int x, Individual[] p) {
        System.out.print("ParentSelection.stochasticUniversalSampling:\t");
        bench.reset();
        for (int i=0; i<x; i++) ParentSelection.stochasticUniversalSampling(p);
        bench.print(x);
    }

    private void bench3(int x, Individual[] p) {
        System.out.print("ParentSelection.tournament:\t");
        bench.reset();
        for (int i=0; i<x; i++) ParentSelection.tournament(p);
        bench.print(x);
    }

    private void bench4(int x, Individual[] p) {
        System.out.print("ParentSelection.random:\t");
        bench.reset();
        for (int i=0; i<x; i++) ParentSelection.random(p);
        bench.print(x);
    }
}