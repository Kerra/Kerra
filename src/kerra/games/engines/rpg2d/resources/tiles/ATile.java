package kerra.games.engines.rpg2d.resources.tiles;

import kerra.games.engines.rpg2d.events.Condition;
import kerra.games.engines.rpg2d.player.IPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ATile implements ITile {

    protected IPlayer player;
    protected Condition condition;
    protected int X, Y;

    public ATile(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    /**
     * Returns {@code true} if the specified player can enter this tile.
     *
     * @param player the player wanting to enter
     * @return {@code true} if the player may enter.<br>
     * {@code false} otherwise
     */
    @Override
    public abstract boolean canEnter(@NotNull IPlayer player);

    /**
     * Makes the specified player enter this tile as long as he can.
     * This method should call {@link #canEnter(IPlayer)} first!
     *
     * @param player the player to enter
     */
    @Override
    public void enter(@NotNull IPlayer player) {
        if (!canEnter(player)) throw new AssertionError("HumanPlayer cannot enter!");
        this.player = player;
    }

    /**
     * Makes the specified player leave this tile.
     *
     * @param player the player to leave
     */
    @Override
    public void leave(@NotNull IPlayer player) {
        if (this.player == null) throw new AssertionError("Current player not null!");
        this.player = null;
    }

    /**
     * Returns {@code true} if this tile is occupied.
     *
     * @return {@code true} if occupied.<br>
     * {@code false} otherwise
     */
    @Override
    public boolean isOccupied() {
        return this.player != null;
    }

    /**
     * Returns the position of this implementation of {@code ITile} as an array {@code [X, Y]}.
     *
     * @return the position of this tile
     */
    public int[] getPosition() {
        return new int[]{X, Y};
    }


    /**
     * Returns whether this implementation of {@code ATile} has a condition set up.
     *
     * @return {@code true} if a condition exists.<br>
     *         {@code false} otherwise
     */
    public boolean hasCondition() {
        return this.condition!= null;
    }

    /**
     * Stores the specified condition into this implementation of {@code ATile}.
     * It may be retrieved calling {@link #getCondition()}.
     *
     * @param condition the condition to be set
     */
    public void setCondition(@NotNull Condition condition) {
        this.condition = condition;
    }

    /**
     * Returns the condition stored into this implementation of {@code ATile}.
     *
     * @return  the stored condition. May be null!
     */
    @Nullable
    public Condition getCondition() {
        return this.condition;
    }

    /**
     * Returns a {@code char} representation of this implementation of {@code ITile}.
     *
     * @return a char representation
     */
    @Override
    public abstract char toChar();


    /**
     * Returns {@link #toChar()} as a {@code String}.
     *
     * @return  the string representation of {@code toChar()}
     */
    @Override
    public String toString() {
        return String.valueOf(toChar());
    }
}
