package kerra.util;

/**
 * A utility class to hel running benchmarks using {@link System#nanoTime()} to track start and end time.
 */
public class Benchmark {

    private long startTime;


    /**
     * Creates a new Benchmark with immediate {@link #reset()}.
     */
    public Benchmark() { this.reset(); }


    /**
     * Resets the benchmark (time).
     */
    public void reset() {
        this.startTime = System.nanoTime();
    }


    /**
     * Returns the elapsed time in nanoseconds using {@link System#nanoTime()}.
     *
     * @return  the time elapsed
     */
    public long timeElapsed() {
        return System.nanoTime() - this.startTime;
    }


    /**
     * Returns the time elapsed for a single benched operation using the specified divisor (amount of runs).
     *
     * @param divisor   the divisor to be used for {@link #timeElapsed()};
     * @return          the time elapsed
     */
    public long benchmark(long divisor) {
        return timeElapsed() / divisor;
    }


    /**
     * Prints out the time elapsed for a single benched operation using the specified divisor (amount of runs).
     *
     * @param divisor   the divisor to be used for {@link #benchmark(long)};
     */
    public void print(long divisor) {
        System.out.println("Average time for single operation: " + benchmark(divisor) + " ns");
    }
}
