package kerra.games.engines.rpg2d;

import kerra.games.engines.rpg2d.player.APlayer;
import org.jetbrains.annotations.NotNull;

public class Engine {
    private static Engine ourInstance = new Engine();
    public static Engine getInstance() {
        return ourInstance;
    }
    private Engine() { }

    private APlayer player;
    private int delay = 800;
    private int steps = -1;
    private int currentSteps = 0;


    /**
     *
     * @throws AssertionError if no player got specified. {@link #setPlayer(APlayer)}
     */
    public void run() {
        if (player == null) throw new AssertionError("Player is null!");
        print();

        while (steps < 0 || currentSteps < steps) {
            player.move();
            print();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (player.getTile().hasCondition() && player.getTile().getCondition().isMet())
                player.getTile().getCondition().run();
            currentSteps++;
        }
    }

    /**
     * Sets the player for this engine to move. ALso used for any conditions using {@link #getPlayer()}}.
     *
     * @param player the player for this game.
     *               Must not be {@code null}.
     */
    public void setPlayer(@NotNull APlayer player) {
        this.player = player;
    }

    /**
     * Returns the player this engine currently maintains.
     *
     * @return the player currently playing
     */
    public APlayer getPlayer() {
        return this.player;
    }

    /**
     * Sets the delay in {@code milliseconds} the engine waits between painting each frame.
     *
     * @param delay the delay between each frame
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }

    /**
     * Returns the delay in {@code milliseconds} the engine waits before painting the next frame.
     *
     * @return the delay between each frame
     */
    public int getDelay() {
        return this.delay;
    }

    /**
     * Sets the amount of steps the player may do before the game ends.
     * A value {@code 'x' < 0} signals no limit.
     *
     * @param steps the amount of allowed steps to be done by the player
     */
    public void setSteps(int steps) {
        this.steps = steps;
    }

    /**
     * Returns the before specified limit of steps the player may do ({@link #setSteps(int)}.
     *
     * @return the specified limit of allowed steps to be done by the player
     */
    public int getSteps() {
        return this.steps;
    }

    /**
     * Returns the amoutn of steps the player has already done.
     *
     * @return the amount of steps the player has done
     */
    public int getCurrentSteps() {
        return this.currentSteps;
    }

    public void print() {
        System.out.println(player.getArea().toString());
    }
}
