package kerra.games.engines.rpg2d;

import kerra.games.engines.rpg2d.players.APlayer;
import org.jetbrains.annotations.NotNull;

public final class Engine {
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
     * @throws AssertionError if no players got specified. {@link #setPlayer(APlayer)}
     */
    public void run() {
        if (player == null) throw new AssertionError("Player is null!");
        print();

        while (steps < 0 || currentSteps < steps) {
            player.move();
            print();
            delay();
            if (player.getTile().hasCondition() && player.getTile().getCondition().isMet())
                player.getTile().getCondition().run();
            currentSteps++;
        }
    }

    /**
     * Sets the players for this engine to move. ALso used for any conditions using {@link #getPlayer()}}.
     *
     * @param player the players for this game.
     *               Must not be {@code null}.
     */
    public void setPlayer(@NotNull APlayer player) {
        this.player = player;
    }

    /**
     * Returns the players this engine currently maintains.
     *
     * @return the players currently playing
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
     *
     */
    public void delay() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the amount of steps the players may do before the game ends.
     * A value {@code 'x' < 0} signals no limit.
     *
     * @param steps the amount of allowed steps to be done by the players
     */
    public void setSteps(int steps) {
        this.steps = steps;
    }

    /**
     * Returns the before specified limit of steps the players may do ({@link #setSteps(int)}.
     *
     * @return the specified limit of allowed steps to be done by the players
     */
    public int getSteps() {
        return this.steps;
    }

    /**
     * Returns the amoutn of steps the players has already done.
     *
     * @return the amount of steps the players has done
     */
    public int getCurrentSteps() {
        return this.currentSteps;
    }

    public void print() {
        System.out.println(player.getMap().toString());
    }
}
