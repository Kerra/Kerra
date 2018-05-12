package kerra.neural.learning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MutationTest {

    private double[] code = new double[20];

    @BeforeEach
    void setUp() {
        Arrays.setAll(code, i -> i);
    }

    @Test
    void swap() {
        Mutation.swap(code);
        System.out.println(Arrays.toString(code));
    }

    @Test
    void scramble() {
        Mutation.scramble(code);
        System.out.println(Arrays.toString(code));
    }

    @Test
    void invert() {
        Mutation.invert(code);
        System.out.println(Arrays.toString(code));
    }

    @Test
    void reset() {
        Mutation.reset(code, 0, 1);
        System.out.println(Arrays.toString(code));
    }

    @Test
    void mutate() {
        Mutation.mutate(code, 0.1);
        System.out.println(Arrays.toString(code));
    }
}