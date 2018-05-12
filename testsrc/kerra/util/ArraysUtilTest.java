package kerra.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ArraysPTest {

    private double[] ar = new double[20];

    @BeforeEach
    void setUp() {
        java.util.Arrays.setAll(ar, i -> i);
    }

    @Test
    void shuffle() {
        ArraysP.shuffle(ar);
        System.out.println(Arrays.toString(ar));
    }

    @Test
    void shuffle2() {
        ArraysP.shuffle(ar, 5, 10);
        System.out.println(Arrays.toString(ar));
    }
}