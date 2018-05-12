package kerra.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ArraysUtilTest {

    private double[] ar = new double[20];

    @BeforeEach
    void setUp() {
        java.util.Arrays.setAll(ar, i -> i);
    }

    @Test
    void shuffle() {
        ArraysUtil.shuffle(ar);
        System.out.println(Arrays.toString(ar));
    }

    @Test
    void shuffle2() {
        ArraysUtil.shuffle(ar, 5, 10);
        System.out.println(Arrays.toString(ar));
    }

    @Test
    void invert() {
        ArraysUtil.invert(ar);
        System.out.println(Arrays.toString(ar));
    }

    @Test
    void invert1() {
        ArraysUtil.invert(ar, 5, 15);
        System.out.println(Arrays.toString(ar));
    }
}