package kerra.neural.learning;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Crossover {

    /**
     * In this one-point crossover, a random crossover point is selected and the
     * tails of both codes (parents) are swapped to create new off-springs.
     *
     * @param code1 the encoded weights of parent 1
     * @param code2 the encoded weights of parent 2
     * @return  the new encoded weight of the off-spring
     * @throws ArrayIndexOutOfBoundsException if both codes are not of equal length
     */
    @NotNull
    public static double[] onePoint(@NotNull double[] code1, @NotNull double[] code2) {
        check(code1, code2);
        double[] crossOver = new double[code1.length];

        int cross = (int) (1 + Math.random()*code1.length);

        System.arraycopy(code1, 0, crossOver, 0, cross);
        System.arraycopy(code2, cross, crossOver, cross, code2.length - cross);

        return crossOver;
    }


    /**
     * In this two-point crossover, two random crossover points are selected and the
     * area between is swapped to create new off-springs.
     *
     * @param code1 the encoded weights of parent 1
     * @param code2 the encoded weights of parent 2
     * @return  the new encoded weight of the off-spring
     * @throws ArrayIndexOutOfBoundsException if both codes are not of equal length
     */
    @NotNull
    public static double[] twoPoint(@NotNull double[] code1, @NotNull double[] code2) {
        check(code1, code2);
        double[] crossOver = new double[code1.length];

        int[] cross = { (int) (1 + Math.random()*code1.length),
                        (int) (2 + Math.random()*(code1.length-1))};
        Arrays.sort(cross);

        System.arraycopy(code1, 0, crossOver, 0, cross[0]);
        System.arraycopy(code2, cross[0], crossOver, cross[0], cross[1]-cross[0]);
        System.arraycopy(code1, cross[1], crossOver, cross[1], code1.length - cross[1]);


        return crossOver;
    }


    /**
     * In this multi-point crossover, random crossover points (1 - {@code code.length/4}) are selected and the
     * area between is swapped alternating to create new off-springs.
     *
     * @param code1 the encoded weights of parent 1
     * @param code2 the encoded weights of parent 2
     * @return  the new encoded weight of the off-spring
     * @throws ArrayIndexOutOfBoundsException if both codes are not of equal length
     */
    @NotNull
    public static double[] multiPoint(@NotNull double[] code1, @NotNull double[] code2) {
        check(code1, code2);
        double[] crossOver = new double[code1.length];

        int[] cross = new int[1 + (int) (Math.random() * code1.length / 4)];
        Arrays.setAll(cross, i -> (int) (code1.length*Math.random()));
        Arrays.sort(cross);

        System.arraycopy(code1, 0, crossOver, 0, cross[0]);
        int i=1;
        while (i < cross.length) {
            if (i % 2 == 0) System.arraycopy(code2, cross[i-1], crossOver, cross[i-1], cross[i]-cross[i-1]);
            else System.arraycopy(code1, cross[i-1], crossOver, cross[i-1], cross[i]-cross[i-1]);
            i++;
        }
        if (i % 2 == 0) System.arraycopy(code2, cross[i-1], crossOver, cross[i-1], code2.length-cross[i-1]);
        else System.arraycopy(code1, cross[i-1], crossOver, cross[i-1], code1.length-cross[i-1]);

        return crossOver;
    }


    /**
     * In this uniform crossover, each code entry is swapped randomly to create new off-springs.
     *
     * @param code1 the encoded weights of parent 1
     * @param code2 the encoded weights of parent 2
     * @return  the new encoded weight of the off-spring
     * @throws ArrayIndexOutOfBoundsException if both codes are not of equal length
     */
    @NotNull
    public static double[] uniform(@NotNull double[] code1, @NotNull double[] code2) {
        check(code1, code2);
        double[] crossOver = new double[code1.length];

        for (int i=0; i<code1.length; i++) crossOver[i] = (2 * Math.random() < 1) ? code1[i] : code2[i];

        return crossOver;
    }


    /**
     * By taking the weighted average of both parents, this arithmetic crossover creates two
     * off-springs using following formulae:
     * <ul>
     *     <li>{@code child1 = s*parent1 + (1-s)*parent2}</li>
     *     <li>{@code child2 = s*parent2 + (1-s)*parent1}</li>
     * </ul>
     *
     * @param code1 the encoded weights of parent 1
     * @param code2 the encoded weights of parent 2
     * @param s     the scalar to be used for average weighting
     * @return  the new encoded weight of the off-spring
     * @throws ArrayIndexOutOfBoundsException if both codes are not of equal length
     */
    @NotNull
    public static double[][] wholeArithmetic(@NotNull double[] code1, @NotNull double[] code2, double s) {
        check(code1, code2);
        if (s <= 0 || s >= 1) throw new UnsupportedOperationException("Scalar out of range");
        double[][] crossOver = {new double[code1.length], new double[code1.length]};

        for (int i=0; i<code1.length; i++) {
            crossOver[0][i] = s*code1[i] + (1-s)*code2[i];
            crossOver[1][i] = s*code2[i] + (1-s)*code1[i];
        }

        return crossOver;
    }


    /**
     * Checks for equal length of codes.
     */
    private static void check(@NotNull double[] code1, @NotNull double[] code2) {
        if (code1.length != code2.length) throw new ArrayIndexOutOfBoundsException("Code lengths do not match!");
    }
}
